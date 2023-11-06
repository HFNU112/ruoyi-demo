package com.ruoyi.business.designpattern.Observer;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author Husp
 * @Date 2023/11/3 0:03
 */
@Slf4j
public class CurrentCondition implements Observer{

    private float temperature;

    private float humidity;

    private float pressure;

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    private void display() {
        log.info("当前温度：temperature:{}",this.temperature,"℃");
        log.info("当前湿度：humidity:{}",this.humidity,"%RH");
        log.info("当前气压：pressure:{}",this.pressure,"P");
    }
}
