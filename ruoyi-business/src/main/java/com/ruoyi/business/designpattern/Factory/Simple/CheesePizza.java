package com.ruoyi.business.designpattern.Factory.Simple;

import lombok.extern.slf4j.Slf4j;

/**
 * 奶酪披萨
 * @Author Husp
 * @Date 2023/10/14 17:16
 */
@Slf4j
public class CheesePizza extends Pizza{

    @Override
    public void prepare() {
        setName("CheesePizza");
        log.info(name + " is preparing ... ");
    }

    @Override
    public void bake() {
        setName("CheesePizza");
        log.info(name + " is baking ... ");
    }

    @Override
    public void cut() {
        setName("CheesePizza");
        log.info(name + " is cutting ... ");
    }

    @Override
    public void box() {
        setName("CheesePizza");
        log.info(name + " is boxing ... ");
    }
}
