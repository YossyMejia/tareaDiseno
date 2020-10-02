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

enum Dia{
    LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO;
}

public class Horario {
    private Dia dia;
    private LocalTime horaInicio;
    private LocalTime horaFinal;
    
    public Horario(Dia pDia, LocalTime pHoraInicio, LocalTime pHoraFinal){
        dia=pDia;
        horaInicio=pHoraInicio;
        horaFinal=pHoraFinal;
    }
    
    public Horario(LocalTime pHoraInicio, LocalTime pHoraFinal){
        this.horaInicio=pHoraInicio;
        this.horaFinal=pHoraFinal;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
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
