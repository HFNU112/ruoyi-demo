package com.ruoyi.business.designpattern.Iterator;

import java.util.Iterator;

/**
 * 计算机学院聚合接口实现子类
 * @Author Husp
 * @Date 2023/10/31 14:09
 */
public class ComputerCollege implements ICollegeAggregate{

    protected Department[] departments;

    private Integer position= 0;

    public ComputerCollege() {
        departments = new Department[5];
        departments[position++] = new Department("软件工程");
        departments[position++] = new Department("计算机学院");
    }

    @Override
    public Iterator<Department> createIterator() {
        return new ComputerCollegeIterator(departments);
    }

    @Override
    public String getName() {
        return "计算机学院";
    }
}
