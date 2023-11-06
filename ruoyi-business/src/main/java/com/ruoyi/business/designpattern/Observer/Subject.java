package com.ruoyi.business.designpattern.Observer;

/**
 * 被依赖对象接口
 * @Author Husp
 * @Date 2023/11/3 0:00
 */
public interface Subject {

    /**
     * 注册方法
     * @param observer
     */
    void registerObserver(Observer observer);

    /**
     * 移除方法
     * @param observer
     */
    void removeObserver(Observer observer);

    /**
     * 通知方法
     */
    void notifyObserver();
}
