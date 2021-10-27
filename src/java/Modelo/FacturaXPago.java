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
public class FacturaXPago {
    
    private FormaDePago formaDePago;
    private Factura factura;
    private float montoAbonado;

    public FacturaXPago(FormaDePago formaDePago, Factura factura, float montoAbonado) {
        this.formaDePago = formaDePago;
        this.factura = factura;
        this.montoAbonado = montoAbonado;
    }

    public FormaDePago getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(FormaDePago formaDePago) {
        this.formaDePago = formaDePago;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public float getMontoAbonado() {
        return montoAbonado;
    }

    public void setMontoAbonado(float montoAbonado) {
        this.montoAbonado = montoAbonado;
    }
    
    
}
