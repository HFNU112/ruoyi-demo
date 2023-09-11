package com.ruoyi.business.utils;

import com.ruoyi.business.domain.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;
import java.util.Iterator;

/**
 * @author: Husp
 * @date: 2023/8/31 22:52
 */
@Component
public class SendMailUtil {

    @Autowired
    JavaMailSender javaMailSender;

    /**
     * 发送邮件
     */
    public void sendMail(SendMail mail) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject(mail.getSubject());  //邮件标题
        helper.setFrom(DeployParameter.MAIL_USERNAME);  // 发送者邮箱
        helper.setTo(mail.getRecipientMailbox());  // 收件人邮箱
        helper.setSentDate(new Date());  //发送日期
        helper.setText(mail.getSendContent());  //发送内容
        /*if(!mail.getEnclosures().isEmpty()){
            //通过keySet取出map数据[Iterator遍历]
            System.out.println("-------[Iterator循环遍历]通过keySet取出map数据---------");
            Iterator<String> it = mail.getEnclosures().keySet().iterator();  //map.keySet()得到的是set集合，可以使用迭代器遍历
            while(it.hasNext()){
                String key = it.next();
                helper.addAttachment(key, new File(mail.getEnclosures().get(key)));//预览文件
                //System.out.println("key值："+key+" value值："+model.getEnclosures().get(key));
            }
        }*/
        javaMailSender.send(mimeMessage);
    }

}
