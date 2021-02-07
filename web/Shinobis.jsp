<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

        <title>Hello, world!</title>
    </head>
    <body>
        <div class="row">
            <div class="card col-md-4">
                <div class="card-body">
                    <h5 class="card-title">Shinobis</h5>
                    <a class="btn btn-warning" href="Controlador?menu=shinobis&accion=listarinactivo">Ver Inactivos</a>
                    <a class="btn btn-warning" href="Controlador?menu=shinobis&accion=listar">Ver Activos</a>
                    <div>
                        <form action="Controlador?menu=shinobis" method="POST">
                            <div class="form-group">
                                
                            </div>
                            <div class="form-group">
                                <label>Nombre</label>
                                <input type="text" class="form-control" name="txtnombre" value="${usuarioSeleccionado.getNomnrbre()}">
                            </div>
                            <div class="form-group">
                                <label>Clan</label>
                                <input type="text" class="form-control" name="txtclan" value="${usuarioSeleccionado.getCloan()}">
                            </div>
                           
                            <div class="form-group">
                                <label>Rango</label>
                                <input type="text"class="form-control" name="txtrango" value="${usuarioSeleccionado.getRango()}">
                                    
                            </div>
                            <div class="form-group">
                                <label>Estados</label>
                                <input type="text" class="form-control"  name="txtestado" value="${usuarioSeleccionado.getEstado()}">
                                   
                            </div>
                                    <div class="form-group">
                                <label>Total Misiones</label>
                                <input type="text" class="form-control" name="txttotal" value="${usuarioSeleccionado.getMisionc() + usuarioSeleccionado.getMisionf()}">
                            </div>
                            <h1>Misiones <span class="badge bg-secondary">${usuarioSeleccionado.getMisionc() + usuarioSeleccionado.getMisionf()} </span></h1>
                            <div class="form-group">
                                <label>Misiones completadas</label>
                                <input type="number" class="form-control" name="txtmisionc" value="${usuarioSeleccionado.getMisionc()}">
                             <h1>Completadas <span class="badge bg-success">${usuarioSeleccionado.getMisionc()} </span></h1>
                            </div>
                            <div class="form-group">
                                <label>Misiones fallidas</label>
                                <input type="number" class="form-control" name="txtmisionf" value="${usuarioSeleccionado.getMisionf()}">
                             <h1>Fallidas <span class="badge bg-danger">${usuarioSeleccionado.getMisionf()} </span></h1>
                            </div>

                            <input type="submit" class="btn btn-primary" name="accion" value="agregar">
                            <input type="submit" class="btn btn-success" name="accion" value="Actualizar">
                        </form>
                    
                    </div>
                            <br>
                             <form action="Controlador?menu=shinobis" method="POST">

                            <h5>Asignar mision </h5>
                            <div class="form-group">
                                <label>Descripcion</label>
                                <input type="text" class="form-control" name="txtmm1">
                                
                            </div>
                                <div class="form-group">
                                <label>Dificultad</label>
                                <input type="text" class="form-control" name="txtmm2">
                            </div>
                           <div class="form-group">
                                <label>Shinobi</label>
                                <input type="text" class="form-control" name="txtmm3" value="${usuarioSeleccionado1.getNomnrbre()}" >
                            </div>
                            <div class="form-group">
                                <label>Rango</label>
                                <input type="text" class="form-control" name="txtmm4" value="${usuarioSeleccionado1.getRango()}" >
                            </div>
                        
                            <div class="form-group">
                                <label>Estado</label>
                                <input type="text" class="form-control" name="txtmm5" >
                            </div>
                           <div class="form-group">
                                <label>Resultado</label>
                                <input type="text" class="form-control" name="txtmm6">
                               
                            </div>
                             <input type="submit" class="btn btn-primary" name="accion" value="Agregar">
                             </form> 
                </div>
            </div>
        

            <div class="col-md-8">

                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">id</th>
                            <th scope="col">nombre</th>
                            <th scope="col">clan</th>
                            <th scope="col">rango</th>
                            <th scope="col">estado</th>
                            
                            <th scope="col">completadas</th>
                            <th scope="col">Fallidas</th>
                        </tr>
                    </thead>

                    <tbody>
                       <c:forEach var="lista" items="${lista}">
                            <tr>
                                <th scope="row" name=>${lista.getId()}</th>
                                <td>${lista.getNomnrbre()}</td>
                                <td>${lista.getCloan()}</td>
                                <td>${lista.getRango()}</td>
                                <td>${lista.getEstado()}</td>
                                
                               <td>${lista.getMisionc()}</td>
                                <td>${lista.getMisionf()}</td>
                                <td>    <a class="btn btn-warning" href="Controlador?menu=shinobis&accion=cargar&id=${lista.getId()}">Ver</a>
    <a class="btn btn-danger" href="Controlador?menu=shinobis&accion=eliminar&id=${lista.getId()}">Eliminar</a>
    <a class=" btn btn-primary"  style="margin-top: 5px;" href="Controlador?menu=shinobis&accion=cargarm&id=${lista.getId()}">Asignar mision</a>
<a class=" btn btn-primary"  style="margin-top: 5px;" href="Controlador?menu=shinobis&accion=cargari&id=${lista.getId()}">inactivo</a>
                                </td>
                            </tr>
                        </c:forEach>



                    </tbody>
                </table>
                
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">id</th>
                            <th scope="col">nombre</th>
                            <th scope="col">clan</th>
                            <th scope="col">rango</th>
                            <th scope="col">estado</th>
                            
                            <th scope="col">completadas</th>
                            <th scope="col">Fallidas</th>
                        </tr>
                    </thead>

                    <tbody>
                       <c:forEach var="lista" items="${listai}">
                            <tr>
                                <th scope="row" name=>${lista.getId()}</th>
                                <td>${lista.getNomnrbre()}</td>
                                <td>${lista.getCloan()}</td>
                                <td>${lista.getRango()}</td>
                                <td>${lista.getEstado()}</td>
                                
                               <td>${lista.getMisionc()}</td>
                                <td>${lista.getMisionf()}</td>
                                <td>    <a class="btn btn-warning" href="Controlador?menu=shinobis&accion=cargar&id=${lista.getId()}">Editar</a>
    <a class="btn btn-danger" href="Controlador?menu=shinobis&accion=eliminar&id=${lista.getId()}">Eliminar</a>
    <a class=" btn btn-success" href="Controlador?menu=shinobis&accion=cargara&id=${lista.getId()}" style="margin-top: 5px">Activar</a>
</td>
                            </tr>
                        </c:forEach>



                    </tbody>
                </table>


            </div>

            <!-- Optional JavaScript -->
            <!-- jQuery first, then Popper.js, then Bootstrap JS -->
            <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
