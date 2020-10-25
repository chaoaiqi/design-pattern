package com.qdu.lc.builder;

/**
 * 构造器模式优化
 *
 * @author lc
 * @date 2020/10/25
 */
public class OptimizedBuilderPattern {

    public static void main(String[] args) {
        Product product = new ConcreteBuilder()
                .field1("值1")
                .field2("值2")
                .field3("值3")
                .create();
        System.out.println(product);

        // 现在基本上流行的一些开源框架，构造器模式的运用，一般都是上面这种变种模式
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

    public interface Builder {

        Builder field1(String value);

        Builder field2(String value);

        Builder field3(String value);

        Product create();

    }

    public static class ConcreteBuilder implements Builder {

        private Product product = new Product();

        @Override
        public Builder field1(String value) {
            System.out.println("在设置field1之前进行复杂的校验逻辑");
            product.setField1(value);
            return this;
        }

        @Override
        public Builder field2(String value) {
            System.out.println("在设置field2之前进行复杂的数据格式转化逻辑");
            product.setField2(value);
            return this;
        }

        @Override
        public Builder field3(String value) {
            System.out.println("在设置field3之前进行复杂的数据处理逻辑，跟其他对象的数据进行关联");
            product.setField3(value);
            return this;
        }

        @Override
        public Product create() {
            return product;
        }

    }
}
