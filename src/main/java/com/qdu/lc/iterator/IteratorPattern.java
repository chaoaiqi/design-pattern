package com.qdu.lc.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用迭代器模式的的实现
 *
 * @author lc
 * @date 2020/10/18
 */
public class IteratorPattern {

    public static void main(String[] args) {
        Student student1 = new Student("小明");
        Student student2 = new Student("小王");

        Classroom classroom = new Classroom(2);
        classroom.addStudent(student1);
        classroom.addStudent(student2);

        java.util.Iterator<Student> iterator = classroom.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student);
        }
    }

    /**
     * 内部定义一个迭代器接口
     */
    public interface Iterator {
        boolean hasNext();
        Object next();
    }

    /**
     * 内部定义一个集合类接口
     */
    public interface Aggregate {
        java.util.Iterator<Student> iterator();
    }

    /**
     * 教室类迭代器
     */
    public static class ClassroomIterator implements Iterator {
        private Classroom classroom;
        private int index;

        public ClassroomIterator(Classroom classroom) {
            this.classroom = classroom;
            this.index = 0;
        }

        /**
         * 假设此时index是0, classroom的length是2
         * 那么肯定是可以去获取下一个学生的，此时数组还没遍历完
         * <p>
         * 假设此时index是2，classroom的length是2， classroom可以遍历的数组offset只能是0和1
         *
         * @return 返回是否还有数据
         */
        @Override
        public boolean hasNext() {
            return index < classroom.getLength();
        }

        /**
         * 从数组中获取当前的这个学生，同时将index往下移动一位
         * 比如一开始index是0，然后数组长度是2
         * 此时遍历获取了第一个学生之后，返回了数组的0元素，然后将index变为1了
         *
         * @return 数据
         */
        @Override
        public Object next() {
            return classroom.getStudent(index++);
        }
    }

    /**
     * 教室类
     */
    public static class Classroom implements Aggregate {
        //        private Student[] students;
        private List<Student> students;
        /**
         * last 相当于是数组的长度
         */
        private int last = 0;

        Classroom(int size) {
//            this.students = new Student[size];
            this.students = new ArrayList<>(size);
        }

        public Student getStudent(int index) {
//            return students[index];
            return students.get(index);
        }

        void addStudent(Student student) {
//            this.students[last] = student;
            this.students.add(student);
            ++last;
        }

        int getLength() {
            return last;
        }

        /**
         * 返回一个教室迭代器， 其中封装了教室自己，让迭代器可以获取教室中的数据
         *
         * @return 教室迭代器自己
         */
        @Override
        public java.util.Iterator<Student> iterator() {
            return students.iterator();
        }
    }
}
