<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="HeaderEnt.jsp" /> 
<!-- header section end-->

<!-- page heading start-->
<div class="page-heading">

</div>
<!-- page heading end-->
<!--body wrapper start-->
<div class="wrapper">
    <h3 style="color: black;"> s'inscrir dans un nouveau cours </h3>
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
