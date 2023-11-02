package com.ruoyi.business.designpattern.responsibilityChain;

/**
 * 抽象处理者
 * @Author Husp
 * @Date 2023/10/31 21:51
 */
public abstract class Approval {

    /**
     * 后继审批处理人
     */
    protected Approval approval;

    /**
     * 审批人姓名
     */
    protected String name;

    public Approval(String name) {
        this.name = name;
    }

    public void setApproval(Approval approval) {
        this.approval = approval;
    }

    /**
     * 采购请求方法
     * @param purchaseRequest
     */
    public abstract void processRequest(PurchaseRequest purchaseRequest);

}
