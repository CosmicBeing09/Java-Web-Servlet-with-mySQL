package com.demo.FrontController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class FrontCommand {
    protected ServletContext context;
    protected HttpServletRequest request;
    protected HttpServletResponse response;

    public void init(ServletContext context,HttpServletRequest request,HttpServletResponse response){
        this.context = context;
        this.request = request;
        this.response = response;
    }

    public abstract void process() throws ServletException,IOException;

    protected void forward(String target) throws ServletException, IOException {
        target = String.format("/WEB-INF/%s.jsp",target);
        RequestDispatcher rd = context.getRequestDispatcher(target);
        rd.forward(request,response);
    }
}
