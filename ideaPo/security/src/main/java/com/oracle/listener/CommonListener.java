package com.oracle.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class CommonListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("root",sc.getContextPath());
        sc.setAttribute("css",sc.getContextPath()+"/resources/css");
        sc.setAttribute("js",sc.getContextPath()+"/resources/js");
        sc.setAttribute("img",sc.getContextPath()+"/resources/images");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
