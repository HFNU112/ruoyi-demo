package com.ruoyi.business.designpattern.Factory.Simple;

/**
 * 客户端
 * @Author Husp
 * @Date 2023/10/14 23:46
 */
public class Client {

    public static void main(String[] args) {
        new OrderPizza1(new SimpleFactory());
        System.out.println(" exit ");
    }
}
