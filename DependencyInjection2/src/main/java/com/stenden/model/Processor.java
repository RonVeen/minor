package com.stenden.model;

import com.stenden.model.impl.LoggerMessage;

/**
 * Created by Ron on 24/11/2016.
 */
public class Processor {

    private LoggerMessage message;

//    public Processor(LoggerMessage message) {
//        this.message = message;
//    }

    public void setMessage(LoggerMessage message) {
        this.message = message;
    }

    public String process() {
        return this.message.getMessage();
    }
}
