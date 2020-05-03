package com.acms.CentralSellerPortal.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailService
{

    private static JavaMailSender mailSender;


    @Autowired
    public void setJavaMailer(JavaMailSender mailSender) {
        EmailService.mailSender=mailSender;
    }


    // @Autowired
    //  private SimpleMailMessage preConfiguredMessage;

    /**
     * This method will send compose and send the message
     * */
    public static void sendMail(String to, String subject, String body)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }


}
