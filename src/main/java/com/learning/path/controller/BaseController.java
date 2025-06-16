package com.learning.path.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.parent.core.CTBaseRequest;
import com.learning.parent.core.CTBaseResponse;
import com.learning.parent.core.SessVO;
import com.learning.path.base.AccountNumber;
import com.learning.path.email.EmailService;

@RestController
@RequestMapping("/Tcs")
public class BaseController {

	private AccountNumber accountNumber;
	
	private EmailService emailService;
	
	@Autowired
	public BaseController(AccountNumber accountNumber,EmailService emailService) {
		this.accountNumber = accountNumber;
		this.emailService=emailService;
	}

	@GetMapping("/accountVerify/{userID}")
	public ResponseEntity<Object> orchestrate(@PathVariable String userID) {
		String result = accountNumber.VerifyAccount(userID);

		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/sendEmail")
	public ResponseEntity<CTBaseResponse> sendEmail(@RequestBody CTBaseRequest body)
	{
		JSONObject response=new JSONObject();
		SessVO sessVo = null;
		CTBaseResponse ctresp = new CTBaseResponse(sessVo);
		try {
			System.out.println("reached to controller");
			System.out.println("intital request"+body.getBody());
			response = emailService.sendEmail(body.getBody());
			
		}catch(Exception e)
		{
			System.out.println("exception while sending the mail"+e);
		}
		
		if(!response.equals(null))
		{
			System.out.println("return the response");
			ctresp.setBody(response);
			return ResponseEntity.ok(ctresp);
		}else {
			return (ResponseEntity<CTBaseResponse>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
		}
		
	}

}
