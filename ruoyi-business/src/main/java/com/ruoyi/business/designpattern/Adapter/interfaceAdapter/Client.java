package com.ruoyi.business.designpattern.Adapter.interfaceAdapter;

/**
 * @Author Husp
 * @Date 2023/10/31 10:55
 */
public class Client {

    public static void main(String[] args) {
        AbstractAdapter absAdapter = new AbstractAdapter() {
            @Override
            public void method1() {
                System.out.println("调用method1");
            }
        };
        absAdapter.method1();
    }
}
