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
        setName("希腊披萨");
        log.info(name + " is preparing ... ");
    }

    @Override
    public void bake() {
        setName("希腊披萨");
        log.info(name + " is baking ... ");
    }

    @Override
    public void cut() {
        setName("希腊披萨");
        log.info(name + "is cutting ... ");
    }

    @Override
    public void box() {
        setName("希腊披萨");
        log.info(name + "is boxing ... ");
    }
}
