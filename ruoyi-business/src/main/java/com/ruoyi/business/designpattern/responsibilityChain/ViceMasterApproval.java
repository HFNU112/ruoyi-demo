package com.ruoyi.business.designpattern.responsibilityChain;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author Husp
 * @Date 2023/10/31 21:54
 */
@Slf4j
public class ViceMasterApproval extends Approval {

    private static final float REFERENCE_MONEY_LOW = 10000f;

    private static final float REFERENCE_MONEY_HIGH = 30000f;

    public ViceMasterApproval(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getMoney() > REFERENCE_MONEY_LOW && purchaseRequest.getMoney() <= REFERENCE_MONEY_HIGH){
            System.out.println("当前编号:" + purchaseRequest.getId()+ "被"+ this.name + "处理了");
            log.info("当前编号：",purchaseRequest.getId()+"被：{}",this.name+"处理了！");
        }else {
            // 大于30000让下一级审批
            approval.processRequest(purchaseRequest);
        }
    }
}
