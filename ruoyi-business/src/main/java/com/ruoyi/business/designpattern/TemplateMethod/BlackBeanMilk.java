package com.ruoyi.business.designpattern.TemplateMethod;

/**
 * 黑豆豆浆
 * @author: shunpeng.hu
 * @date: 2023/10/24
 */
public class BlackBeanMilk extends SoymilkAbstractClass{

    public BlackBeanMilk() {
        super();
        setName("黑豆豆浆");
    }

    @Override
    public void addIngredients() {
        System.out.println(" step2: 加入上好的黑豆~ ");
    }
}
