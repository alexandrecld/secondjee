package com.lidem.cfa.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PdfServlet", urlPatterns = {"/pdf"})
public class PdfServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/pdf");
        try{
            Document doc = new Document();
            PdfWriter.getInstance(doc, resp.getOutputStream());
            doc.open();
            doc.add(new Paragraph("Voici mon super text pour du pdf"));
            doc.add(new Paragraph("Voici un second paragraphe"));
            doc.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
