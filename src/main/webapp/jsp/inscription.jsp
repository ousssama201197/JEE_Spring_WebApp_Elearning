<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" >
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="ThemeBucket">
        <link rel="shortcut icon" href="#" type="image/png">
        <title>Login</title>
        <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" />
        <link href="<c:url value="/resources/css/style-responsive.css" />" rel="stylesheet" />
        <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet" />

    </head>

    <body class="login-body">

        <div class="container">
            <form class="form-signin" action="<c:url value="/saveuser" />" method="POST">


                <div class="form-signin-heading text-center">
                    <h1 class="sign-title">Inscription</h1>
                    <img src="<c:url value="/resources/images/eLearning.png" />" >       
                </div>
                ${erreur}
                <div class="login-wrap">
                    <div class="form-group"> 
                        <label>Etudiant  :</label>
                        <input type="radio" name="type" value="etudiant" >
                    </div>

                    <div class="form-group"> 
                        <label>Enseignant  :</label>
                        <input type="radio" name="type" value="ens" >
                    </div>


                    <div class="form-group"> 
                        <label>&nbsp;nom d'utilisateur  :</label>
                        <input type="text" class="form-control" name="username" placeholder="nom d'utilisateur " autofocus required="true">
                    </div>
                    <div class="form-group"> 
                        <label>&nbsp;Nom :</label>
                        <input type="text" class="form-control" name="nom" placeholder="nom"  required="true">
                    </div>
                    <div class="form-group"> 
                        <label>&nbsp;Prénom :</label>
                        <input type="text" class="form-control" name="prenom" placeholder="prénom" required="true">
                    </div>
                    <div class="form-group"> 
                        <label >&nbsp;Email :</label>
                        <input type="text" class="form-control" name="email" placeholder="exemple@mail.com" required="true">
                    </div>
                    <div class="form-group"> 
                        <label >&nbsp;mot de passe :</label>
                        <input type="password" class="form-control" name="password" placeholder="mot de passe" required="true">
                    </div>
                    <div class="form-group ${erreur2}"> 
                        <label >&nbsp;confirmation du mot de passe :</label>
                        <input type="password" class="form-control"  name="cpassword" placeholder="confirmer mot de passe" required="true">
                    </div>
                    <div class="form-group"> 
                        <label>&nbsp;Adresse :</label>
                        <input type="text" class="form-control" name="adresse" placeholder="Adresse" required="true">
                    </div>

                        


                    <input class="btn btn-block btn-primary" type="submit" value="valider">


                    <div class="registration">
                        vous avez déja un compte ?
                        <a class="" href="<c:url value="/login" />">
                            login
                        </a>
                    </div>


                </div>

                <!-- modal -->

            </form>

        </div>
        </script>

    </body>
</html>
