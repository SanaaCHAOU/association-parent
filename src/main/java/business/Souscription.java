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
public class Souscription implements Serializable{
    private static final String TYPE_VITAVI = "VITAVI";
    private static final String TYPE_LMDE = "LMDE";
    
    private Integer numeroSouscription;
    private String typeSouscription;

    public Souscription() {
    }

    public Souscription(Integer numeroSouscription, String typeSouscription) {
        this.numeroSouscription = numeroSouscription;
        this.typeSouscription = typeSouscription;
    }

    public Integer getNumeroSouscription() {
        return numeroSouscription;
    }

    public void setNumeroSouscription(Integer numeroSouscription) {
        this.numeroSouscription = numeroSouscription;
    }

    public String getTypeSouscription() {
        return typeSouscription;
    }

    public void setTypeSouscription(String typeSouscription) {
        this.typeSouscription = typeSouscription;
    }

    @Override
    public String toString() {
        return "Souscription{" + "numeroSouscription=" + numeroSouscription + ", typeSouscription=" + typeSouscription + '}';
    }
    
    
}
