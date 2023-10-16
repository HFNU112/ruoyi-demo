package com.ruoyi.business.designpattern.Decorator;

/**
 * @Author Husp
 * @Date 2023/10/16 10:08
 */
public class Milk extends Decorator{

    /**
     * 构造器初始化
     */
    public Milk(Drinks decorated) {
        super(decorated);
        setDescription("加牛奶");
        setPrice(3.0);
    }


}
