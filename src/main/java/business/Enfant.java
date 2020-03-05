/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.Serializable;

/**
 *
 * @author moham
 */
public class Enfant implements Serializable{
    
    private static final String LYCEE = "LYCEE";
    private static final String COLLEGE = "COLLEGE";
    private static final String PRIMAIRE = "PRIMAIRE";
    
    private int numeroAdhesion;
    private String nom;
    private String prenom;
    private String niveau; // LYCEE, COLLEGE, PRIMAIRE
    private Souscription souscription;

    public Enfant() {
    }

    public Enfant(int numeroAdhesion, String nom, String prenom, String niveau, Souscription souscription) {
        this.numeroAdhesion = numeroAdhesion;
        this.nom = nom;
        this.prenom = prenom;
        this.niveau = niveau;
        this.souscription = souscription;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    

    public int getNumeroAdhesion() {
        return numeroAdhesion;
    }

    public void setNumeroAdhesion(int numeroAdhesion) {
        this.numeroAdhesion = numeroAdhesion;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Souscription getSouscription() {
        return souscription;
    }

    public void setSouscription(Souscription souscription) {
        this.souscription = souscription;
    }

    
    
}
