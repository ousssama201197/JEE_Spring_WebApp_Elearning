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
                   ${message}
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

</body>
</html>
