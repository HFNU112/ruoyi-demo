### 黑马磊哥解析的JavaSE综合题
#### 第一题（Stream+集合应用）(15)

> 问题：maven工程建的子模块引入dom4j2.1.4依赖，使用saxReader输入流通过当前类.class.getResourceAsStream()反射机制读取相对路径下
> .xml文件解析报错:Exception in thread "main" org.dom4j org.dom4j.io.SAXReader.read

> 解决：文件传输相对路径：new File("ruoyi-javasepro\\src\\main\\resources\\order.xml")

#### 第二题（集合嵌套+Stream流）(10)
