package com.qdu.lc.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 未使用组合模式的实现
 *
 * @author lc
 * @date 2020/11/2
 */
public class WithoutCompositePattern {

    public static void main(String[] args) {
        Department leafDept1 = new Department("叶子部门1");
        Department leafDept2 = new Department("叶子部门2");
        Department leafDept3 = new Department("叶子部门3");

        Department subDept1 = new Department("子部门1");
        subDept1.getChildren().add(leafDept1);
        subDept1.getChildren().add(leafDept2);

        Department subDept2 = new Department("子部门2");
        subDept2.getChildren().add(leafDept3);

        Department parentDept = new Department("父部门");
        parentDept.getChildren().add(subDept1);
        parentDept.getChildren().add(subDept2);

        for (Department subDept : parentDept.getChildren()) {
            if (subDept.getChildren().size() > 0) {
                for (Department leafDept : subDept.getChildren()) {
                    leafDept.remove();
                }
            }
            subDept.remove();
        }
        parentDept.remove();

        // 问题：对层级数据的操作，很恶心，很不方便，需要手工编写大量的屎一样的代码
        // 平时，屎一样代码的典型特征，四五个，六七个，for if else，嵌套，嵌套的非常深，1年后，团队里没人看得懂你写的代码
    }

    public static class Department {

        private String name;

        private List<Department> children = new ArrayList<>();

        public Department(String name) {
            super();
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Department> getChildren() {
            return children;
        }

        public void setChildren(List<Department> children) {
            this.children = children;
        }

        public void remove() {
            System.out.println("删除部门【" + name + "】");
        }

    }
}
