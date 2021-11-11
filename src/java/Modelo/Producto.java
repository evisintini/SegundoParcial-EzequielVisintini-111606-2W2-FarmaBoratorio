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
public class Producto {
    
    private int idProducto;
    private String nombre;
    private float precio;
    private boolean isVentaLibre;

    public Producto() {
    }

    public Producto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    public Producto(int idProducto, String nombre, float precio) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
    }

    
    public Producto(int idProducto, String nombre) {
        this.idProducto = idProducto;
        this.nombre = nombre;
    }
        
    public Producto(int idProducto, String nombre, float precio, boolean isVentaLibre) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.isVentaLibre = isVentaLibre;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public boolean isIsVentaLibre() {
        return isVentaLibre;
    }

    public void setIsVentaLibre(boolean isVentaLibre) {
        this.isVentaLibre = isVentaLibre;
    }
    
    
}
