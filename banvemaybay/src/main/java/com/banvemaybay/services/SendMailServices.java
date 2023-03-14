package com.banvemaybay.services;

import java.util.Properties;
import java.util.Random;
import javax.servlet.http.HttpServlet;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class SendMailServices {
	private static final String chart = "abcdefghijklmnopqrstuvwxyz0123456789";
	public static final String ACCOUNT_SID = "AC0e1b830f7c1a7020bf1c9158586f5669";
	public static final String AUTH_TOKEN = "4f430a5a72fb16b0b44713f3c3899b5e";
	public static void sendMail(String to,String subject, String text) {
		final String from = "2051050459thao@ou.edu.vn";
        String host = "smtp.gmail.com";
        final String password = "kolonam0706847756";

		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.port", "587");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.ssl.trust", host);

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			message.setText(text);

			Transport.send(message);
			System.out.println("Email sent successfully.");
		} catch (MessagingException mex) {
			System.out.println("Failed");
			mex.printStackTrace();
		}

	}

	public static void sendSMS(String sdt, String text) {

		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		String sendSMS = text;

		Message message = Message.creator(new PhoneNumber(sdt), new PhoneNumber("+15746867718"), sendSMS)
				.create();

		System.out.println(message.getSid());

	}

	public static String randomChar() {
		Random rand = new Random();
		StringBuilder std = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			int index = rand.nextInt(0, chart.length());
			char randChart = chart.charAt(index);
			std.append(randChart);
		}
		return std.toString();
	}
}
