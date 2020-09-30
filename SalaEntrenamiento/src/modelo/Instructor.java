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
    private Estado estado;
    private ArrayList<Servicio> servicios;

    public Instructor(String pNombre, String pApellido, String pCedula, String pTelefono, String pCorreo, String pPassword, 
            Estado pEstado, ArrayList<Servicio> pServicios) {
        super(pNombre, pApellido, pCedula, pTelefono, pCorreo, pPassword);
        estado=pEstado;
        servicios=pServicios;
    }


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
