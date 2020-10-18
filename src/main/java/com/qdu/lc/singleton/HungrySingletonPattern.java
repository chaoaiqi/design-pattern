package com.qdu.lc.singleton;

/**
 * 饿汉模式
 *
 * @author lc
 * @date 2020/10/18
 */
public class HungrySingletonPattern {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.execute();
    }

    static class Singleton {
        /**
         * 第一步：直接就是将这个类的实例在创建出来，赋予static final修饰的变量
         * static：就是一个类的静态变量
         * final：这个变量的引用第一次初始化赋予之后，就再也不能修改引用了
         */
        private static final Singleton instance = new Singleton();

        /**
         * 第二步：将构造函数搞成private私有的
         * 此时除了这个类自己本身，其他任何人都不能创建它的这个实例对象
         */
        private Singleton() {
        }

        /**
         * 第三步：给一个static静态方法，返回自己唯一的内部创建的一个实例
         *
         * @return 单例
         */
        static Singleton getInstance() {
            return instance;
        }

        void execute() {
            System.out.println("单例类的方法");
        }
    }
}
