package com.qdu.lc.adapter;

/**
 * 使用适配器模式的实现
 *
 * @author lc
 * @date 2020/10/18
 */
public class AdapterPattern {

    public static void main(String[] args) {
        NewInterface oldObject = new NewInterfaceAdapter(new OldInterfaceImpl());
        NewInterface newObject = new NewInterfaceImpl();
        oldObject.newExecute();
        newObject.newExecute();

        // 适配器模式
        // 就是你手上有新老俩接口和一个老接口的实现类
        // 但是现在系统中要面向新接口来开发，老接口的实现类就不能直接用了，不能直接面向老接口来开发
        // 开发一个老接口到新接口的一个适配器
        // 适配器是实现了新接口的，但是适配器中持有老接口实现类实例的引用
        // 适配器的新接口方法的实现，全部基于老接口实现类的老方法来实现即可
        // 对于调用方而言，只要使用适配器来开发即可，就可以通过面向新接口开发，底层使用老接口实现类
    }

    public static class NewInterfaceAdapter implements NewInterface {

        private OldInterface oldObject;

        NewInterfaceAdapter(OldInterface oldObject) {
            this.oldObject = oldObject;
        }

        @Override
        public void newExecute() {
            oldObject.oldExecute();
        }
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
