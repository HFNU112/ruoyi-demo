package com.ruoyi.business.designpattern.Factory.Simple;

import lombok.extern.slf4j.Slf4j;

/**
 * 希腊披萨
 * @Author Husp
 * @Date 2023/10/14 17:19
 */
@Slf4j
public class GreekPizza extends Pizza{

    @Override
    public void prepare() {
        setName("GreekPizza");
        log.info(name + " is preparing ... ");
    }

    @Override
    public void bake() {
        setName("GreekPizza");
        log.info(name + " is baking ... ");
    }

    @Override
    public void cut() {
        setName("GreekPizza");
        log.info(name + "is cutting ... ");
    }

    @Override
    public void box() {
        setName("GreekPizza");
        log.info(name + "is boxing ... ");
    }
}
