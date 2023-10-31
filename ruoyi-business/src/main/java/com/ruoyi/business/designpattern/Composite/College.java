package com.ruoyi.business.designpattern.Composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Husp
 * @Date 2023/10/31 11:24
 */
public class College extends OrganizationComponent{

    protected List<OrganizationComponent> organizationComponentList = new ArrayList<>();

    public College(String name) {
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
        System.out.println("----"+getName());
        for (OrganizationComponent organizationComponent : organizationComponentList) {
            organizationComponent.print();
        }
    }
}
