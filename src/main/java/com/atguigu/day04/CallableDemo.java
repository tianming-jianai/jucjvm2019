package com.atguigu.day04;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @BelongsProject: jucjvm2019
 * @BelongsPackage: com.atguigu.day04
 * @Author: 张世罡
 * @CreateTime: 2022/9/22 20:29
 * @Description:
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread t = new Thread(new Mythread(), "A");
        t.start();

        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread2());
        new Thread(futureTask, "B").start();
        Integer result = futureTask.get();
        System.out.println(result);
    }
}

class Mythread implements Runnable {
    @Override
    public void run() {

    }
}

class MyThread2 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 1024;
    }
}