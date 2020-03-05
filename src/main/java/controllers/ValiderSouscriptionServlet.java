/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import business.Enfant;
import business.dao.EnfantDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author moham
 */
@WebServlet(name = "ValiderSouscriptionServlet", urlPatterns = {"/validation"})
public class ValiderSouscriptionServlet extends HttpServlet {
    @Inject
    EnfantDAO enfantDAO;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            List<Enfant> selectedEnfants = enfantDAO.selectAll();
            request.getSession().setAttribute("enfants", selectedEnfants);
            request.getRequestDispatcher("recu_souscription.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ValiderSouscriptionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Enfant> enfants = (List<Enfant>)request
                .getSession()
                .getAttribute("enfants");
        try {
            for(Enfant enfant: enfants) {
                enfantDAO.insert(enfant);
            }

            List<Enfant> selectedEnfants = enfantDAO.selectAll();
            request.getSession().setAttribute("enfants", selectedEnfants);
            request.getRequestDispatcher("recu_souscription.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ValiderSouscriptionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
