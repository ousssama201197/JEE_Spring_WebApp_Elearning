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
                    Nouveau Examen
                    <span class="tools pull-right">
                        <a href="javascript:;" class="fa fa-chevron-down"></a>
                        <a href="javascript:;" class="fa fa-times"></a>
                    </span>
                </header>
                <div class="panel-body">
                    <form action="<c:url value="/saveexam"/>" method="GET" >
                    <div class="form-group"> 
                        <label>&nbsp; Liste  des cours  :</label>
                        <select name="idcours" class="form-control">
                            <c:forEach items="${listecours}" var="cours">
                                <option value="${cours.id}"> ${cours.name}</option>
                            </c:forEach>

                        </select>
                    </div>
                                             </br></br>
                    <div class="form-group"> 
                        <label>Question :</label>
                        <input type="text" name='question' required="true" class="form-control">
                    </div>
                     <div class="form-group"> 
                        <label>Choix 1 :</label>
                        <input type="text" name='c1' required="true" class="form-control">
                    </div>
                     <div class="form-group"> 
                        <label>Choix 2 :</label>
                        <input type="text" name='c2' required="true" class="form-control">
                    </div>
                     <div class="form-group"> 
                        <label>Choix 3 :</label>
                        <input type="text"  name='c3' required="true" class="form-control">
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
