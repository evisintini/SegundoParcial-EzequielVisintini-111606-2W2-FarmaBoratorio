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
public class ProductosXSucursal {
    
    private Producto p;
    private Sucursal s;
    private int stock;

    public ProductosXSucursal(Producto p, Sucursal s, int stock) {
        this.p = p;
        this.s = s;
        this.stock = stock;
    }

    public Producto getP() {
        return p;
    }

    public void setP(Producto p) {
        this.p = p;
    }

    public Sucursal getS() {
        return s;
    }

    public void setS(Sucursal s) {
        this.s = s;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
}
