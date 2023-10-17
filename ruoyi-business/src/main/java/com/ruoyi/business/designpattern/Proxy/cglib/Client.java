package com.ruoyi.business.designpattern.Proxy.cglib;

/**
 * @Author Husp
 * @Date 2023/10/17 17:54
 */
public class Client {

    public static void main(String[] args) {
        // 创建目标对象
        TeacherDao teacherDao = new TeacherDao();
        // 创建代理对象
        TeacherDao proxyTeacher = (TeacherDao) new ProxyFactory(teacherDao).getProxyInstance();
        proxyTeacher.teach();
    }
}
