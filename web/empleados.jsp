<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="es">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title>Empleados</title>
    </head>
    <body>
        <div class="row">            
            <div class="col-md-4">
                <div class="card-body">
                    <h5 class="card-title">Empleados</h5>
                    <h6 class="card-subtitle mb-2 text-muted">En este panel podras gestionar los datos de los empleados en el sistema</h6>
                    <div>
                        <form action="AltaEmpleadoServlet?menu=Empleados" method="POST">
                            <div class="form-group">
                                <label>Nombre</label>
                                <input type="text" class="form-control" name="txtNombre" value="${empleadoSeleccionado.getNombre()}">
                            </div>
                            <div class="form-group">
                                <label>Puesto</label>
                                <input type="text" class="form-control" name="txtPuesto" value="${empleadoSeleccionado.getPuesto()}">
                            </div>
                            <div class="form-group">
                                <label>Usuario</label>
                                <input type="text" class="form-control" name="txtUsuario" value="${empleadoSeleccionado.getUsuario()}">
                                <small class="form-text text-muted">Ingrese el Usuario que utilizará para el inicio de sesión</small>
                            </div>
                            <div class="form-group">
                                <label>Contraseña</label>
                                <input type="password" class="form-control" name="txtContraseña" value="${empleadoSeleccionado.getContraseña()}">
                                <small class="form-text text-muted">Ingrese la Contraseña que utilizará para el inicio de sesión</small>
                            </div>
                            <br>
                            <input type="submit" class="btn btn-primary" name="accion" value="Agregar" >
                            <input type="submit" class="btn btn-success" name="accion" value="Actualizar" >
                            <a class="btn btn-warning" href="AltaEmpleadoServlet?menu=Empleados&accion=Actualizar&idEmpleado=${empleado.getIdEmpleado()}">ACTUALIZAR</a>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-md-8">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Puesto</th>
                            <th scope="col">Usuario</th>
                            <th scope="col">Contraseña</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="empleado" items="${empleados}">
                            <tr>
                                <th scope="row">${empleado.getIdEmpleado()}</th>
                                <td>${empleado.getNombre()}</td>
                                <td>${empleado.getPuesto()}</td>
                                <td>${empleado.getUsuario()}</td>
                                <td>${empleado.getContraseña()}</td>
                                <td>
                                    <a class="btn btn-warning" href="AltaEmpleadoServlet?menu=Empleados&accion=Cargar&idEmpleado=${empleado.getIdEmpleado()}">Editar</a>
                                    <a class="btn btn-danger" href="AltaEmpleadoServlet?menu=Empleados&accion=Eliminar&idEmpleado=${empleado.getIdEmpleado()}">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table> 
            </div>
        </div>

        <!-- Optional JavaScript; choose one of the two! -->

        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

        <!-- Option 2: Separate Popper and Bootstrap JS -->
        <!--
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
        -->
    </body>
</html>