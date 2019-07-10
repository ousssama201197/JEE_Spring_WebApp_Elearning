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
                    Documents
                    <span class="tools pull-right">
                        <a href="javascript:;" class="fa fa-chevron-down"></a>
                        <a href="javascript:;" class="fa fa-times"></a>
                    </span>
                </header>
                <div class="panel-body">
                    <div class="row">
                        <c:forEach items="${listedocument}" var="doc">

                            <div class="col-sm-2">
                                &nbsp; <a href="<c:url value="/downfile?id=${doc.id}" />"><span class="fa fa-file" style="font-size:   60px;Color :red;"></span></a>
                                </br>
                                <a href="<c:url value="/downfile?id=${doc.id}" />"> <span tyle="font-size:   30px;">${doc.name}</span></a>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </section>
        </div>
    </div>


    <div class="row">
        <div class="col-sm-12">
            <section class="panel">
                <header class="panel-heading">
                    Examen en cours 
                    <span class="tools pull-right">
                        <a href="javascript:;" class="fa fa-chevron-down"></a>
                        <a href="javascript:;" class="fa fa-times"></a>
                    </span>
                </header>

                <div class="panel-body">
                    
                    <form action="<c:url value="/reponsequiz" />" method="GET">
                        ${date}
                     
                        <input type="text" name='id' value="${id}"  hidden="true">
                  
                    ${message}
                    <div style="display: ${erreur};">
                    <div class="form-group"> 
                        <label>Question :</label>
                        <input type="text" name='question' required="true" value="${q}"  class="form-control" disabled="true">
                    </div>
                     <div class="form-group"> 
                        <label>Choix 1 :</label>
                        <input type="text" name='c1' required="true"  value="${c1}" class="form-control" disabled="true">
                    </div>
                     <div class="form-group"> 
                        <label>Choix 2 :</label>
                        <input type="text" name='c2' required="true" value="${c2}" class="form-control" disabled="true">
                    </div>
                     <div class="form-group"> 
                        <label>Choix 3 :</label>
                        <input type="text"  name='c3' required="true" value="${c3}" class="form-control" disabled="true">
                    </div>
                                             </br>
                     <div class="form-group"> 
                        <label> Reponse :</label>
                        <input type="number"  name='reponse' min="1" max="3" required="true" class="form-control">
                    </div>  
               
                    <input type="submit" value="valider" class="btn btn-block btn-primary">
                    </div>
                    </form>
                    

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
