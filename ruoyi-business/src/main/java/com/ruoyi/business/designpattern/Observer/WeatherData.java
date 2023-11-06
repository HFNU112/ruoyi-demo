package com.ruoyi.business.designpattern.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体实现被依赖的接口
 * @Author Husp
 * @Date 2023/11/3 0:01
 */
public class WeatherData implements Subject{

    private List<Observer> observers;

    /**
     * 温度
     */
    private float temperature;

    /**
     * 湿度
     */
    private float humidity;

    /**
     * 气压
     */
    private float pressure;

    // 构造器初始化
    public WeatherData() {
        observers = new ArrayList<Observer>();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    /**
     * 推送天气数据到气象站
     */
    public void dataChange(){
        notifyObserver();
    }

    /**
     * 更新天气数据
     */
    public void setData (Float temperature, Float humidity, Float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        dataChange();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observer != null && observers.contains(observer)){
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }
}
