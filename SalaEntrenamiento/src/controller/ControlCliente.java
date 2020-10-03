/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Date;
import modelo.Cliente;

/**
 *
 * @author Steven
 */
public class ControlCliente {
    private static ArrayList<Cliente> clientes=new ArrayList<Cliente>();

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    
    public Cliente getCliente(String pId){
        for(Cliente c: getClientes()){
            if(c.getCedula().equals(pId)){
                return c;
            }
           
        }
        return null;
    }
    
    public void postCliente(String pNombre, String pApellido, String pCedula, String pTelefono, String pCorreo, String pPassword,
            Date pMatricula, Date pUltimoPago) {
        
        clientes.add(new Cliente(pNombre, pApellido, pCedula, pTelefono, pCorreo, pPassword,pMatricula, pUltimoPago));
    }
//    public void postCliente(String pNombre, String pApellido, String pCedula, String pTelefono, String pCorreo, String pPassword,
//            Date pMatricula, Date pUltimoPago){
//        this.C
//    }
    
    public void pagar(String cedula) {
        for (int i=0;i<clientes.size();i++){
            if(clientes.get(i).getCedula() == cedula) {
                clientes.get(i).setMatricula(new Date());
                clientes.get(i).setEstado();

            }
        }    
    }
    
    public void changeEstado(String cedula) {
        for (int i=0;i<clientes.size();i++){
            if(clientes.get(i).getCedula() == cedula) clientes.get(i).setEstado();  //En la clase cliente debería haber un procedimiento que calcule el nuevo estado a partir de la última fecha de pago y el mes actual
        }
    }   

  
}
