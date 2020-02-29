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
public class Adhesion {
    private int numeroAdhesion;
    private String email_parent_1;
    private String email_parent_2;
    

    public Adhesion() {
    }

    public Adhesion(int numeroAdhesion, String email_parent_1, String email_parent_2) {
        this.numeroAdhesion = numeroAdhesion;
        this.email_parent_1 = email_parent_1;
        this.email_parent_2 = email_parent_2;
    }

    public Adhesion(int numeroAdhesion, String email_parent_1) {
        this.numeroAdhesion = numeroAdhesion;
        this.email_parent_1 = email_parent_1;
        this.email_parent_2 = null;
    }

    public int getNumeroAdhesion() {
        return numeroAdhesion;
    }

    public void setNumeroAdhesion(int numeroAdhesion) {
        this.numeroAdhesion = numeroAdhesion;
    }

    public String getEmail_parent_1() {
        return email_parent_1;
    }

    public void setEmail_parent_1(String email_parent_1) {
        this.email_parent_1 = email_parent_1;
    }

    public String getEmail_parent_2() {
        return email_parent_2;
    }

    public void setEmail_parent_2(String email_parent_2) {
        this.email_parent_2 = email_parent_2;
    }
    
    
}
