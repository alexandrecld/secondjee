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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebServlet(name="ListServlet", urlPatterns={"/list"})
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        PersonneService service = new PersonneService();

        List<Personne> personnes = new ArrayList<Personne>();
        personnes.add(new Personne("Dupont", "Jeanjean"));
        personnes.add(new Personne("Dupont2", "Jeanjean"));
        personnes.add(new Personne("Dupont3", "Jeanjean"));
        personnes.add(new Personne("Dupont4", "Jeanjean"));

        Iterator<Personne> iter = personnes.iterator();
        while (iter.hasNext()) {
            service.addPersonne((Personne) iter.next());
        }

        List<Personne> listPersonne = service.findAllPersonnes();

        req.setAttribute("personnes", listPersonne);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/liste.jsp");
        dispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");

        PersonneService service = new PersonneService();
        Personne personne = service.findPersonneByNomAndPrenom(nom, prenom);

        List<Personne> listPersonne = service.findAllPersonnes();

        req.setAttribute("personnes", listPersonne);
        req.setAttribute("personne", personne);
        RequestDispatcher dispatcher = req.getRequestDispatcher("./liste.jsp");
        dispatcher.forward(req, resp);
    }
}