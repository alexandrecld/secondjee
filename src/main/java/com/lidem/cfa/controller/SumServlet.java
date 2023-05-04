package com.lidem.cfa.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddServlet", urlPatterns = {"/sum"})
public class SumServlet extends HttpServlet {
    Integer num1 = 5;
    Integer num2 = 9;

    public Integer addNumbers(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

// recover the url string params
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");

        out.println("<html><head><title>hello</title></head><body><h2>Welcome to the Some Page</h2><p>The sum of "
                + num1 + " and " + num2
                + " is " + String.valueOf(addNumbers(Integer.parseInt(num1), Integer.parseInt(num2)))
                + "</p> <h6>Merci, au revoir.</h6></body></html>"
        );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

// recover the url string params
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");

        out.println("<html><head><title>hello</title></head><body><h2>Welcome to the Sum Page</h2><p>The sum of "
                + num1 + " and " + num2
                + " is " + String.valueOf(addNumbers(Integer.parseInt(num1), Integer.parseInt(num2)))
                + "</p> <h6>Merci, au revoir.</h6></body></html>"
        );
    }
}