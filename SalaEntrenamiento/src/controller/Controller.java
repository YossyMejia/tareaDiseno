/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import modelo.Clase;
import modelo.Cliente;
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
    
    public ArrayList<Cliente> allClientes(){
        return this.sala.controlCliente.getClientes();
    }
    
    public ArrayList<Clase> allClases() {
        return this.sala.controlClase.getClases();
    }
    
}
