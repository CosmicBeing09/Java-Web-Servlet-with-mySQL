package com.demo;

import com.demo.databaseConnection.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println(req.getContextPath());

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h3>Hello Client</h3>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Connection con = DatabaseConnection.initDatabase();

            PreparedStatement statement = con.prepareStatement("insert into demo values(?, ?)");

            statement.setInt(1,Integer.valueOf(req.getParameter("id")));

            statement.setString(2,req.getParameter("text"));

            statement.executeUpdate();

            statement.close();

            con.close();

            PrintWriter out = resp.getWriter();
            out.println("<html><body><b>Successfully Inserted"
                    + "</b></body></html>");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
