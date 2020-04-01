package com.jsu.util;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.*;

public class CheckAccountUtil {
    /**
     * 通过QQ邮箱发送验证码
     * @param toEmail 收件人电子邮箱
     * @return 验证码
     */
    public static String sendEmail(String toEmail)  {
        // 发件人电子邮箱
        String from = "1726637374@qq.com";
        // 指定发送邮件的主机为 smtp.qq.com
        String host = "smtp.qq.com";  //QQ 邮件服务器
        // 获取系统属性
        Properties properties = System.getProperties();
        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);
    //bgyirymlupsxegcc
        properties.put("mail.smtp.auth", "true");
        MailSSLSocketFactory sf = null;
        try {
            sf = new MailSSLSocketFactory();
        } catch (GeneralSecurityException e) {
            System.out.println("GeneralSecurityException 异常 CheckAccountUtil 33 行");
            return null;
        }
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("1726637374@qq.com", "wkjwjpctwbqvdcid");
            }
        });
//        List<Integer> randList = new ArrayList<>();
        StringBuffer code = new StringBuffer();
        Random random = new Random();
        for(int i=0;i<4;i++) {
            code.append(random.nextInt(10));
        }
        try {
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);
            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));
            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            // Set Subject: 头部头字段
            message.setSubject("U store 验证码");
            // 设置消息体
            message.setText(String.valueOf(code));
            // 发送消息
            Transport.send(message);
        } catch (MessagingException mex) {
            System.out.println("MessagingException 异常 CheckAccountUtil 67 行");
            return null;
        }
        return String.valueOf(code);
    }


    public String sendTel(){
        return null;
    }
}
