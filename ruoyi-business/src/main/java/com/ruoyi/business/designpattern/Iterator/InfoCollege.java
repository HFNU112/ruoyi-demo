package com.ruoyi.business.designpattern.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author Husp
 * @Date 2023/10/31 14:17
 */
public class InfoCollege implements ICollegeAggregate{

    protected List<Department> departments = new ArrayList<>();

    public InfoCollege() {
        departments.add(new Department("电气自动化"));
        departments.add(new Department("电子信息工程"));
    }

    @Override
    public Iterator<Department> createIterator() {
        return new InfoCollegeIterator(departments);
    }

    @Override
    public String getName() {
        return "信息电气学院";
    }
}
