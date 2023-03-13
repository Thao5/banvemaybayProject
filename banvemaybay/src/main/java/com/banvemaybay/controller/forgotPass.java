package com.banvemaybay.controller;

import javax.servlet.http.HttpServlet;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
public class forgotPass extends HttpServlet {
	 public static final String ACCOUNT_SID = "AC0e1b830f7c1a7020bf1c9158586f5669";
	 public static final String AUTH_TOKEN = "4f430a5a72fb16b0b44713f3c3899b5e";
	 public static void main(String[] args) {
	        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

	        Message message = Message.creator(
	                new PhoneNumber("0981543358"),
	                new PhoneNumber("+15746867718"),
	                "Hello from Twilio!")
	            .create();

	        System.out.println(message.getSid());
	    }

}
