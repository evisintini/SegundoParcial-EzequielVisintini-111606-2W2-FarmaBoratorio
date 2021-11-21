/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import GestorBD.GestorBD;
import Modelo.Empleado;
import Modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 2w50 111606 Ezequiel Favio Visintini
 */
@WebServlet(name = "AltaProductoServlet", urlPatterns = {"/AltaProductoServlet"})
public class AltaProductoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        GestorBD g = new GestorBD();
        int idProducto = 0;

        if (menu.equals("Productos")) {
            switch (accion) {
                case "Listar":

                    ArrayList<Empleado> lista = g.getProductos();
                    request.setAttribute("productos", lista);

                    break;

                case "Cargar":

                    Producto p = new Producto();
                    idProducto = Integer.parseInt(request.getParameter("idProducto"));
                    p = g.getProductoPorId(idProducto);
                    request.setAttribute("productoSeleccionado", p);
                    request.getRequestDispatcher("LoginServlet?menu=Productos&accion=Listar").forward(request, response);

                    break;
                case "Eliminar":

                    idProducto = Integer.parseInt(request.getParameter("idProducto"));
                    g.eliminarProducto(idProducto);
                    request.getRequestDispatcher("AltaProductosServlet?menu=Productos&accion=Listar").forward(request, response);

                    break;
                default:
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/productos.jsp");
            rd.forward(request, response);
        }
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
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("Productos")) {
            switch (accion) {
                case "Agregar":
                    Producto p = new Producto();
                    try {
                        String nombre = request.getParameter("txtNombre");
                        float precio = Float.parseFloat(request.getParameter("txtPrecio"));
                        int stock = Integer.parseInt(request.getParameter("txtStock"));

                        p.setNombre(nombre);
                        p.setPrecio(precio);
                        p.setStock(stock);

                        GestorBD g = new GestorBD();
                        g.agregarProducto(p);
                        request.getRequestDispatcher("AltaProductoServlet?menu=Productos&accion=Listar").forward(request, response);
                        break;

                    } catch (Exception e) {
                        System.out.println("Error al castear el combo Tipo Doc y el numero de doc");
                    }
            }
            request.getRequestDispatcher("AltaProductoServlet?menu=Productos&accion=Listar").forward(request, response);
        }
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
