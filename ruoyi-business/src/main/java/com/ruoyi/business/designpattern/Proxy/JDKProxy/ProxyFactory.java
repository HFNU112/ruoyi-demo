package com.ruoyi.business.designpattern.Proxy.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理工厂
 * @Author Husp
 * @Date 2023/10/17 17:01
 */
public class ProxyFactory {

    // 目标对象
    private Object target;

    // 构造器
    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 获取代理对象实例
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(" JDK动态代理开始 ");
                // 执行目标对象方法
                Object invoke = method.invoke(target, args);
                System.out.println(" JDK动态代理结束 ");
                return invoke;
            }
        });
    }

}
