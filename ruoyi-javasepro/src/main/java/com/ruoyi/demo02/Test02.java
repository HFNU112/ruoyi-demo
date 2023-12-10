package com.ruoyi.demo02;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Husp
 * @Date 2023/12/9 23:42
 */
public class Test02 {

    public static void main(String[] args) {
        //1.定义Map集合存储学生和选择的地点
        Map<String, List<String>> selects = new HashMap<>(20);
        //1.1 定义List集合存储选择的地点
        List<String> location1 = new ArrayList<>();
        Collections.addAll(location1, "农家乐", "野外拓展");
        selects.put("张全蛋儿", location1);

        List<String> location2 = new ArrayList<>();
        Collections.addAll(location2, "轰趴", "野外拓展", "健身房");
        selects.put("李二狗子", location2);

        List<String> location3 = new ArrayList<>();
        Collections.addAll(location3, "轰趴", "野外拓展", "健身房");
        selects.put("翠花", location3);

        List<String> location4 = new ArrayList<>();
        Collections.addAll(location4, "轰趴", "野外拓展", "健身房");
        selects.put("小帅", location4);

        List<String> location5 = new ArrayList<>();
        Collections.addAll(location5, "轰趴", "野外拓展", "健身房");
        selects.put("有容", location5);
        System.out.println("========学生选择的地点如下：========");
        System.out.println(selects);

        //2.找出每个去处想去的人数是多少，并输出投票最多的去处是哪个
        Map<String, Integer> infos = new HashMap<>();
        selects.forEach((location, datas) -> {
            for (String data : datas) {
                infos.put(data, infos.containsKey(data) ? infos.get(data) + 1 : 1);
            }
        });
        System.out.println("==========每一个地点选择的人数如下：========");
        System.out.println(infos);
        Map.Entry<String, Integer> entry = infos.entrySet().stream().max((element1, element2) ->
                element1.getValue() - element2.getValue()
        ).get();

        List<String> names = infos.entrySet().stream().filter(element ->
                entry.getValue().equals(element.getValue())
        ).map(element -> element.getKey()).collect(Collectors.toList());
        System.out.println("=======输出投票最多的去处如下：========");
        System.out.println(names);

        //3.找出哪些人没有选择投票最多的去处，输出他们的名字
        System.out.println("======没有选择投票最多的去处的名字如下：=======");
        selects.entrySet().stream().filter(element -> {
            // true标识没有选择最多的地点
            boolean flag = true;
            for (String e : element.getValue()) {
                if (names.contains(e)) {
                    flag = false;
                    break;
                }
            }
            return flag;
        }).forEach(element -> System.out.println(element.getKey()));
    }

}
