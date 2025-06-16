package com.learning.parent.core;

public class SessVO {
    private final String tnxId;
public int counter;
    public SessVO() {
    	
        this.tnxId = "com.tcs"+System.currentTimeMillis() + "_" + counter;
        counter++;
    }

    public String getTnxId() {
        return tnxId;
    }
}
