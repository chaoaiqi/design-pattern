package com.qdu.lc.builder;

/**
 * 使用构造器模式的实现
 *
 * @author lc
 * @date 2020/10/25
 */
public class BuilderPattern {

    public static void main(String[] args) {
        Director director = new Director(new ConcreteBuilder());
        Product product = director.build("值1", "值2", "值3");
        System.out.println(product);

        // 好处1：通过builder接口将复杂构建步骤拆分成了多个部分，代码逻辑清晰，维护性和扩展性都很好
        // 好处2：将对象构建的过程，封装在了director里面，director来基于builder进行构建，构建逻辑修改，不需要修改很多地方
        // 好处3：相对于工厂，有一个很好的抽象设计，director和builder
    }

    public interface Builder {

        void field1(String value);

        void field2(String value);

        void field3(String value);

        Product create();
    }

    public static class Product {

        private String field1;
        private String field2;
        private String field3;

        public String getField1() {
            return field1;
        }

        public void setField1(String field1) {
            this.field1 = field1;
        }

        public String getField2() {
            return field2;
        }

        public void setField2(String field2) {
            this.field2 = field2;
        }

        public String getField3() {
            return field3;
        }

        public void setField3(String field3) {
            this.field3 = field3;
        }

        @Override
        public String toString() {
            return "Product [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
        }

    }

    public static class ConcreteBuilder implements Builder {

        private Product product = new Product();

        @Override
        public void field1(String value) {
            System.out.println("在设置field1之前进行复杂的校验逻辑");
            product.setField1(value);
        }

        @Override
        public void field2(String value) {
            System.out.println("在设置field2之前进行复杂的数据格式转化逻辑");
            product.setField2(value);
        }

        @Override
        public void field3(String value) {
            System.out.println("在设置field3之前进行复杂的数据处理逻辑，跟其他对象的数据进行关联");
            product.setField3(value);
        }

        @Override
        public Product create() {
            return product;
        }

    }

    /**
     * director是面向builder的接口，来编程的
     * director可以复杂控制构建的一个步骤，具体的每个步骤的逻辑封装在具体的builder类中
     * 如果我们此时要更换一整套的构建逻辑，可以再搞一个新的builder类就可以了
     * 但是我们的整个构建步骤是没有任何改变的
     * <p>
     * 如果整个构建步骤变化了，但是对构建的逻辑是没有影响的
     *
     */
    public static class Director {

        private Builder builder;

        Director(Builder builder) {
            this.builder = builder;
        }

        Product build(String field1, String field2, String field3) {
            builder.field1(field1);
            builder.field2(field2);
            builder.field3(field3);
            return builder.create();
        }

    }
}
