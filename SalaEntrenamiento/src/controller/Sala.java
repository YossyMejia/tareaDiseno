/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import modelo.Horario;

/**
 *
 * @author admin
 */
public class Sala {
    private String nombre;
    private int capacidadMaxima;
    private double montoMensual;
    public ControlServicio controlServicio;
    private double montoMatricula;
    public ControlInstructor controlInstructor;
    public ArrayList<ControlClase> listaControlClase;
    public ControlCliente controlCliente;
    private final Horario horario;
    private Month mesActual;
    /**
     * 
     * @param pNombre
     * @param pCapacidad
     * @param pMontoMensual
     * @param pMontoMatricula
     * @param pHorario
     * @param pControlServicio
     * @param pControlInstructor
     * @param pControlClase
     * @param pControlCliente 
     */
    public Sala(String pNombre, int pCapacidad, double pMontoMensual,double pMontoMatricula,Horario pHorario){
        nombre=pNombre;
        capacidadMaxima=pCapacidad;
        montoMensual=pMontoMensual;
        controlServicio=new ControlServicio();
        montoMatricula=pMontoMatricula;
        controlInstructor=new ControlInstructor();
        controlClase= new ArrayList<ControlClase>();
        controlCliente=new ControlCliente();
        this.horario=pHorario;
        controlClase.add(new ControlClase());
        mesActual= LocalDate.now().getMonth();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public double getMontoMensual() {
        return montoMensual;
    }

    public void setMontoMensual(double montoMensual) {
        this.montoMensual = montoMensual;
    }

    public ControlServicio getControlServicio() {
        return controlServicio;
    }

    public void setControlServicio(ControlServicio controlServicio) {
        this.controlServicio = controlServicio;
    }

    public double getMontoMatricula() {
        return montoMatricula;
    }

    public void setMontoMatricula(double montoMatricula) {
        this.montoMatricula = montoMatricula;
    }

    public ControlInstructor getControlInstructor() {
        return controlInstructor;
    }

    public void setControlInstructor(ControlInstructor controlInstructor) {
        this.controlInstructor = controlInstructor;
    }



    public ControlCliente getControlCliente() {
        return controlCliente;
    }

    public void setControlCliente(ControlCliente controlCliente) {
        this.controlCliente = controlCliente;
    }
    
    
    
}
