<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<%--<%
    if (session.getAttribute("lista") == null) {
        ArrayList<String> lis = new ArrayList<String>();
        session.setAttribute("lista", lis);
    }
    ArrayList<String> lista = (ArrayList<String>) session.getAttribute("lista");
%>--%>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

        <title>Sistema de ventas</title>
        <style>
            @media print{
                .seccion1, .btn, .columna{
                    display:none;
                }
            }
        </style>
    </head>
    <body>
        <jsp:useBean id="gestor" scope="request" class="GestorBD.GestorBD" />
        <jsp:useBean id="altaFactura" scope="session" class="Modelo.Factura"/>
        <jsp:setProperty name="altaFactura" property="*"/>
        <div class="row">
            <div class="col-md-5 seccion1">
                <div class="card">
                    <h5 class="card-header">Datos Factura</h5>
                    <div class="card-header">
                        <form action="AltaFacturaServlet?menu=Facturas" method="POST">
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">Sucursal</label>
                                <select name="sucursal">
                                    <c:forEach var="s" items="${gestor.getSucursales()}">
                                        <option value="${ s.getIdSucursal() }">${s.getCiudad()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <%--<div class="form-group row">
                                <label class="col-sm-4 col-form-label">Fecha</label>
                                <input type="date" name="fecha" min="1950-01-01"/>
                            </div> --%> 
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">Nombre del cliente</label>
                                <input class="form-control col-md-4" type="text" name="nombreCliente">
                            </div> 
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">Empleado</label>
                                <select name="empleado">
                                    <c:forEach var="e" items="${gestor.getEmpleados()}">
                                        <option value="${ e.getIdEmpleado() }">${e.getNombre()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div>
                                <input type="submit" name="accion" value="Generar Factura"  class="btn btn-outline-primary col text-center">
                            </div>
                        </form>
                    </div>
                </div>
            </div>               
        </div>

        <!-- Optional JavaScript; choose one of the two! -->

        <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

        <!-- Option 2: jQuery, Popper.js, and Bootstrap JS
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
        -->
    </body>
</html>