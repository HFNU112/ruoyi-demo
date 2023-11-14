package com.ruoyi.business.designpattern.Prototype;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author Husp
 * @Date 2023/11/7 22:47
 */
@Slf4j
public class Client {
    public static void main(String[] args) {
        Sheep sheep = new Sheep("Tom", 1, "white");
        for (int i = 0; i < 10; i++) {
            Sheep sheep1 = (Sheep) sheep.clone();
            log.info("sheep1:{}", sheep1);
        }
    }
}
