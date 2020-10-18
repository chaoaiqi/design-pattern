package com.qdu.lc.factory;

/**
 * 不使用简单工厂模式的实现
 *
 * @author lc
 * @date 2020/10/18
 */
public class WithoutFactoryPattern {

    public static void main(String[] args) {
        Product2 product = new Product2("测试产品");
        System.out.println(product);

        // 有什么问题
        // 如果你直接面向一个类来编程，new来创建类的实例的话，你就是后面会死的很惨
        // 我们如果对Product，要更换一个类，换一个类的实现
        // 此时就必须在创建这个类实例的地方，都要修改一下这个代码
        // 如果你有100个地方，都创建了Product这个类的实例
        // 你需要在100个地方都去修改这个new Product()的这段代码
        // 代码可维护性和可扩展性之差，惨不忍睹，垃圾代码
    }
    //	static class Product {
//
//		private String name;
//
//		Product(String name) {
//			super();
//			this.name = name;
//		}
//
//		public String getName() {
//			return name;
//		}
//
//		public void setName(String name) {
//			this.name = name;
//		}
//
//		@Override
//		public String toString() {
//			return "Product [name=" + name + "]";
//		}
//
//	}
    static class Product2 {

        private String name;

        Product2(String name) {
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
            return "Product [name=" + name + "]";
        }

    }
}
