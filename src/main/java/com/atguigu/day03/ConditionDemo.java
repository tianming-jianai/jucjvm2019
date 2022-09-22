package com.atguigu.day03;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @BelongsProject: jucjvm2019
 * @BelongsPackage: com.atguigu.day03
 * @Author: 张世罡
 * @CreateTime: 2022/9/22 19:45
 * @Description:
 * 备注：多线程之间按顺序调用，实现A → B → C
 * 三个线程启动，要求如下：
 *
 * AA打印5次，BB打印10次，CC打印15次
 * 接着
 * AA打印5次，BB打印10次，CC打印15次
 * 来10轮
 *
 * 一把锁配多把备用钥匙
 */
public class ConditionDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareData.print5();
            }
        }, "AA").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareData.print10();
            }
        }, "BB").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareData.print15();
            }
        }, "CC").start();
    }
}

class ShareData {

    // 标志位
    private int number = 1;

    ReentrantLock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            // 判断
            while (number != 1) {
                c1.await();
            }
            // 干活
            number = 2;
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 通知
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            // 判断
            while (number != 2) {
                c2.await();
            }
            // 干活
            number = 3;
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 通知
            c3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            // 判断
            while (number != 3) {
                c3.await();
            }
            // 干活
            number = 1;
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 通知
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}