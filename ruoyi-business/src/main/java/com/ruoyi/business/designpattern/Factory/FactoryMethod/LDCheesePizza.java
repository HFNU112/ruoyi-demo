package com.ruoyi.business.designpattern.Factory.FactoryMethod;

/**
 * @Author Husp
 * @Date 2023/10/30 16:28
 */
public class LDCheesePizza extends Pizza{

    @Override
    public void prepare() {
        setName("伦敦奶酪披萨");
        System.out.println(name + " is preparing ... ");
    }
}
