package com.ruoyi.business.designpattern.Proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author Husp
 * @Date 2023/10/17 17:41
 */
public class ProxyFactory implements MethodInterceptor {

    // 目标对象
    private Object target;

    // 构造器初始化
    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 代理实例对象
    public Object getProxyInstance(){
        // 创建工具类
        Enhancer enhancer = new Enhancer();

        // 设置父类
        enhancer.setSuperclass(target.getClass());

        // 设置回调函数
        enhancer.setCallback(this);
        // 代理对象
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(" 开始执行动态代理 ");
        Object invoke = method.invoke(target, objects);
        System.out.println(" 代理执行结束 ");
        return invoke;
    }
}
