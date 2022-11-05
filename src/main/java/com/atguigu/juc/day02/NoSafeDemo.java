package com.atguigu.juc.day02;

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
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

/**
 * @BelongsProject: jucjvm2019
 * @BelongsPackage: com.atguigu.juc.day02
 * @Author: 张世罡
 * @CreateTime: 2022/11/4 21:05
 * @Description:
 */
public class NoSafeDemo {

    public static void main(String[] args) {
        // HashMap<String, String> map1 = new HashMap<>();
        // java.util.ConcurrentModificationException

        // Map<String, String> map = Collections.synchronizedMap(map1);
        Map<String, String> map = new ConcurrentHashMap();

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException e) {
                }
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }

    public void setNotSafe() {
        Set<String> set = new HashSet<>();
        // java.util.ConcurrentModificationException
        // Set<String> set = Collections.synchronizedSet(set1);
        // Set<String> set = new CopyOnWriteArraySet<>();

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException e) {
                }
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }

    public void listNotSafe() {
        // List<String> list1 = new ArrayList<>();
        // List<String> list = new Vector<>();
        // List<String> list = Collections.synchronizedList(list1);
        List<String> list = new CopyOnWriteArrayList<>();
        // *写时复制
        // Copyonwrite容器即写时复制的容器。往一个容器添加元素的时候，不直按往当前容object[]添加，
        // 而是先将当前容器object[]进行copy ,复制出一个新的容器object[] newELements，然后新的容器object[] newElements里添加元素，
        // 添加完元素之后，
        // 再将原容器的引用指向新的容器setArray(newELements);。
        // 这样做的好处是可以对CopyOnwrite容器进行并发的读，而不需要加锁，因为当前容器不会添加任何元素。
        // 所以CopyOnwrite容器也是一种读写分离的思想，读和写不同的容I

        // 多线程，数据一致性
        // java.util.ConcurrentModificationException
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException e) {
                }
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
