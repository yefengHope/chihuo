// package com.fengyu;
//
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.SpringApplicationConfiguration;
// import org.springframework.mail.SimpleMailMessage;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
// /**
//  * 邮件测试
//  * Created by rain on 2017/3/21.
//  */
// @RunWith(SpringJUnit4ClassRunner.class)
// @SpringApplicationConfiguration(classes = ChihuoApplication.class)
// public class SendMailTest {
//
//     @Autowired
//     private JavaMailSender mailSender;
//
//     @Test
//     public void sendSimpleMail() throws Exception {
//         SimpleMailMessage message = new SimpleMailMessage();
//         message.setFrom("1825445185@qq.com");   // 发送者
//         message.setTo("1825445185@qq.com");     // 接收者
//         // message.setFrom("15881253374@163.com");   // 发送者
//         // message.setTo("1825445185@qq.com");     // 接收者
//         message.setSubject("主题：简单邮件");      //邮件主题
//         message.setText("测试邮件内容");          //邮件内容
//         mailSender.send(message);               //发送邮件
//     }
// }
