<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="es">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title>Productos</title>
    </head>
    <body>
        <div class="row">            
            <div class="col-md-4">
                <div class="card-body">
                    <h5 class="card-title">Productos</h5>
                    <h6 class="card-subtitle mb-2 text-muted">En este panel podras gestionar los datos de los productos en el sistema</h6>
                    <div>
                        <form action="AltaProductoServlet?menu=Productos" method="POST">
                            <div class="form-group">
                                <label>Nombre</label>
                                <input type="text" class="form-control" name="txtNombre" value="${productoSeleccionado.getNombre()}">
                            </div>
                            <div class="form-group">
                                <label>Precio</label>
                                <input type="number" class="form-control" name="txtPrecio" value="${productoSeleccionado.getPuesto()}">
                            </div>
                            <div class="form-group">
                                <div class="form-group">
                                    <label>Stock</label>
                                    <input type="number" class="form-control" name="txtStock" value="${productoSeleccionado.getStock()}">
                                </div>
                            </div>
                            <br>
                            <input type="submit" class="btn btn-primary" name="accion" value="Agregar" >
                            <input type="submit" class="btn btn-success" name="accion" value="Actualizar" >
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
                            <th scope="col">Precio</th>
                            <th scope="col">Stock</th>
                        </tr>
                    </thead>
                    <tbody>                        
                        <c:forEach var="producto" items="${productos}">
                            <tr>
                                <th scope="row">${producto.idProducto}</th>
                                <td>${producto.nombre}</td>
                                <td>${producto.precio}</td>
                                <td>${producto.stock}</td>
                                <td>
                                    <a class="btn btn-warning" href="AltaProductoServlet?menu=Productos&accion=Cargar&idProducto=${producto.getIdProducto()}">Editar</a>
                                    <a class="btn btn-danger" href="AltaProductoServlet?menu=Productos&accion=Eliminar&idProducto=${producto.idProducto}">Eliminar</a>
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