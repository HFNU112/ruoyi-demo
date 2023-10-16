package com.ruoyi.business.designpattern.Strategy;

/**
 * @Author Husp
 * @Date 2023/10/16 11:38
 */
public class Noswimbehavior implements Swimbehavior{

    @Override
    public void swim() {
        System.out.println(" 不会游泳 ");
    }
}
