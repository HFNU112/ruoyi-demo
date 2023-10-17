package com.ruoyi.business.designpattern.Proxy.StaticProxy;

/**
 * 目标对象实现类
 * @Author Husp
 * @Date 2023/10/17 14:46
 */
public class TeacherDao implements ITeacherDao{

    @Override
    public void prepare() {
        System.out.println(" 讲师在备课中 ");
    }

    @Override
    public void teach() {
        System.out.println(" 讲师正在讲课中 ... ");
    }

    @Override
    public void summary() {
        System.out.println(" 老师总结课 ");
    }

}
