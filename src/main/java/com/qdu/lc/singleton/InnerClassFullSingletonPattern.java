package com.qdu.lc.singleton;

/**
 * 这个才是我们实际开发过程中，最最常用的单例模式，内部类的方式来实现
 *
 * @author lc
 * @date 2020/10/18
 */
public class InnerClassFullSingletonPattern {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.execute();
    }

    /**
     * 可以做饱汉模式
     * 内部类，只要没有被使用，就不会初始化，Singleton的实例就不会创建
     * 在第一次有人调用getInstance方法的时候，内部类会初始化，创建一个Singleton的实例
     * 然后java能确保的一点是，类静态初始化的过程一定只会执行一次
     */
    static class Singleton {

        private Singleton() {
        }

        static class InnerHolder {
            static final Singleton instance = new Singleton();
        }

        static Singleton getInstance() {
            return InnerHolder.instance;
        }

        void execute() {
            System.out.println("单例类的方法");
        }
    }
}
