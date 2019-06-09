package com.muggle.temp.impl;

import com.muggle.base.EmailBean;
import com.muggle.temp.EmailTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


@Component
public class SimpleEmailTemplate implements EmailTemplate {

    @Value("${email.server}")
    private String server;
    @Autowired
    private JavaMailSender javaMailSender;

    @Async
    @Override
    public void sendSimpleMail(EmailBean mailBean) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        //邮件发送人
        simpleMailMessage.setFrom("1977339740@qq.com(poseidon)");
        //邮件接收人
        simpleMailMessage.setTo(mailBean.getRecipient());
        //邮件主题
        simpleMailMessage.setSubject(mailBean.getSubject());
        //邮件内容
        simpleMailMessage.setText(mailBean.getContent());
        javaMailSender.send(simpleMailMessage);
    }
    @Override
    public void sendMailForHtml(EmailBean mailBean){
        StringBuffer context=new StringBuffer();
        context.append("<h3> 嗨，小伙伴,poseidon 给你回信了</h3><br>");
        context.append(mailBean.getContent());
        mailBean.setContent(context.toString());
        sendSimpleMail(mailBean);
    }
    @Override
    public void sendCode(String recipient, String context) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("1977339740@qq.com(波塞冬)");
        simpleMailMessage.setTo(recipient);
        simpleMailMessage.setSubject("poseidon :验证码");
        simpleMailMessage.setText("验证码是："+context+"   五分钟内有效");
        javaMailSender.send(simpleMailMessage);
    }


}
