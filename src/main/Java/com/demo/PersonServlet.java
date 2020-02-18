package com.demo;

import com.demo.Converter.JSONconverter;
import com.demo.databaseConnection.DatabaseConnection;
import com.demo.model.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.stream.Collectors;


@WebServlet("/person")
public class PersonServlet extends HttpServlet {

    JSONconverter<Person> jsonConverter = new JSONconverter<Person>();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Connection con = DatabaseConnection.initDatabase();

            PreparedStatement statement = con.prepareStatement("insert into person values(?, ?, ?)");

//            Gson jsonConverter =new GsonBuilder().create();
//            Person person = jsonConverter.fromJson(req.getReader().lines().collect(Collectors.joining(System.lineSeparator())),Person.class);

            Person person = jsonConverter.JSONtoObject(req.getReader().lines().collect(Collectors.joining(System.lineSeparator())),Person.class);
            statement.setInt(1,person.getId());

            statement.setString(2,person.getName());

            statement.setInt(3,person.getAge());

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h3>Hello From Person</h3>");
    }
}
