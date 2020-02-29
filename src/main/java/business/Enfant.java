/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author moham
 */
public class Enfant {
    private int numeroAdhesion;
    private String nom;
    private String prenom;
    private int numeroSouscription;
    private String typeAssurance;

    public Enfant() {
    }

    public Enfant(int numeroAdhesion, String nom, String prenom, int numeroSouscription, String typeAssurance) {
        this.numeroAdhesion = numeroAdhesion;
        this.nom = nom;
        this.prenom = prenom;
        this.numeroSouscription = numeroSouscription;
        this.typeAssurance = typeAssurance;
    }
    
}
