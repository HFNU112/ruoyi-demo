package com.ruoyi.business.designpattern.Composite;

/**
 * 组织机构组合声明抽象类
 * @Author Husp
 * @Date 2023/10/31 11:09
 */
public abstract class OrganizationComponent {

    private String name;

    private String description;

    public OrganizationComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(OrganizationComponent organizationComponent){
        throw new UnsupportedOperationException();
    }

    public void remove(OrganizationComponent organizationComponent){
        throw new UnsupportedOperationException();
    }

    public abstract void print();
}
