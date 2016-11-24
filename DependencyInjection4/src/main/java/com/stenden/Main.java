package com.stenden;

import com.stenden.config.Config;
import com.stenden.model.Processor;
import com.stenden.model.impl.LoggerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(Config.class);
        ctx.refresh();

        processor = ctx.getBean(Processor.class);
        String msg = processor.process();

        System.out.println(msg);
    }


}
