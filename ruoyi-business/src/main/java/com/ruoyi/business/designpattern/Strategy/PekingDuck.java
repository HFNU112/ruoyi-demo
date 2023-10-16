package com.ruoyi.business.designpattern.Strategy;

/**
 * 北京鸭
 * @Author Husp
 * @Date 2023/10/16 11:33
 */
public class PekingDuck extends Duck{

    /**
     * 构造器初始化
     */
    public PekingDuck() {
        super();
        setName("北京鸭");
        swimbehavior = new Badswimbehavior();
    }

    @Override
    public void fly() {
        System.out.println(name + " 不会飞行");
    }

    @Override
    public void swim() {
        System.out.println(name + " 游泳很好 ");
    }

    @Override
    public void quack() {
        System.out.println(name + " 呱呱叫 ");
    }

    @Override
    public void display() {
        System.out.println(" 北京鸭 ");
    }
}
