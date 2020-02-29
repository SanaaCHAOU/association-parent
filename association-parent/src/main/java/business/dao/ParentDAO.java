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
import java.sql.SQLException;

/**
 *
 * @author moham
 */
public class ParentDAO {
    private Connection conn;
    
    public ParentDAO(Connection conn){
        this.conn = conn;
    }
    
    public void insert(Adhesion adhesion,Parent parent) throws SQLException {
        String insert = "INSERT INTO Parent "
                + "(nom, prenom, email, mdp, telephone, nom_parent_2, prenom_parent_2, email_parent_2, telephone_parent_2)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(insert);
        stmt.setString(0, parent.getNom());
        stmt.setString(1, parent.getPrenom());
        stmt.setString(2, parent.getEmail());
        stmt.setString(3, parent.getMdp());
        stmt.setString(4, parent.getTelephone());
        stmt.setString(5, parent.getNomParent2());
        stmt.setString(6, parent.getPrenomParent2());
        stmt.setString(7, parent.getEmailParent2());
        stmt.setString(8, parent.getTelephoneParent2());
        
        stmt.execute();
    }
}
