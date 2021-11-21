/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import GestorBD.GestorBD;
import Modelo.DetalleFactura;
import Modelo.Empleado;
import Modelo.Factura;
import Modelo.Producto;
import Modelo.Sucursal;
import Modelo.Venta;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 2w50 111606 Ezequiel Favio Visintini
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    int idEmpleado;
    int idProducto;
    int item;
    int cantidad;
    float totalapagar;
    String nombreProducto;
    float precio;
    float subtotal;

    GestorBD g = new GestorBD();
    Empleado e = new Empleado();
    Producto p = new Producto();

    Sucursal s = new Sucursal();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("principal")) {
            request.getRequestDispatcher("principal.jsp").forward(request, response);
        }
//        if (menu.equals("Productos")) {
//            switch (accion) {
//                case "Listar":
//                    ArrayList<Empleado> lista = g.getProductos();
//                    request.setAttribute("productos", lista);
//
//                    break;
//                case "Agregar":
//
//                    String nombre = request.getParameter("txtNombre");
//                    float precio = Float.parseFloat(request.getParameter("txtPrecio"));
//                    int stock = Integer.parseInt(request.getParameter("txtStock"));
//
//                    p.setNombre(nombre);
//                    p.setPrecio(precio);
//                    p.setStock(stock);
//
//                    g.agregarProducto(p);
//                    g.agregarEmpleado((Empleado) request.getSession().getAttribute("empleado"));
//                    request.getRequestDispatcher("LoginServlet?menu=Productos&accion=Listar").forward(request, response);
//
//                    break;
//                case "Actualizar":
//
//                    String nombreProductoUpdate = request.getParameter("txtNombre");
//                    float precioUpdate = Float.parseFloat(request.getParameter("txtPrecio"));
//                    int stockUpdate = Integer.parseInt(request.getParameter("txtStock"));
//                    idProducto = (Integer.parseInt(request.getParameter("txtIdEmpleado")));
//
//                    p.setNombre(nombreProductoUpdate);
//                    p.setPrecio(precioUpdate);
//                    p.setStock(stockUpdate);
//                    p.setIdProducto(idProducto);
//
//                    g.agregarProducto(p);
//
//                    request.getRequestDispatcher("LoginServlet?menu=Productos&accion=Listar").forward(request, response);
//
//                    break;
//                case "Cargar":
//
//                    idProducto = Integer.parseInt(request.getParameter("idProducto"));
//                    p = g.getProductoPorId(idProducto);
//                    request.setAttribute("productoSeleccionado", p);
//                    request.getRequestDispatcher("LoginServlet?menu=Productos&accion=Listar").forward(request, response);
//
//                    break;
//                case "Eliminar":
//
//                    idProducto = Integer.parseInt(request.getParameter("idProducto"));
//                    g.eliminarProducto(idProducto);
//                    request.getRequestDispatcher("LoginServlet?menu=Productos&accion=Listar").forward(request, response);
//
//                    break;
//                default:
//            }
//
//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/productos.jsp");
//            rd.forward(request, response);
//        }
//        if (menu.equals("Empleados")) {
//
//            switch (accion) {
//                case "Listar":
//                    ArrayList<Empleado> lista = g.getEmpleados();
//                    request.setAttribute("empleados", lista);
//
//                    break;
//                case "Agregar":
//
//                    String nombre = request.getParameter("txtNombre");
//                    String puesto = request.getParameter("txtPuesto");
//                    String usuario = request.getParameter("txtUsuario");
//                    String contraseña = request.getParameter("txtContraseña");
//
//                    e.setNombre(nombre);
//                    e.setPuesto(puesto);
//                    e.setUsuario(usuario);
//                    e.setContraseña(contraseña);
//
//                    g.agregarEmpleado(e);
//                    //g.agregarEmpleado((Empleado) request.getSession().getAttribute("empleado"));
//                    request.getRequestDispatcher("LoginServlet?menu=Empleados&accion=Listar").forward(request, response);
//
//                    break;
//                case "Actualizar":
//
//                    String nombreUpdate = request.getParameter("txtNombre");
//                    String puestoUpdate = request.getParameter("txtPuesto");
//                    String usuarioUpdate = request.getParameter("txtUsuario");
//                    String contraseñaUpdate = request.getParameter("txtContraseña");
//                    idEmpleado = (Integer.parseInt(request.getParameter("txtIdEmpleado")));
//
//                    e.setNombre(nombreUpdate);
//                    e.setPuesto(puestoUpdate);
//                    e.setUsuario(usuarioUpdate);
//                    e.setContraseña(contraseñaUpdate);
//                    e.setIdEmpleado(idEmpleado);
//
//                    g.actualizarEmpleado(e);
//
//                    request.getRequestDispatcher("LoginServlet?menu=Empleados&accion=Listar").forward(request, response);
//
//                    break;
//                case "Cargar":
//
//                    idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
//                    e = g.getEmpleadoPorId(idEmpleado);
//                    request.setAttribute("empleadoSeleccionado", e);
//                    request.getRequestDispatcher("LoginServlet?menu=Empleados&accion=Listar").forward(request, response);
//
//                    break;
//                case "Eliminar":
//
//                    idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
//                    g.eliminarEmpleado(idEmpleado);
//                    request.getRequestDispatcher("LoginServlet?menu=Empleados&accion=Listar").forward(request, response);
//
//                    break;
//                default:
//            }
//
//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/empleados.jsp");
//            rd.forward(request, response);
//        }
        if (menu.equals("Facturas")) {
            switch (accion) {

                case "Generarfactura":

                    int idSucursal = Integer.parseInt(request.getParameter("sucursal"));
                    String nombreCliente = request.getParameter("nombreCliente");
                    int idEmpleado = Integer.parseInt(request.getParameter("empleado"));

                    Factura f = new Factura(idSucursal, null, nombreCliente, idEmpleado);
                    g.agregarFactura(f);
                    
                    int idUltimaFactura = g.getUltimaFactura();
                    request.setAttribute("idUltimaFactura", idUltimaFactura);
                    
                    request.getRequestDispatcher("LoginServlet?menu=Ventas&accion=Listar").forward(request, response);
                    break;
                default:
            }
            request.getRequestDispatcher("facturas.jsp").forward(request, response);
        }
//        if (menu.equals("Ventas")) {
//            switch (accion) {
//
//                case "Listar":
//                    ArrayList<DetalleFactura> listaDetalleFactura = new ArrayList<>();
//                    request.getSession().setAttribute("listaDetalle", listaDetalleFactura);
//
//                    break;
//
//                case "BuscarProducto":
//                    idProducto = Integer.parseInt(request.getParameter("idProducto"));
//                    p = g.ConsultaPorCodigo(idProducto);
//                    request.setAttribute("productoSeleccionado", p);
//
//                    break;
//
//                case "AgregarProducto":
//
//                    int idProducto,
//                     cantidad;
//                    float precio;
//                    float total = 0;
//                    int stock;
//
//                    idProducto = Integer.parseInt(request.getParameter("idProducto"));
//                    precio = Float.parseFloat(request.getParameter("precioproducto"));
//                    cantidad = Integer.parseInt(request.getParameter("cantidadproducto"));
//                    stock = Integer.parseInt(request.getParameter("stock"));
//
//                    int idUltimaFactura = g.getUltimaFactura();
//                    request.getSession().setAttribute("idUltimaFactura", idUltimaFactura);
//                    System.out.println(idUltimaFactura + " idfactura");
//
//                    DetalleFactura d = new DetalleFactura();
//
//                    d.setIdFactura(idUltimaFactura);
//                    d.setIdProducto(idProducto);
//                    d.setCantidad(cantidad);
//                    d.setPrecio(precio);
//                    p.setStock(stock);
//
//                    if (stock > cantidad) {
//                        listaDetalleFactura = (ArrayList<DetalleFactura>) request.getSession().getAttribute("listaDetalle");
//                        listaDetalleFactura.add(d);
//
//                        for (int i = 0; i < listaDetalleFactura.size(); i++) {
//                            total = total + listaDetalleFactura.get(i).getSubtotal();
//                        }
//
//                        request.getSession().setAttribute("totalapagar", total);
//                    }
//
////                    //SELECT IDENT_CURRENT('Facturas')
//                    break;
//
//                case "GenerarVenta":
////                    Para grabar pasarle la listadetallefactura (que esta guardada en la sesion) a un metodo del gestor. 
////                    Debo usar un foreach para que cargue en la base
//
//                    total = (float) request.getSession().getAttribute("totalapagar");
//                    int cmbefectivo,
//                     cmbdebito,
//                     cmbcredito = 0;
//                    float txtefectivo,
//                     txtdebito,
//                     txtcredito = 0;
//
//                    cmbefectivo = Integer.parseInt(request.getParameter("cmbefectivo"));
//                    cmbdebito = Integer.parseInt(request.getParameter("cmbdebito"));
//                    cmbcredito = Integer.parseInt(request.getParameter("cmbcredito"));
//
//                    txtefectivo = Float.parseFloat(request.getParameter("txtefectivo"));
//                    txtdebito = Float.parseFloat(request.getParameter("txtdebito"));
//                    txtcredito = Float.parseFloat(request.getParameter("txtcredito"));
//
//                    System.out.println(cmbefectivo + " " + cmbdebito + " " + cmbcredito);
////                    
//                    if (cmbefectivo == 1 ) {
//                        txtefectivo = (float) (txtefectivo - (txtefectivo * 0.25));
//                    }
//                    if (cmbcredito == 3 ) {
//                        txtcredito = (float) (txtcredito + (txtcredito * 0.10));
//                    }
////                    
////                    System.out.println(txtefectivo + " " + txtdebito + " " + txtcredito);
//                    listaDetalleFactura = (ArrayList<DetalleFactura>) request.getSession().getAttribute("listaDetalle");
//                    g.agregarDetalleFactura(listaDetalleFactura);
//
//                    request.getRequestDispatcher("LoginServlet?menu=Ventas&accion=Listar").forward(request, response);
//                    break;
//
//            }
//            request.getRequestDispatcher("generarVenta.jsp").forward(request, response);
//        }
        if (menu.equals("Reportes")) {
            request.getRequestDispatcher("reportes.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
