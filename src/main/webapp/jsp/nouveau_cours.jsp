<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="headerEns.jsp" />
<!-- page heading start-->
<div class="page-heading">
    <h2>  Nouveau Cours </h2>
</div>
<!-- page heading end-->
<!--body wrapper start-->
<div class="wrapper">
    ${message}
    <form action="<c:url value="/nouveau_cours/save" />" method="POST">
        <div class="form-group"> 
            <label>&nbsp;Nom  :</label>
            <input type="text" class="form-control" name="name" placeholder="Nom "  required="true">
        </div>

        <div class="form-group"> 
            <label>&nbsp;Discription :</label>
            <textarea class="form-control" name="dis" placeholder="Discription"  required="true" > </textarea>
        </div>

        <button class="btn btn-primary btn-lg btn-block"  type="submit">Ajouter</button>
    </form>
</div>

<jsp:include page="JsImports.jsp" />
</div>

</section>

</body>
</html>
