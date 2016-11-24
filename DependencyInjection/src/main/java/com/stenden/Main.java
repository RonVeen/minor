package com.stenden;

import com.stenden.model.impl.LoggerMessage;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Ron on 24/11/2016.
 */
public class Main {


    public static void main(String... args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationcontext.xml");


        LoggerMessage loggerMessage = (LoggerMessage)ctx.getBean("loggerMessage");

        String msg = loggerMessage.getMessage();

        System.out.println(msg);
    }


}
