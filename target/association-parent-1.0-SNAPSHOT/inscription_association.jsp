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
        <title>Inscription</title>
    </head>
    <body>
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
    </body>
</html>
