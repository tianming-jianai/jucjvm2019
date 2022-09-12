package com.atguigu.day01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @BelongsProject: jucjvm2019
 * @BelongsPackage: com.atguigu.day01
 * @Author: 张世罡
 * @CreateTime: 2022/9/11 15:41
 * @Description:
 * 题目：三个售票员 卖出 30张票
 * 笔记：如何编写企业级的多线程代码
 * 固定的编程套路+模板是什么
 *
 * 1 在高内聚低耦合的前提下：线程    操作   资源类
 * 1.1 一言不合，先创建一个资源类
 */
public class SaleTicketDemo01 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 40; i++) {
                ticket.sale();
            }
        }, "A");
        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 40; i++) {
                ticket.sale();
            }
        }, "B");
        Thread t3 = new Thread(() -> {
            for (int i = 1; i <= 40; i++) {
                ticket.sale();
            }
        }, "C");
        t1.start();
        t2.start();
        t3.start();
    }
}

class Ticket { // 资源类 = 实例变量 + 实例方法

    private int number = 30;
    Lock lock = new ReentrantLock();

    public void sale() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "\t 卖出第：" + number-- + "张票， 剩余票数：" + number);
            }
        } finally {
            lock.unlock();
        }
    }

}