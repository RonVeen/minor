package com.stenden.model;

import com.stenden.model.impl.LoggerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Ron on 24/11/2016.
 */
@Component
public class Processor {

    @Autowired
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
