package com.ruoyi.business.designpattern.Adapter.objectAdapters;

/**
 * 电压适配
 * @Author Husp
 * @Date 2023/10/31 10:40
 */
public class VoltageAdapt extends Voltage220 implements IVoltage5{

    private IVoltage5 voltage5;

    public VoltageAdapt(IVoltage5 voltage5) {
        this.voltage5 = voltage5;
    }

    @Override
    public int output5() {
        if (voltage5 == null){
            return 0;
        }
        int src = output220();
        int target = src / 44;
        System.out.println("转换后电压" + target + "V");
        return target;
    }
}
