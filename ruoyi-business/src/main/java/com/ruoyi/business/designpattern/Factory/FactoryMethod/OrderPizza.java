package com.ruoyi.business.designpattern.Factory.FactoryMethod;

/**
 * @Author Husp
 * @Date 2023/10/30 16:31
 */
public abstract class OrderPizza {

    private Pizza pizza;

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void orderPizza() {
        do {
            pizza = createPizza(getType());
            if (pizza == null){
                throw new IllegalArgumentException("pizza order failed");
            }else {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }
        } while (true);
    }

    public abstract Pizza createPizza(String orderType);
}
