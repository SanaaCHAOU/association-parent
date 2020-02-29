<%-- 
    Document   : index
    Created on : 22 févr. 2020, 10:10:07
    Author     : sanaa
--%>

<%@page import="business.Parent"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="width: 50%; margin: 0 auto;">
        <jsp:useBean id="user" type="Parent" scope="session" />
        <h1>Veuillez remplir le formulaire:</h1>
        <form action="/association-parent/souscription" method="POST">
            <div id="form-inscr">
                <table>
                    <tbody>
                        <tr>
                            <td colspan = "2"> <h4> Informations du tuteur </h4> </td>
                        </tr>
                        <tr>
                            <td>Nom tuteur <span style="color: red">*</span>:</td>
                            <td><input type="text" name="nom_parent_1" value="<%=user.getNom()%>" /></td>
                        </tr>
                        <tr>
                            <td>Prénom tuteur <span style="color: red">*</span>:</td>
                            <td><input type="text" name="prenom_parent_1" value="<%=user.getPrenom()%>" /></td>
                        </tr>
                        <tr>
                            <td>Email <span style="color: red">*</span>:</td>
                            <td><input type="text" name="email_parent_1" value="<%=user.getEmail()%>" /></td>
                        </tr>   
                        <tr>
                            <td>Téléphone <span style="color: red">*</span>:</td>
                            <td><input type="text" name="telephone_parent_1" value="<%=user.getTelephone()%>" /></td>
                        </tr>  
<!--                        <tr>
                            <td colspan = "2"> <h4> Informations du parent facultatif </h4> </td>
                        </tr>
                        <tr>
                            <td>Nom Parent</td>
                            <td><input type="text" name="nom_parent_2" value="" /></td>
                        </tr>
                        <tr>
                            <td>Prénom tuteur :</td>
                            <td><input type="text" name="prenom_parent_2" value="" /></td>
                        </tr>
                        <tr>
                            <td>Email :</td>
                            <td><input type="text" name="email_parent_2" value="" /></td>
                        </tr>   
                        <tr>
                            <td> Téléphone :</td>
                            <td><input type="text" name="telephone_parent_2" value="" /></td>
                        </tr>  -->
                    </tbody>
                </table>
                <table>
                    <h4>Enfant 1</h4>
                        <tr>
                            <td>Nom :</td>
                            <td><input type="text" name="nom_enfant_1" value="" /></td>
                        </tr>
                         <tr>
                            <td>Prénom :</td>
                            <td><input type="text" name="prenom_enfant_1" value="" /></td>
                        </tr>
                        <tr>
                            <td>Niveau :</td>
                            <td>           
                                <select name="niveau">
                                  <option value="primaire">Primaire</option>
                                  <option value="college">collège</option>
                                  <option value="lycee">Lycée</option>
                                </select>
                            </td>
                        </tr>
                </table>
                <div>
                    <label for="lmde_enfant_1">LMDE</label>
                    <input type="radio" name="assurance_enfant_1" id="lmde_enfant_1"/>
                    <label for="vitavi_enfant_1">Vitavi</label>
                    <input type="radio" name="assurance_enfant_1" id="vitavi_enfant_1"/>
                </div>
                <div>     
                    <input type="checkbox" name="accepter_conditions" id="accepter_conditions" required/>
                    <label for="accepter_conditions">J’ai lu et accepte les garanties du contrat d’assurance</label>
                </div>
                <div>
                    <input type="checkbox" name="recevoir_informations" id="recevoir_informations"/>
                    <label for="recevoir_informations">Je souhaite recevoir les informations concernant l’association</label>
                </div>
                <div>
                    <input type="checkbox" name="etre_parent_delegue" id="etre_parent_delegue" />
                    <label for="etre_parent_delegue">Je souhaite être parents délégués au conseil d’école</label>
                </div>
            </div>
            <button onclick="ajouterEnfant(event)">Ajouter Enfant</button>
            <input type="number" hidden="true" name="nombre_enfant" value="1" id="nb-enfant"/>
            
            <input type="submit" value="Envoyer" id="submit"/>
        </form>
        
        <script>
            var div = document.getElementById('form-inscr');
            var nombreEnfantInput = document.getElementById('nb-enfant');
            //console.log(nombreEnfantInput);
            var nombreEnfant = 1;
            
            function ajouterEnfant(event) {
                //pour que le click sur btn ne fait pas submit par defaut
                event.preventDefault();
                nombreEnfant ++;
                nombreEnfantInput.value = nombreEnfant;
                let table = document.createElement('table');
                
                let titre = document.createElement('h4');
                titre.innerText = "Enfant " + nombreEnfant;
                
                let nomTr = createTr(label="Nom :", type="text", name="nom_enfant_" + nombreEnfant);
                let prenomTr = createTr(label="Prénom :", type="text", name="prenom_enfant_" + nombreEnfant);
                let niveauTr = document.createElement('tr');
                
                let niveauLabelTd = document.createElement('td');
                niveauLabelTd.innerText = "Niveau :";
                let niveauInputTd = document.createElement('td');
                let niveauSelect = document.createElement('select');
                let niveauOptionPrimaire = document.createElement('option');
                niveauOptionPrimaire.innerText = "Primaire";
                niveauOptionPrimaire.value = "primaire"
                let niveauOptionCollege = document.createElement('option');
                niveauOptionCollege.innerText = "Collège";
                niveauOptionCollege.value = "college";
                let niveauOptionLycee = document.createElement('option');
                niveauOptionLycee.innerText = "Lycée"
                niveauOptionLycee.value = "lycee";
                niveauSelect.name = "niveau_enfant_" + nombreEnfant;
                niveauSelect.type = "text";
                
                let assuranceDiv = document.createElement('div');
                assuranceDiv.innerHTML = `
                    <label for="lmde_enfant_`+ nombreEnfant +`">LMDE</label>
                    <input type="radio" name="assurance_enfant_` + nombreEnfant +`" id="lmde_enfant_`+ nombreEnfant +`"/>
                    <label for="vitavi_enfant_`+ nombreEnfant +`">Vitavi</label>
                    <input type="radio" name="assurance_enfant_`+ nombreEnfant +`" id="vitavi_enfant_`+ nombreEnfant +`"/>
                `;
                
                niveauSelect.appendChild(niveauOptionPrimaire);
                niveauSelect.appendChild(niveauOptionCollege);
                niveauSelect.appendChild(niveauOptionLycee);
                
                niveauInputTd.appendChild(niveauSelect);
                niveauTr.appendChild(niveauLabelTd);
                niveauTr.appendChild(niveauInputTd);

                
                
                //(label="Niveau :", type="text", name="niveau_enfant_" + nombreEnfant);
                
                table.appendChild(titre);
                table.appendChild(nomTr);
                table.appendChild(prenomTr);
                table.appendChild(niveauTr);
                
                div.appendChild(table);
                div.appendChild(assuranceDiv);
            }
            
            function createTr(label, type, name){
                let tr = document.createElement('tr');
                // label
                let labelTd = document.createElement('td');
                labelTd.innerText = label;
                // Input
                let inputTd = document.createElement('td');
                let input = document.createElement('input');
                input.type = type;
                input.name = name;
                
                inputTd.appendChild(input);
                
                // ajouter les tds au tr
                tr.appendChild(labelTd);
                tr.appendChild(inputTd);
                
                return tr;
            }
        </script>
    </body>
</html>



