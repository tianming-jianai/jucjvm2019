package com.atguigu.day05;

/**
 * @BelongsProject: jucjvm2019
 * @BelongsPackage: com.atguigu.day05
 * @Author: 张世罡
 * @CreateTime: 2022/10/7 16:17
 * @Description:
 */
public class TestTransferValue {
    public void changeValue1(int age) {
        age = 30;
    }

    public void changeValue2(Person person) {
        person.setPersonName("xxx");
    }

    public void changeValue3(String str) {
        str = "xxx";
    }

    public static void main(String[] args) {
        TestTransferValue test = new TestTransferValue();
        int age = 20;
        test.changeValue1(age);
        System.out.println("age --- " + age);

        Person p = new Person("abc");
        test.changeValue2(p);
        System.out.println("personName --- " + p.getPersonName());

        String str = "abc";
        test.changeValue3(str);
        System.out.println("str --- " + str);
    }
}
