package com.ruoyi.business.designpattern.Builder;

/**
 * 普通房子-具体建造者
 * @author: shunpeng.hu
 * @date: 2023/10/24
 */
public class CommonHouse extends AbstractHouseBuilder{

    @Override
    public void foundation() {
        System.out.println("普通房打桩");
    }

    @Override
    public void buildwall() {
        System.out.println("普通房砌墙");
    }

    @Override
    public void capping() {
        System.out.println("普通房封顶");
    }
}
