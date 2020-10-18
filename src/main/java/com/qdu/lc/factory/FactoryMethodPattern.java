package com.qdu.lc.factory;

/**
 * 使用工厂方法模式的实现
 *
 * @author lc
 * @date 2020/10/18
 */
public class FactoryMethodPattern {

    public static void main(String[] args) {
        Product product1 = Product1Factory.get().createProduct();
        Product product2 = Product2Factory.get().createProduct();
        Product product3 = Product3Factory.get().createProduct();

        product1.execute();
        product2.execute();
        product3.execute();
    }

    public interface Product {
        void execute();
    }

    public static class Product1 implements Product {
        @Override
        public void execute() {
            System.out.println("产品1的功能逻辑");
        }
    }

    public static class Product2 implements Product {
        @Override
        public void execute() {
            System.out.println("产品2的功能逻辑");
        }
    }

    public static class Product3 implements Product {
        @Override
        public void execute() {
            System.out.println("产品3的功能逻辑");
        }
    }

    public static abstract class AbstractProductFactory {

        public Product createProduct() {
            commonCreate();
            return specificCreate();
        }

        private void commonCreate() {
            System.out.println("生产产品的通用逻辑，修改");
        }

        protected abstract Product specificCreate();
    }

    public static class Product1Factory extends AbstractProductFactory {

        private static final Product1Factory instance = new Product1Factory();

        private Product1Factory() {
        }

        public static Product1Factory get() {
            return instance;
        }

        @Override
        protected Product specificCreate() {
            System.out.println("生产产品1的特殊逻辑");
            return new Product1();
        }
    }

    public static class Product2Factory extends AbstractProductFactory {

        private static final Product2Factory instance = new Product2Factory();

        private Product2Factory() {}

        public static Product2Factory get() {
            return instance;
        }

        @Override
        public Product specificCreate() {
            System.out.println("生产产品2的特殊逻辑");
            return new Product2();
        }

    }

    public static class Product3Factory extends AbstractProductFactory {

        private static final Product3Factory instance = new Product3Factory();

        private Product3Factory() {}

        public static Product3Factory get() {
            return instance;
        }

        @Override
        public Product specificCreate() {
            System.out.println("生产产品3的特殊逻辑");
            return new Product3();
        }
    }
}
