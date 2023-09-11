package com.ruoyi.business.controller;

import com.ruoyi.business.domain.SendMail;
import com.ruoyi.business.utils.SendMailUtil;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.mail.MessagingException;

/**
 * @author: Husp
 * @date: 2023/8/31 23:06
 */
@RestController
@RequestMapping("/email")
public class MailController {

    @Resource
    private SendMailUtil sendMailUtil;

    /**
     * 发送邮件
     */
    @PostMapping("/sendMail")
    public AjaxResult sendMail(@RequestBody SendMail mail) throws MessagingException {
        sendMailUtil.sendMail(mail);
        return AjaxResult.success("发送成功");
    }

}
