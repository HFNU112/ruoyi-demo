package com.ruoyi.business.designpattern.Adapter.classAdapters;

/**
 * 电压适配
 * @Author Husp
 * @Date 2023/10/31 10:20
 */
public class VoltageAdapt extends Voltage220 implements IVoltage5{

    @Override
    public int output5() {
        int src = output220();
        int target = src / 44;
        System.out.println("转换后电压" + target + "V");
        return target;
    }
}
