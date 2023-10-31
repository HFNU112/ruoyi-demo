package com.ruoyi.business.designpattern.Factory.Abstract;

/**
 * @Author Husp
 * @Date 2023/10/30 16:57
 */
public class LDPizzaFactory implements AbstractPizzaFactory{

    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        switch (orderType) {
            case "cheese":
                pizza = new LDCheesePizza();
                break;
            case "pepper":
                pizza = new LDPepperPizza();
            default:
                break;
        }
        return pizza;
    }
}
