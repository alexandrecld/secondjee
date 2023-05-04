package com.lidem.cfa.utils;

import com.lidem.cfa.dto.Personne;

import java.util.List;

public class WebUtil {

    public static String getHead(String title) {
        return "<html><head><title>" + title + "</title></head><body>";
    }

    public static String getFoot() {
        return "</body></html>";
    }

    public static String goHome() {
        return "<nav><a href='./'>Accueil</a></nav>";
    }

    public static String lienHome() {
        return "<nav><a href='./'>Accueil</a></nav>";
    }

    public static String generatePersonnesList(List<Personne> personnes) {
        String html = "<ul>";
        for (Personne personne : personnes) {
            html += "<li>" + personne.getNom() + " " + personne.getPrenom() + "</li>";
        }
        html += "</ul>";
        return html;
    }

    public static String getLogout() {
        return "<nav><a href='./logout'>Déconnexion</a></nav>";
    }
}