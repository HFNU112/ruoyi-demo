package com.ruoyi.business.designpattern.Decorator;

/**
 * 咖啡调料（装饰者）
 * @Author Husp
 * @Date 2023/10/16 10:02
 */
public class Decorator extends Drinks{

    private Drinks decorated;

    /**
     * 构造器初始化
     */
    public Decorator(Drinks decorated) {
        this.decorated = decorated;
    }

    @Override
    public double cost() {
        return super.getPrice() + decorated.cost();
    }
}
