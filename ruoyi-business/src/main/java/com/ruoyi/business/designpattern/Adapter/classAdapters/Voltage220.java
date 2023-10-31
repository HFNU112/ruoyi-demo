package com.ruoyi.business.designpattern.Adapter.classAdapters;

/**
 * 被适配类
 * @Author Husp
 * @Date 2023/10/31 10:15
 */
public class Voltage220 {

    public int output220(){
        int src = 220;
        System.out.println("电压" + src +"V");
        return src;
    }
}
