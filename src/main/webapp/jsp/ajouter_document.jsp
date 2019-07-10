<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="headerEns.jsp" />
<div class="page-heading">
</div>
<div class="wrapper">
    ${message}
    <div class="row">
        <div class="col-sm-12">
            <section class="panel">
                <header class="panel-heading">
                    Nouveau document
                    <span class="tools pull-right">
                        <a href="javascript:;" class="fa fa-chevron-down"></a>
                        <a href="javascript:;" class="fa fa-times"></a>
                    </span>
                </header>
                <div class="panel-body">
                    <form action="<c:url value="/savedoc"/>" method="GET" >
                        <div class="form-group"> 
                            <label>&nbsp; Liste  des cours  :</label>
                            <select name="idcours" class="form-control">
                                <c:forEach items="${listecours}" var="cours">
                                    <option value="${cours.id}"> ${cours.name}</option>
                                </c:forEach>

                            </select>
                        </div>

                        <div class="form-group"> 
                            <label>&nbsp;Description : </label>
                            <textarea type="text" class="form-control" name="des" placeholder="Description"   required="true"></textarea>
                        </div>

                        <div class="form-group"> 
                            <label>Fichier :</label>
                            <input type="file" class="default" name='file' required="true" class="btn btn-block btn-primary">
                        </div>
                        <input type="submit" value="valider" class="btn btn-block btn-primary">
                    </form>
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
