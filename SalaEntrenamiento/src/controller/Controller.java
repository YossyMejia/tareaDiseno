/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import modelo.Horario;
import modelo.Servicio;

/**
 *
 * @author kcorr
 */
public class Controller {
    Sala sala;
    
 
    public Controller(){
        
    }
    
    public void nuevoInstructor(String pNombre, String pApellido, String pCedula, String pTelefono, String pCorreo, String pPassword, 
            String  pEstado, ArrayList<Servicio> pServicios){
        this.sala.controlInstructor.postInstructor(pNombre, pApellido, pCedula, pTelefono, pCorreo, pPassword, pEstado, pServicios);
        
    }
    
    public void createSala(String pNombre, int pCapacidad, double pMontoMensual,double pMontoMatricula,Horario pHorario,ControlServicio pControlServicio,  
            ControlInstructor pControlInstructor, ControlClase pControlClase, ControlCliente pControlCliente){
        this.sala = new Sala(pNombre,pCapacidad,pMontoMensual,pMontoMatricula,pHorario,pControlServicio,pControlInstructor,pControlClase,pControlCliente);
    }
    
    public void createServicio(String pNombre, String pDescripcion){
        this.sala.controlServicio.postServicio(pNombre,pDescripcion);
    }
    
    public ArrayList<Servicio> allServicios(){
        return this.sala.controlServicio.getServicios();
    }


    

    

    
    
    
  
}
