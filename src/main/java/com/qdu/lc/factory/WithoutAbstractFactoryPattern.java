package com.qdu.lc.factory;

/**
 * 不使用抽象工厂模式的实现
 *
 * @author lc
 * @date 2020/10/18
 */
public class WithoutAbstractFactoryPattern {

    public static void main(String[] args) {
        // 我们现在要创建产品A1+产品B1的组合
//		ProductA productA1 = new ProductA1();
//		ProductB productB1 = new ProductB1();
//
//		productA1.execute();
//		productB1.execute();

        // 变成产品A1+产品B3的组合
        ProductA productA1 = new ProductA1();
        ProductB otherProductB3 = new ProductB3();

        productA1.execute();
        otherProductB3.execute();

        // 问题来了，调整产品组合的这个行为，如果你手动创建产品组合的代码，有100个地方，A1+B1
        // 一旦要调整，就是要对100个地方的代码，手动一点一点的去修改，组合的逻辑
        // 不可维护，不可扩展

        // 我们现在要创建产品A2+产品B2的组合
        ProductA productA2 = new ProductA2();
        ProductB productB2 = new ProductB2();

        productA2.execute();
        productB2.execute();

        // 我们现在要创建产品A3+产品B3的组合
        ProductA productA3 = new ProductA3();
        ProductB productB3 = new ProductB3();

        productA3.execute();
        productB3.execute();
    }

    public interface ProductA {
        void execute();
    }

    public static class ProductA1 implements ProductA {
        @Override
        public void execute() {
            System.out.println("产品A1的功能逻辑");
        }
    }

    public static class ProductA2 implements ProductA {
        @Override
        public void execute() {
            System.out.println("产品A2的功能逻辑");
        }
    }

    public static class ProductA3 implements ProductA {
        @Override
        public void execute() {
            System.out.println("产品A3的功能逻辑");
        }
    }

    public interface ProductB {
        void execute();
    }

    public static class ProductB1 implements ProductB {
        @Override
        public void execute() {
            System.out.println("产品B1的功能逻辑");
        }
    }

    public static class ProductB2 implements ProductB {
        @Override
        public void execute() {
            System.out.println("产品B2的功能逻辑");
        }
    }

    public static class ProductB3 implements ProductB {
        @Override
        public void execute() {
            System.out.println("产品B3的功能逻辑");
        }
    }
}
