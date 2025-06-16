package com.learning.path.email;

import org.json.JSONObject;

public interface EmailService {
	
	public JSONObject sendEmail(JSONObject body);

}
