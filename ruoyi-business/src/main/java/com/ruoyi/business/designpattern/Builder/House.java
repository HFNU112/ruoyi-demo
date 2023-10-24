package com.ruoyi.business.designpattern.Builder;

/**
 * 建造产品
 * @author: shunpeng.hu
 * @date: 2023/10/24
 */
public class House {

    // 房子名称
    private String name;

    // 桩
    private String pile;

    // 墙
    private String wall;

    // 屋顶
    private String roof;

    public String getPile() {
        return pile;
    }

    public void setPile(String pile) {
        this.pile = pile;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getRoof() {
        return roof;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
