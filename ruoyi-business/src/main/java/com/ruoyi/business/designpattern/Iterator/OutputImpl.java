package com.ruoyi.business.designpattern.Iterator;

import java.util.Iterator;
import java.util.List;

/**
 * 输出实现类
 * @Author Husp
 * @Date 2023/10/31 14:24
 */
public class OutputImpl {

    public OutputImpl() {
    }

    public void printCollege(List<ICollegeAggregate> collegeList) {
        Iterator<ICollegeAggregate> iterator = collegeList.iterator();
        while (iterator.hasNext()){
            ICollegeAggregate collegeAggregate = iterator.next();
            System.out.println("-----------"+collegeAggregate.getName());
            printDepartment(collegeAggregate);
        }
    }

    private void printDepartment(ICollegeAggregate collegeAggregate) {
        Iterator<Department> iterator = collegeAggregate.createIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().getName());
        }
    }
}
