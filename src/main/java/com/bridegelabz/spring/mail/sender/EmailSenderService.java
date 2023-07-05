package com.bridegelabz.spring.mail.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service

public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;
    public void sendSimpleMail(String toMail,
                               String body,
                               String subject){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("tanuja.chaugule03@gmail.com");
        message.setTo(toMail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);
        System.out.println("Mail Send .....");

    }
    public void sendEmailWithAttachment(String toMail,
                                        String body,
                                        String subject,
                                        String attachment) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper
                = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom("tanuja.chaugule03@gmail.com");
        mimeMessageHelper.setTo(toMail);
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject(subject);

        FileSystemResource fileSystem = new FileSystemResource(new File(attachment));
        mimeMessageHelper.addAttachment(fileSystem.getFilename(),fileSystem);
        mailSender.send(mimeMessage);
        System.out.println("Mail Sender .....");
    }

}
