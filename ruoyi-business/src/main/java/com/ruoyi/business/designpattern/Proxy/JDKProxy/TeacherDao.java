package com.ruoyi.business.designpattern.Proxy.JDKProxy;

/**
 * @Author Husp
 * @Date 2023/10/17 17:00
 */
public class TeacherDao implements ITeacherDao{

    @Override
    public void teach() {
        System.out.println(" 老师正在讲课 ");
    }
}
