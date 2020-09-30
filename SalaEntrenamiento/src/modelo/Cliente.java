/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author admin
 */
enum EstadoCliente{
    MOROSO, ACTIVO, INACTIVO;
}

public class Cliente extends Persona{
    private EstadoCliente estado;
    private Date matricula;
    private Date ultimoPago;
    
    public Cliente (String pNombre, String pApellido, String pCedula, String pTelefono, String pCorreo, String pPassword,
            EstadoCliente pEstado, Date pMatricula, Date pUltimoPago){
        super(pNombre, pApellido, pCedula, pTelefono, pCorreo, pPassword);
        estado=pEstado;
        matricula=pMatricula;
        ultimoPago=pUltimoPago;
    }

    public EstadoCliente getEstado() {
        return estado;
    }

    public void setEstado() {
        // CONSIDERO QUE ACÁ DEBE IR LA LÓGICA PARA CAMBIAR EL ESTADO SEGÚN LA FECHA ACTUAL Y EL ÚLTIMO PAGO 
        // DEL CLIENTE, ADEMÁS QUE ACÁ ESTÁ EL ENUM QUE SE NECESITA, PERO NO ESTOY SEGURO JAJA
        this.estado = estado.ACTIVO;
    }
    
    public void setEstado(EstadoCliente estado) {
        this.estado = estado;
    }

    public Date getMatricula() {
        return matricula;
    }

    public void setMatricula(Date matricula) {
        this.matricula = matricula;
    }

    public Date getUltimoPago() {
        return ultimoPago;
    }

    public void setUltimoPago(Date ultimoPago) {
        this.ultimoPago = ultimoPago;
    }
    
    
}
