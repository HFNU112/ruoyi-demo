package com.ruoyi.business.designpattern.Factory.Simple;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 订购披萨
 * @Author Husp
 * @Date 2023/10/14 23:17
 */
@Slf4j
public class OrderPizza1 {

    private SimpleFactory simpleFactory;

    // 构造器构造预定披萨聚合工厂
    public OrderPizza1(SimpleFactory simpleFactory) {
        this.simpleFactory = simpleFactory;
        orderPizza();
    }

    private void orderPizza() {
        Pizza pizza = null;

        do {
            pizza = simpleFactory.createPizza(getType());
            if (pizza == null){
                log.info(" order failed ... ");
            }
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        } while (true);
    }

    private String getType() {
        System.out.println(" Please enter the desired pizza type:");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }


}
