package com.ruoyi.business.designpattern.Strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author Husp
 * @Date 2023/10/16 11:09
 */
@Slf4j
public class Goodflybehavior implements Flybehavior{

    @Override
    public void fly() {
        System.out.println("飞翔很好");
    }
}
