package com.qdu.lc.proxy;

/**
 * 代理模式
 *
 * @author lc
 * @date 2020/11/2
 */
public class ProxyPattern {

    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Subject proxy = new Proxy(subject);
        proxy.request();
    }

    public interface Subject {

        void request();

    }

    public static class ConcreteSubject implements Subject {

        @Override
        public void request() {
            System.out.println("执行请求");
        }

    }

    public static class Proxy implements Subject {

        private Subject subject;

        public Proxy(Subject subject) {
            this.subject = subject;
        }

        @Override
        public void request() {
            System.out.println("执行额外的条件判断，拷贝是否要调用subject的request()方法");
            boolean invoke = true;
            if (invoke) {
                subject.request();
            }
        }

    }
}
