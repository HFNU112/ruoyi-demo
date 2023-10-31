package com.ruoyi.business.designpattern.Iterator;

import java.util.Iterator;

/**
 * 统一聚合接口
 * @Author Husp
 * @Date 2023/10/31 14:00
 */
public interface ICollegeAggregate {

    /**
     * 创建学院聚合接口
     * @return
     */
    Iterator<Department> createIterator();

    /**
     * 接口名称
     * @return
     */
    String getName();
}
