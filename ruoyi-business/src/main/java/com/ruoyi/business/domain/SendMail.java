package com.ruoyi.business.domain;

import lombok.Data;

import java.util.Map;

/**
 * @author: Husp
 * @date: 2023/8/31 22:46
 */
@Data
public class SendMail {

    /**
     * 邮件主题
     */
    private String subject;

    /**
     * 收件人邮箱
     */
    private String[] recipientMailbox;

    /**
     * 发送内容
     */
    private String sendContent;

    /**
     * 真实名称/附件路径
     */
    private Map<String, String> enclosures;

}
