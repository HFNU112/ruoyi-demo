package com.ruoyi.business.designpattern.Builder;

/**
 * 高楼-具体建造者
 * @author: shunpeng.hu
 * @date: 2023/10/24
 */
public class HighHouse extends AbstractHouseBuilder{

    @Override
    public void foundation() {
        System.out.println("高楼打桩");
    }

    @Override
    public void buildwall() {
        System.out.println("高楼砌墙");
    }

    @Override
    public void capping() {
        System.out.println("高楼封顶");
    }
}
