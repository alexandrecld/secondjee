package com.lidem.cfa.controller;

import com.lidem.cfa.dao.PersonneService;
import com.lidem.cfa.dto.Personne;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "HelloServlet", urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PersonneService ps = new PersonneService();
//        PrintWriter out = resp.getWriter();
        Personne jeanjean = new Personne("Dupont", "Jeanjean");
//        ps.addPersonne(jeanjean);
        String titre = "Bienvenue";
        Date today = new Date();
        System.out.println(today);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/bienvenue.jsp");
        req.setAttribute("titre", titre);
        req.setAttribute("personne", jeanjean);
        req.setAttribute("date", today);
        dispatcher.forward(req, resp);
//        out.println("<html><head><title>hello</title>" +
//                "</head><body>" +
//                "<ol>" +
//                "<li>Bonjour " + jeanjean.getFullName() + "</li>" +
//                "</ol></body></html>");
    }
}
