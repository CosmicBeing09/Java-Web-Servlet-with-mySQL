package com.demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/validate")
public class Validate extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        try {
            String name = req.getParameter("user");
            String password = req.getParameter("pass");

            if(password.equals("123")){
                RequestDispatcher rd = req.getRequestDispatcher("welcome");
                rd.forward(req,resp);
            }
            else{
                out.println("<font color='red'><b>Incorrect</b></font>");
                RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
                rd.include(req,resp);
            }
        }
        finally {
            out.close();
        }
    }
}
