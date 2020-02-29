/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import business.Parent;
import business.dao.ParentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.annotation.sql.DataSourceDefinition;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.apache.derby.jdbc.ClientDriver;

@WebServlet("/inscription")
public class InscriptionAssociationServlet extends HttpServlet {
    @Inject
    DataSources ds;
    
    @Inject
    ParentDAO parentDAO;
    
    
//    @Resource(lookup = "java:app/env/jdbc/sanaa")
//    DataSource data;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
        request.getRequestDispatcher("inscription_association.jsp").forward(request, response);
    }
 
    
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
//        DataSource data = ds.getDataSource();
        
        Connection conn = null;
        try {
            
            DataSource data = ds.getDataSource();
            conn = data.getConnection();
//            ParentDAO parentDAO = new ParentDAO(conn);
            
            Parent parent = getParentFromRequest(request);
            
            parentDAO.insert(parent);
            
            // rediriger vers la page de connexion
            response.sendRedirect("login_form.jsp");

//            String createParentTable = "CREATE TABLE Parent ("
//                    + "numero_adhesion INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,"
//                    + "email VARCHAR(100) NOT NULL UNIQUE,"
//                    + "nom VARCHAR(25) NOT NULL,"
//                    + "prenom VARCHAR(25) NOT NULL,"
//                    + "telephone VARCHAR(13) NOT NULL,"
//                    + "mdp VARCHAR(60) NOT NULL,"
//                    + "email_parent_2 VARCHAR(100) DEFAULT NULL,"
//                    + "telephone_parent_2 VARCHAR(13) DEFAULT NULL,"
//                    + "nom_parent_2 VARCHAR(25) DEFAULT NULL,"
//                    + "prenom_parent_2 VARCHAR(25) DEFAULT NULL)";
//
//            String createSouscriptionAssuranceTable = "CREATE TABLE SouscriptionAssurance("
//                    + "numero_souscription INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,"
//                    + "type VARCHAR(25) NOT NULL)";
//
//            String createEnfantTable = "CREATE TABLE Enfant("
//                    + "numero_adhesion INT NOT NULL,"
//                    + "nom VARCHAR(25) NOT NULL,"
//                    + "prenom VARCHAR(25) NOT NULL,"
//                    + "numero_souscription INT DEFAULT NULL,"
//                    + "PRIMARY KEY (numero_adhesion, prenom),"
//                    + "FOREIGN KEY (numero_adhesion) REFERENCES Parent(numero_adhesion),"
//                    + "FOREIGN KEY (numero_souscription) REFERENCES SouscriptionAssurance (numero_souscription))";
//
//            Statement stmt = conn.createStatement();
//            stmt.executeUpdate(createParentTable);
//            stmt.executeUpdate(createSouscriptionAssuranceTable);
//            stmt.executeUpdate(createEnfantTable);
    
//            Statement stmt = conn.createStatement();
//
//            String select = "SELECt * from Parent";
//            
//            ResultSet rs = stmt.executeQuery(select);
//            
//            rs.next();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        //catch (ClassNotFoundException ex) {
         //   throw new RuntimeException(ex);
        //} 
        finally {
            // code executé tt le temps meme si une erreur ou exception survenu 
            // on peut l'utiliser par exemple pour fermer des fichier ouvert ou des connexion au base de données 
            // des connexion reseau ....
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
    
    private Parent getParentFromRequest(HttpServletRequest request) {
        Parent parent = new Parent();
        parent.setEmail(request.getParameter("email"));
        parent.setEmailParent2(request.getParameter("email_parent_2"));
        parent.setNom(request.getParameter("nom"));
        parent.setNomParent2(request.getParameter("nom_parent_2"));
        parent.setPrenom(request.getParameter("prenom"));
        parent.setPrenomParent2(request.getParameter("prenom_parent_2"));
        parent.setTelephone(request.getParameter("telephone"));
        parent.setTelephoneParent2(request.getParameter("telephone_parent_2"));
        parent.setMdp(request.getParameter("mdp"));
        
        return parent;
    }
   
}
