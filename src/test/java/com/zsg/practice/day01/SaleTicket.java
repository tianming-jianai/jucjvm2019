package com.zsg.practice.day01;



import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @BelongsProject: jucjvm2019
 * @BelongsPackage: com.zsg.practice.day01
 * @Author: 张世罡
 * @CreateTime: 2022/9/14 21:12
 * @Description:
 */
public class SaleTicket {

    @Test
    public void test(){
        Ticket ticket = new Ticket();
        // 三个售票员
        new Thread(()->{for (int i = 0; i < 40; i++) {ticket.sale();}},"A").start();
        new Thread(()->{for (int i = 0; i < 40; i++) {ticket.sale();}},"B").start();
        new Thread(()->{for (int i = 0; i < 40; i++) {ticket.sale();}},"C").start();

        while(true){

        }
    }
}

class Ticket {
    private int number = 30;
    ReentrantLock lock = new ReentrantLock();

    public void sale() {
        lock.lock();
        try {
            if (number > 0) {
                Thread.sleep(200);
                System.out.println(Thread.currentThread().getName() + "卖出第" + number-- + "张票， 还剩" + number + "张");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}