package com.ruoyi.business.designpattern.Decorator;

/**
 * @Author Husp
 * @Date 2023/10/16 10:32
 */
public class Chocolate extends Decorator{
    /**
     * 构造器初始化
     */
    public Chocolate(Drinks decorated) {
        super(decorated);
        setDescription("加巧克力");
        setPrice(2.6);
    }
}
