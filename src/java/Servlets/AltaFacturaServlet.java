/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import GestorBD.GestorBD;
import Modelo.Factura;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 2w50 111606 Ezequiel Favio Visintini
 */
@WebServlet(name = "AltaFacturaServlet", urlPatterns = {"/AltaFacturaServlet"})
public class AltaFacturaServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        GestorBD g = new GestorBD();
        
        if (menu.equals("Facturas")) {
            switch (accion) {

                case "Generar Factura":

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
