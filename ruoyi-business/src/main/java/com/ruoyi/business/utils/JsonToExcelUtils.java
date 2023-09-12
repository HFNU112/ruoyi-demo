package com.ruoyi.business.utils;

import com.alibaba.fastjson2.*;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Husp
 * @date: 2023/9/11 22:32
 */
public class JsonToExcelUtils {

    /**
     * 读取json文件
     */
    public static String readJSONFile(String resourcePath) {
        try{
            // 1. 创建文件流
            File file = new File(resourcePath);
            // 2. 使用 common-lang3工具包, 以 UTF-8 格式读取文件, 转为字符串
            String str = FileUtils.readFileToString(file, "UTF-8");
            JSONObject jsonObject = JSONObject.parseObject(str);
            // 3. 将字符串转为标准的JSON格式的字符串
            return JSONObject.toJSONString(jsonObject, JSONWriter.Feature.WriteMapNullValue);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * json字符串导出excel
     */
    public static void toExcelByString(String jsonStr, String savePath, String fileName){
        assert JSON.isValid(jsonStr) : "字符串: " + jsonStr + " 不是标准的JSON字符串";
        toExcelByJSONObject(JSONObject.parseObject(jsonStr),savePath, fileName);
    }

    /**
     * jsonObect导出到excel
     */
    public static void toExcelByJSONObject(JSONObject jsonObject,  String savePath, String fileName){
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 获取当前的Sheet
        XSSFSheet sheet = workbook.createSheet("被评人（蔡俨煌）");
        // 获取第一行
        XSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("PJ20230830001");
        XSSFRow row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("A0001中高管人员领导力360°反馈-高级经理");

        // 记录Key所在的列
        Map<String, Integer> map = new HashMap<>();
        int cellCount = 0;
        // 遍历的行
        XSSFRow currentRow = sheet.createRow(2);
        int lastRowNum = sheet.getLastRowNum();
        for (int i = 2; i <= lastRowNum; i++) {
            Object problems = jsonObject.get("problems");
            JSONObject problemsJson = (JSONObject) JSON.toJSON(problems);
            JSONArray firstProperty = (JSONArray) problemsJson.get("firstPropertyList");
            for (int j = 0; j < firstProperty.size() - 1; j++) {
                JSONObject firstPropertyJsonObject = firstProperty.getJSONObject(j);
                Object firstTitle = firstPropertyJsonObject.get("firstTitle");
                currentRow.createCell(0).setCellValue(firstTitle.toString());
                JSONArray secondProperty = (JSONArray) firstPropertyJsonObject.get("secondPropertyList");
                for (int k = 0; k < secondProperty.size() - 1; k++) {
                    JSONObject secondPropertyJsonObject = secondProperty.getJSONObject(k);
                    Object secondTitle = secondPropertyJsonObject.get("secondTitle");
                    Object options = secondPropertyJsonObject.get("options");

                    sheet.createRow(3).createCell(0).setCellValue(secondTitle.toString());
                    sheet.createRow(5).createCell(0).setCellValue(options.toString());
                }

            }
        }


        save(workbook, savePath, fileName);

        /*try(XSSFWorkbook workbook = new XSSFWorkbook()){
            // 获取当前的Sheet
            XSSFSheet sheet = workbook.createSheet("sheet");
            // 获取第一行
            XSSFRow firstRow = sheet.createRow(0);
            // 记录Key所在的列
            Map<String, Integer> map = new HashMap<>();
            // 记录列数
            int cellCount = 0;
            // 遍历 JSON的key
            XSSFRow currentRow = sheet.createRow(1);
            for (String key : jsonObject.keySet()) {
                // 先处理列
                if(!map.containsKey(key)){  // 当列不存在则添加
                    map.put(key, cellCount);
                    XSSFCell cell = firstRow.createCell(cellCount++);
                    cell.setCellValue(key);
                }
                XSSFCell currentCell = currentRow.createCell(map.get(key));
                String jsonStr = jsonObject.getString(key);
                // 如果 Value为数组 则创建新的 Sheet
                if(JSON.isValidArray(jsonStr)){
                    String subSheetName = "Sheet-" + key;
                    createSubSheet(1, workbook, subSheetName, jsonObject.getJSONArray(key));
                    currentCell.setCellValue(subSheetName);
                } else if(JSON.isValidObject(jsonStr)){ // 如果当前 value 仍然是一个JSON对象
                    String subSheetName = "Sheet-" + key;
                    createSubSheet(1, workbook, subSheetName, jsonObject.getJSONObject(key));
                    currentCell.setCellValue(subSheetName);
                }
                else {
                    // 特殊处理空值
                    if(StringUtils.isEmpty(jsonStr))
                        currentCell.setCellValue("null");
                    else
                        currentCell.setCellValue(jsonStr);
                }
            }
            save(workbook, savePath, fileName);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }*/
    }

    /**
     * 新建sheet
     */
    public static void createSubSheet(int layer, XSSFWorkbook workbook, String sheetName, JSONObject jsonObject){
        // 创建新的 sheet
        XSSFSheet sheet = workbook.createSheet(sheetName);
        // 存储每个字段
        Map<String, Integer> map = new HashMap<>();
        // 统计当前的列
        int cellCount = 0;
        // 创建第一行
        XSSFRow fistRow = sheet.createRow(0);
        // 记录行数
        int row = 1;
        // 获取每一项
        // 创建行
        XSSFRow currentRow = sheet.createRow(row);
        // 遍历每个KV
        for (String cellName : jsonObject.keySet()) {
            // 列不存在时, 则创建列
            if (!map.containsKey(cellName)) {
                // 第一行创建列
                XSSFCell firstRowCell = fistRow.createCell(cellCount);
                firstRowCell.setCellValue(cellName);
                map.put(cellName, cellCount++);
            }
            // 设置单元格
            XSSFCell cell = currentRow.createCell(map.get(cellName));
            // 获取 Value
            String cellValue = JSON.toJSONString(jsonObject.get(cellName));
            // 如果V为对象则递归创建sheet
            if(JSON.isValidObject(cellValue)){
                String subCellName = "Sheet" + layer + "-" + sheetName + "-" + cellName;
                cell.setCellValue(subCellName);
                createSubSheet(layer + 1, workbook,subCellName, JSON.parseObject(cellValue));

            } else if(JSON.isValidArray(cellValue)){
                String subCellName = "Sheet" + layer + "-" + sheetName + "-" + cellName;
                cell.setCellValue(subCellName);
                createSubSheet(layer + 1, workbook,subCellName, JSON.parseArray(cellValue));
            }
            else{
                cell.setCellValue(jsonObject.getString(cellName));
            }
        }
    }

    public static void createSubSheet(int layer, XSSFWorkbook workbook, String sheetName, JSONArray jsonArray){
        // 创建新的 sheet
        XSSFSheet sheet = workbook.createSheet(sheetName);
        // 存储每个字段
        Map<String, Integer> map = new HashMap<>();
        // 统计当前的列
        int cellCount = 0;
        // 创建第一行
        XSSFRow firstRow = sheet.createRow(0);
        // 获取每一项
        for (int row = 1; row <= jsonArray.size(); row++) {
            JSONObject jsonObject = jsonArray.getJSONObject(row - 1);
            // 创建行
            XSSFRow currentRow = sheet.createRow(row);
            if(jsonObject != null){
                // 遍历每个KV
                for (String cellName : jsonObject.keySet()) {
                    // 列不存在时, 则创建列
                    if (!map.containsKey(cellName)) {
                        // 第一行创建列
                        XSSFCell firstRowCell = firstRow.createCell(cellCount);
                        firstRowCell.setCellValue(cellName);
                        map.put(cellName, cellCount++);
                    }
                    // 设置单元格
                    XSSFCell cell = currentRow.createCell(map.get(cellName));
                    // 获取 Value
                    String cellValue = JSON.toJSONString(jsonObject.get(cellName));

                    // 如果V为数组则递归创建sheet
                    if(JSON.isValidArray(cellValue)){
                        String subCellName = sheetName + "-" + cellName;
                        cell.setCellValue(subCellName);
                        createSubSheet(layer + 1, workbook,subCellName, jsonObject.getJSONArray(cellName));
                    }
                    else{
                        cell.setCellValue(jsonObject.getString(cellName));
                    }
                }
            } else{ // Value为一个数组
                JSONArray array = jsonArray.getJSONArray(row - 1);
                // 遍历数组
                if(array != null && array.size() > 0){
                    for (int i = 1; i <= array.size(); i++) {
                        JSONObject obj = array.getJSONObject(i - 1);
                        // 遍历 obj
                        for (String cellName : obj.keySet()) {
                            // 若列不存在则添加
                            if(!map.containsKey(cellName)){
                                XSSFCell cell = firstRow.createCell(cellCount);
                                map.put(cellName, cellCount++);
                                cell.setCellValue(cellName);
                            }
                            // 分情况讨论
                            String cellValue = obj.getString(cellName);
                            XSSFCell cell = currentRow.createCell(map.get(cellName));
                            // 如果值是JSON对象, 则递归创建
                            if(JSON.isValidObject(cellValue)){
                                String subSheetName = sheetName + "-" + cellName;
                                cell.setCellValue(subSheetName);
                                createSubSheet(layer+1, workbook, subSheetName , JSONObject.parseObject(cellValue));
                            } else if(JSON.isValidArray(cellValue)){
                                String subSheetName = sheetName + "-" + cellName;
                                cell.setCellValue(subSheetName);
                                createSubSheet(layer+1, workbook, subSheetName , JSONArray.parseArray(cellValue));
                            } else {
                                cell.setCellValue(cellValue);
                            }
                        }
                    }
                } else {
                    firstRow.createCell(0).setCellValue(sheetName);
                    XSSFCell cell = currentRow.createCell(cellCount);
                    cell.setCellValue(jsonArray.getString(row-1));
                }
            }
        }
    }


    public static void save(Workbook workbook, String path, String fileName){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path +"/" + fileName +".xlsx");
            workbook.write(fileOutputStream);
            fileOutputStream.close();
            System.out.println("保存完毕. 保存位置为[ " + path + "/" + fileName + " ]");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 导出 excel
     */
    public static void toExcelByLocalJSONFile(String resourcePath, String savePath, String fileName){
        // 1. 获取标准的 JSON 字符串
        String jsonStr = readJSONFile(resourcePath);
        // 验证字符串是否合法
        assert JSON.isValid(jsonStr) : "路径:[" + resourcePath + "] 的json文件不符合标准的JSON格式";
        toExcelByString(jsonStr, savePath, fileName);
    }

    class QuestionnaireInfo{
        private String name;
        private String topTitle;
        private Problems problems;
    }

    class Problems {
        private List<FirstProperty> firstPropertyList;
        private String suggest;
        private String comment;
    }

    class FirstProperty {
        private String firstTitle;
        private List<SecondProperty> secondPropertyList;
    }
    class SecondProperty {
        private String secondTitle;
        private String options;
    }
}
