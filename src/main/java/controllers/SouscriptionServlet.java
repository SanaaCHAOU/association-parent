/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import business.Enfant;
import business.Parent;
import business.Souscription;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.sql.DataSourceDefinition;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/souscription")
public class SouscriptionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request
                .getRequestDispatcher("souscription_assurance.jsp")
                .forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        // get numero d'ahdeision à partir de l'utilisateur courant 
        Integer numeroAdhesion = ((Parent)session.getAttribute("user")).getNumeroAdhesion();
        
        List<Enfant> enfants = new ArrayList<>();
        // récuperation des information des enfant 
            // nombre d'enfants
            int nomberEnfant = Integer.parseInt(request.getParameter("nombre_enfant"));
            
            // recuperation des infos des enfants 
            for(int i = 1; i <= nomberEnfant; i++) {
                // nom
                String nom = request.getParameter("nom_enfant_" + i);
                
                // prenom
                String prenom = request.getParameter("prenom_enfant_" + i);
                
                // niveau
                String niveau = request.getParameter("niveau_enfant_" + i);
                
                // type de souscription
                String typeSouscription = request.getParameter("assurance_enfant_" + i);
                System.out.println("ASSURANCE TYPE REQUETE =========> " + typeSouscription);
                Souscription s  = new Souscription(null, typeSouscription);
                Enfant e = new Enfant(numeroAdhesion, nom, prenom, niveau, s);
                
                enfants.add(e);         
            }
            
            // ajouter la list enfants à la session utilisateur 
            session.setAttribute("enfants", enfants);
            
            // Stateless ==> sans etat
            
            request.getRequestDispatcher("confirm_souscription.jsp")
                    .forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
