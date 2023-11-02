package com.ruoyi.business.designpattern.responsibilityChain;

/**
 * @Author Husp
 * @Date 2023/11/2 23:21
 */
public class Client {

    public static void main(String[] args) {
        // 创建请求对象
        PurchaseRequest request = new PurchaseRequest(1001, 10, 31000f, 1);

        // 创建审批对象
        DepartmentApproval departmentApproval = new DepartmentApproval("张主任");
        CollegeApproval collegeApproval = new CollegeApproval("李院长");
        ViceMasterApproval viceMasterApproval = new ViceMasterApproval("周副校长");
        MasterApproval masterApproval = new MasterApproval("徐校长");

        // 将每一级审批设置成环形链
        departmentApproval.setApproval(collegeApproval);
        collegeApproval.setApproval(viceMasterApproval);
        viceMasterApproval.setApproval(masterApproval);
        masterApproval.setApproval(departmentApproval);

        // 处理请求
        departmentApproval.processRequest(request);
    }
}
