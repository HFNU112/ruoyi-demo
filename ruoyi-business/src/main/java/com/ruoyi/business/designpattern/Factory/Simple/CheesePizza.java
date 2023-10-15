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
        setName("奶酪披萨");
        log.info(name + " is preparing ... ");
    }

    @Override
    public void bake() {
        setName("奶酪披萨");
        log.info(name + " is baking ... ");
    }

    @Override
    public void cut() {
        setName("奶酪披萨");
        log.info(name + " is cutting ... ");
    }

    @Override
    public void box() {
        setName("奶酪披萨");
        log.info(name + " is boxing ... ");
    }
}
