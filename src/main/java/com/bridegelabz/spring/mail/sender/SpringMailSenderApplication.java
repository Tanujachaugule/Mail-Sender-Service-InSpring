package com.bridegelabz.spring.mail.sender;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class SpringMailSenderApplication {
	@Autowired
	private EmailSenderService service;

	public static void main(String[] args) {
		SpringApplication.run(SpringMailSenderApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
//			service.sendSimpleMail("tanujachaugule1999@gmail.com",
//					" This is the mail body",
//					"This is the mail subject");
		service.sendEmailWithAttachment("tanujachaugule1999@gmail.com",
				" This is the mail body with attachment",
				"This is the mail subject with attachment",
				"C:\\Users\\ADMIN\\Downloads\\Spring Mail Sender\\Spring-Mail-Sender\\HELP.md");
		}

	}

