package com.ruoyi.business.designpattern.TemplateMethod;

/**
 * 花生豆浆
 * @author: shunpeng.hu
 * @date: 2023/10/24
 */
public class PeanutSoyMilk extends SoymilkAbstractClass{

    public PeanutSoyMilk() {
        super();
        setName("花生豆浆");
    }

    @Override
    public void addIngredients() {
        System.out.println(" step2:加入上好的花生 ~ ");
    }
}
