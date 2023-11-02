package com.ruoyi.business.designpattern.responsibilityChain;

import lombok.extern.slf4j.Slf4j;

/**
 * 具体系主任审批人
 * @Author Husp
 * @Date 2023/10/31 21:54
 */
@Slf4j
public class DepartmentApproval extends Approval {

    private static final float REFERENCE_MONEY = 5000f;

    public DepartmentApproval(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getMoney() <= REFERENCE_MONEY) {
            System.out.println("当前编号:" + purchaseRequest.getId()+ "被"+ this.name + "处理了");
            log.info("当前编号:{}",purchaseRequest.getId()+"被：{}",this.name+"处理了！");
        }else {
            // 大于5000让下一级审批人去处理
            approval.processRequest(purchaseRequest);
        }
    }
}
