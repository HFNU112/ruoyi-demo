package com.ruoyi.business.designpattern.Factory.Abstract;

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
    public void bake(){
        System.out.println(name + " is baking ... ");
    }

    // 切披萨
    public void cut(){
        System.out.println(name + " is cutting ... ");
    }

    // 打包披萨
    public void box(){
        System.out.println(name + "is boxing ... ");
    }
}
