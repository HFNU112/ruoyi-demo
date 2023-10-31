package com.ruoyi.business.designpattern.Adapter.interfaceAdapter;

/**
 * @Author Husp
 * @Date 2023/10/31 10:52
 */
public abstract class AbstractAdapter implements InterfaceA{

    @Override
    public void method1() {
        System.out.println("method1 ...");
    }

    @Override
    public void method2() {
        System.out.println("method2 ...");
    }

    @Override
    public void method3() {
        System.out.println("method3 ...");
    }
}
