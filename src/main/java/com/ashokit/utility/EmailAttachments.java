package com.ashokit.utility;

import java.io.File;


import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


@Component
public class EmailAttachments {
	@Autowired
    private JavaMailSender mailSender;
   
	public boolean sendEmail(String subject,String body,String to,File f) {
       
		
		try {
		 MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
		helper.setSubject(subject);
		helper.setText(body,true);
		helper.setTo(to);
		helper.addAttachment("plans_info",f );
		
		mailSender.send(mimeMessage);	
		}catch(Exception e) {
			e.getStackTrace();		}
		
		return true;
	}
	
public boolean sendEmailPdf(String subject,String body,String to,File f) {
       
		
		try {
		 MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
		helper.setSubject(subject);
		helper.setText(body,true);
		helper.setTo(to);
		helper.addAttachment("plans_info",f );
		
		mailSender.send(mimeMessage);	
		}catch(Exception e) {
			e.getStackTrace();		}
		
		return true;
	}
}
