/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import modelo.Horario;
import modelo.Instructor;
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
    
    public void nuevoInstructor(String pNombre, String pApellido, String pCedula, String pTelefono, String pCorreo, String pPassword, 
            String  pEstado, ArrayList<Servicio> pServicios){
        this.sala.controlInstructor.postInstructor(pNombre, pApellido, pCedula, pTelefono, pCorreo, pPassword, pEstado, pServicios);
        
    }
    
    /**
     *
     * @param pNombre
     * @param pCapacidad
     * @param pMontoMensual
     * @param pMontoMatricula
     * @param pHorario
     */
    public void createSala(String pNombre, int pCapacidad, double pMontoMensual,double pMontoMatricula, Horario pHorario){
        
        this.sala = new Sala(pNombre,pCapacidad,pMontoMensual,pMontoMatricula,pHorario);
    }
    
    public void createServicio(String pNombre, String pDescripcion){
        this.sala.controlServicio.postServicio(pNombre,pDescripcion);
    }
    
    public ArrayList<Servicio> allServicios(){
        return this.sala.controlServicio.getServicios();
    }
    
    public ArrayList<Instructor> allInstructores(){
        return this.sala.controlInstructor.getInstructores();
    }
    
    public ArrayList<Clase> allClaseMes(){
        return this.sala.listaControlClase.get( this.sala.listaControlClase.size()-1 ).getClases();
    }
    public void createClient(String pNombre, String pApellido, String pCedula, String pTelefono, String pCorreo, String pPassword,
            Date pMatricula, Date pUltimoPago){
        this.sala.controlCliente.postCliente(pNombre, pApellido, pCedula, pTelefono, pCorreo, pPassword,pMatricula, pUltimoPago);
    }

    
    public void nuevaClase(int pCapacidad,String dia,LocalTime horaInicio,LocalTime horaFinal, Instructor pInstructor, Servicio pServicio){
        this.sala.listaControlClase.get( this.sala.listaControlClase.size()-1 ).postClase( pCapacidad,dia,horaInicio,horaFinal,pInstructor,pServicio);
    
    }


    

    

    
    
    
  
}
