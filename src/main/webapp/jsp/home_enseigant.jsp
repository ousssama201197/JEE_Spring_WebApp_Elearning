
        <jsp:include page="headerEns.jsp" />
        
        <div class="page-heading">
           
        </div>
        <!-- page heading end-->
        <!--body wrapper start-->
        <div class="wrapper">
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
                                            </tr>
                                        </thead>
                                        <tbody role="alert" aria-live="polite" aria-relevant="all">
       <c:forEach items="" var="">
      
           <tr>
            <td>
                <a href="/edit?id=${customer.id}">Valider</a>
                &nbsp;&nbsp;&nbsp;
                <a href="/delete?id=${customer.id}">Supprimer</a>
            </td>
        </tr>
        </c:forEach>

                                        </tbody> 

                                    </table>

                                </div>
                            </section>
                        </div>
                    </div>
            
            
            
            
            
            
            
            
            
             <div class="row">
                        <div class="col-sm-12">
                            <section class="panel">
                                <header class="panel-heading">
                                    Liste des Etudiants
                                    <span class="tools pull-right">
                                        <a href="javascript:;" class="fa fa-chevron-down"></a>
                                        <a href="javascript:;" class="fa fa-times"></a>
                                    </span>
                                </header>
                                <div class="panel-body">
                                    <table class="display" id="mydata2">
                                        <thead>
                                            <tr>
                                                <th>Nom</th>
                                                <th>Prénom</th>
                                                <th>Adresse</th>
                                                 <th>liste des cours + NOTE</th>                          
                                            </tr>
                                        </thead>
                                        <tbody role="alert" aria-live="polite" aria-relevant="all">
       <c:forEach items="${listeEtudiantCours}" var="etudiantCours">
           
        <tr>
            <td>${etudiantCours.etudiant.nom}</td>
             <td>${etudiantCours.etudiant.prenom}</td>
              <td>${etudiantCours.etudiant.adresse}</td>
              <td>${etudiantCours.etudiant.nom}</td>
         
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

 <script> 
           $(document).ready( function () {
    $('#mydata').DataTable();
     $('#mydata2').DataTable();
} );
        </script>

    </div>
    <!-- main content end-->
</section>

</body>
</html>
