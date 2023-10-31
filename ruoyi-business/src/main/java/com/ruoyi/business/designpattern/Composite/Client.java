package com.ruoyi.business.designpattern.Composite;

import com.ruoyi.business.domain.vo.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Husp
 * @Date 2023/10/29 22:00
 */
public class Client {

    public static void main(String[] args) {
        /*Map<Integer, String> map = new HashMap<>();
        map.put(1, "aaa");

        Map<Integer, String> newMap = new HashMap<>();
        newMap.put(2, "bbb");
        newMap.put(3, "ccc");
        map.putAll(newMap);
        System.out.println(map); // {1=aaa, 2=bbb, 3=ccc}*/

        OrganizationComponent university = new University("合肥师范学院");

        OrganizationComponent computerCollege = new College("计算机学院");
        OrganizationComponent infoCollege = new College("信息电气学院");

        computerCollege.add(new Department("软件工程"));
        computerCollege.add(new Department("计算机科学与技术"));

        infoCollege.add(new Department("电气自动化"));
        infoCollege.add(new Department("电子信息工程"));

        university.add(computerCollege);
        university.add(infoCollege);

        university.print();
    }
}
