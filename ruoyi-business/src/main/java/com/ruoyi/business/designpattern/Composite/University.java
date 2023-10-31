package com.ruoyi.business.designpattern.Composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite: 非叶子节点
 * @Author Husp
 * @Date 2023/10/31 11:15
 */
public class University extends OrganizationComponent{

    protected List<OrganizationComponent> organizationComponentList = new ArrayList<>();

    public University(String name) {
        super(name);
    }

    @Override
    public void add(OrganizationComponent organizationComponent) {
        organizationComponentList.add(organizationComponent);
    }

    @Override
    public void remove(OrganizationComponent organizationComponent) {
        organizationComponent.remove(organizationComponent);
    }

    @Override
    public void print() {
        for (OrganizationComponent organizationComponent : organizationComponentList) {
            organizationComponent.print();
        }
    }
}
