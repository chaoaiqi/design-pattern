package com.qdu.lc.mediator;

/**
 *
 * 使用中介者模式的实现
 *
 * @author lc
 * @date 2020/11/2
 */
public class MediatorPattern {

    public static void main(String[] args) {
        Mediator mediator = new Mediator();

        ModuleA moduleA = new ModuleA(mediator);
        ModuleB moduleB = new ModuleB(mediator);
        ModuleC moduleC = new ModuleC(mediator);

        moduleA.execute();
        moduleB.execute();
        moduleC.execute();

        // 好处在哪儿
        // moduleA，只要知道一个中介者就可以了，具体跟其他模块的交互都封装在中介者里面了
        // moduleB，同上
        // moduleC，同上
        // moduleA、B、C之间不再有任何的耦合，不再有复杂的交互关系，互相之间修改不会对对方产生什么影响
    }

    public static class Mediator {

        private ModuleA moduleA;
        private ModuleB moduleB;
        private ModuleC moduleC;

        public ModuleA getModuleA() {
            return moduleA;
        }

        public void setModuleA(ModuleA moduleA) {
            this.moduleA = moduleA;
        }

        public ModuleB getModuleB() {
            return moduleB;
        }

        public void setModuleB(ModuleB moduleB) {
            this.moduleB = moduleB;
        }

        public ModuleC getModuleC() {
            return moduleC;
        }

        public void setModuleC(ModuleC moduleC) {
            this.moduleC = moduleC;
        }

        public void moduleAInvoke() {
            moduleB.execute("模块A通知中介者");
            moduleC.execute("模块A通知中介者");
        }

        public void moduleBInvoke() {
            moduleA.execute("模块B通知中介者");
            moduleC.execute("模块B通知中介者");
        }

        public void moduleCInvoke() {
            moduleA.execute("模块C通知中介者");
            moduleB.execute("模块C通知中介者");
        }

    }

    public static class ModuleA {

        private Mediator mediator;

        public ModuleA(Mediator mediator) {
            this.mediator = mediator;
            this.mediator.setModuleA(this);
        }

        public void execute() {
            mediator.moduleAInvoke();
        }

        public void execute(String invoker) {
            System.out.println(invoker + "在调用模块A的功能");
        }

    }

    public static class ModuleB {

        private Mediator mediator;

        public ModuleB(Mediator mediator) {
            this.mediator = mediator;
            this.mediator.setModuleB(this);
        }

        public void execute() {
            mediator.moduleBInvoke();
        }

        public void execute(String invoker) {
            System.out.println(invoker + "在调用模块B的功能");
        }

    }

    public static class ModuleC {

        private Mediator mediator;

        public ModuleC(Mediator mediator) {
            this.mediator = mediator;
            this.mediator.setModuleC(this);
        }

        public void execute() {
            mediator.moduleCInvoke();
        }

        public void execute(String invoker) {
            System.out.println(invoker + "在调用模块C的功能");
        }

    }
}
