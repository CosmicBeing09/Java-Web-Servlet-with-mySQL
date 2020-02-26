package com.demo.ServletUnderFrontController;

import com.demo.FrontController.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

public class Order extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Order Controller");
        out.close();
    }
}
