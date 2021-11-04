<%-- 
    Document   : cargaVentas
    Created on : 28 oct. 2021, 19:13:03
    Author     : 2w50 111606 Ezequiel Favio Visintini
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta de ventas</title>
    </head>
    <body>
        <h1>Alta de ventas</h1>
        
        <form>
            
            <table>                
                <tr>
                    <td>Fecha</td>
                    <td><input type="text" name="txtFecha" value="" /></td>
                    <td>Sucursal</td>
                    <td>
                        <select name="idSucursal">
                            <c:forEach var="s" items="${gestor.sucursales}"> <%--uso el bean para llamar directamente al metodo "getEstadosCiviles de la clase GestorBD --%>
                                <option value="${s.id}">${s.ciudad}
                            </c:forEach>
                        </select>
                    </td>
                </tr>  
                <tr>
                    <td>Nombre del cliente</td>
                    <td><input type="text" name="txtNombreCliente" value="" /></td>
                </tr>
                <td>Sucursal</td>
                <td>
                        <select name="idSucursal">
                            <c:forEach var="s" items="${gestor.sucursales}"> <%--uso el bean para llamar directamente al metodo "getEstadosCiviles de la clase GestorBD --%>
                                <option value="${s.id}">${s.ciudad}
                            </c:forEach>
                        </select>
                </td>
            </table>
            
        </form>
    </body>
</html>
