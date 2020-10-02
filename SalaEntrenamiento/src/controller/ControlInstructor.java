/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import modelo.Instructor;
import modelo.Servicio;

/**
 *
 * @author XPC
 */
public class ControlInstructor {
    
    private ArrayList<Instructor> instructores= new ArrayList<Instructor>();

    public ControlInstructor() {
    }

//    public Instructor getInstructor() {
//        return this.instructor.find;
//    }

    public void postInstructor(String pNombre, String pApellido, String pCedula, String pTelefono, String pCorreo, String pPassword, 
            String  pEstado, ArrayList<Servicio> pServicios) {
        Instructor instructor = new Instructor(pNombre, pApellido,pCedula, pTelefono, pCorreo,pPassword, pEstado,pServicios);
        this.instructores.add(instructor);
    }
    
    public ArrayList<Instructor> getInstructores(){
        return this.instructores;
    }
   
  
    
}
