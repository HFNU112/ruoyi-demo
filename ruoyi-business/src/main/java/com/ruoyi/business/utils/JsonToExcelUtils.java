package com.ruoyi.business.utils;

import com.alibaba.fastjson2.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
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
@Slf4j
public class JsonToExcelUtils {

    /**
     * 读取json文件
     */
    public static String readJSONFile(String resourcePath) {
        try {
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
     * json字符串 转 excel
     */
    public static void toExcelByString(String jsonStr, String savePath, String fileName) throws IOException {
        assert JSON.isValid(jsonStr) : "字符串: " + jsonStr + " 不是标准的JSON字符串";
        toExcelByJSONObject(JSONObject.parseObject(jsonStr), savePath, fileName);
    }

    /**
     * jsonObect导出到excel
     */
    public static void toExcelByJSONObject(JSONObject jsonObject, String savePath, String fileName) throws IOException {
        Object name = jsonObject.get("name");
        Object topTitle = jsonObject.get("topTitle");
        JSONArray problemArray = jsonObject.getJSONObject("problems").getJSONArray("firstPropertyList");
        Object suggest = jsonObject.getJSONObject("problems").get("suggest");
        Object comment = jsonObject.getJSONObject("problems").get("comment");

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("被评人");
        sheet.createRow(0).createCell(0).setCellValue(name.toString());
        sheet.createRow(1).createCell(0).setCellValue(topTitle.toString());

        int rowNum = 2;
        // 遍历jsonArray
        for (int i = 0; i < problemArray.size(); i++) {
            Object firstTitle = problemArray.getJSONObject(i).get("firstTitle");
            createRow(sheet, rowNum, "firstTitle", firstTitle.toString());
            rowNum++;
            JSONArray secondPropertyArray = problemArray.getJSONObject(i).getJSONArray("secondPropertyList");
            for (int j = 0; j < secondPropertyArray.size(); j++) {
                Object secondTitle = secondPropertyArray.getJSONObject(j).get("secondTitle");
                createRow(sheet, rowNum, "secondTitle", secondTitle.toString());
                rowNum++;
                sheet.createRow(rowNum).createCell(1).setCellValue("总评情况");
                sheet.createRow(rowNum).createCell(2).setCellValue("（评价人：张三）");
                rowNum++;
                // 遍历选项
                for (int k = 1; k <= 5; k++) {
                    sheet.createRow(rowNum).createCell(0).setCellValue("无法评价");
                    sheet.createRow(rowNum).createCell(0).setCellValue("非常不认同");
                    sheet.createRow(rowNum).createCell(0).setCellValue("不认同");
                    sheet.createRow(rowNum).createCell(0).setCellValue("一般");
                    sheet.createRow(rowNum).createCell(0).setCellValue("非常认同");
                    rowNum++;
                }
                Object options = secondPropertyArray.getJSONObject(j).get("options");
            }
        }
        save(workbook, savePath, fileName);
    }

    // 新建行
    private static void createRow(XSSFSheet sheet, int rowNum, String title, String value) {
        Row row = sheet.createRow(rowNum);
        Cell cell = row.createCell(0);
        // 存入excel
        cell.setCellValue(value);

        /*if (value != null && !value.isEmpty()) {
            int columnIndex = 1;
            String[] options = value.split(",");
            for (String option : options) {
                Cell cellOption = row.createCell(columnIndex++);
                cellOption.setCellValue(option);
            }
        }*/

    }

    /**
     * 新建sheet
     */
    public static void createSubSheet(int layer, XSSFWorkbook workbook, String sheetName, JSONObject jsonObject) {
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
            if (JSON.isValidObject(cellValue)) {
                String subCellName = "Sheet" + layer + "-" + sheetName + "-" + cellName;
                cell.setCellValue(subCellName);
                createSubSheet(layer + 1, workbook, subCellName, JSON.parseObject(cellValue));

            } else if (JSON.isValidArray(cellValue)) {
                String subCellName = "Sheet" + layer + "-" + sheetName + "-" + cellName;
                cell.setCellValue(subCellName);
                createSubSheet(layer + 1, workbook, subCellName, JSON.parseArray(cellValue));
            } else {
                cell.setCellValue(jsonObject.getString(cellName));
            }
        }
    }

    public static void createSubSheet(int layer, XSSFWorkbook workbook, String sheetName, JSONArray jsonArray) {
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
            if (jsonObject != null) {
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
                    if (JSON.isValidArray(cellValue)) {
                        String subCellName = sheetName + "-" + cellName;
                        cell.setCellValue(subCellName);
                        createSubSheet(layer + 1, workbook, subCellName, jsonObject.getJSONArray(cellName));
                    } else {
                        cell.setCellValue(jsonObject.getString(cellName));
                    }
                }
            } else { // Value为一个数组
                JSONArray array = jsonArray.getJSONArray(row - 1);
                // 遍历数组
                if (array != null && array.size() > 0) {
                    for (int i = 1; i <= array.size(); i++) {
                        JSONObject obj = array.getJSONObject(i - 1);
                        // 遍历 obj
                        for (String cellName : obj.keySet()) {
                            // 若列不存在则添加
                            if (!map.containsKey(cellName)) {
                                XSSFCell cell = firstRow.createCell(cellCount);
                                map.put(cellName, cellCount++);
                                cell.setCellValue(cellName);
                            }
                            // 分情况讨论
                            String cellValue = obj.getString(cellName);
                            XSSFCell cell = currentRow.createCell(map.get(cellName));
                            // 如果值是JSON对象, 则递归创建
                            if (JSON.isValidObject(cellValue)) {
                                String subSheetName = sheetName + "-" + cellName;
                                cell.setCellValue(subSheetName);
                                createSubSheet(layer + 1, workbook, subSheetName, JSONObject.parseObject(cellValue));
                            } else if (JSON.isValidArray(cellValue)) {
                                String subSheetName = sheetName + "-" + cellName;
                                cell.setCellValue(subSheetName);
                                createSubSheet(layer + 1, workbook, subSheetName, JSONArray.parseArray(cellValue));
                            } else {
                                cell.setCellValue(cellValue);
                            }
                        }
                    }
                } else {
                    firstRow.createCell(0).setCellValue(sheetName);
                    XSSFCell cell = currentRow.createCell(cellCount);
                    cell.setCellValue(jsonArray.getString(row - 1));
                }
            }
        }
    }


    public static void save(Workbook workbook, String path, String fileName) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path + "/" + fileName + ".xlsx");
            workbook.write(fileOutputStream);
            fileOutputStream.close();
            log.info("保存完毕. 保存位置为[ " + path + "/" + fileName + " ]");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * json转 excel
     */
    public static void toExcelByLocalJSONFile(String resourcePath, String savePath, String fileName) throws IOException {
        // 1. 获取标准的 JSON 字符串
        String jsonStr = readJSONFile(resourcePath);
        // 验证字符串是否合法
        assert JSON.isValid(jsonStr) : "路径:[" + resourcePath + "] 的json文件不符合标准的JSON格式";
        toExcelByString(jsonStr, savePath, fileName);
    }

    class QuestionnaireInfo {
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
