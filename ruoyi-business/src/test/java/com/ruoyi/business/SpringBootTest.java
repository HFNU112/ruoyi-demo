package com.ruoyi.business;


import com.ruoyi.business.designpattern.Factory.Simple.OrderPizza1;
import com.ruoyi.business.designpattern.Factory.Simple.SimpleFactory;

import com.ruoyi.business.designpattern.responsibilityChain.*;
import com.ruoyi.business.utils.QrUtils;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

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
    public void testSimpleFactoryPizza() {
        new OrderPizza1(new SimpleFactory());
        System.out.println("exit");
    }

    @Test
    public void test01() {
//         int n = 100; // 目标白兔总数

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();  // 目标白兔总数

        if (num < 0) {
            throw new IllegalArgumentException("输入的白兔总数不能为负数");
        }

        int p = 1; // 每轮变成的白兔数量
        int k = 0; // 总共进行的轮数

        while (p * Math.pow(p, k) < num) {
            p++;
            k = (int) (Math.log(num) / Math.log(p));
        }

        System.out.println("p = " + p + ", k = " + k);
        System.out.println("p + k = " + (p + k));
    }

    /**
     * 测试二维码写入输出流
     */
    @Test
    public void testQrOutputStream() {
        try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\hushunpeng\\Pictures\\b.png");
            QrUtils.writeToStream(200, 200, 0, "http://www.baidu.com", fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试二维码写入指定路径
     */
    @Test
    public void testQrToPath(){
        QrUtils.writeToPath(200, 200, 5, "hello world", "C:\\Users\\hushunpeng\\Pictures\\a.png");
    }

}
