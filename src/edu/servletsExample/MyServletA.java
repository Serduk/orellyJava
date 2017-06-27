package edu.servletsExample;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Example for servlets.
 * How it works, etc
 *
 * Firstly, we need download HTTPServlet from oracle
 * Import Servlet to project
 * Created by sserdiuk on 6/27/17.
 */

/*
* Mostly simple servlets extend HttpServlet
* and override one or more methods
* */
public class MyServletA extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        * By this -> we say for server and client
        * in which format we will return response us result server execute
        * */
        response.setContentType("text/html");

        /*
        * In variable we save output thread
        * with the help of, we can write information back on server
        * */
        PrintWriter out = response.getWriter();

        String message = "If you read this -> Servlet is work";

        /*
        * This code we write for HTML page
        * she will be delivered back to browser from server
        * as well as any other web-page
        * also if she don't be  exist for this moment
        * */
        out.println("<HTML><BODY>");
        out.println("<H1>" + message + "</H1>");
        out.println("</BODY></HTML>");
        out.close();
    }
}
