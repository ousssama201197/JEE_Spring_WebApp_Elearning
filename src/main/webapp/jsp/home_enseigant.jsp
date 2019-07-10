
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="headerEns.jsp" />

<div class="page-heading">

</div>
<!-- page heading end-->
<!--body wrapper start-->
<div class="wrapper">
    ${message}
    <div class="row">
        <div class="col-sm-12">
            <section class="panel">
                <header class="panel-heading">
                    Nouvelles demande d'inscription au cours
                    <span class="tools pull-right">
                        <a href="javascript:;" class="fa fa-chevron-down"></a>
                        <a href="javascript:;" class="fa fa-times"></a>
                    </span>
                </header>
                <div class="panel-body">
                    <table class="display" id="mydata">
                        <thead>
                            <tr>
                                <th>Nom Cours</th>
                                <th>Nom</th>
                                <th>Prénom</th>
                                <th>Adresse</th>
                                  <th>Options</th>
                            </tr>
                        </thead>
                        <tbody role="alert" aria-live="polite" aria-relevant="all">
                            <c:forEach items="${listecours}" var="cours">
                               <tr>
                            <td>${cours.cours.name}</td>
                            <td>${cours.etudiant.nom}</td>
                            <td>${cours.etudiant.prenom}</td>
                            <td>${cours.etudiant.adress}</td>
                                <td>
                                    <a href="<c:url value="/valider?id=${cours.id}&id2=${cours.etudiant.id}" />"<button class="btn btn-primary">Valider</button></a>
                                    <a href="/delete"><button class="btn btn-danger">Supprimer</button></a>
                                </td>
                            </tr>
                        </c:forEach>

                        </tbody> 

                    </table>

                </div>
            </section>
        </div>
    </div>







<!--footer section start-->
<jsp:include page="JsImports.jsp" />
<!--footer section end-->



</div>
<!-- main content end-->
</section>

</body>
<script>
    $(document).ready(function () {
        $('#mydata').DataTable();
        $('#mydata2').DataTable();
    });
</script>
</html>
