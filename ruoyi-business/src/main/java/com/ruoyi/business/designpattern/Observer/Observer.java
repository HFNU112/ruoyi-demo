package com.ruoyi.business.designpattern.Observer;

/**
 * 观察者依赖者接口
 * @Author Husp
 * @Date 2023/11/3 0:02
 */
public interface Observer {

    /***
     * 更新方法
     * @param temperature
     * @param humidity
     * @param pressure
     */
    void update(float temperature, float humidity ,float pressure);
}
