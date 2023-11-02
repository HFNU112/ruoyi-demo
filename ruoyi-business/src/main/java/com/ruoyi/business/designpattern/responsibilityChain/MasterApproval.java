package com.ruoyi.business.designpattern.responsibilityChain;

import lombok.extern.slf4j.Slf4j;

/**
 * 具体校长审批人
 * @Author Husp
 * @Date 2023/10/31 21:55
 */
@Slf4j
public class MasterApproval extends Approval{

    private static final float REFERENCE_MONEY_HIGH = 30000f;

    public MasterApproval(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getMoney() > REFERENCE_MONEY_HIGH){
            System.out.println("当前编号:" + purchaseRequest.getId()+ "被"+ this.name + "处理了");
            log.info("当前编号：{}",purchaseRequest.getId()+"被：{}",this.name+"处理了！");
        }else {
            approval.processRequest(purchaseRequest);
        }
    }
}
