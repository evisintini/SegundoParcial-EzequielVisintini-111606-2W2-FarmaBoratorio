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
public class Cliente {
    
    private int idCliente;
    private Persona p;
    private String ultimaCompra;

    public Cliente(int idCliente, Persona p, String ultimaCompra) {
        this.idCliente = idCliente;
        this.p = p;
        this.ultimaCompra = ultimaCompra;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Persona getP() {
        return p;
    }

    public void setP(Persona p) {
        this.p = p;
    }

    public String getUltimaCompra() {
        return ultimaCompra;
    }

    public void setUltimaCompra(String ultimaCompra) {
        this.ultimaCompra = ultimaCompra;
    }
    
    
}
