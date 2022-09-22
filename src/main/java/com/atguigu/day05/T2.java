package com.atguigu.day05;

/**
 * @BelongsProject: jucjvm2019
 * @BelongsPackage: com.atguigu.day05
 * @Author: 张世罡
 * @CreateTime: 2022/9/22 22:38
 * @Description:
 */
public class T2 {
    public static void main(String[] args) {
        Thread t = new Thread();
        t.start();
        // Exception in thread "main" java.lang.IllegalThreadStateException
        t.start();
    }
}
