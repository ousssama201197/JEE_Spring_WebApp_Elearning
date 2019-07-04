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
            <form class="form-signin" action="<c:url value="/mdpoublier/restauration" />" method="GET">
                <div class="form-signin-heading text-center">
                    <h1 class="sign-title">Nouveau Compte</h1>
                    <img src="<c:url value="/resources/images/eLearning.png" />" >       
                </div>
                   ${message}
                <div class="login-wrap">                   
               
                    <input type="email" class="form-control" name="email" placeholder="email" autofocus required="true">

                    <button class="btn btn-lg btn-login btn-block" type="submit">
                        <i class="fa fa-check"></i>
                    </button>
                </div>
            </form>

        </div>
    </body>
</html>
