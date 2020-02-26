package com.demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/welcome")
public class Welcome extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/test.jsp");
            request.setAttribute("name",request.getParameter("user"));
            rd.forward(request,response);
           // out.println("<h2> Welcome Client</h2>");

        }finally {
            out.close();
        }
    }
}
