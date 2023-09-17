package com.ruoyi.business;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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

}
