package com.ruoyi.business.designpattern.Factory.Abstract;

/**
 * @Author Husp
 * @Date 2023/10/30 16:54
 */
public interface AbstractPizzaFactory {

    Pizza createPizza(String orderType);
}
