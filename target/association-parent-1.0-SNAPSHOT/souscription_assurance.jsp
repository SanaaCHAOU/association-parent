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
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Jekyll v3.8.6">
        <title>Souscription</title>
        <link rel="canonical" href="https://getbootstrap.com/docs/4.4/examples/checkout/">

        <!-- Bootstrap core CSS -->
        <link href="https://getbootstrap.com/docs/4.4/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">


        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                -ms-user-select: none;
                user-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }
        </style>
        <!-- Custom styles for this template -->
        <link href="https://getbootstrap.com/docs/4.4/examples/checkout/form-validation.css" rel="stylesheet">
 
    </head>
    
    <body class="bg-light">
        <div class="container">
            <jsp:useBean id="user" type="Parent" scope="session" />
            <div class="py-5 text-center">
                <h2>Veuillez remplir le formulaire:</h2>
            </div>
            <div class="col-md-8 order-md-1">
                <h4 class="mb-3">Informations du tuteur</h4>
                <form class="needs-validation" action="/association-parent/souscription" method="POST" novalidate>
                    <div  id="form-inscr">
                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label for="firstName">Nom tuteur <span class="text-muted">(Obligatoire)</span></label>
                                <input type="text" name="nom_parent_1" class="form-control" id="firstName" placeholder="" value="<%=user.getNom()%>" required>
                                <div class="invalid-feedback">
                                    Valid first name is required.
                                </div>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="lastName">Prénom tuteur <span class="text-muted">(Obligatoire)</span></label>
                                <input type="text" name="prenom_parent_1" class="form-control" id="lastName" placeholder="" value="<%=user.getPrenom()%>" required>
                                <div class="invalid-feedback">
                                    Valid last name is required.
                                </div>
                            </div>
                        </div>

                        <div class="mb-3">
                            <label for="telephone">Téléphone <span class="text-muted">(Obligatoire)</span></label>
                            <input type="text" name="telephone_parent_1" value="<%=user.getTelephone()%>" class="form-control" id="phone" required>
                            <div class="invalid-feedback">
                                Please enter a valid phone number.
                            </div>
                        </div>

                        <div class="mb-3">
                            <label for="email">Email <span class="text-muted">(Obligatoire)</span></label>
                            <input type="email" name="email_parent_1" class="form-control" id="email" placeholder="nom.prenom@example.com" value="<%=user.getEmail()%>"  required>
                            <div class="invalid-feedback">
                                Please enter a valid email address.
                            </div>
                        </div>

                        <table>
                            <h5>Enfant 1</h5>
                            <label for="nom">Nom</label>
                            <input type="text" class="form-control" name="nom_enfant_1" id="nom" value="" />
                            <label for="prenom">Prénom</label>
                            <input type="text" class="form-control" name="prenom_enfant_1" id="prenom" value="" />
                            <label for="niveau">Niveau</label>         
                            <select  name="niveau_enfant_1"  class="custom-select d-block w-100" id="niveau">
                                <option value="PRIMAIRE">Primaire</option>
                                <option value="COLLEGE">collège</option>
                                <option value="LYCEE">Lycée</option>
                            </select>

                            <div class="d-block my-3">
                                <div class="custom-control custom-radio">
                                    <input type="radio" name="assurance_enfant_1"  value="LMDE" id="lmde_enfant_1" class="custom-control-input"/>
                                    <label class="custom-control-label" for="lmde_enfant_1">LMDE</label>
                                </div>
                                <div class="custom-control custom-radio">
                                    <input type="radio" name="assurance_enfant_1"  value="VITAVI" id="vitavi_enfant_1" class="custom-control-input">
                                    <label class="custom-control-label" for="vitavi_enfant_1">VITAVI</label>
                                </div>
                            </div>
                        </table>

                      
                    </div>
                           <hr class="mb-4">
                        <div class="d-block my-3">
                            <div class="custom-control custom-checkbox">     
                                <input class="custom-control-input"  type="checkbox" name="accepter_conditions" id="accepter_conditions" required/>
                                <label class="custom-control-label" for="accepter_conditions">J’ai lu et accepte les garanties du contrat d’assurance</label>
                            </div>
                            <div class="custom-control custom-checkbox">
                                <input class="custom-control-input" type="checkbox" name="recevoir_informations" id="recevoir_informations"/>
                                <label class="custom-control-label" for="recevoir_informations">Je souhaite recevoir les informations concernant l’association</label>
                            </div>
                            <div class="custom-control custom-checkbox">
                                <input class="custom-control-input" type="checkbox" name="etre_parent_delegue" id="etre_parent_delegue" />
                                <label class="custom-control-label" for="etre_parent_delegue">Je souhaite être parents délégués au conseil d’école</label>
                            </div>
                        </div>
                    <div>
                        <button class="btn btn-primary btn-lg" onclick="ajouterEnfant(event)">Ajouter Enfant</button>
                        <input type="number" hidden="true" name="nombre_enfant" value="1" id="nb-enfant"/>
                        <input class="btn btn-primary btn-lg" type="submit" value="Envoyer" id="submit"/>
                    </div>
                </form>

        </div>
        
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
                niveauOptionPrimaire.value = "PRIMAIRE"
                let niveauOptionCollege = document.createElement('option');
                niveauOptionCollege.innerText = "Collège";
                niveauOptionCollege.value = "COLLEGE";
                let niveauOptionLycee = document.createElement('option');
                niveauOptionLycee.innerText = "Lycée"
                niveauOptionLycee.value = "LYCEE";
                niveauSelect.name = "niveau_enfant_" + nombreEnfant;
                niveauSelect.type = "text";
                
                let assuranceDiv = document.createElement('div');
                assuranceDiv.innerHTML = `
                    <label for="lmde_enfant_`+ nombreEnfant +`">LMDE</label>
                    <input type="radio" name="assurance_enfant_` + nombreEnfant +`" value="LMDE" id="lmde_enfant_`+ nombreEnfant +`"/>
                    <label for="vitavi_enfant_`+ nombreEnfant +`">Vitavi</label>
                    <input type="radio" name="assurance_enfant_`+ nombreEnfant +`" value="VITAVI" id="vitavi_enfant_`+ nombreEnfant +`"/>
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
        
        <footer class="my-5 pt-5 text-muted text-center text-small">
                <p class="mb-1">&copy; 2019-2020 </p>
        </footer>
        
     </div>
        
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script>window.jQuery || document.write('<script src="/docs/4.4/assets/js/vendor/jquery.slim.min.js"><\/script>')</script><script src="https://getbootstrap.com/docs/4.4/dist/js/bootstrap.bundle.min.js" integrity="sha384-6khuMg9gaYr5AxOqhkVIODVIvm9ynTT5J4V1cfthmT+emCG6yVmEZsRHdxlotUnm" crossorigin="anonymous"></script>
        <script src="https://getbootstrap.com/docs/4.4/examples/checkout/form-validation.js"></script>
    </body>
</html>



