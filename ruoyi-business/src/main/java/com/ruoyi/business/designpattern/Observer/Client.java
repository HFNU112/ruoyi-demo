package com.ruoyi.business.designpattern.Observer;

import java.util.Observable;

/**
 * @Author Husp
 * @Date 2023/10/27 23:55
 */
public class Client {

    //    Observable
    public static void main(String[] args) {
        // 创建气象站对象
        CurrentCondition currentCondition = new CurrentCondition();
        // 创建气象数据对象
        WeatherData weatherData = new WeatherData();
        // 注册气象站数据
        weatherData.registerObserver(currentCondition);
        // 天气发生变化，更新气象数据
        currentCondition.update(10f, 150f, 40f);
    }
}
