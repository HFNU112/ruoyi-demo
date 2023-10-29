package com.ruoyi.business.designpattern.Composite;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Husp
 * @Date 2023/10/29 22:00
 */
public class Client {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "aaa");

        Map<Integer, String> newMap = new HashMap<>();
        newMap.put(2, "bbb");
        newMap.put(3, "ccc");
        map.putAll(newMap);
        System.out.println(map); // {1=aaa, 2=bbb, 3=ccc}
    }
}
