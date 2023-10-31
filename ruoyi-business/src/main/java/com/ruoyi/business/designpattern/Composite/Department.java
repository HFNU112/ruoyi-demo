package com.ruoyi.business.designpattern.Composite;

/**
 *  Leaf: 叶子节点
 * @Author Husp
 * @Date 2023/10/31 11:30
 */
public class Department extends OrganizationComponent{

    public Department(String name) {
        super(name);
    }

    @Override
    public void print() {
        System.out.println("------"+getName());
    }
}
