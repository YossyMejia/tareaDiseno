/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.time.LocalTime;

/**
 *
 * @author admin
 */



public class Horario {
    String dia;
    private LocalTime horaInicio;
    private LocalTime horaFinal;
    
    public Horario(String pDia, LocalTime pHoraInicio, LocalTime pHoraFinal){
        dia=pDia;
        horaInicio=pHoraInicio;
        horaFinal=pHoraFinal;
    }
    
    public Horario(LocalTime pHoraInicio, LocalTime pHoraFinal){
        this.horaInicio=pHoraInicio;
        this.horaFinal=pHoraFinal;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String  dia) {
        this.dia = dia;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(LocalTime horaFinal) {
        this.horaFinal = horaFinal;
    }
    
    
    
}
