package com.qdu.lc.strategy;

/**
 * 使用策略模式的实现
 *
 * @author lc
 * @date 2020/11/2
 */
public class StrategyPattern {

    public static void main(String[] args) {
        int discountStyle = 1;

        DiscountCalculateStrategy strategy = DiscountCalculateStrategyFactory.getDiscountCalculateStrategy(discountStyle);

        Context context = new Context();
        context.setStrategy(strategy);
        context.calculate();

        // 要点1：必须将if else的代码，封装到不同的策略类中
        // 要点2：将选择哪种策略的逻辑给放到一个工厂类中去，选择策略的代码务必很简洁
        // 要点3：context可有可无，具体是看你的策略执行这块如果就一行代码调用，不需要context
        // 如果context中的策略执行逻辑较为复杂一点，context来封装策略类的执行逻辑
    }

    public interface DiscountCalculateStrategy {

        void calculate();

    }

    public static class DiscountCalculateStrategyA implements DiscountCalculateStrategy {
        @Override
        public void calculate() {
            System.out.println("执行优惠计价方式1的复杂业务逻辑");
        }

    }

    public static class DiscountCalculateStrategyB implements DiscountCalculateStrategy {
        @Override
        public void calculate() {
            System.out.println("执行优惠计价方式2的复杂业务逻辑");
        }

    }

    public static class DiscountCalculateStrategyC implements DiscountCalculateStrategy {
        @Override
        public void calculate() {
            System.out.println("执行优惠计价方式3的复杂业务逻辑");
        }

    }

    public static class DiscountCalculateStrategyDefault implements DiscountCalculateStrategy {
        @Override
        public void calculate() {
            System.out.println("执行默认的优惠计价方式的复杂业务逻辑");
        }

    }

    public static class DiscountCalculateStrategyFactory {

        public static DiscountCalculateStrategy getDiscountCalculateStrategy(int discountStyle) {
            if (discountStyle == 1) {
                return new DiscountCalculateStrategyA();
            } else if (discountStyle == 2) {
                return new DiscountCalculateStrategyB();
            } else if (discountStyle == 3) {
                return new DiscountCalculateStrategyC();
            } else {
                return new DiscountCalculateStrategyDefault();
            }
        }

    }

    public static class Context {

        private DiscountCalculateStrategy strategy;

        public DiscountCalculateStrategy getStrategy() {
            return strategy;
        }

        public void setStrategy(DiscountCalculateStrategy strategy) {
            this.strategy = strategy;
        }

        public void calculate() {
            strategy.calculate();
        }

    }
}
