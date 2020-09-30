/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Clase {
    private int capacidad;
    private Horario horario;
    private ArrayList<Instructor> instructor;
    private ArrayList<Cliente> cliente;
    private Servicio servicio;
    
    public Clase(int pCapacidad, Horario pHorario, ArrayList<Instructor> pInstructor, ArrayList<Cliente> pCliente, Servicio pServicio){
        capacidad=pCapacidad;
        horario=pHorario;
        instructor=pInstructor;
        cliente=pCliente;
        servicio=pServicio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public ArrayList<Instructor> getInstructor() {
        return instructor;
    }

    public void setInstructor(ArrayList<Instructor> instructor) {
        this.instructor = instructor;
    }

    public ArrayList<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(ArrayList<Cliente> cliente) {
        this.cliente = cliente;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    
    
}
