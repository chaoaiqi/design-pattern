package com.qdu.lc.template;

/**
 * 使用模板方法模式的实现
 *
 * @author lc
 * @date 2020/10/18
 */
public class TemplateMethodPattern {
    public static void main(String[] args) {
        DiscountCalculator calculator1 = new DiscountCalculator1();
        calculator1.calculate();
        DiscountCalculator calculator2 = new DiscountCalculator2();
        calculator2.calculate();
        DiscountCalculator calculator3 = new DiscountCalculator3();
        calculator3.calculate();
    }

    interface DiscountCalculator {
        void calculate();
    }
    /**
     * 模板方法模式 实现的精华所在
     */
    static abstract class AbstractDiscountCalculator implements DiscountCalculator {
        @Override
        public void calculate() {
            // 完成通用的计算逻辑
            commonCalculate();
            // 完成特殊的计算逻辑
            specificCalculate();
        }
        private void commonCalculate() {
            System.out.println("通用的计算逻辑，修改了一下");
        }
        protected abstract void specificCalculate();
    }

    static class DiscountCalculator1 extends AbstractDiscountCalculator {
        @Override
        public void specificCalculate() {
            System.out.println("优惠计算器1的特殊计算逻辑");
        }
    }

    static class DiscountCalculator2 extends AbstractDiscountCalculator {
        @Override
        public void specificCalculate() {
            System.out.println("优惠计算器2的特殊计算逻辑");
        }
    }

    static class DiscountCalculator3 extends AbstractDiscountCalculator {
        @Override
        public void specificCalculate() {
            System.out.println("优惠计算器3的特殊计算逻辑");
        }
    }
}
