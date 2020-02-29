/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import business.Parent;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.Resource;
import javax.annotation.sql.DataSourceDefinition;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author moham
 */
@DataSourceDefinition(
        name = "java:app/env/jdbc/sanaa",   
        className = "org.apache.derby.jdbc.EmbeddedDriver",   
//        portNumber = 1527,   
//        serverName = "localhost",   
//        databaseName = 
        url="jdbc:derby:association_parent;create=true;")
public class InscriptionAssociationServlet extends HttpServlet {
    @Resource(lookup = "java:app/env/jdbc/sanaa")
    DataSource data;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
        // recuperer les parametres de la requetes (info du parent)
        /*Parent parent = new Parent();
        
        parent.setEmail(request.getParameter("email"));
        parent.setMdp(request.getParameter("mdp"));
        parent.setNom(request.getParameter("nom"));
        parent.setPrenom(request.getParameter("prenom"));
        parent.setTelephone(request.getParameter("telephone"));*/
        System.out.println("DO POST EXECUTED");
        Connection conn = null;
        try {
            conn = data.getConnection();

            String createParentTable = "CREATE TABLE Parent ("
                    + "numero_adhesion INT AUTO_INCREMENT PRIMARY KEY,"
                    + "email VARCHAR(100) NOT NULL UNIQUE,"
                    + "nom VARCHAR(25) NOT NULL"
                    + "prenom VARCHAR(25) NOT NULL"
                    + "telephone VARCHAR(13) NOT NULL"
                    + "mdp VARCHAR(60) NOT NULL"
                    + "email_parent_2 VARCHAR(100) DEFAULT NULL,"
                    + "telephone_parent_2 VARCHAR(13) DEFAULT NULL,"
                    + "nom_parent_2 VARCHAR(25) DEFAULT NULL,"
                    + "prenom_parent_2 VARCHAR(25) DEFAULT NULL)";

            String createSouscriptionAssuranceTable = "CREATE TBALE SouscriptionAssurance("
                    + "numero_souscription INT AUTO_INCREMENT PRIMARY KEY,"
                    + "type VARCHAR(25) NOT NULL)";

            String createEnfantTable = "CREATE TABLE Enfant("
                    + "numero_adhesion INT PRIMARY KEY FOREIGN KEY REFERENCES Parent(numero_adhesion),"
                    + "nom VARCHAR(25) NOT NULL,"
                    + "prenom VARCHAR(25) NOT NULL PRIMARY KEY,"
                    + "numero_souscription DEFAULT NULL FOREIGN KEY REFERENCES SouscriptionAssurance (numero_souscription))";
            
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(createParentTable);
            stmt.executeUpdate(createSouscriptionAssuranceTable);
            stmt.executeUpdate(createEnfantTable);
            
            PrintWriter out = response.getWriter();
            out.println("<h1> Hello </h1>");
            conn.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
                
                /*private String email;
    private String nom;
    private String prenom;
    private String telephone;
    private String mdp;
   
    private String emailParent2;
    private String telephoneParent2;
    private String nomParent2;
    private String prenomParent2;*/
        
        //System.out.println(parent);
    }
   
}
