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
public class Factura {
    
    private int idFactura;
    private Sucursal s;
    private String fecha;
    private Cliente c;
    private Empleado e;
    private Receta r;

    public Factura(int idFactura, Sucursal s, String fecha, Cliente c, Empleado e, Receta r) {
        this.idFactura = idFactura;
        this.s = s;
        this.fecha = fecha;
        this.c = c;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Cliente getC() {
        return c;
    }

    public void setC(Cliente c) {
        this.c = c;
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
