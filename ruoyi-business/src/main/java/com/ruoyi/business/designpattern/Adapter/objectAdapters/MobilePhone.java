package com.ruoyi.business.designpattern.Adapter.objectAdapters;

import com.ruoyi.business.designpattern.Adapter.classAdapters.IVoltage5;

/**
 * 使用适配器
 * @Author Husp
 * @Date 2023/10/31 10:44
 */
public class MobilePhone {

    protected String name;

    public void setName(String name) {
        this.name = name;
    }

    public void charge(IVoltage5 voltage5){
        if (voltage5.output5() == 5){
            setName(" 手机");
            System.out.println(name + "正在充电~");
        }else {
            throw new IllegalArgumentException(name + "无法充电~");
        }
    }
}
