package com.ruoyi.business.designpattern.Adapter.classAdapters;

/**
 * @Author Husp
 * @Date 2023/10/31 10:33
 */
public class Client {

    public static void main(String[] args) {
        new MobilePhone().charge(new VoltageAdapt());
    }
}
