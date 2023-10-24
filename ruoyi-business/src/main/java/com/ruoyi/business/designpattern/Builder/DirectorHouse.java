package com.ruoyi.business.designpattern.Builder;

/**
 * 指挥者
 * @author: shunpeng.hu
 * @date: 2023/10/24
 */
public class DirectorHouse {

    private AbstractHouseBuilder houseBuilder;

    public DirectorHouse() {

    }

    public void setHouseBuilder(AbstractHouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House build(){
        houseBuilder.foundation();
        houseBuilder.buildwall();
        houseBuilder.capping();
        return houseBuilder.build();
    }
}
