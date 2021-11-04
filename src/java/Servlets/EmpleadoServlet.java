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
@WebServlet(name = "EmpleadoServlet", urlPatterns = {"/EmpleadoServlet"})
public class EmpleadoServlet extends HttpServlet {
    Empleado e = new Empleado();
    GestorBD g = new GestorBD();

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
        int idEmpleado;

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
                    request.getRequestDispatcher("EmpleadoServlet?menu=Empleados&accion=Listar").forward(request, response);

                    break;
                case "Actualizar":

                    Empleado e1 = new Empleado();
                    String nombreUpdate = request.getParameter("txtNombre");
                    String puestoUpdate = request.getParameter("txtPuesto");
                    String usuarioUpdate = request.getParameter("txtUsuario");
                    String contraseñaUpdate = request.getParameter("txtContraseña");
                    idEmpleado = (Integer.parseInt(request.getParameter("txtIdEmpleado")));

                    e1.setNombre(nombreUpdate);
                    e1.setPuesto(puestoUpdate);
                    e1.setUsuario(usuarioUpdate);
                    e1.setContraseña(contraseñaUpdate);
                    e1.setIdEmpleado(idEmpleado);

                    g.agregarEmpleado(e1);

                    request.getRequestDispatcher("EmpleadoServlet?menu=Empleados&accion=Listar").forward(request, response);

                    break;
                case "Cargar":

                    idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
                    Empleado e = g.getEmpleadoPorId(idEmpleado);
                    request.setAttribute("empleadoSeleccionado", e);
                    request.getRequestDispatcher("EmpleadoServlet?menu=Empleados&accion=Listar").forward(request, response);

                    break;
                case "Eliminar":

                    idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
                    g.eliminarEmpleado(idEmpleado);
                    request.getRequestDispatcher("EmpleadoServlet?menu=Empleados&accion=Listar").forward(request, response);

                    break;
            }

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/empleados.jsp");
            rd.forward(request, response);
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
