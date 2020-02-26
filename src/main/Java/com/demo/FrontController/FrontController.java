package com.demo.FrontController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/base-path")
public class FrontController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FrontCommand command = getCommand(req);
        command.init(getServletContext(),req,resp);
        command.process();
    }

    private FrontCommand getCommand(HttpServletRequest request){
        try {
            Class type = Class.forName(String.format("com.demo.ServletUnderFrontController.%s",request.getParameter("command")));
            return (FrontCommand) type.asSubclass(FrontCommand.class).newInstance();
        } catch (Exception e) {
            return new UnknownCommand();
        }
    }

//    private FrontCommand getCommand(HttpServletRequest request) throws ClassNotFoundException {
//        String uri = request.getRequestURI();
//        StringBuilder sb = new StringBuilder(uri);
//        Class type = Class.forName(String.format("com.demo.%s"));
//    }
}
