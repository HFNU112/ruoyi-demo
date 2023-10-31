package com.ruoyi.business.designpattern.Iterator;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

/**
 * @Author Husp
 * @Date 2023/10/28 12:48
 */
public class Client {

    // Iterator
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//
//        Hashtable<Integer, String> hashtable = new Hashtable<>();
//        hashtable.put(1, "aaa");
//        hashtable.put(2, "bbb");
//        hashtable.put(3, "ccc");

        List<ICollegeAggregate> collegeList = new ArrayList<>();
        collegeList.add(new ComputerCollege());
        collegeList.add(new InfoCollege());
        new OutputImpl().printCollege(collegeList);
    }
}
