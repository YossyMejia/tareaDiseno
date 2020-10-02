/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import modelo.Servicio;

/**
 *
 * @author XPC
 */
public class ControlServicio {
    private ArrayList<Servicio> servicios= new ArrayList<Servicio>();

    public ControlServicio() {
    }

    public ArrayList<Servicio> getServicios() {//devuelve todos los servicios
        return servicios;
    }

    public void setServicio(ArrayList<Servicio> servicios) {//setea un arreglo de servicios
        this.servicios = servicios;
    }
 
    
//    public ArrayList<Servicio> getServicio(int key){
//        //Crear un servicio en quemado anadirlo al array y retornarlo
//        this.servicio.add(); //objeto servicio
//        return this.servicio;
//    }
            
    public boolean postServicio(String pNombreEvento,String pDescripcion){// guarda un servicio en el arreglo de servicios
        boolean estado = false;
        Servicio servicio = new Servicio(pNombreEvento,pDescripcion);
        this.servicios.add(servicio);
        return estado;
    } 
    
    public boolean deleteServicio(int key){
        boolean estado = false;
        //Hacer un delete del array
        return estado;
    }

    
    public boolean modifyServicio(Servicio servicio){
        boolean estado = false;
        //Hacer un modify del objeto en el array
        return estado;
    }
   
}
