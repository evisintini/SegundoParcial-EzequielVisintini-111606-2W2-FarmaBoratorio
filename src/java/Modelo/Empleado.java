/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author 2w50 111606 Ezequiel Favio Visintini
 */
public class Empleado {
    
    private int idEmpleado;
    private Persona p;
    private String puesto;
    private String usuario;
    private String contraseña;

    public Empleado(int idEmpleado, Persona p, String puesto, String usuario, String contraseña) {
        this.idEmpleado = idEmpleado;
        this.p = p;
        this.puesto = puesto;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Persona getP() {
        return p;
    }

    public void setP(Persona p) {
        this.p = p;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
}
