<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>




        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
        <meta name="keywords" content="admin, dashboard, bootstrap, template, flat, modern, theme, responsive, fluid, retina, backend, html5, css, css3">
        <meta name="description" content="">
        <meta name="author" content="ThemeBucket">
        <link rel="shortcut icon" href="#" type="image/png">

        <title>Enseigant</title> 
        <jsp:include page="CssImports.jsp" />



    </head>

    <body class="sticky-header">

        <section>
            <!-- left side start-->
            <div class="left-side sticky-left-side">

                <!--logo and iconic logo start-->
                <div class="logo" style="float: right;">
                    <a href="<c:url value="/" />" ><img src="<c:url value="/resources/images/eLearning70X70.png" />" alt=""></a>
                    <span style="color : white;">Elearning</span>
                </div>

                <div class="logo-icon text-center">
                    <a href="<c:url value="/" />" ><img src="<c:url value="/resources/images/eLearning70X70.png" />" alt="Elearning"></a>
                </div>

                </br>
                <!--logo and iconic logo end-->

                <div class="left-side-inner">

                    <!-- visible to small devices only -->
                    <div class="visible-xs hidden-sm hidden-md hidden-lg">
                        <div class="media logged-user">
                            <img alt="" src="images/photos/user-avatar.png" class="media-object">
                            <div class="media-body">
                                <h4><a href="#">user    </a></h4>
                                <span>"Hello There..."</span>
                            </div>
                        </div>

                        <h5 class="left-nav-title">Account Information</h5>
                        <ul class="nav nav-pills nav-stacked custom-nav">
                            <li><a href="#"><i class="fa fa-bell-o"></i> <span>Profile</span></a></li>
                            <li><a href="#"><i class="fa fa-cog"></i> <span>Settings</span></a></li>
                            <li><a href="#"><i class="fa fa-sign-out"></i> <span>Sign Out</span></a></li>
                        </ul>
                    </div>

                    <!--sidebar nav start-->
                    <ul class="nav nav-pills nav-stacked custom-nav">
                        <li class="menu-list"><a href="<c:url value="/" />"><i class="fa fa-home"></i> <span>Home</span></a></li>
                        <li class="menu-list"><a href="<c:url value="/nouveau_cours" />"><i class="fa fa-file"></i> <span>Nouveau Cours</span></a>
                        <li class="menu-list"><a href="<c:url value="/ajouter_document" />"><i class="fa fa-file-text"></i> <span>Nouveau Document</span></a></li>
                        <li class="menu-list"><a href="<c:url value="/ajouter_examen" />"><i class="fa fa-pencil"></i> <span>Nouveau Examen</span></a></li>
                    </ul>
                    <!--sidebar nav end-->

                </div>
            </div>
            <!-- left side end-->

            <!-- main content start-->
            <div class="main-content" >

                <!-- header section start-->
                <div class="header-section">

                    <!--notification menu start -->
                    <div class="menu-right">
                        <ul class="notification-menu">

                            <li>
                                <a href="#" class="btn btn-default dropdown-toggle info-number" data-toggle="dropdown">
                                    <i class="fa fa-bell-o"></i>
                                    <span class="badge">4</span>
                                </a>
                                <div class="dropdown-menu dropdown-menu-head pull-right">
                                    <h5 class="title">Notifications</h5>
                                    <ul class="dropdown-list normal-list">


                                        <li class="new">
                                            <a href="">
                                                <span class="label label-danger"><i class="fa fa-bolt"></i></span>
                                                <span class="name">Server #1 overloaded.  </span>
                                                <em class="small">34 mins</em>
                                            </a>
                                        </li>


                                    </ul>
                                </div>
                            </li>
                            <li>
                                <a href="#" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                    <img src="images/photos/user-avatar.png" alt="" />
                                    ${username}
                                    <span class="caret"></span>
                                </a>
                                <ul class="dropdown-menu dropdown-menu-usermenu pull-right">

                                    <li><a href="<c:url value="/logout" />"><i class="fa fa-sign-out"></i> Log Out</a></li>
                                </ul>
                            </li>

                        </ul>
                    </div>
                    <!--notification menu end -->

                </div>