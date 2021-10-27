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
public class Receta {
    
    private int idReceta;
    private int matriculaMedico;
    private String nombreMedico;

    public Receta(int idReceta, int matriculaMedico, String nombreMedico) {
        this.idReceta = idReceta;
        this.matriculaMedico = matriculaMedico;
        this.nombreMedico = nombreMedico;
    }

    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public int getMatriculaMedico() {
        return matriculaMedico;
    }

    public void setMatriculaMedico(int matriculaMedico) {
        this.matriculaMedico = matriculaMedico;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }
    
    
}
