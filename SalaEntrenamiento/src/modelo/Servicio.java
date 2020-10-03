/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author admin
 */


public class Servicio {
        private String nombreEvento;
        private String descripcion;
/**
 * 
 * @param pNombreEvento
 * @param pDescripcion 
 */
    public Servicio(String pNombreEvento, String pDescripcion){
        nombreEvento=pNombreEvento;
        descripcion=pDescripcion;
    }
        
    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
        
        
        
}
