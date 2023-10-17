package com.ruoyi.business.designpattern.Proxy.StaticProxy;

/**
 * @Author Husp
 * @Date 2023/10/17 14:57
 */
public class Client {

    public static void main(String[] args) {
        //创建被代理对象
        TeacherDao teacherDao = new TeacherDao();
        //创建代理对象
        ProxyTeacherDao proxy = new ProxyTeacherDao(teacherDao);
        proxy.prepare();
        proxy.teach();
        proxy.summary();
    }
}
