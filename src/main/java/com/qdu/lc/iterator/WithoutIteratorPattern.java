package com.qdu.lc.iterator;

import java.util.HashMap;
import java.util.Map;

/**
 * 不使用迭代器模式的的实现
 *
 * @author lc
 * @date 2020/10/18
 */
public class WithoutIteratorPattern {

    public static void main(String[] args) {
        Student student1 = new Student("小明");
        Student student2 = new Student("小王");

//        Student[] students = new Student[2];
//        students[0] = student1;
//        students[1] = student2;
//
//        Classroom classroom = new Classroom();
//        classroom.setStudents(students);
//
//        Student[] resultStudents = classroom.getStudents();
//        for (Student student : resultStudents) {
//            System.out.println(student);
//        }
        Map<String, Student> studentMap = new HashMap<String, Student>();
        studentMap.put(student1.getName(), student1);
        studentMap.put(student2.getName(), student1);

        Classroom classroom = new Classroom();
        classroom.setStudents(studentMap);
        Map<String, Student> resultStudents = classroom.getStudents();
        for (Student student : resultStudents.values()) {
            System.out.println(student);
        }
        // 如果不用任何设计模式，直接去遍历一个类中的集合
        // 一旦这个类中对集合的使用改版了，比如从数组 -> map，还有别的可能
        // 你迭代的这块代码，就要改动
        // 如果说代码和业务逻辑很复杂，同时集合类的实现和遍历代码的实现，是两个人开发的
        // 成本就很高了，大家又要协调，又要改动
        // 简单来说，这种代码，可扩展性，可维护性，很差。屎一样的代码
    }

    /**
     * 教室类
     */
//    public static class Classroom {
//        private Student[] students;
//
//        public Student[] getStudents() {
//            return students;
//        }
//
//        public void setStudents(Student[] students) {
//            this.students = students;
//        }
//    }
    public static class Classroom {
        private Map<String, Student> students;

        Map<String, Student> getStudents() {
            return students;
        }

        void setStudents(Map<String, Student> students) {
            this.students = students;
        }
    }
}