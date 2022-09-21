package com.atguigu.day03;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @BelongsProject: jucjvm2019
 * @BelongsPackage: com.atguigu.day03
 * @Author: 张世罡
 * @CreateTime: 2022/9/22 0:32
 * @Description:
 */
public class ProdConsumerDemo05 {
    public static void main(String[] args) {
        AirCondition2 airCondition = new AirCondition2();

    }
}

class AirCondition2 {
    private int number = 0;
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void increment() throws Exception {
        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            number++;
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws Exception {
        lock.lock();
        try {
            while (number == 0) {
                condition.await();
            }
            number--;
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}