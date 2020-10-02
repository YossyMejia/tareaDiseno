/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Date;
import modelo.Clase;
import modelo.Cliente;
import modelo.Instructor;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import modelo.Horario;
import modelo.Servicio;

/**
 *
 * @author Steven
 */
public class ControlClase {
    private ArrayList<Clase> clases=new ArrayList<Clase>();
    private String mesActual;  
    
    public ControlClase(){
        Month mesActual = LocalDate.now().getMonth();
        this.mesActual=mesActual.toString();
    }
    
    
    public ArrayList<Clase> getClases() {
        return clases;
    }
    
    public void postClase(int pCapacidad,String pDia,LocalTime pHoraInicio,LocalTime pHoraFinal ,Instructor pInstructor, Servicio pServicio) {
        Horario h = new Horario(pDia,pHoraInicio,pHoraFinal);
        Clase c = new Clase(pCapacidad, h, pInstructor,pServicio);
        clases.add(c);
    }
    
    public void reservarClase(Cliente pCliente, Clase pClase ) {
        for (int i=0;i<clases.size();i++){
            if(clases.get(i) == pClase) {
                clases.get(i).addCliente(pCliente);     //El modelo de Clase debería tener un método addCliente() para agregar un nuevo cliente en el array de clientes
            }
        } 
    }
    
    public Clase getClase(int pIdClase) {
        for (int i=0;i<clases.size();i++){
            if(clases.get(i).getIdClase() == pIdClase) return clases.get(i); //Falta un identificador en el modelo de Clase para poder identificar cada una de las clases
        }                    
        return null;
    }
    
    public void sustituirInstructor(Instructor pInstructor, Clase pClase) {
        for (int i=0;i<clases.size();i++){
            if(clases.get(i) == pClase) clases.get(i).setInstructor(pInstructor); //En el modelo del Instructor, la función setInstructor() debería asignar un sólo istructor en lugar de un arreglo de instructores
        } 
    }
    
    public void setMesActual(String pMesActual) {
        this.mesActual=pMesActual;
    }
    
    public String getMesActual() {
        return mesActual;
    }
}
