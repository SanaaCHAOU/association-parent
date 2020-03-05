/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.dao;

import business.Enfant;
import business.Parent;
import business.Souscription;
import controllers.DataSources;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author moham
 */

// demander la création d'une singleton (càd un seul objet dans toute l'app) de cette classe
@Singleton

// l'instance va être créé au démarrage de l'application
@Startup

// La création de cette instance depend de la création de l'instance de type DataSources (on l'a besoin pour l'injecter)
@DependsOn("DataSources")
public class EnfantDAO {
    
    private DataSources ds;
    
    public EnfantDAO() {
        
    }
    
    public DataSources getDS() {
        return ds;
    }
    
    // On peut inject un objet en utilisant le setter à la place de le faire dans la propriété directement
    // l'objet injecté va être passé en paramètre de la methode setDS
    @Inject //injecter l'instance de type DataSources créer automatquement par le conteneur (par annotation @xyz)
    public void setDS(DataSources ds) {
        this.ds = ds;
    }
    
    public void insert(Enfant enfant) throws SQLException {
        Connection conn = ds.getDataSource().getConnection();
        
        // Insert souscription
        System.out.println("Inserting souscription " + enfant.getSouscription());
        Souscription s = insertSouscription(enfant.getSouscription(), conn);
        System.out.println("Souscription Inserted " + s);
        
        enfant.setSouscription(s);
        
        String insert = "INSERT INTO Enfant "
                + "(numero_adhesion, nom, prenom, niveau, numero_souscription) "
                + "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(insert);
        stmt.setInt(1, enfant.getNumeroAdhesion());
        stmt.setString(2, enfant.getNom());
        stmt.setString(3, enfant.getPrenom());
        stmt.setString(4, enfant.getNiveau());
        stmt.setInt(5, enfant.getSouscription().getNumeroSouscription());

        
        stmt.execute();
    }
    
    public List<Enfant> selectAll() throws SQLException {
        Connection conn = ds.getDataSource().getConnection();
        List<Enfant> enfants = new ArrayList<>();
        
        String select = "SELECT e.numero_adhesion, e.prenom, e.nom, e.niveau, s.type_souscription, s.numero_souscription "
                + "FROM Enfant e, SouscriptionAssurance s "
                + "WHERE e.numero_souscription = s.numero_souscription";
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(select);
        
        while(rs.next()) {
            Souscription s = new Souscription();
            s.setNumeroSouscription(rs.getInt(6));
            s.setTypeSouscription(rs.getString(5));
            
            Enfant e = new Enfant();
            
            e.setSouscription(s);
            e.setNumeroAdhesion(rs.getInt(1));
            e.setPrenom(rs.getString(2));
            e.setNom(rs.getString(3));
            e.setNiveau(rs.getString(4));
            
            enfants.add(e);
        }
        
        stmt.close();
        conn.close();
        
        return enfants;
    }
    
    private Souscription insertSouscription(Souscription s, Connection conn) throws SQLException {
        String insert = "INSERT INTO SOUSCRIPTIONASSURANCE (type_souscription) VALUES ('" + s.getTypeSouscription() + "')";
        PreparedStatement stmt = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if(rs.next()) {
            System.out.println("Souscription Inserted");
            System.out.println("Inserted Key : " + rs.getInt(1));
        } else {
            System.out.println("No Souscription was inserted");
        }
        
        
        s.setNumeroSouscription(stmt.getGeneratedKeys().getInt(1));
        stmt.close();
        return s;
    }
    
}
