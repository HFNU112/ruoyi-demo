package com.ruoyi.business.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: Husp
 * @date: 2023/8/31 22:37
 */
@Component("DeployParameter")
public class DeployParameter {

    /**
     * 发送方邮箱
     */
    public static String MAIL_USERNAME;
    @Value("${spring.mail.username}")
    public void setMailUserName(String mailUserName){
        MAIL_USERNAME = mailUserName;
    }

    /**
     * 文件上传
     */
    public static String UPLOAD_URL;
    @Value("${ruoyi.profile}")
    public void setUploadUrl(String uploadUrl){
        UPLOAD_URL = uploadUrl;
    }
}
