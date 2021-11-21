/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import GestorBD.GestorBD;
import Modelo.DetalleFactura;
import Modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 2w50 111606 Ezequiel Favio Visintini
 */
@WebServlet(name = "GenerarVentaServlet", urlPatterns = {"/GenerarVentaServlet"})
public class GenerarVentaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        Producto p = new Producto();
        GestorBD g = new GestorBD();

        if (menu.equals("Ventas")) {
            switch (accion) {

                case "Listar":
                    ArrayList<DetalleFactura> listaDetalleFactura = new ArrayList<>();
                    request.getSession().setAttribute("listaDetalle", listaDetalleFactura);

                    break;
            }
            request.getRequestDispatcher("generarVenta.jsp").forward(request, response);
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

        Producto p = new Producto();
        GestorBD g = new GestorBD();
        ArrayList<DetalleFactura> listaDetalleFactura;
        int idProducto;

        if (menu.equals("Ventas")) {
            switch (accion) {
                case "BuscarProducto":
                    idProducto = Integer.parseInt(request.getParameter("idProducto"));
                    p = g.ConsultaPorCodigo(idProducto);
                    request.setAttribute("productoSeleccionado", p);

                    break;

                case "AgregarProducto":

                    int cantidad;
                    float precio;
                    float total = 0;
                    int stock;

                    idProducto = Integer.parseInt(request.getParameter("idProducto"));
                    precio = Float.parseFloat(request.getParameter("precioproducto"));
                    cantidad = Integer.parseInt(request.getParameter("cantidadproducto"));
                    stock = Integer.parseInt(request.getParameter("stock"));

                    int idUltimaFactura = g.getUltimaFactura();
                    request.getSession().setAttribute("idUltimaFactura", idUltimaFactura);
                    System.out.println(idUltimaFactura + " idfactura");

                    DetalleFactura d = new DetalleFactura();

                    d.setIdFactura(idUltimaFactura);
                    d.setIdProducto(idProducto);
                    d.setCantidad(cantidad);
                    d.setPrecio(precio);
                    p.setStock(stock);

                    if (stock > cantidad) {
                        listaDetalleFactura = (ArrayList<DetalleFactura>) request.getSession().getAttribute("listaDetalle");
                        listaDetalleFactura.add(d);

                        for (int i = 0; i < listaDetalleFactura.size(); i++) {
                            total = total + listaDetalleFactura.get(i).getSubtotal();
                        }

                        request.getSession().setAttribute("totalapagar", total);
                    }

                    break;

                case "GenerarVenta":
//                    Para grabar pasarle la listadetallefactura (que esta guardada en la sesion) a un metodo del gestor. 
//                    Debo usar un foreach en GestorBD para que cargue en la base
                    
                    try {
                        total = (float) request.getSession().getAttribute("totalapagar");
                        float totalFinal,
                         txtefectivo,
                         txtdebito,
                         txtcredito = 0;
                   
                        txtefectivo = Float.parseFloat(request.getParameter("txtefectivo"));
                        txtdebito = Float.parseFloat(request.getParameter("txtdebito"));
                        txtcredito = Float.parseFloat(request.getParameter("txtcredito"));

                        txtefectivo = (float) (txtefectivo - (txtefectivo * 0.25));
                        txtcredito = (float) (txtcredito + (txtcredito * 0.10));
                        
                        totalFinal = txtefectivo + txtdebito + txtcredito;
                        request.getSession().setAttribute("totalFinal", totalFinal);
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("error al castear");
                    }

                    listaDetalleFactura = (ArrayList<DetalleFactura>) request.getSession().getAttribute("listaDetalle");
                    g.agregarDetalleFactura(listaDetalleFactura);

                    request.getRequestDispatcher("ConfirmacionServlet").forward(request, response);
                    break;

            }
            request.getRequestDispatcher("generarVenta.jsp").forward(request, response);

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
