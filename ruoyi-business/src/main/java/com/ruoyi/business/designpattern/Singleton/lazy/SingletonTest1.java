package com.ruoyi.business.designpattern.Singleton.lazy;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author Husp
 * @Date 2023/11/13 21:44
 */
@Slf4j
public class SingletonTest1 {
    public static void main(String[] args) {
        Singleton1 instance = Singleton1.getInstance();
        Singleton1 instance1 = Singleton1.getInstance();
        log.info(String.valueOf(instance == instance1));
        log.info(String.valueOf(instance.hashCode()));
        log.info(String.valueOf(instance1.hashCode()));
    }
}
class Singleton1 {
    //类的内部创建对象
    private static Singleton1 instance;

    //构造器私有化
    private Singleton1() {
    }

    //向外暴露一个静态的公共方法
    public static Singleton1 getInstance() {
        if (instance == null){
            instance = new Singleton1();
        }
        return instance;
    }
}
