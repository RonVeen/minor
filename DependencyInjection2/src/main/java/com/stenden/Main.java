package com.stenden;

import com.stenden.model.Processor;
import com.stenden.model.impl.LoggerMessage;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Ron on 24/11/2016.
 */
public class Main {


    public static void main(String... args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationcontext.xml");


        Processor processor = (Processor)ctx.getBean("processor");

        String msg = processor.process();

        System.out.println(msg);
    }


}
