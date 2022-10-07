package com.atguigu.day05;

/**
 * @BelongsProject: jucjvm2019
 * @BelongsPackage: com.atguigu.day05
 * @Author: 张世罡
 * @CreateTime: 2022/10/7 16:24
 * @Description:
 */
public class Person {
    private String personName;

    public Person(String personName) {
        this.personName = personName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personName='" + personName + '\'' +
                '}';
    }
}
