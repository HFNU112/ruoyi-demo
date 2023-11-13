package com.ruoyi.business.designpattern.Singleton.dcl;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author Husp
 * @Date 2023/11/13 22:23
 */
@Slf4j
public class SingletonTest6 {
    public static void main(String[] args) {
        Singleton6 instance = Singleton6.getInstance();
        Singleton6 instance1 = Singleton6.getInstance();
        log.info(String.valueOf(instance == instance1));
        log.info(String.valueOf(instance.hashCode()));
        log.info(String.valueOf(instance1.hashCode()));
    }
}

class Singleton6 {
    //构造器私有化
    private Singleton6() {
    }

    //类的内部声明对象
    private static volatile Singleton6 instance;

    //向外暴露一个静态的公共方法
    public static Singleton6 getInstance() {
        if (instance == null){
            synchronized (Singleton6.class){
                if (instance == null){
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }
}
