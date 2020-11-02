package com.qdu.lc.prototype;

/**
 * 使用原型模式的实现
 *
 * @author lc
 * @date 2020/11/2
 */
public class PrototypePattern {

    public static void main(String[] args) {
        try {
            Product product = new Product("测试产品", new Component("测试组件"));
            Product copyProduct = (Product) product.clone();
            System.out.println(copyProduct);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 原型模式，就是在要拷贝的类里实现一个clone()方法，自己拷贝自己
        // 拷贝的时候，就两个概念，浅拷贝，深拷贝

        // 很多地方要克隆这个对象，不要自己维护克隆的逻辑，即使克隆逻辑修改了，只要在clone()方法里面修改
    }

    public static class Component {

        private String name;

        public Component(String name) {
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
            return "Component [name=" + name + "]";
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            super.clone();
            return new Component(name);
        }

    }

    public static class Product {

        private String name;
        private Component component;

        public Product(String name, Component component) {
            super();
            this.name = name;
            this.component = component;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Component getComponent() {
            return component;
        }

        public void setComponent(Component component) {
            this.component = component;
        }

        @Override
        public String toString() {
            return "Product [name=" + name + ", component=" + component + "]";
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            super.clone();
            // 浅拷贝，就是我们现在的一个实现
            // 就是仅仅简单的对当前所有的变量进行一个拷贝
//			return new Product(getName(), getComponent());

            // 深拷贝，递归对自己引用的对象也进行拷贝
            return new Product(name, (Component) component.clone());
        }

    }

}
