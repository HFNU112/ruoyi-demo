package com.ruoyi.business;

import org.junit.Test;

import static com.ruoyi.business.utils.JsonToExcelUtils.toExcelByLocalJSONFile;

/**
 * @author: Husp
 * @date: 2023/8/31 23:57
 */
public class SpringBootTest {

     @Test
    public void testToExcelByJson(){
         String jsonPath = "C:\\Users\\29428\\Desktop\\data.json";
         String savePath = "C:\\Users\\29428\\Desktop";
         String fileName = "test";
         toExcelByLocalJSONFile(jsonPath, savePath, fileName);
     }

}
