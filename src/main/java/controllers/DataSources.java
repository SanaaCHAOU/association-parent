/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.annotation.Resource;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.sql.DataSource;


@DataSourceDefinition(
        name = "java:app/env/jdbc/sanaa",
        className = "org.apache.derby.jdbc.ClientDataSource",
        //className = "org.apache.derby.jdbc.EmbeddedDriver",   
        portNumber = 1527,   
        serverName = "localhost",   
        databaseName = "association",
        user = "sanaa",
        password = "sanaa",
        url="jdbc:derby://localhost:1527/association") // => DataSource : un objet qui créer plusieurs
         //connexion à la base de données spécifiée et permet la réutilisation de ces connexion

@Startup // On demande au conteneur (serveur) de créer une instance au démarrage (startup) de l'application de
        // cette classe (DataSouces)
@Singleton // Singelton c'est une classe dont on utilise qu'une seule instance dan,s tte l'app
@ApplicationScoped  // Une instance accessible dans toutes l'application
    // d'autre scope sont possible ex. SessionScoped (un objet par session d'utilisateur),
    // RequestScoped (Un objet créer par requete GET OR POST OR ...)

public class DataSources {
    
    // inversion of control (IOC) => on demande au conteneur (serveur) de chercher la resource (l'objet) qui a le 
        // nom 'java:app/env/jdbc/sanaa' et l'affecter à la propriete derby
    @Resource(lookup = "java:app/env/jdbc/sanaa")
    DataSource derby;
    
    // getter de derby
    public DataSource getDataSource() {
        return derby;
    }
}
