package com.qdu.lc.bridge;

/**
 * 桥接模式
 *
 * @author lc
 * @date 2020/11/3
 */
public class BridgePattern {

    public static void main(String[] args) {
        Implementor implementor = new ConcreteImplementor();
        Abstraction abstraction = new RefinedAbstraction(implementor);
        abstraction.execute();

        // implementor可以认为是一个代码组件，包含了一个接口和一个实现类
        // abstraction可以认为是一个代码组件，包含了一个抽象类和一个子类
        // abstraction要调用implementor的接口
        // 在abstraction中包含了一个implementor的接口
        // 在abstraction调用implementor的时候，实际上是面向implementor接口去编程和调用的
        // 只不过我们会将implementor的实现类实例传入abstraction中

        // abstraction调用implementor就是基于一个桥去调用的
        // 不是说abstraction直接仅仅面向implementor实现类去编程的，面向implementor接口去编程的
        // 所以abstraction和implementor两个代码组件之间的桥，就是implementor接口
        // 这个一个代码组件面向另外一个代码组件的接口来编程，就是将那个接口作为一个桥
        // 使用了桥接的设计模式来编程

        // 桥接模式，都不需要运用，java之中，无处不桥接
        // 几乎所有的编程，都是面向接口去编程的
    }

    public interface Implementor {

        void execute();

    }

    public static class ConcreteImplementor implements Implementor {
        @Override
        public void execute() {
            System.out.println("执行了功能逻辑");
        }

    }

    public static abstract class Abstraction {

        protected Implementor implementor;

        public Abstraction(Implementor implementor) {
            this.implementor = implementor;
        }

        public abstract void execute();

    }

    public static class RefinedAbstraction extends Abstraction {

        public RefinedAbstraction(Implementor implementor) {
            super(implementor);
        }

        @Override
        public void execute() {
            implementor.execute();
        }

    }
}
