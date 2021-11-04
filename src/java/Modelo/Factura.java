/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.time.*;
//import java.util.Date;

/**
 *
 * @author 2w50 111606 Ezequiel Favio Visintini
 */
public class Factura {
    
    private int idFactura;
    private Sucursal s;
    private LocalDate fecha;
    private String nombreCliente;
    private Empleado e;
    private Receta r;

    public Factura(int idFactura, Sucursal s, LocalDate fecha, String nombreCliente, Empleado e, Receta r) {
        this.idFactura = idFactura;
        this.s = s;
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.e = e;
        this.r = r;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Sucursal getS() {
        return s;
    }

    public void setS(Sucursal s) {
        this.s = s;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Empleado getE() {
        return e;
    }

    public void setE(Empleado e) {
        this.e = e;
    }

    public Receta getR() {
        return r;
    }

    public void setR(Receta r) {
        this.r = r;
    }

    
    
    
}
