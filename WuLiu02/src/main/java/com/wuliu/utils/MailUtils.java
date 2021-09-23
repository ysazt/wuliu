package com.wuliu.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 发邮件工具类
 */
public final class MailUtils {
    private static final String USER = "1262602082@qq.com"; // 发件人称号，同邮箱地址
    private static final String PASSWORD = "wuhpeaewhkiigcdc"; // 如果是qq邮箱可以使户端授权码，或者登录密码
    //SMTP fttpamrbqutuhebf
    // eXCHANCE  papflyteccuqjfje
    // CARDDIV  bsrcblxtoctxgaib


    /**
     *
     * @param to 收件人邮箱
     * @param text 邮件正文
     * @param title 标题
     */
    /* 发送验证信息的邮件 */
    public static boolean sendMail(String to, String text, String title){
        try {
           // System.setProperty("java.net.preferIPv4Stack", "true");
            final Properties props = new Properties();

            props.setProperty("mail.debug", "true");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", "smtp.qq.com");
           // props.put("mail.smtp.port", "25");
            //props.setProperty("mail.transport.protocol", "smtp");
           props.setProperty("mail.smtp.ssl.enable", "true");
         //   props.setProperty("mail.smtp.port", "587");
          //  props.setProperty("mail.smtp.socketFactory.port", "587");


            // 发件人的账号
            props.put("mail.user", USER);
            //发件人的密码
            props.put("mail.password", PASSWORD);

            // 构建授权信息，用于进行SMTP进行身份验证
            Authenticator authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    // 用户名、密码
                    String userName = props.getProperty("mail.user");
                    String password = props.getProperty("mail.password");
                    return new PasswordAuthentication(userName, password);
                }
            };
            // 使用环境属性和授权信息，创建邮件会话
            Session mailSession = Session.getInstance(props, authenticator);
            // 创建邮件消息
            MimeMessage message = new MimeMessage(mailSession);
            // 设置发件人
            String username = props.getProperty("mail.user");
            InternetAddress form = new InternetAddress(username);
            message.setFrom(form);

            // 设置收件人
            InternetAddress toAddress = new InternetAddress(to);
            message.setRecipient(Message.RecipientType.TO, toAddress);

            // 设置邮件标题
            message.setSubject(title);

            // 设置邮件的内容体
            message.setContent(text, "text/html;charset=UTF-8");
            // 发送邮件
            Transport transport = mailSession.getTransport();
            transport.send(message);
            transport.close();

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) throws Exception { // 做测试用
        String content="<a href='http://localhost:8080/web0822_war_exploded/mails?code=1'>点击激活</a>";
        MailUtils.sendMail("ting.zhang@ambow.com",content,"激活邮件");
        //MailUtils.sendMail("ting.zhang@ambow.com","你好，这是一封测试邮件，无需回复。","测试邮件");
        System.out.println("发送成功");
    }



}
