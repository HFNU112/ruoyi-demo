package com.ruoyi.business.designpattern.Proxy.StaticProxy;

/**
 * 代理对象实现类
 * @Author Husp
 * @Date 2023/10/17 14:48
 */
public class ProxyTeacherDao extends TeacherDao{

    private ITeacherDao teacherDao;

    //构造器初始化
    public ProxyTeacherDao(ITeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public void teach() {
        System.out.println("执行目标对象之前");
        //目标方法
//        teacherDao.prepare();
        teacherDao.teach();
//        teacherDao.summary();
        System.out.println("代理对象结束");
    }
}
