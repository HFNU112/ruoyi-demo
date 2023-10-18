package com.ruoyi.business.designpattern.Factory.FactoryMethod;

/**
 * @author: shunpeng.hu
 * @date: 2023/10/18
 */
public abstract class Pizza {

    protected String name;

    public void setName(String name) {
        this.name = name;
    }

    // 准备材料
    public abstract void prepare();

    // 烘烤披萨
    public abstract void bake();

    // 切披萨
    public abstract void cut();

    // 打包披萨
    public abstract void box();
}
