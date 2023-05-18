package com.example.demo;

import java.io.*;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello, PC!";
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        var writer = response.getWriter();
        writer.write("<html><body>");
        try (var reader = request.getReader()) {
            var lines = reader.lines();
            lines.forEach(writer::write);
            lines.forEach(System.out::println);
            writer.write("</body></html>");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<a href=\"download-servlet\">Download file</a><br>");
        Enumeration<String> headerNames = request.getHeaderNames();

        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String header = headerNames.nextElement();
                out.println(header + ": " + request.getHeader(header));
                out.println("<br>");
            }
        }
//        out.println(request.getHeader());
        out.println("</body></html>");
    }
    public void destroy() {
    }
}