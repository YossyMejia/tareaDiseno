/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Date;
import modelo.Horario;
import modelo.Servicio;
import modelo.Clase;


/**
 *
 * @author kcorr
 */
public class Controller {
    Sala sala;
    
 
    public Controller(){
        
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
    
    public ArrayList<Clase> allClasses(){
        return this.sala.controlClase.getClases();
    }
    
    public void createClient(String pNombre, String pApellido, String pCedula, String pTelefono, String pCorreo, String pPassword,
            Date pMatricula, Date pUltimoPago){
        this.sala.controlCliente.postCliente(pNombre, pApellido, pCedula, pTelefono, pCorreo, pPassword,pMatricula, pUltimoPago);
    }

    
    
    

    

    
    
    
  
}
