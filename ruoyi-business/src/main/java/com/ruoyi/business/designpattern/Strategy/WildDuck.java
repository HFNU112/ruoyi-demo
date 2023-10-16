package com.ruoyi.business.designpattern.Strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author Husp
 * @Date 2023/10/16 10:59
 */
@Slf4j
public class WildDuck extends Duck{

    public WildDuck() {
        super();
        setName(" 野鸭 ");
        flybehavior = new Goodflybehavior();
    }

    @Override
    public void fly() {
        System.out.println(name + "在飞翔");
    }

    @Override
    public void swim() {
        System.out.println(name + "在游泳");
    }

    @Override
    public void quack() {
        System.out.println(name + "呱呱叫");
    }

    @Override
    public void display() {
        log.info("野鸭");
    }
}
