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

    private int idClase;
    private int capacidad;
    private Horario horario;
    private Instructor instructor;
    private ArrayList<Cliente> cliente = new ArrayList<>();
    private Servicio servicio;
    
    public Clase(int pCapacidad, Horario pHorario, Instructor pInstructor, Servicio pServicio){
        capacidad=pCapacidad;
        horario=pHorario;
        instructor=pInstructor;
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

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public ArrayList<Cliente> getCliente() {
        return cliente;
    }

    public void addCliente(Cliente pCliente) {
        cliente.add(pCliente);
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    
    public int getIdClase() {
        return idClase;
    }

    public void setIdClase(int idClase) {
        this.idClase = idClase;
    }
    
    
}
