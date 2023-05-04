package com.lidem.cfa.controller;

import com.lidem.cfa.utils.WebUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "private", urlPatterns = "/private")
public class PrivateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();
        String html = WebUtil.getHead("private") + WebUtil.goHome();
        if (session.getAttribute("connected") != null && session.getAttribute("connected").equals(true)) {
            html += WebUtil.getLogout();
            html += "Vous êtes connecté" + WebUtil.getFoot();
            out.println(html);
        } else {
            html += "vous n'êtes pas autorisé" + WebUtil.getFoot();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();
        if (session.getAttribute("connected") != null && session.getAttribute("connected").equals(true)) {
            resp.sendRedirect("./private");
//            RequestDispatcher dispatcher = req.getRequestDispatcher("/private");
//            dispatcher.forward(req, resp);
        } else {
            String identifiant = req.getParameter("identifiant");
            String password = req.getParameter("password");

            if (identifiant != null && password != null && identifiant.equals("admin") && password.equals("admin")) {
                session.setAttribute("connected", true);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/private");
                dispatcher.forward(req, resp);
            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
                dispatcher.forward(req, resp);
            }
        }
    }
}
