package com.atguigu.day01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @BelongsProject: jucjvm2019
 * @BelongsPackage: com.atguigu.day01
 * @Author: 张世罡
 * @CreateTime: 2022/9/12 13:21
 * @Description:
 * 1. 故障现象
 *      java.util.ConcurrentModificationException
 * 2. 导致原因
 *      多线程并发情况下，未加锁，线程争夺资源类
 * 3. 解决方案
 * new Vector<>(); // 同步锁太重
 * Collections.synchronizedList(new ArrayList<>());
 * new CopyOnWriteArrayList();
 *
 * 4. 优化建议（同样的错误不犯第2次）
 *
 *
 * 写时复制：
 * CopyOnWrite容器即写时复制的容器。向一个容器添加元素的时候，不直接向当前容器Object[]添加，而是先将当前容器Object[]进行Copy，
 * 复制出一个新的容器Object[] newElements，然后新的容器Object[] newElements里添加元素，添加完元素之后，
 * 再将原容器的引用指向新的容器setArray(newElements); 这样的好处是可以对CopyOnWrite容器进行并发的读，
 * 而不需要加锁，因为当前容器不会添加任何元素。所以CopyOnWrite容器也是一种读写分离的思想，读和写不同的容器
 *
 */
public class NotSafeDemo03 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        // Map<String, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }

    private static void setNotSafe() {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }

    private static void listNotSafe() {
        // ArrayList 线程不安全
        // List<String> list = new ArrayList<>(); // 线程不安全
        // List<String> list = new Vector<>(); // 同步锁太重
        // List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList();

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
