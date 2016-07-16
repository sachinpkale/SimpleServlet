package com.sachinpkale.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleServlet extends HttpServlet {

    private static final long serialVersionUID = 3012706949375984482L;

    public void doGetStatic(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Welcome. Who are you?</h1>");
        out.println("</body>");
        out.println("</html>"); 
    }

    public void doGetDynamic(HttpServletRequest request, HttpServletResponse response, String user) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<marquee><h1>Welcome " + user + "</h1></marquee>");
        out.println("</body>");
        out.println("</html>"); 
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
              throws IOException, ServletException {
        String user = request.getParameter("iam");
    	if(user == null) {
            doGetStatic(request, response);
        } else {
            doGetDynamic(request, response, user);            
        }
    }
	
}
