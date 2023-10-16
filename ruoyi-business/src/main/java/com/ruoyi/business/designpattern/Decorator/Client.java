package com.ruoyi.business.designpattern.Decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author Husp
 * @Date 2023/10/16 10:15
 */
@Slf4j
public class Client {

    public static void main(String[] args) {
        Drinks drinks = new LongBlack();
        log.info("美式咖啡消费: {}", drinks.cost()+"美元");

        drinks = new Milk(drinks);
        log.info("美式咖啡 + 一份牛奶消费:{}", drinks.cost()+"美元");

        System.out.println("-------------------------------");

        Drinks drinks1 = new Espressa();
        log.info("意式浓咖啡:{}", drinks1.cost()+"美元");
        drinks1 = new Milk(drinks1);
        log.info("意式浓咖啡+一份牛奶消费：{}", drinks1.cost()+"美元");
        drinks1 = new Chocolate(drinks1);
        log.info("意式浓咖啡+一份牛奶+一份巧克力消费：{}",drinks1.cost()+"美元");
        drinks1 = new Chocolate(drinks1);
        log.info("意式浓咖啡+一份牛奶+两份巧克力消费：{}",drinks1.cost()+"美元");
    }
}
