package com.ruoyi.business.designpattern.Decorator;

/**
 * 美式咖啡
 * @Author Husp
 * @Date 2023/10/16 9:58
 */
public class LongBlack extends Coffee{

    /**
     * 构造器初始化
     */
    public LongBlack() {
        setDescription("美式咖啡");
        setPrice(1.5);
    }
}
