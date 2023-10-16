package com.ruoyi.business.designpattern.Decorator;

/**
 * 咖啡类
 * @Author Husp
 * @Date 2023/10/16 9:55
 */
public class Coffee extends Drinks{

    @Override
    public double cost() {
        return super.getPrice();
    }
}
