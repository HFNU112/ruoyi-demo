package com.ruoyi.business;


import com.ruoyi.business.designpattern.Decorator.Drinks;
import com.ruoyi.business.designpattern.Decorator.Milk;
import com.ruoyi.business.designpattern.Factory.Simple.OrderPizza1;
import com.ruoyi.business.designpattern.Factory.Simple.SimpleFactory;

import org.junit.Test;

import java.io.IOException;

import static com.ruoyi.business.utils.JsonToExcelUtils.toExcelByLocalJSONFile;

/**
 * @author: Husp
 * @date: 2023/8/31 23:57
 */
public class SpringBootTest {

     @Test
    public void testToExcelByJson() throws IOException {
         // 读取数据库的结果数据（json格式）
         String jsonPath = "C:\\Users\\29428\\Desktop\\data.json";
         String savePath = "C:\\Users\\29428\\Desktop";
         String fileName = "test";
         // 将json数据写入到excel
         toExcelByLocalJSONFile(jsonPath, savePath, fileName); //传递的json字符串；保存json数据的位置；文件名
     }

     @Test
     public void testSimpleFactoryPizza(){
         new OrderPizza1(new SimpleFactory());
         System.out.println("exit");
     }

}
