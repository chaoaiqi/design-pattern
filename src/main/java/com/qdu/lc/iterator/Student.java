package com.qdu.lc.iterator;

/**
 * 自定义 学生类
 *
 * @author lc
 * @date 2020/10/18
 */
public class Student {

    private String name;

    public Student(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
