/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
enum Estado{
    TEMPORAL, FIJO, INVITADO;
}

public class Instructor extends Persona{
    public Estado estado;
    private ArrayList<Servicio> servicios;
/**
 * 
 * @param pNombre
 * @param pApellido
 * @param pCedula
 * @param pTelefono
 * @param pCorreo
 * @param pPassword
 * @param pEstado
 * @param pServicios 
 */
    public Instructor(String pNombre, String pApellido, String pCedula, String pTelefono, String pCorreo, String pPassword, 
            Estado pEstado, ArrayList<Servicio> pServicios) {
        super(pNombre, pApellido, pCedula, pTelefono, pCorreo, pPassword);
        estado=pEstado;
        servicios=pServicios;
    }

//    public Instructor() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }


    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }
    
    
    
}
