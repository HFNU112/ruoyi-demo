package com.ruoyi.demo03;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author Husp
 * @Date 2023/12/10 15:02
 */
public class Test03 {

    public static void main(String[] args) {
        try (
                //1.输入流读取系统菜单.txt文件（相对路径）
                BufferedReader bufferedReader = new BufferedReader(new FileReader("ruoyi-javasepro\\src\\main\\resources\\系统菜单.txt"));
                //4.1 定义打印流输出到新文件中（相对路径）
                PrintStream printStream = new PrintStream("ruoyi-javasepro\\src\\main\\resources\\系统菜单2.txt");
        ) {
            //2.读取文件菜单内容
            //2.1 定义集合存储菜单
            List<String> menus = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                //2.2 读取的每一行内容添加到集合中
                menus.add(line);
            }
            //3.对菜单集合排序
            Collections.sort(menus);

            //4.遍历集合输出
            for (String menu : menus) {
                String[] menuNames = menu.split("-");
                System.out.println(((menuNames[0].length() % 2 == 0) || (menuNames[0].length() % 4 == 0) )? menuNames[1] : "\t" + menuNames[1]);
            }
            //5.菜单信息写出到一个新文件
            for (String menu : menus) {
                printStream.println(menu);
            }

        } catch (IOException e) {
            throw new RuntimeException("文件读写异常！");
        }
    }

}
