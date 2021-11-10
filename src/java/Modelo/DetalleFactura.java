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
public class DetalleFactura {
    
    private int idDetalleFactura;
    private Factura f;
    private Producto p;
    private int cantidad;
    private float precio;

    public DetalleFactura() {
    }

    public DetalleFactura(Producto p, int cantidad, float precio) {
        this.p = p;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    
    public DetalleFactura(int idDetalleFactura, Factura f, Producto p, int cantidad, float precio) {
        this.idDetalleFactura = idDetalleFactura;
        this.f = f;
        this.p = p;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getIdDetalleFactura() {
        return idDetalleFactura;
    }

    public void setIdDetalleFactura(int idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    public Factura getF() {
        return f;
    }
    
    public int getIdFactura() {
        return f.getIdFactura();
    }

    public void setF(Factura f) {
        this.f = f;
    }

    public Producto getP() {
        return p;
    }
    
    public String getNombreProducto() {
        return p.getNombre();
    }

    public void setP(Producto p) {
        this.p = p;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    
}
