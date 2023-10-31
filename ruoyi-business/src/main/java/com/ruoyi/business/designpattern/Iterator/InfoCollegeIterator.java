package com.ruoyi.business.designpattern.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 信息电气学院迭代器子类
 * @Author Husp
 * @Date 2023/10/31 13:54
 */
public class InfoCollegeIterator implements Iterator {

    protected List<Department> departments = new ArrayList<>();

    private Integer position = -1;

    public InfoCollegeIterator(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        return position + 1 < departments.size();
    }

    @Override
    public Object next() {
        return departments.get(position++);
    }

    @Override
    public void remove() {

    }
}
