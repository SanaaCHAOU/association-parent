/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.dao;

import business.Adhesion;
import business.Parent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moham
 */
// Data Access Object of parent table
public class ParentDAO {
    private Connection conn;
    
    public ParentDAO(Connection conn){
        this.conn = conn;
    }
    
    public void insert(Parent parent) throws SQLException {
        String insert = "INSERT INTO Parent "
                + "(nom, prenom, email, mdp, telephone, nom_parent_2, prenom_parent_2, email_parent_2, telephone_parent_2)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(insert);
        stmt.setString(1, parent.getNom());
        stmt.setString(2, parent.getPrenom());
        stmt.setString(3, parent.getEmail());
        stmt.setString(4, parent.getMdp());
        stmt.setString(5, parent.getTelephone());
        stmt.setString(6, parent.getNomParent2());
        stmt.setString(7, parent.getPrenomParent2());
        stmt.setString(8, parent.getEmailParent2());
        stmt.setString(9, parent.getTelephoneParent2());
        
        stmt.execute();
    }
    
    public Parent login(String email, String mdp) {
        String select = "SELECT * FROM Parent WHERE email=? AND mdp=?";
        try {
            PreparedStatement pStmt = conn.prepareStatement(select);
            pStmt.setString(1, email);
            pStmt.setString(2, mdp);
            ResultSet rs = pStmt.executeQuery();
            if(rs.next()) {
                Parent parent = new Parent();
                parent.setNumeroAdhesion(rs.getInt("numero_adhesion"));
                parent.setNom(rs.getString("nom"));
                parent.setPrenom(rs.getString("prenom"));
                parent.setEmail(rs.getString("email"));
                parent.setTelephone(rs.getString("telephone"));
                parent.setNomParent2("nom_parent_2");
                parent.setPrenomParent2("prenom_parent_2");
                parent.setEmailParent2("email_parent_2");
                parent.setTelephoneParent2("telephone_parent_2");
                return parent;
            }
            
            return null;
        } catch (SQLException ex) {
            return null;
//            Logger.getLogger(ParentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
