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
    private int stock;
    private boolean isVentaLibre;

    public Producto(int idProducto, String nombre, float precio, int stock, boolean isVentaLibre) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isIsVentaLibre() {
        return isVentaLibre;
    }

    public void setIsVentaLibre(boolean isVentaLibre) {
        this.isVentaLibre = isVentaLibre;
    }
    
    
}
