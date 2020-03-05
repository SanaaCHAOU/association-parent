/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author moham
 */
@Singleton
@Startup
@ApplicationScoped
public class CalculatriceSouscription {
    
    // un prix pour chaque niveau de LMDE et de VITAVI 
    // (LYCEE, COLLEGE, PRIMAIRE),(LMDE, VITAVI)
    
    // Map (type d'assurence, Map(niveau, prix))
    private static final Map<String, Map<String, Double>> prix = dictionnairePrixAssurance();
    
    private static Map<String, Map<String, Double>> dictionnairePrixAssurance() {
        Map<String, Map<String, Double>> m = new HashMap();
        
        // creation des valeurs des prix selon le niveau et le type d'assurance choisi
        Map<String, Double> lmde = new HashMap<>();
        lmde.put("PRIMAIRE", 1000.0);
        lmde.put("COLLEGE", 1530.0);
        lmde.put("LYCEE", 2420.0);
        
        Map<String, Double> vitavi = new HashMap<>();
        vitavi.put("PRIMAIRE", 1150.0);
        vitavi.put("COLLEGE", 1480.0);
        vitavi.put("LYCEE", 2300.0);
        
        m.put("LMDE", lmde);
        m.put("VITAVI", vitavi);
        
        return m;
    }
    
    public double getPrix(Enfant enfant) {
        String niveau = enfant.getNiveau();
        String typeAssurance = enfant.getSouscription().getTypeSouscription();
        System.out.println("TYPE ASSURANCE =============> " + typeAssurance);
        System.out.println("NIVEAU =============> " + niveau);
        return prix.get(typeAssurance).get(niveau);
    }
    
    public double getPrixTotal(List<Enfant> enfants) {
        double total = 0;
        
        for (Enfant enfant: enfants) {
            total += getPrix(enfant);
            // règles métier exemple : réduction dans la deuxème souscription chez la meme assurance ?? 
        }
        
        return total;
    }
}
