package com.ruoyi.business.designpattern.Factory.Simple;

/**
 * @Author Husp
 * @Date 2023/10/14
 */
public class SimpleFactory {

    // 制作Pizza的方法
    public Pizza createPizza(String orderType){
        Pizza pizza = null;
        switch (orderType) {
            case "cheese":
                pizza = new CheesePizza();
                break;
            case "greek":
                pizza = new GreekPizza();
                break;
            case "pepper":
                pizza = new PepperPizza();
                break;
            default:
                break;
        }
        return  pizza;
    }
}
