package com.ruoyi.business.designpattern.Singleton.eager;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author Husp
 * @Date 2023/11/13 21:26
 */
@Slf4j
public class SingletonTest2 {

    public static void main(String[] args) {
        Singleton2 instance = Singleton2.getInstance();
        Singleton2 instance1 = Singleton2.getInstance();
        log.info(String.valueOf(instance == instance1));
        log.info(String.valueOf(instance.hashCode()));
        log.info(String.valueOf(instance1.hashCode()));
    }
}
class Singleton2 {
    //构造器私有化
    private Singleton2() {
    }
    //类的内部声明对象
    private static Singleton2 instance;

    //在静态代码块中创建对象
    static {
        instance = new Singleton2();
    }
    //向外暴露一个静态的公共方法
    public static Singleton2 getInstance() {
        return instance;
    }
}
