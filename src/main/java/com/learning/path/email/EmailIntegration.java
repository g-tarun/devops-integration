package com.learning.path.email;

import java.util.Arrays;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailIntegration implements EmailService {
	
	@Value("${Notification_UserList}")
	private String notificationList;
	
	@Autowired
	JavaMailSender mailsender;

	@Override
	public JSONObject sendEmail(JSONObject body) {
		System.out.println(body);
		String email = body.opt("to").toString();
		String cc=body.optString("cc");
		JSONObject response=new JSONObject();
		System.out.println("Email to be valideate"+email);
		if(ValidateUser(email))
		{
			System.out.println("email validated");
			response=sendEmailImpl(body);
		}else {
			
			response.put("head", "");
			response.put("body", "Email is not present in props");
		}
		return response;
				
		
		
	}
	
	public boolean ValidateUser(String email)
	{
		
		List<String> validusers = Arrays.asList(notificationList.split(","));
		validusers.forEach(System.out::println);
		System.out.println(Arrays.stream(notificationList.replace("\"", "").split(","))
                .map(String::trim)
                .anyMatch(i -> i.equalsIgnoreCase(email)));
		return Arrays.stream(notificationList.replace("\"", "").split(","))
                .map(String::trim)
                .anyMatch(i -> i.equalsIgnoreCase(email));
		
	}
	
	
	public JSONObject sendEmailImpl(JSONObject body)
	{
		JSONObject resp= new JSONObject();
		try {
			System.out.println("inside email service");
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(body.getString("to"));
		message.setBcc(body.getString("cc"));
		message.setSubject(body.getString("subject"));
		message.setText(body.getString("content"));
		mailsender.send(message);
		
		System.out.println("Email sentsuccesfulyy");
		resp.put("head", "");
		resp.put("body", "Message send successfully");
		
	}catch(Exception e){
		resp.put("head", "");
		resp.put("body", "message send failed");
		System.out.println("Excetpion "+e);
	}
		return resp;
	}

}
