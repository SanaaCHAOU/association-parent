/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import business.dao.ParentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * Servlet Permettant de créer les table de la base de données
 */
@WebServlet(name = "InitDatabaseServlet", urlPatterns = {"/init-db"})
public class InitDatabaseServlet extends HttpServlet {
    // on demande au conteneur de chercher l'instance créer automatiquement de type DataSources
    // et l'affecter à la propriete ds
    @Inject
    DataSources ds;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("init-db.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dropParam = request.getParameter("drop");
        boolean dropTables = (dropParam != null) && (dropParam == "true");
        try {
            DataSource data = ds.getDataSource();
            Connection conn = data.getConnection();
            String dropParentTable = "DROP TABLE Parent";
            String createParentTable = "CREATE TABLE Parent ("
                + "numero_adhesion INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,"
                + "email VARCHAR(100) NOT NULL UNIQUE,"
                + "nom VARCHAR(25) NOT NULL,"
                + "prenom VARCHAR(25) NOT NULL,"
                + "telephone VARCHAR(13) NOT NULL,"
                + "mdp VARCHAR(60) NOT NULL,"
                + "email_parent_2 VARCHAR(100) DEFAULT NULL,"
                + "telephone_parent_2 VARCHAR(13) DEFAULT NULL,"
                + "nom_parent_2 VARCHAR(25) DEFAULT NULL,"
                + "prenom_parent_2 VARCHAR(25) DEFAULT NULL)";

            String dropSouscriptionAssuranceTable = "DROP TABLE SouscriptionAssurance";
            String createSouscriptionAssuranceTable = "CREATE TABLE SouscriptionAssurance("
                + "numero_souscription INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,"
                + "type_souscription VARCHAR(25) NOT NULL)";

            String dropEnfantTable = "DROP TABLE Enfant";
            String createEnfantTable = "CREATE TABLE Enfant("
                + "numero_adhesion INT NOT NULL,"
                + "nom VARCHAR(25) NOT NULL,"
                + "prenom VARCHAR(25) NOT NULL,"
                + "niveau VARCHAR(25) NOT NULL,"
                + "numero_souscription INT DEFAULT NULL,"
                + "PRIMARY KEY (numero_adhesion, prenom),"
                + "FOREIGN KEY (numero_adhesion) REFERENCES Parent(numero_adhesion),"
                + "FOREIGN KEY (numero_souscription) REFERENCES SouscriptionAssurance (numero_souscription))";

            Statement stmt = conn.createStatement();
            
            if(dropTables) {
                stmt.executeUpdate(dropEnfantTable);
                stmt.executeUpdate(dropParentTable);
                stmt.executeUpdate(dropSouscriptionAssuranceTable);
            }
            
            stmt.executeUpdate(createParentTable);
            stmt.executeUpdate(createSouscriptionAssuranceTable);
            stmt.executeUpdate(createEnfantTable);
            
            request.getRequestDispatcher("inscription_association.jsp").forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
