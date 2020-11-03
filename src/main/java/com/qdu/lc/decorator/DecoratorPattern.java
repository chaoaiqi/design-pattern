package com.qdu.lc.decorator;

/**
 * 装饰器模式
 *
 * @author lc
 * @date 2020/11/3
 */
public class DecoratorPattern {

    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        Component decorator = new Decorator(component);
        decorator.execute();
    }

    public interface Component {

        void execute();

    }

    public static class ConcreteComponent implements Component {
        @Override
        public void execute() {
            System.out.println("执行基础功能");
        }

    }

    public static class Decorator implements Component {

        private Component component;

        public Decorator(Component component) {
            this.component = component;
        }

        @Override
        public void execute() {
            System.out.println("在执行基础功能之前，执行部分功能增强");
            component.execute();
            System.out.println("在执行基础功能之后，执行部分功能增强");
        }

    }
}
