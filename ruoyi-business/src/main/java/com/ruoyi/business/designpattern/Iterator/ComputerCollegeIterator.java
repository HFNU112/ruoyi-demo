package com.ruoyi.business.designpattern.Iterator;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 计算机学院迭代器子类
 * @Author Husp
 * @Date 2023/10/31 13:41
 */
public class ComputerCollegeIterator implements Iterator {

    protected Department[] departments;

    private Integer positions = -1;

    public ComputerCollegeIterator(Department[] departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        return positions + 1 < departments.length && departments[positions + 1] != null;
    }

    @Override
    public Object next() {
        return departments[positions++];
    }

    @Override
    public void remove() {

    }
}
