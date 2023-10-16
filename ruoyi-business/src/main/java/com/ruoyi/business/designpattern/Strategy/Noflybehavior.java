package com.ruoyi.business.designpattern.Strategy;

/**
 * @Author Husp
 * @Date 2023/10/16 11:10
 */
public class Noflybehavior implements Flybehavior{

    @Override
    public void fly() {
        System.out.println(" 不会飞行 ");
    }
}
