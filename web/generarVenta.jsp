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
        <script>
            function activarEfectivo() {
                var efectivo = document.getElementById("txtefectivo").disabled = false;
            }
            function activarDebito() {
                var debito = document.getElementById("txtdebito").disabled = false;
            }
            function activarCredito() {
                var credito = document.getElementById("txtcredito").disabled = false;
            }
        </script>
    </head>
    <body>
        <div class="row">
            <div class="card col-md-4">
                <h5 class="card-header">Datos producto</h5>
                <div class="card-body">
                    <%-- <form action="LoginServlet" method="POST">
                        <input type="text" name="producto">
                        <input type="submit" value="Enviar">
                    </form>--%>

                    <form action="GenerarVentaServlet?menu=Ventas" method="POST">


                        <div class="form-group">
                            <input type="number" name="idProducto" class="form-control" placeholder="Id Producto" value="${productoSeleccionado.getIdProducto()}">
                            <input type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-dark">
                        </div>
                        <br>
                        <div class="form-group">
                            <input type="text" disabled="" name="nombreproducto" class="form-control" placeholder="Nombre Producto" value="${productoSeleccionado.getNombre()}">
                        </div>
                        <div class="form-group">
                            <input type="text" name="precioproducto" class="form-control" placeholder="Precio producto" value="${productoSeleccionado.getPrecio()}">
                        </div>
                        <div class="form-group">
                            <h6 class="card-subtitle mb-2 text-muted">Stock</h6>
                            <input type="text" name="stock" class="form-control" value="${productoSeleccionado.getStock()}">
                        </div>
                        <div class="form-group">
                            <h6 class="card-subtitle mb-2 text-muted">Cantidad</h6>
                            <input type="number" value="1" name="cantidadproducto" class="form-control" placeholder="Cantidad">
                        </div>
                        <input type="submit" name="accion" value="AgregarProducto" class="btn btn-outline-primary col text-center">
                        <div class="row"></div>
                    </form>
                </div>
            </div>

            <div class="col-md-8">
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
                                <c:forEach var="lista" items="${sessionScope.listaDetalle}">
                                    <tr>
                                        <td style="width: 350px;">${lista.idProducto}</td>
                                        <td>${lista.precio}</td>
                                        <td style="width: 30px;">${lista.cantidad}</td>
                                        <td style="width: 30px;">${lista.subtotal}</td>
                                        <td class="columna">
                                            <a class="btn btn-danger">Eliminar</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer d-flex">  
                        <h4 class="col-md-4">Total a pagar: </h4>
                        <div class="col-md-3">
                            <input type=text" name="txttotalapagar" class="form-control" placeholder="$ 00.000.00" disabled="disabled" value="${totalapagar}">
                        </div>

                        <div>
                            <form action="GenerarVentaServlet?menu=Ventas" method="POST">
                                <h6 class="card-subtitle mb-2 text-muted">Ingrese la cantidad que desea abonar por cada medio de pago</h6>
                                <div>
                                    <div class="form-floating mb-3">
                                        <input type="number" id="txtefectivo" name="txtefectivo" class="form-control" value="0">
                                        <label for="floatingInput">Efectivo</label>
                                    </div>
                                    <div class="form-floating">
                                        <input type="number" id="txtdebito" name="txtdebito" class="form-control" value="0">
                                        <label for="floatingInput">Debito</label>
                                    </div>
                                    <div class="form-floating">
                                        <input type="number" id="txtcredito" name="txtcredito" class="form-control" value="0">
                                        <label for="floatingInput">Credito</label>
                                    </div>
                                </div>

                                <!-- Button trigger modal -->
                                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                                    Resumen de venta
                                </button>

                                <!-- Modal -->
                                <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                            </div>
                                            <div class="modal-body">
                                                ...
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                <div class="col-md-3">
                                                    <input type="submit" name="accion" value="GenerarVenta" class="btn btn-success">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <h1>Está seguro de querer confirmar la venta?</h1>
                            </form>
                        </div>
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