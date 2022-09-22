package com.atguigu.day05;

/**
 * @BelongsProject: jucjvm2019
 * @BelongsPackage: com.atguigu.day05
 * @Author: 张世罡
 * @CreateTime: 2022/9/22 21:35
 * @Description:
 */
public class MyObject {
    public static void main(String[] args) {
        Object object = new Object();
        // null BootStrap类加载器
        System.out.println(object.getClass().getClassLoader());

        MyObject myObject = new MyObject();
        // null
        System.out.println(myObject.getClass().getClassLoader().getParent().getParent());
        // jdk.internal.loader.ClassLoaders$PlatformClassLoader@119d7047
        System.out.println(myObject.getClass().getClassLoader().getParent());
        // jdk.internal.loader.ClassLoaders$AppClassLoader@63947c6b
        System.out.println(myObject.getClass().getClassLoader());

    }
}
