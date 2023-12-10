package com.ruoyi.demo01;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Husp
 * @Date 2023/12/9 20:11
 */
public class Test01 {

    public static void main(String[] args) throws DocumentException {
        //1.定义存储订单Order对象的集合
        List<Order> orderList = new ArrayList<>();
        //2.新建解析order.xml文件输入流
        SAXReader saxReader = new SAXReader();
        //2.1获取dom对象
        Document document = saxReader.read(new File("ruoyi-javasepro\\src\\main\\resources\\order.xml"));
        //2.2获取dom元素的根元素
        Element root = document.getRootElement();
        //2.3获取订单对象集合
        List<Element> orders = root.elements();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //3.遍历订单对象集合
        for (Element element : orders) {
            //3.1封装订单对象
            Order order = new Order();
            order.setId(Long.valueOf(element.attributeValue("id")));
            order.setName(element.elementText("name"));
            order.setOrderTime(LocalDateTime.parse(element.elementText("time"), formatter));
            order.setPrice(Double.parseDouble(element.elementText("price")));
            //3.2订单对象添加到集合
            orderList.add(order);
        }
        System.out.println("=====订单内容如下：=========");
        for (Order order : orderList) {
            System.out.println(order);
        }
        //4.用Stream流找出今天之前的订单，并遍历输出
        System.out.println("=====今天之前的订单如下：=======");
        orderList.stream().filter(order ->
            order.getOrderTime().isBefore(LocalDateTime.now())
        ).forEach(order -> System.out.println(order));
        //5.集合中价格最贵的订流单,这个订单的详细信息打印出来
        Order order = orderList.stream().max((order1, order2) ->
                //比较规则 -1 最小的  1 最大的 0 相等
                Double.compare(order1.getPrice(), order2.getPrice())
        ).get();
        System.out.println("======打印价格最贵的订流单详细信息如下：==========");
        System.out.println(order);
        //6.遍历集合中的每个订单，要求按照价格降序输出
        System.out.println("=======按照价格降序输出每个订单如下：=========");
        orderList.stream().sorted((order1, order2) ->
            Double.compare(order2.getPrice(), order1.getPrice())
        ).forEach(curOrder -> System.out.println(curOrder));
    }

}
