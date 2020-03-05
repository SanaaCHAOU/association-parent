<%-- 
    Document   : inscription
    Created on : 23 févr. 2020, 13:51:35
    Author     : moham
--%>

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
        <title>Inscription</title>
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
<!--    <body>
        <form method="POST" action="/association-parent/inscription">
            <table>
                <tr>
                    <td>Nom <span style="color: red">*</span>:</td>
                    <td><input type="text" name="nom" value="" required/></td>
                </tr>
                <tr>
                    <td>Prénom <span style="color: red">*</span>:</td>
                    <td><input type="text" name="prenom" value="" required/></td>
                </tr>
                <tr>
                    <td>Téléphone <span style="color: red">*</span>:</td>
                    <td><input type="text" name="telephone" value="" required/></td>
                </tr>
                <tr>
                    <td>Email <span style="color: red">*</span>:</td>
                    <td><input type="text" name="email" value="" required/></td>
                </tr>
                <tr>
                    <td>Mot de passe <span style="color: red">*</span>:</td>
                    <td><input type="password" name="mdp" value="" required/></td>
                </tr>
                <tr>
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
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Envoyer" style="float: right"/></td>
                </tr>
            </table>
        </form>
    </body>-->
    
    <body class="bg-light">
        <div class="container">
            <div class="py-5 text-center">
                <h2>Créer un compte SVP :</h2>
            </div>

            <div class="col-md-8 order-md-1">
                <h4 class="mb-3">Informations du tuteur</h4>
                <form class="needs-validation" method="POST" action="/association-parent/inscription" novalidate>
                    <div  id="form-inscr">
                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label for="firstName">Nom tuteur <span class="text-muted">(Obligatoire)</span></label>
                                <input type="text" name="nom" class="form-control" id="firstName" placeholder="" value="" required>
                                <div class="invalid-feedback">
                                    Valid first name is required.
                                </div>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="lastName">Prénom tuteur <span class="text-muted">(Obligatoire)</span></label>
                                <input type="text" name="prenom" class="form-control" id="lastName" placeholder="" value="" required>
                                <div class="invalid-feedback">
                                    Valid last name is required.
                                </div>
                            </div>
                        </div>

                        <div class="mb-3">
                            <label for="telephone">Téléphone <span class="text-muted">(Obligatoire)</span></label>
                            <input type="text" name="telephone"  class="form-control" id="phone" required>
                            <div class="invalid-feedback">
                                Please enter a valid phone number.
                            </div>
                        </div>

                        <div class="mb-3">
                            <label for="email">Email <span class="text-muted">(Obligatoire)</span></label>
                            <input type="email" name="email" class="form-control" id="email" placeholder="you@example.com" required>
                            <div class="invalid-feedback">
                                Please enter a valid email address.
                            </div>
                        </div>
                        
                        <div class="mb-3">
                            <label for="pwd">Password <span class="text-muted">(Obligatoire)</span></label>
                            <input type="password" name="mdp" class="form-control" id="pwd" required>
                            <div class="invalid-feedback">
                                Please enter a valid password.
                            </div>
                        </div>

                        <h4 class="mb-3">Informations d'autre parent</h4>
                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label for="firstName">Nom tuteur <span class="text-muted">(Facultatif)</span></label>
                                <input type="text" name="nom_parent_2" class="form-control" id="firstName" placeholder="" value="" />
                                <div class="invalid-feedback">
                                    Valid first name is required.
                                </div>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="lastName">Prénom tuteur <span class="text-muted">(Facultatif)</span></label>
                                <input type="text" name="prenom_parent_2" class="form-control" id="lastName" placeholder="" value="" />
                                <div class="invalid-feedback">
                                    Valid last name is required.
                                </div>
                            </div>
                        </div>

                        <div class="mb-3">
                            <label for="telephone">Téléphone <span class="text-muted">(Facultatif)</span></label>
                            <input type="text" name="telephone_parent_2" class="form-control" id="phone">
                            <div class="invalid-feedback">
                                Please enter a valid phone number.
                            </div>
                        </div>

                        <div class="mb-3">
                            <label for="email">Email <span class="text-muted">(Facultatif)</span></label>
                            <input type="email" name="email_parent_2" class="form-control" id="email" placeholder="you@example.com">
                            <div class="invalid-feedback">
                                Please enter a valid email address.
                            </div>
                        </div>
                    </div>
                    <input class="btn btn-primary btn-lg" type="submit" value="Envoyer" id="submit"/>
                </form>
            </div>
            <footer class="my-5 pt-5 text-muted text-center text-small">
                <p class="mb-1">&copy; 2019-2020</p>
            </footer>
        </div>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script>window.jQuery || document.write('<script src="/docs/4.4/assets/js/vendor/jquery.slim.min.js"><\/script>')</script><script src="https://getbootstrap.com/docs/4.4/dist/js/bootstrap.bundle.min.js" integrity="sha384-6khuMg9gaYr5AxOqhkVIODVIvm9ynTT5J4V1cfthmT+emCG6yVmEZsRHdxlotUnm" crossorigin="anonymous"></script>
        <script src="https://getbootstrap.com/docs/4.4/examples/checkout/form-validation.js"></script>
    </body>
</html>
