package com.ruoyi.business.designpattern.Factory.Abstract;

import com.ruoyi.business.designpattern.Factory.Abstract.Pizza;

/**
 * @Author Husp
 * @Date 2023/10/30 16:25
 */
public class BJCheesePizza extends Pizza {

    @Override
    public void prepare() {
        setName("北京奶酪披萨");
        System.out.println(name + " is preparing ...");
    }
}
