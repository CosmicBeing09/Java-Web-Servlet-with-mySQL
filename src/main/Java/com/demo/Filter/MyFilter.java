package com.demo.Filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter out = servletResponse.getWriter();
        out.println("Filter in invoked before");

        filterChain.doFilter(servletRequest,servletResponse);

        out.println("Filter is invoked after");
    }
}
