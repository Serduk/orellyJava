package edu.servletsExample;

import edu.mainRun.PhraseOMatic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This Servlet Example use EnvironmentForServletWorkExample
 * and return string for user on HTML page
 * Created by sserdiuk on 6/27/17.
 */
public class KatyServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = "PhraseOMatic Has Generate following phrase";

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<HTML><HEAD><TITLE>");
        out.println("PhraseOMatic");
        out.println("</HTML></HEAD></TITLE>");

        out.println("<BODY>");
        out.println("<H1>" + title + "</H1>");
        out.println("<P>" + EnvironmetnForServletWorkExamples.makePhrase());
        out.println("<P><a href = \"KatyServlet\"> Make Another Phrase</a></P>");
        out.println("</BODY></HTML>");

        out.close();
    }
}
