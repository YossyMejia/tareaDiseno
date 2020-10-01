/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Time;

/**
 *
 * @author admin
 */

enum Dia{
    LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO;
}

public class Horario {
    private Dia dia;
    private Time horaInicio;
    private Time horaFinal;
    
    public Horario(Dia pDia, Time pHoraInicio, Time pHoraFinal){
        dia=pDia;
        horaInicio=pHoraInicio;
        horaFinal=pHoraFinal;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Time horaFinal) {
        this.horaFinal = horaFinal;
    }
    
    
    
}
