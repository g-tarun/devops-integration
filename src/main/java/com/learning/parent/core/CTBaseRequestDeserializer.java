package com.learning.parent.core;

import java.io.IOException;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class CTBaseRequestDeserializer extends JsonDeserializer<CTBaseRequest>{

	@Override
	public CTBaseRequest deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		JsonNode node=p.getCodec().readTree(p);
		
		
		JsonNode headNode=node.get("head");
		JsonNode bodyNode=node.get("body");
		
		JSONObject head = new JSONObject(headNode.toString());
		JSONObject body = new JSONObject(bodyNode.toString());
		return new CTBaseRequest(head,body);
	}

}
