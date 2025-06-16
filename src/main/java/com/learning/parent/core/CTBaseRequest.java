package com.learning.parent.core;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = CTBaseRequestDeserializer.class)
public class CTBaseRequest {
	
	private JSONObject head;
	private JSONObject body;
	public CTBaseRequest(JSONObject head, JSONObject body) {
		this.head=head;
		this.body=body;
	}
	public JSONObject getHead() {
		return head;
	}
	
	public JSONObject getBody() {
		return body;
	}
	
	

}
