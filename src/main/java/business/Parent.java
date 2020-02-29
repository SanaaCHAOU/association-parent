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
public class Parent {
    private int numeroAdhesion;
    
    private String email;
    private String nom;
    private String prenom;
    private String telephone;
    private String mdp;
   
    private String emailParent2;
    private String telephoneParent2;
    private String nomParent2;
    private String prenomParent2;
   

    public Parent() {
    }

    public int getNumeroAdhesion() {
        return numeroAdhesion;
    }

    public void setNumeroAdhesion(int numeroAdhesion) {
        this.numeroAdhesion = numeroAdhesion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getEmailParent2() {
        return emailParent2;
    }

    public void setEmailParent2(String emailParent2) {
        this.emailParent2 = emailParent2;
    }

    public String getTelephoneParent2() {
        return telephoneParent2;
    }

    public void setTelephoneParent2(String telephoneParent2) {
        this.telephoneParent2 = telephoneParent2;
    }

    public String getNomParent2() {
        return nomParent2;
    }

    public void setNomParent2(String nomParent2) {
        this.nomParent2 = nomParent2;
    }

    public String getPrenomParent2() {
        return prenomParent2;
    }

    public void setPrenomParent2(String prenomParent2) {
        this.prenomParent2 = prenomParent2;
    }

    @Override
    public String toString() {
        return "Parent{" + "numeroAdhesion=" + numeroAdhesion + ", email=" + email + ", nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone + ", mdp=" + mdp + ", emailParent2=" + emailParent2 + ", telephoneParent2=" + telephoneParent2 + ", nomParent2=" + nomParent2 + ", prenomParent2=" + prenomParent2 + '}';
    }

}
