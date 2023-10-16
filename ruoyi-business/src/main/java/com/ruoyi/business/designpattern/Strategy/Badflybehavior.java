package com.ruoyi.business.designpattern.Strategy;

/**
 * @Author Husp
 * @Date 2023/10/16 11:11
 */
public class Badflybehavior implements Flybehavior{
    @Override
    public void fly() {
        System.out.println(" 飞行技术有待训练");
    }
}
