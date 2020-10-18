package com.qdu.lc.adapter;

/**
 * 不使用适配器模式的实现
 *
 * @author lc
 * @date 2020/10/18
 */
public class WithoutAdapterPattern {

    public static void main(String[] args) {
        OldInterface oldObject = new OldInterfaceImpl();
        NewInterface newObject = new NewInterfaceImpl();
        oldObject.oldExecute();
        newObject.newExecute();

        // 如果不用任何设计模式，我们的问题在哪儿？
        // 问题其实很明显，就是说，我们的新的代码中，融合了新老两套接口，很麻烦的一个事情
        // 首先如果你这么干的话，就会导致代码很恶心，面向的是规范和风格完全不同的两套接口，你理解和维护的成本提高了
        // 其次，假如说，现在都不给你选择使用老版本接口的机会
        // 直接强制性公司规范要求按照新版本接口来走，你的老版本接口的实现类，就没法用了啊？
        // 难不成还要基于新版本的接口重新写一套？
    }

    /**
     * 老版本接口
     */
    interface OldInterface {
        void oldExecute();
    }

    /**
     * 老版本接口的实现类
     */
    static class OldInterfaceImpl implements OldInterface {
        @Override
        public void oldExecute() {
            System.out.println("老版本接口实现的功能逻辑");
        }

    }

    /**
     * 新版本接口
     */
    interface NewInterface {
        void newExecute();
    }

    /**
     * 新版本接口的实现类
     */
    static class NewInterfaceImpl implements NewInterface {
        @Override
        public void newExecute() {
            System.out.println("新版本接口实现的功能逻辑");
        }
    }
}
