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
import java.text.NumberFormat;
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
    int idFactura;
    int item;
    int cantidad;
    float totalapagar;
    String nombreProducto;
    float precio;
    float subtotal;

    GestorBD g = new GestorBD();
    Empleado e = new Empleado();
    Producto p = new Producto();
    Venta v = new Venta();
    DetalleFactura d = new DetalleFactura();
    Factura f = new Factura();
    Sucursal s = new Sucursal();

    ArrayList<DetalleFactura> listaDetalleFactura = new ArrayList<>();
    ArrayList<Venta> listaVentas = new ArrayList<>();

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
        if (menu.equals("Productos")) {
            switch (accion) {
                case "Listar":
                    ArrayList<Empleado> lista = g.getProductos();
                    request.setAttribute("productos", lista);

                    break;
                case "Agregar":

                    String nombre = request.getParameter("txtNombre");
                    float precio = Float.parseFloat(request.getParameter("txtPrecio"));
                    boolean isVentaLibre = Boolean.parseBoolean(request.getParameter("chkVentaLibre"));

                    p.setNombre(nombre);
                    p.setPrecio(precio);
                    p.setIsVentaLibre(isVentaLibre);

                    g.agregarProducto(p);
                    //g.agregarEmpleado((Empleado) request.getSession().getAttribute("empleado"));
                    request.getRequestDispatcher("LoginServlet?menu=Productos&accion=Listar").forward(request, response);

                    break;
                case "Actualizar":

                    String nombreProductoUpdate = request.getParameter("txtNombre");
                    float precioUpdate = Float.parseFloat(request.getParameter("txtPrecio"));
                    boolean isVentaLibreUpdate = Boolean.parseBoolean(request.getParameter("chkVentaLibre"));
                    idProducto = (Integer.parseInt(request.getParameter("txtIdEmpleado")));

                    p.setNombre(nombreProductoUpdate);
                    p.setPrecio(precioUpdate);
                    p.setIsVentaLibre(isVentaLibreUpdate);
                    p.setIdProducto(idProducto);

                    g.agregarProducto(p);

                    request.getRequestDispatcher("LoginServlet?menu=Productos&accion=Listar").forward(request, response);

                    break;
                case "Cargar":

                    idProducto = Integer.parseInt(request.getParameter("idProducto"));
                    p = g.getProductoPorId(idProducto);
                    request.setAttribute("productoSeleccionado", p);
                    request.getRequestDispatcher("LoginServlet?menu=Productos&accion=Listar").forward(request, response);

                    break;
                case "Eliminar":

                    idProducto = Integer.parseInt(request.getParameter("idProducto"));
                    g.eliminarProducto(idProducto);
                    request.getRequestDispatcher("LoginServlet?menu=Productos&accion=Listar").forward(request, response);

                    break;
                default:
            }

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/productos.jsp");
            rd.forward(request, response);
        }
        if (menu.equals("Empleados")) {

            switch (accion) {
                case "Listar":
                    ArrayList<Empleado> lista = g.getEmpleados();
                    request.setAttribute("empleados", lista);

                    break;
                case "Agregar":

                    String nombre = request.getParameter("txtNombre");
                    String puesto = request.getParameter("txtPuesto");
                    String usuario = request.getParameter("txtUsuario");
                    String contraseña = request.getParameter("txtContraseña");

                    e.setNombre(nombre);
                    e.setPuesto(puesto);
                    e.setUsuario(usuario);
                    e.setContraseña(contraseña);

                    g.agregarEmpleado(e);
                    //g.agregarEmpleado((Empleado) request.getSession().getAttribute("empleado"));
                    request.getRequestDispatcher("LoginServlet?menu=Empleados&accion=Listar").forward(request, response);

                    break;
                case "Actualizar":

                    String nombreUpdate = request.getParameter("txtNombre");
                    String puestoUpdate = request.getParameter("txtPuesto");
                    String usuarioUpdate = request.getParameter("txtUsuario");
                    String contraseñaUpdate = request.getParameter("txtContraseña");
                    idEmpleado = (Integer.parseInt(request.getParameter("txtIdEmpleado")));

                    e.setNombre(nombreUpdate);
                    e.setPuesto(puestoUpdate);
                    e.setUsuario(usuarioUpdate);
                    e.setContraseña(contraseñaUpdate);
                    e.setIdEmpleado(idEmpleado);

                    g.actualizarEmpleado(e);

                    request.getRequestDispatcher("LoginServlet?menu=Empleados&accion=Listar").forward(request, response);

                    break;
                case "Cargar":

                    idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
                    e = g.getEmpleadoPorId(idEmpleado);
                    request.setAttribute("empleadoSeleccionado", e);
                    request.getRequestDispatcher("LoginServlet?menu=Empleados&accion=Listar").forward(request, response);

                    break;
                case "Eliminar":

                    idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
                    g.eliminarEmpleado(idEmpleado);
                    request.getRequestDispatcher("LoginServlet?menu=Empleados&accion=Listar").forward(request, response);

                    break;
                default:
            }

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/empleados.jsp");
            rd.forward(request, response);
        }
        if (menu.equals("Facturas")) {
            switch (accion) {   
                
                case "Generar factura":

                    int idSucursal = Integer.parseInt(request.getParameter("sucursal"));
                    String nombreCliente = request.getParameter("nombreCliente");
                    int idEmpleado = Integer.parseInt(request.getParameter("empleado"));
                    int numeroReceta = Integer.parseInt(request.getParameter("numeroReceta"));
                    s = new Sucursal(idSucursal);
                    e = new Empleado(idEmpleado);

                    f.setS(s);
                    f.setNombreCliente(nombreCliente);
                    f.setE(e);
                    f.setNumeroReceta(numeroReceta);

                    g.agregarFactura(f);
                    request.getRequestDispatcher("LoginServlet?menu=Ventas&accion=Listar").forward(request, response);
                    break;
                default:
            }
            request.getRequestDispatcher("facturas.jsp").forward(request, response);
        }
        if (menu.equals("Ventas")) {
            switch (accion) {
                
                case "Listar":
                    ArrayList<Venta> listav = new ArrayList<>();
                    request.getSession().setAttribute("ventas", listav);
                    break;

                case "BuscarProducto":
                    idProducto = Integer.parseInt(request.getParameter("idProducto"));
                    p = g.ConsultaPorCodigo(idProducto);
                    request.setAttribute("productoSeleccionado", p);
                    break;

                case "AgregarProducto":
                    totalapagar = 0;
                    v = new Venta();
                    item++;
//                    idFactura = Integer.parseInt(request.getParameter("factura"));
                    idProducto = Integer.parseInt(request.getParameter("idProducto"));
                    nombreProducto = request.getParameter("nombreproducto");
                    precio = Float.parseFloat(request.getParameter("precioproducto"));
                    cantidad = Integer.parseInt(request.getParameter("cantidadproducto"));
                    subtotal = precio * cantidad;
                    //.setItem(item);
//                    d.setP(p);

//                    p = new Producto(idProducto, nombreProducto);
//                    d.setIdDetalleFactura(p.getIdProducto());
                    Factura f2 = new Factura(idFactura);
                    d.setF(f2);
                    Producto p2 = new Producto(idProducto);
                    d.setP(p2);
                    d.setCantidad(cantidad);
                    d.setPrecio(subtotal);
                    
                    v.setIdProducto(p.getIdProducto());
                    v.setNombreProducto(nombreProducto);
                    v.setCantidad(cantidad);
                    v.setPrecio(precio);
                    v.setSubtotal(subtotal);
                    
                    listaDetalleFactura = (ArrayList<DetalleFactura>) request.getSession().getAttribute("detalleFactura");
                    listaDetalleFactura.add(d);
                    request.getSession().setAttribute("detalle", listaDetalleFactura);
                    
                    listaVentas = (ArrayList<Venta>) request.getSession().getAttribute("ventas");
                    listaVentas.add(v);
                    request.getSession().setAttribute("ventas", listaVentas);
                    System.err.println("error venta");
//                    request.setAttribute("listaventas", listaVentas);

//                    for (int i = 0; i < listaVentas.size(); i++) {
//                        totalapagar += listaVentas.get(i).getSubtotal();
//                    }
//                    NumberFormat formatoNumero1 = NumberFormat.getNumberInstance();
//                    String total1 = formatoNumero1.format(totalapagar);
//                    request.setAttribute("totalapagar", total1);
                    break;
            }
            request.getRequestDispatcher("generarVenta.jsp").forward(request, response);
        }
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
