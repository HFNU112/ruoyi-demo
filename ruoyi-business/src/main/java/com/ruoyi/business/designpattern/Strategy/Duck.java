package com.ruoyi.business.designpattern.Strategy;

/**
 * 鸭子抽象类
 * @Author Husp
 * @Date 2023/10/16 10:54
 */
public abstract class Duck {

    protected String name;

    protected Flybehavior flybehavior;

    protected Swimbehavior swimbehavior;

    public void setName(String name) {
        this.name = name;
    }

    public void setFlybehavior(Flybehavior flybehavior) {
        this.flybehavior = flybehavior;
    }

    public abstract void fly();

    public abstract void swim();

    public abstract void quack();

    // 显示鸭子信息
    public abstract void display();
}
