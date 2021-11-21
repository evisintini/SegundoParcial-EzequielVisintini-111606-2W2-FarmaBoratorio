/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.time.*;
import java.sql.*;
//import java.util.Date;

/**
 *
 * @author 2w50 111606 Ezequiel Favio Visintini
 */
public class Factura {
    
    private int idFactura;
    private int idSucursal;
    private Date fecha;
    private String nombreCliente;
    private int idEmpleado;

    public Factura() {
    }

    public Factura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Factura(int idSucursal, Date fecha, String nombreCliente, int idEmpleado) {
        this.idSucursal = idSucursal;
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.idEmpleado = idEmpleado;
    }

    public Factura(int idFactura, int idSucursal, Date fecha, String nombreCliente, int idEmpleado) {
        this.idFactura = idFactura;
        this.idSucursal = idSucursal;
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.idEmpleado = idEmpleado;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
}
