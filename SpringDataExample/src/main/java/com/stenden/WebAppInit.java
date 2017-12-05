package com.stenden;

import com.stenden.config.Config;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


/**
 * Created by Ron on 24/11/2016.
 */
public class WebAppInit implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(Config.class);
        context.setServletContext(servletContext);

        ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        dynamic.addMapping("/");
        dynamic.setLoadOnStartup(1);
    }
}
