/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
// * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author admin
 */


public class Instructor extends Persona{
    private String estado;
    private ArrayList<Servicio> servicios = new ArrayList<Servicio>();

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
            String pEstado, ArrayList<Servicio> pServicios) {
        super(pNombre, pApellido, pCedula, pTelefono, pCorreo, pPassword);
        estado=pEstado;
        for(int i=0;i<pServicios.size();i++){
            servicios.add(pServicios.get(i));
        }

    }




    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }
    
    
    
}
