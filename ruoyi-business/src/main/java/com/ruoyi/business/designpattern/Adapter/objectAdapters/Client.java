package com.ruoyi.business.designpattern.Adapter.objectAdapters;


import com.ruoyi.business.designpattern.Adapter.classAdapters.VoltageAdapt;

/**
 * @Author Husp
 * @Date 2023/10/31 10:46
 */
public class Client {

    public static void main(String[] args) {
        new MobilePhone().charge(new VoltageAdapt());
    }
}
