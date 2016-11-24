package com.stenden;

import com.stenden.model.Processor;
import com.stenden.model.impl.LoggerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Ron on 24/11/2016.
 */
public class Main {

    @Autowired
    Processor processor;


    public static void main(String... args) {
        new Main();
    }


    public Main() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationcontext.xml");
        AutowireCapableBeanFactory acbFactory = ctx.getAutowireCapableBeanFactory();
        acbFactory.autowireBean(this);

        String msg = processor.process();

        System.out.println(msg);
    }


}
