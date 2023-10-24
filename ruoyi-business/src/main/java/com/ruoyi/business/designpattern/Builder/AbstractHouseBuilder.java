package com.ruoyi.business.designpattern.Builder;

/**
 * 抽象建造者
 * @author: shunpeng.hu
 * @date: 2023/10/24
 */
public abstract class AbstractHouseBuilder {

    protected House house = new House();

    public abstract void foundation();

    public abstract void buildwall();

    public abstract void capping();

    public House build(){
        return house;
    }

}
