package com.ruoyi.business.designpattern.Proxy.JDKProxy;

/**
 * @Author Husp
 * @Date 2023/10/17 17:10
 */
public class Client {

    public static void main(String[] args) {
        //创建被代理对象
        TeacherDao teacherDao = new TeacherDao();

        //创建代理对象
        TeacherDao proxyTeacher1 = (TeacherDao) new ProxyFactory(teacherDao).getProxyInstance();
        proxyTeacher1.teach();
    }
}
