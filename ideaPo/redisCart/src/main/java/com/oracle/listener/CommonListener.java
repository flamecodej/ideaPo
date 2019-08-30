package com.oracle.listener;

import com.oracle.service.ProService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class CommonListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();

        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-root.xml");
        ProService proService = (ProService) ac.getBean("proServiceImpl");
        sc.setAttribute("initProList",proService.list());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
