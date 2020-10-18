package com.qdu.lc.template;

/**
 * 不使用模板方法模式的实现
 *
 * @author lc
 * @date 2020/10/18
 */
public class WithoutTempalteMethodPattern {

    public static void main(String[] args) {
        DiscountCalculator1 calculator1 = new DiscountCalculator1();
        calculator1.calculate();
        DiscountCalculator2 calculator2 = new DiscountCalculator2();
        calculator2.calculate();
        DiscountCalculator3 calculator3 = new DiscountCalculator3();
        calculator3.calculate();

        // 有一个问题
        // 就是说，这个三种优惠方式计算器里面，都有一段通用的计算逻辑，是完全相同的代码
        // 但是相同的一段代码，给通过复制粘贴的方式，放到了不同的类里去
        // 一旦说，那段通用的计算逻辑，要修改，就涉及到多个类都要去修改那个代码
        // 如果你一旦忘了修改某个类中的那段代码，后果不堪设想
        // 而且到了后期，几乎没人记得清楚，那段通用逻辑代码放在了多少个类中，如果要排查，需要将很多类重新读一遍代码
        // 这就是垃圾代码，扩展性，维护性，很烂
    }

    static class DiscountCalculator1 {
        void calculate() {
            System.out.println("通用的计算逻辑，修改了一下");
            System.out.println("优惠计算器1的特殊计算逻辑");
        }
    }

    static class DiscountCalculator2 {
        void calculate() {
            System.out.println("通用的计算逻辑，修改了一下");
            System.out.println("优惠计算器2的特殊计算逻辑");
        }
    }

    static class DiscountCalculator3 {
        void calculate() {
            System.out.println("通用的计算逻辑");
            System.out.println("优惠计算器3的特殊计算逻辑");
        }
    }
}
