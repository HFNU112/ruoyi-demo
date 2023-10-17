package com.ruoyi.business.designpattern.Proxy.StaticProxy;

/**
 * 目标对象接口
 * @Author Husp
 * @Date 2023/10/17 14:39
 */
public interface ITeacherDao {

    // 备课中
    void prepare();

    // 教 方法
    void teach();

    //总结
    void summary();
}
