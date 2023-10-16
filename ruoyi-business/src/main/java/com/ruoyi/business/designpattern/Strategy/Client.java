package com.ruoyi.business.designpattern.Strategy;

/**
 * @Author Husp
 * @Date 2023/10/16 11:19
 */
public class Client {

    public static void main(String[] args) {
        Duck wildDuck =new WildDuck();
        wildDuck.fly();

        System.out.println("--------------------");
        Duck pekingDuck = new PekingDuck();
        pekingDuck.swim();
    }
}
