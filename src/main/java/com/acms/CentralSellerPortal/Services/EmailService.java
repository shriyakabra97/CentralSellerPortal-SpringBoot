package com.acms.CentralSellerPortal.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import javax.mail.internet.MimeMessage;
import javax.mail.MessagingException;
import org.springframework.mail.javamail.MimeMessageHelper;


import java.io.*;


@Service("emailService")
public class EmailService
{

    private JavaMailSender mailSender;

    @Autowired
    public EmailService(JavaMailSender javamailSender) {
        this.mailSender = javamailSender;
    }


    public void sendMail(String to,String subject, boolean isHtml) throws MessagingException, FileNotFoundException {

        MimeMessage emailMessage = mailSender.createMimeMessage();
        MimeMessageHelper mailBuilder = new MimeMessageHelper(emailMessage, true);

        mailBuilder.setTo(to);
        String conten = "<h1 style=\"color: black; font-size:28px; text-align:center;\"> Central Seller Portal</h1>\n" +
                "<p style=\"color: grey; font-size:14px; text-align:center;\">One Stop for all Sellers' Information</p>\n" +
                "\n" +
                "<br/>\n" +
                "<div style=\"color: black; font-size:14px;\">\n" +
                "<p>Hii,</p>\n" +
                "<p>   Greetings from Central Seller Portal </p>\n" +
                " <p>   There have been some updates in the last 4 hours,\n" +
                "     click on the button below to log-in or kindly visit our website.</p>\n" +
                "</div>\n" +
                "<div><button href=\"http://localhost:8080\" style=\"margin: auto;display: block;padding: 14px 45px; text-align: center; background-color: green; color: white;\">Click here to log-in</button></div>\n" +
                "\n" +
                "<br/>\n" +
                "<div>\n" +
                "    <table  cellpadding=\"0\"; cellspacing=\"0\"; width=\"85%\"; align=\"center\">\n" +
                "        <tr>\n" +
                "            <td >\n" +
                "    <table cellpadding=\"0\"; cellspacing=\"0\"; width=\"100%\" >\n" +
                "        <tr><td width=\"50%\" >\n" +
                "            <img src=\"https://media.treehugger.com/assets/images/2020/04/grocery-cart.jpg.860x0_q70_crop-scale.jpg\" width=\"100%\" height=\"280\" style=\"display: block;\"/>\n" +
                "\n" +
                "\n" +
                "\n" +
                "        </td><td>\n" +
                "            <img src=\"https://www.startuptalks.in/wp-content/uploads/2016/03/email-laptop-computer-marketing-ss-1920-800x445.jpg\" width=\"100%\" height=\"280\" style=\"display: block;\"/>\n" +
                "\n" +
                "        </td>\n" +
                "        </tr>\n" +
                "    </table></td></tr>\n" +
                "        <tr>\n" +
                "            <td>\n" +
                "                <table cellpadding=\"0\"; cellspacing=\"0\"; width=\"100%\">\n" +
                "                    <tr style=\"padding: 25px 0 0; background-color: black; color: white \">\n" +
                "                        <td width=\"50%\" >\n" +
                "                        <p ><strong>Benefits of being on our Portal</strong></p>\n" +
                "                        <p>All sellers' information is now just one click away.</p>\n" +
                "                            <p> Timely notifications from us and huge variety of products. </p>\n" +
                "                    </td>\n" +
                "                      <td width=\"50%\"> <p ><strong>One Stop Store</strong></p>\n" +
                "\n" +
                "                        <p>We notify you all the updates,</p>\n" +
                "                          <p>from new sellers tonew products added to deletion of any product. </p>\n" +
                "                 </td>\n" +
                "\n" +
                "\n" +
                "                    </tr>\n" +
                "                </table></td></tr></table>\n" +
                "</div>\n" +
                "<div>\n" +
                "    <p>Please do not reply to this mail, this is a system generated mail.</p>\n" +
                "\n" +
                "    <p>  Have a great day!</p>\n" +
                "\n" +
                "    <p>  -Central Seller Portal Team</p>\n" +
                "</div>";

        mailBuilder.setText(conten, isHtml); // Second parameter indicates that this is HTML mail
        mailBuilder.setSubject(subject);

        mailSender.send(emailMessage);

    }


}