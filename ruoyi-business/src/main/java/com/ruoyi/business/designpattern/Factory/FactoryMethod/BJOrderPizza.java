package com.ruoyi.business.designpattern.Factory.FactoryMethod;

/**
 * @Author Husp
 * @Date 2023/10/30 16:40
 */
public class BJOrderPizza extends OrderPizza{

    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        switch (orderType){
            case "cheese":
                pizza = new BJCheesePizza();
                break;
            case "pepper":
                pizza = new BJPepperPizza();
                break;
            default:
                break;
        }
        return pizza;
    }
}
