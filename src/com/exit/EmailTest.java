package com.exit;

import java.io.File;

import jodd.mail.Email;
import jodd.mail.EmailMessage;
import jodd.mail.SendMailSession;
import jodd.mail.SmtpSslServer;
import jodd.util.MimeTypes;

public class EmailTest {
	public static void main(String[] args) {
		Email email = Email.create();
		//MimeTypes.MIME_TEXT_PLAIN need jodd-code.jar package
		email.addMessage(new EmailMessage("Hello, I am Vincen",MimeTypes.MIME_TEXT_PLAIN));
		email.addText("这里写的是Test");
//		email.embed(new File("D:\\user\\P0049380\\我的桌面","20141113150803.jpeg"));
		//from EmailAddress need mail-1.4.5.jar package
		email.from("1282911204@qq.com").to("1282911204@qq.com");
		email.subject("我的主题我做主");
		
		SendMailSession mailSession = new SmtpSslServer("smtp.qq.com","1282911204@qq.com", "cww199433.").createSession();
		mailSession.open();
		mailSession.sendMail(email);
		mailSession.close();
		System.out.println("发送成功!...");
	}
}