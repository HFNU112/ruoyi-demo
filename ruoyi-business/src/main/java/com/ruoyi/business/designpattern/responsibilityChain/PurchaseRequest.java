package com.ruoyi.business.designpattern.responsibilityChain;

/**
 * 采购申请请求
 * @Author Husp
 * @Date 2023/11/2 22:15
 */
public class PurchaseRequest {

    /**
     * 采购类型
     */
    private Integer type;

    /**
     * 采购数量
     */
    private Integer number;

    /**
     * 采购金额
     */
    private float money;

    /**
     * 采购编号
     */
    private Integer id;

    public PurchaseRequest(Integer type, Integer number, float money, Integer id) {
        this.type = type;
        this.number = number;
        this.money = money;
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public Integer getNumber() {
        return number;
    }

    public float getMoney() {
        return money;
    }

    public Integer getId() {
        return id;
    }
}
