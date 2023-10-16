package com.ruoyi.business.designpattern.Strategy;

/**
 * @Author Husp
 * @Date 2023/10/16 11:39
 */
public class Badswimbehavior implements Swimbehavior{

    @Override
    public void swim() {
        System.out.println(" 游泳有待训练");
    }
}
