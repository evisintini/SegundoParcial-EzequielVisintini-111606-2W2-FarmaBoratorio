/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import GestorBD.GestorBD;
import Modelo.Empleado;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author 2w50 111606 Ezequiel Favio Visintini
 */
@WebServlet(name = "AltaEmpleadoServlet", urlPatterns = {"/AltaEmpleadoServlet"})
public class AltaEmpleadoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        GestorBD g = new GestorBD();
        Empleado e = new Empleado();
        int idEmpleado;

        if (menu.equals("Empleados")) {
            switch (accion) {
                case "Listar":
                    ArrayList<Empleado> lista = g.getEmpleados();
                    request.setAttribute("empleados", lista);

                    break;
                case "Cargar":

                    idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
                    e = g.getEmpleadoPorId(idEmpleado);
                    request.setAttribute("empleadoSeleccionado", e);
                    request.getRequestDispatcher("AltaEmpleadoServlet?menu=Empleados&accion=Listar").forward(request, response);

                    break;
                case "Eliminar":

                    idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
                    g.eliminarEmpleado(idEmpleado);
                    request.getRequestDispatcher("AltaEmpleadoServlet?menu=Empleados&accion=Listar").forward(request, response);

                    break;
                    
                default:
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/empleados.jsp");
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

        if (menu.equals("Empleados")) {
            switch (accion) {

                case "Agregar":
                    
                    

                    try {
                        Empleado e = new Empleado();
                        GestorBD g = new GestorBD();
                        
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

                        request.getRequestDispatcher("AltaEmpleadoServlet?menu=Empleados&accion=Listar").forward(request, response);

                    } catch (Exception ex) {
                        System.out.println("Error al castear el combo Tipo Doc y el numero de doc");
                    }

                    break;

                case "Actualizar":

                    Empleado e = new Empleado();
                    GestorBD g = new GestorBD();
                    
                    String nombreUpdate = request.getParameter("txtNombre");
                    String puestoUpdate = request.getParameter("txtPuesto");
                    String usuarioUpdate = request.getParameter("txtUsuario");
                    String contraseñaUpdate = request.getParameter("txtContraseña");
                    int idEmpleado = (int) request.getSession().getAttribute("txtIdEmpleado");

                    e.setNombre(nombreUpdate);
                    e.setPuesto(puestoUpdate);
                    e.setUsuario(usuarioUpdate);
                    e.setContraseña(contraseñaUpdate);
                    e.setIdEmpleado(idEmpleado);

                    g.actualizarEmpleado(e);

                    request.getRequestDispatcher("AltaEmpleadoServlet?menu=Empleados&accion=Listar").forward(request, response);

                    break;
                    
                default:
            }

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/empleados.jsp");
            rd.forward(request, response);
//            request.getRequestDispatcher("AltaEmpleadoServlet?menu=Empleados&accion=Listar").forward(request, response);
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
