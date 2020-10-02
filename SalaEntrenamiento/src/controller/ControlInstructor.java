/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import modelo.Estado;
import modelo.Instructor;
import modelo.Servicio;

/**
 *
 * @author XPC
 */
public class ControlInstructor {
    
    private ArrayList<Instructor> instructor;

    public ControlInstructor() {
    }

//    public Instructor getInstructor() {
//        return this.instructor.find;
//    }

    public void postInstructor(String pNombre, String pApellido, String pCedula, String pTelefono, String pCorreo, String pPassword, 
            Estado pEstado, ArrayList<Servicio> pServicios) {
        Instructor instructor = new Instructor(pNombre, pApellido,pCedula, pTelefono, pCorreo,pPassword, pEstado,pServicios);
        this.instructor.add(instructor);
    }
    
//    public ArrayList<Instructor> getInstructores(){
//        //Tomar el arreglo de instructores
//        this.instructor.add();
//        return this.instructor;
//    }
//    
//    public arrayList<Instructor> getServiciosInstructor(){
//        //Tomar el arreglo de la clase instructor
//        return instructor;
//    }
//    
    public boolean postServiciosInstructor(int key){
        
    }
    
}
