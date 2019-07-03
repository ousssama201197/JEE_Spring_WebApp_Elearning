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
            <form class="form-signin" action="http://localhost:8080/learning2/login" method="GET">

                <div class="form-signin-heading text-center">
                    <h1 class="sign-title">Authentification</h1>
                    <img src="<c:url value="/resources/images/eLearning.png" />" >
                </div>
                <div class="login-wrap">
                    ${erreur}
           
                <div class="form-group">
                    
                    <select class="form-control" name="type">
                        <option>...........</option>
                        <option value="etudiant">Etudiant</option>
                        <option value="ens">Enseignant</option>
                    </select>
                </div>
                <input type="text" class="form-control" name="username" placeholder="User ID" autofocus>
                <input type="password" class="form-control" name="password" placeholder="Password">

                <button class="btn btn-lg btn-login btn-block" type="submit">
                    <i class="fa fa-check"></i>
                </button>

                <div class="registration">
                    Not a member yet?
                    <a class="" href="registration.html">
                        Signup
                    </a>
                </div>
                <label class="checkbox">
                    <input type="checkbox" value="remember-me"> Remember me
                    <span class="pull-right">
                        <a data-toggle="modal" href="#myModal"> Forgot Password?</a>

                    </span>
                </label>

        </div>

        <!-- Modal -->
        <!--                <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                        <h4 class="modal-title">Forgot Password ?</h4>
                                    </div>
                                    <div class="modal-body">
                                        <p>Enter your e-mail address below to reset your password.</p>
                                        <input type="text" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">
        
                                    </div>
                                    <div class="modal-footer">
                                        <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
                                        <button class="btn btn-primary" type="button">Submit</button>
                                    </div>
                                </div>
                            </div>
                        </div>-->
        <!-- modal -->

    </form>

</div>
</body>
</html>
