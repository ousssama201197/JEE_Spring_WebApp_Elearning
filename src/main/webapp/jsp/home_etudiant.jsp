<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="HeaderEnt.jsp" /> 
<!-- header section end-->

<!-- page heading start-->
<div class="page-heading">

</div>
<!-- page heading end-->
<!--body wrapper start-->
<div class="wrapper">
    <h4> s'inscrir dans un nouveau cours </h4>
    ${message}
    <form action="<c:url value="/DemandeCours" />" method="POST">
        <div class="row">
            <div class="col-sm-6 form-group"> 
                <label>&nbsp;Nom  :</label>
                <input type="text" class="form-control" name="name" placeholder="Nom "  required="true">
            </div>

            <div class="col-sm-6">               
                <button class="btn btn-primary"  style="margin-top: 23px ;" type="submit">Envoyer demande</button>
            </div>
        </div>
    </form>
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

                    <table class="display" id="mydata">
                        <thead>
                            <tr>
                                <th>Marque</th>
                                <th>Modéle</th>
                                <th>Options</th>
                            </tr>
                        </thead>

                        <tbody role="alert" aria-live="polite" aria-relevant="all">

                            <c:forEach items="${listCours}" var="cours">
                                <tr>
                                    <td>${cours.id}</td>
                                    <td>${cours.name}</td>
                                    <td>${cours.enseignant.nom} ${cours.enseignant.prenom}</td>
                                    <td>${cours.address}</td>
                                    <td>
                                        <a href="/edit?id=${customer.id}">Edit</a>
                                        &nbsp;&nbsp;&nbsp;
                                        <a href="/delete?id=${customer.id}">Delete</a>
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
    });
</script>


</body>
</html>
