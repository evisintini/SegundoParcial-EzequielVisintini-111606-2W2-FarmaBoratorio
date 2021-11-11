<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="gestor" scope="request" class="GestorBD.GestorBD" />
<jsp:useBean id="altaFactura" scope="session" class="Modelo.Factura"/>
<jsp:setProperty name="altaFactura" property="*"/>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title>Hello, world!</title>
    </head>
    <body>

        <h5 class="card-header">Datos producto</h5>
        <div class="card-body">
            <%-- <form action="LoginServlet" method="POST">
                <input type="text" name="producto">
                <input type="submit" value="Enviar">
            </form>--%>

            <form action="LoginServlet?menu=Ventas" method="POST">
                <div>
                    <select name="factura">
                        <c:forEach var="f" items="${gestor.getFacturas()}">
                            <option selected="${f.getIdFactura()}" value="${f.getIdFactura()}">Factura N° ${f.getIdFactura()}, Fecha: ${f.getFecha()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="row">
                    <div class="col-md-6 d-flex form-group">
                        <input type="number" name="idProducto" class="form-control" placeholder="Id Producto" value="${productoSeleccionado.getIdProducto()}">
                        <input type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-dark">
                    </div>
                    <div class="col-md-6 d-flex form-group">
                        <input type="text" name="nombreproducto" class="form-control" placeholder="Nombre Producto" value="${productoSeleccionado.getNombre()}">
                    </div>
                    <div class="col-md-4 d-flex form-group">
                        <input type="text" name="precioproducto" class="form-control" placeholder="$ 0000.00" value="${productoSeleccionado.getPrecio()}">
                    </div>
                    <div class="col-md-8 d-flex form-group">
                        <input type="number" value="1" name="cantidadproducto" class="form-control" placeholder="Cantidad">
                    </div>
                </div>
                <input type="submit" name="accion" value="AgregarProducto" class="btn btn-outline-primary col text-center">
                <div class="row"></div>
            </form>
        </div>
        <div class="col-md-7">
            <div class="card">
                <div class="card-body">
                    <table class="table">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">Producto</th>
                                <th scope="col">Precio</th>
                                <th scope="col">Cantidad</th>
                                <th scope="col">Subtotal</th>
                                <th scope="col" class="columna"></th>
                            </tr>
                        </thead>
                        <tbody>                   
                            <c:forEach var="lista" items="${sessionScope.detalle}">
                                <tr>
                                    <td style="width: 350px;">${lista.getP().getIdProducto}</td>
                                    <td>${lista.getPrecio()}</td>
                                    <td style="width: 30px;">${lista.getCantidad()}</td>
                                    <td style="width: 30px;">${lista.getSubtotal()}</td>
                                    <td class="columna">
                                        <a class="btn btn-danger">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="card-footer d-flex">
                    <div class="col-md-8 text-center">
                        <a class="btn btn-success" href="Controlador?menu=Ventas&accion=GenerarVenta">Generar Venta</a>
                        <a class="btn btn-danger" href="Controlador?menu=Ventas&accion=NuevaVenta">Nueva Venta</a>
                    </div>
                    <div class="col-md-4">
                        <input type=text" name="txttotalapagar" class="form-control" placeholder="$ 00.000.00" disabled="disabled" value="${totalapagar}">
                    </div>
                </div>                    
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