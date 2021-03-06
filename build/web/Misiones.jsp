<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
 
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
 
        <title>Productos</title>
    </head>
    <body>
        <div class="row">
            <div class="card col-md-10">
        <div>
        <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">id</th>
                            <th scope="col">Descripcion</th>
                            <th scope="col">Dificultad</th>
                            <th scope="col">Shinobi</th>
                            <th scope="col">rango</th>
                            <th scope="col">Estado</th>
                          
                           <th scope="col">Resultado</th>
                        </tr>
                    </thead>

                    <tbody>
                      
                       <c:forEach var="listam" items="${listam}">
                            <tr>
                                <th scope="row">${listam.getId()}</th>
                                <td>${listam.getDescripcion()}</td>
                                <td>${listam.getDificultad()}</td>
                                <td>${listam.getShinobi()}</td>
                                <td>${listam.getRango()}</td>
                                <td>${listam.getEstado()}</td>
                                <td>${listam.getResultado()}</td>
                                
                                
                                  <td>    <a class="btn btn-warning" href="Controlador?menu=misiones&accion=cargare&id=${listam.getId()}&nombre=${listam.getShinobi()}"> exito</a>
    <a class="btn btn-danger" href="Controlador?menu=misiones&accion=cargarf&id=${listam.getId()}&nombre=${listam.getShinobi()}">fracaso</a>
   
    
</td>
                                
    
                            </tr>
                        </c:forEach>



                    </tbody>
                </table>

            </div>
            </div>
            <div class="card col-md-2">
                <img src="imagenes/descarga.jpg" style="margin-top: 50px;" alt=""/>
            </div> 
            
        
        
        
        
        
    
 
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
