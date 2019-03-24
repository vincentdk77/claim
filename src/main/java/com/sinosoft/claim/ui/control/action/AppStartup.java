package com.sinosoft.claim.ui.control.action;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
/**
 * 启动时初始化配置 
 */ 
public class AppStartup extends HttpServlet {
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
//        String dbmanagerConfig = servletConfig.getInitParameter("dbmanagerConfig");
//        String logConfig = servletConfig.getInitParameter("logConfig");
//        String sysconstConfig = servletConfig.getInitParameter("sysconstConfig");
//        String exceptionConfig = servletConfig.getInitParameter("exceptionConfig");
        try {
            //Logger.configure(servletConfig.getServletContext().getRealPath(logConfig));
            //AppConfig.configure(servletConfig.getServletContext().getRealPath(sysconstConfig));
            //UserException.configure(servletConfig.getServletContext().getRealPath(exceptionConfig));
             
            //DBFactory.configure(servletConfig.getServletContext().getRealPath(dbmanagerConfig));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
