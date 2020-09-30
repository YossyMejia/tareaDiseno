/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author XPC
 */
public class ControlServicio {
    private ArrayList<Servicio> servicio;

    public ControlServicio() {
    }

    public <any> getServicio() {
        return servicio;
    }

    public void setServicio(<any> servicio) {
        this.servicio = servicio;
    }
    
    public ArrayList<Servicio> getServicio(int key){
        //Crear un servicio en quemado anadirlo al array y retornarlo
        this.servicio.add(); //objeto servicio
        return this.servicio;
    }
            
    public boolean postServicio(Servicio servicio){
        boolean estado = false;
        //Hacer un guardado del servicio
        return estado;
    }    
    
    public boolean deleteServicio(int key){
        boolean estado = false;
        //Hacer un delete del array
        return estado;
    }
            
    public ArrayList<Servicio> getServicios(){
        //Crear servicios en quemado anadirlo al array y retornarlo
        this.servicio.add(); //objeto servicio
        return this.servicio;
    }
    
    public boolean modifyServicio(Servicio servicio){
        boolean estado = false;
        //Hacer un modify del objeto en el array
        return estado;
    }
    
}
