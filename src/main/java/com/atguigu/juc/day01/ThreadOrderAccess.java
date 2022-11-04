package com.atguigu.juc.day01;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @BelongsProject: jucjvm2019
 * @BelongsPackage: com.atguigu.juc.day01
 * @Author: 张世罡
 * @CreateTime: 2022/11/4 20:42
 * @Description:
 * (AA 5 BB 10 CC 15) * 10
 *
 */
public class ThreadOrderAccess {
    public static void main(String[] args) {
        ShareResource resource = new ShareResource();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    resource.print5();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    resource.print10();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    resource.print15();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t3").start();
    }
}

class ShareResource {
    private int number = 1; // 1 A 2 B 3 C
    private Lock lock = new ReentrantLock();

    Condition a = lock.newCondition();
    Condition b = lock.newCondition();
    Condition c = lock.newCondition();

    public void print5() throws InterruptedException {
        lock.lock();
        try {
            while (number != 1) {
                a.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + "A");
            }
            number = 2;
            b.signal();
        } finally {
            lock.unlock();
        }
    }

    public void print10() throws InterruptedException {
        lock.lock();
        try {
            while (number != 2) {
                b.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + "B");
            }
            number = 3;
            c.signal();
        } finally {
            lock.unlock();
        }
    }

    public void print15() throws InterruptedException {
        lock.lock();
        try {
            while (number != 3) {
                c.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + "C");
            }
            number = 1;
            a.signal();
        } finally {
            lock.unlock();
        }
    }
}
