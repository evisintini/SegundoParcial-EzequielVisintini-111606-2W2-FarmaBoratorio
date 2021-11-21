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
public class FormaDePago {
    
    private int idFormasDePago;
    private String nombre;

    public FormaDePago() {
    }

    public FormaDePago(int idFormasDePago, String nombre) {
        this.idFormasDePago = idFormasDePago;
        this.nombre = nombre;
    }

    public int getIdFormasDePago() {
        return idFormasDePago;
    }

    public void setIdFormasDePago(int idFormasDePago) {
        this.idFormasDePago = idFormasDePago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
