package com.ruoyi.business.designpattern.Factory.Simple;

import lombok.extern.slf4j.Slf4j;

/**
 * 披萨类
 * @Author Husp
 * @Date 2023/10/14
 */
@Slf4j
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
