package com.ruoyi.business.designpattern.Decorator;

/**
 * 意式咖啡
 * @Author Husp
 * @Date 2023/10/16 10:30
 */
public class Espressa extends Coffee{

    /**
     * 构造器初始化
     */
    public Espressa() {
        setDescription("意式浓咖啡");
        setPrice(4.0);
    }
}
