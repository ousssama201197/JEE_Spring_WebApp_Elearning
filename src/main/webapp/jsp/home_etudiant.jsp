<%@page import="com.elearning.entities.EtudiantCours_"%>
<%@page import="java.util.Random"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="HeaderEnt.jsp" /> 
<!-- header section end-->

<!-- page heading start-->
<div class="page-heading">

</div>
<!-- page heading end-->
<!--body wrapper start-->
<div class="wrapper">
    <div class="row">
        <div class="col-sm-12">
            <section class="panel">
                <header class="panel-heading">
                    Liste des Cours
                    <span class="tools pull-right">
                        <a href="javascript:;" class="fa fa-chevron-down"></a>
                        <a href="javascript:;" class="fa fa-times"></a>
                    </span>
                </header>
                <div class="panel-body">
                    <span class="fa fa-check-circle" style="color: red ;"> </span>        
                    <span >demande d'inscription non accepter</span> 
                            <span class="fa fa-check-circle" style="color: green ;"> </span>        
                    <span >demande accepter</span> 
                    
                    <table class="display" id="mydata">
                        <thead>
                            <tr>
                                <th>code cours</th>
                                <th>Nom</th>
                                <th>Enseignant</th>
                                  <th>Options</th>


                            </tr>
                        </thead>

                        <tbody role="alert" aria-live="polite" aria-relevant="all">

                            <c:forEach items="${listCours}" var="cours">
                                <tr id="${cours.valider}">
                                    <td>${cours.id}</td>
                                    <td>${cours.cours.name}</td>
                                    <td>${cours.cours.enseignant.nom} ${cours.cours.enseignant.prenom}</td>
                                    <td>       
                                         <a href="<c:url value="/affichage?id=${cours.cours.id}" />" ><button  class="btn">Acceder</button></a>
                                        <a href="/delete" ><button  class="btn">Quitter</button></a>
                                    </td>
                                </tr>
                            </c:forEach>

                        </tbody> 

                    </table>

                </div>
            </section>
        </div>
    </div>
</div>
<!--body wrapper end-->

<!--footer section start-->

<jsp:include page="JsImports.jsp" />
<!--footer section end-->


</div>
<!-- main content end-->
</section>





<script>
    $(document).ready(function () {
        $('#mydata').DataTable();
        $('#false').css("color", "red");
        $('#true').css("color", "green");
        
    });
</script>


</body>
</html>
