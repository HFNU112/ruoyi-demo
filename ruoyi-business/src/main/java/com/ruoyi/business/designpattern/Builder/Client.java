package com.ruoyi.business.designpattern.Builder;

/**
 * @Author Husp
 * @Date 2023/10/23 1:05
 */
public class Client {

    public static void main(String[] args) {
//        StringBuilder builder = new StringBuilder("hello world");
        DirectorHouse directorHouse = new DirectorHouse();

        directorHouse.setHouseBuilder(new CommonHouse());
        directorHouse.build();


    }
}
