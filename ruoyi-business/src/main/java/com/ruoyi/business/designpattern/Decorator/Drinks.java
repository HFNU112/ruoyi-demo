package com.ruoyi.business.designpattern.Decorator;

/**
 * 抽象饮料类(被装饰者)
 * @Author Husp
 * @Date 2023/10/16 9:49
 */
public abstract class Drinks {

    /**
     * 饮料描述
     */
    private String description;

    /**
     * 价格
     */
    private double price;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * 计算消费饮料方法
     */
    public abstract double cost();
}
