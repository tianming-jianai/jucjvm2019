package com.atguigu.day01;

/**
 * @BelongsProject: jucjvm2019
 * @BelongsPackage: com.atguigu.day01
 * @Author: 张世罡
 * @CreateTime: 2022/9/11 16:46
 * @Description:
 *
 * 1. () -> {}
 * 2. @FunctionalInterface
 * 3. default
 * 4. static
 */
public class LambdaExpressDemo {
    public static void main(String[] args) {
        Foo foo = (x, y) -> {
            System.out.println("come in add method");
            return x + y;
        };
        System.out.println(foo.add(1, 3));
        System.out.println(foo.mul(1, 4));
        System.out.println(Foo.div(4, 2));
    }
}

@FunctionalInterface
interface Foo {
    int add(int x, int y);

    default int mul(int x, int y) {
        return x * y;
    }

    default int mul2(int x, int y) {
        return x * y;
    }

    static int div(int x, int y) {
        return x / y;
    }

    static int div2(int x, int y) {
        return x / y;
    }
}
