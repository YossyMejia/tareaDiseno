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
    private ArrayList<Cliente> clientes=new ArrayList<Cliente>();

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    
    public void postCliente(Cliente cliente) {
        clientes.add(cliente);
    }
    
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
