package com.ruoyi.business.designpattern.Factory.Abstract;

import com.ruoyi.business.designpattern.Factory.Abstract.Pizza;

/**
 * @Author Husp
 * @Date 2023/10/30 16:27
 */
public class BJPepperPizza extends Pizza {

    @Override
    public void prepare() {
        setName("北京胡椒披萨");
        System.out.println(name + " is preparing ... ");
    }
}
