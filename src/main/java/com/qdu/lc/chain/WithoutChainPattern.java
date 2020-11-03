package com.qdu.lc.chain;

/**
 * 未使用责任链模式的实现
 *
 * @author lc
 * @date 2020/11/3
 */
public class WithoutChainPattern {

    public static void main(String[] args) {
        // 业务流程1
        System.out.println("执行功能1");
        System.out.println("执行功能2");
        System.out.println("执行功能3");

        // 业务流程2
        System.out.println("执行功能3");
        System.out.println("执行功能1");
        System.out.println("执行功能2");

        // 有什么问题？
        // 第一个，大量的重复代码出现了，功能123的代码，都出现在了两个地方，有复制粘贴的现象
        // 如果说，现在要对某个功能的代码进行修改，那么就会很麻烦，要在多个地方去修改这个功能的代码
        // 另外一个问题是说，如果现在要对某个业务流程的顺序进行调整或者改造，很麻烦，要去修改大量的代码
    }
}
