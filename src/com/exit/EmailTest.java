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
		email.addText("����д����Test");
//		email.embed(new File("D:\\user\\P0049380\\�ҵ�����","20141113150803.jpeg"));
		//from EmailAddress need mail-1.4.5.jar package
		email.from("1282911204@qq.com").to("1282911204@qq.com");
		email.subject("�ҵ�����������");
		
		SendMailSession mailSession = new SmtpSslServer("smtp.qq.com","1282911204@qq.com", "cww199433.").createSession();
		mailSession.open();
		mailSession.sendMail(email);
		mailSession.close();
		System.out.println("���ͳɹ�!...");
	}
}