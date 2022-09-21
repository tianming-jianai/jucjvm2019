package com.atguigu.day03;

/**
 * @BelongsProject: jucjvm2019
 * @BelongsPackage: com.atguigu.day03
 * @Author: 张世罡
 * @CreateTime: 2022/9/21 23:47
 * @Description:
 * 题目：现在两个线程，可以操作初始值为0的一个变量
 * 实现一个线程对该变量加1，一个线程对该变量减1
 * 实现交替，来10轮，变量初始值为0
 * 1. 高内聚低耦合前提下，线程操作资源类
 * 2. 判断/干活/通知
 * 3. 防止虚假唤醒
 */
public class ProdConsumerDemo04 {
    public static void main(String[] args) throws Exception {
        AirCondition airCondition = new AirCondition();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airCondition.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airCondition.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
        // 四个线程，我要两个生产者，两个消费者
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airCondition.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airCondition.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }
}

class AirCondition {
    private int number = 0;

    public synchronized void increment() throws Exception {
        // 判断
        while (this.number != 0) {
            this.wait();
        }
        // 干活
        this.number++;
        System.out.println(Thread.currentThread().getName() + "\t" + this.number);
        // 通知
        this.notify();
    }

    public synchronized void decrement() throws Exception {
        while (this.number == 0) {
            this.wait();
        }
        this.number--;
        System.out.println(Thread.currentThread().getName() + "\t" + this.number);
        this.notify();
    }
}

