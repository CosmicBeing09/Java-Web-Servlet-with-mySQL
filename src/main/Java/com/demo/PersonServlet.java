package com.demo;

import com.demo.Converter.JSONconverter;
import com.demo.Wrapper.PersonWrapper;
import com.demo.XMLconverter.PersonXMLconverter;
import com.demo.databaseConnection.DatabaseConnection;
import com.demo.model.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;


@WebServlet("/person")
public class PersonServlet extends HttpServlet {

    JSONconverter<Person> jsonConverter = new JSONconverter<Person>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Connection con = DatabaseConnection.initDatabase();

            PreparedStatement statement = con.prepareStatement("insert into person values(?, ?, ?)");

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

        Connection con = null;
        try {
            con = DatabaseConnection.initDatabase();
            PreparedStatement statement = con.prepareStatement("select * from person");
            ResultSet resultSet = statement.executeQuery();


            ArrayList<Person> personArrayList = new ArrayList<>();
            while (resultSet.next()){

                Person temp = new Person(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"));

                personArrayList.add(temp);

            }

            PrintWriter out = resp.getWriter();
            if(req.getHeader("Accept").equals("application/xml")){
                PersonXMLconverter personXMLconverter = new PersonXMLconverter();

                PersonWrapper personWrapper = new PersonWrapper();
                personWrapper.setPersonList(personArrayList);

                out.println(personXMLconverter.convertPersonListToXml(personWrapper));

                resp.setContentType("application/xml");

            }

            else{

                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String jsonResponse = gson.toJson(personArrayList);

                out.println(jsonResponse);
                resp.setContentType("application/json");
            }


            out.close();
            statement.close();
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException | JAXBException e) {
            e.printStackTrace();
        }


    }
}
