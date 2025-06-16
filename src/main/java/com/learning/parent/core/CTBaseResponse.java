package com.learning.parent.core;

import org.json.JSONObject;

public class CTBaseResponse {
    private final JSONObject head = new JSONObject();
    private JSONObject body = new JSONObject();

    public CTBaseResponse(SessVO sessVO) {
        head.put("tnx_id", sessVO.getTnxId());
    }

    public JSONObject getHead() {
        return head;
    }

    public JSONObject getBody() {
        return body;
    }

    public void setBody(JSONObject body) {
        this.body = body;
    }
}
