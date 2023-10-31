package com.ruoyi.business.designpattern.Factory.Abstract;

import com.ruoyi.business.designpattern.Factory.Abstract.Pizza;

/**
 * @Author Husp
 * @Date 2023/10/30 16:29
 */
public class LDPepperPizza extends Pizza {

    @Override
    public void prepare() {
        setName("伦敦胡椒披萨");
        System.out.println(name + "is preparing ...");
    }
}
