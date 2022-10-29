package com.atguigu.juc.day01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @BelongsProject: jucjvm2019
 * @BelongsPackage: com.atguigu.juc.day01
 * @Author: 张世罡
 * @CreateTime: 2022/10/29 22:46
 * @Description:
 * 题目：三个售票员 卖出 30张票
 *
 * 多线程的企业级套路+模板
 * 1. 在高内聚低耦合的情况下，线程 操作 资源类
 * 高内聚低耦合：资源类自身的属性
 */
public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "t1").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "t2").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "t3").start();
    }
}

class Ticket {// 资源类

    private int num = 30;
    private Lock lock = new ReentrantLock();

    public void sale() {
        lock.lock();
        try {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出第" + num + "张票，还剩" + --num + "张");
            }
        } finally {
            lock.unlock();
        }
    }
}


