package com.ruoyi.business.designpattern.Factory.Simple;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author Husp
 * @Date 2023/10/14 22:47
 */
@Slf4j
public class PepperPizza extends Pizza{

    @Override
    public void prepare() {
        setName("胡椒披萨");
        log.info(name + " is preparing ... ");
    }

    @Override
    public void bake() {
        setName("胡椒披萨");
        log.info(name + " is baking ... ");
    }

    @Override
    public void cut() {
        setName("胡椒披萨");
        log.info(name + " is cutting ... ");
    }

    @Override
    public void box() {
        setName("胡椒披萨");
        log.info(name + " is boxing ... ");
    }
}
