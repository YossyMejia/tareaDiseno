/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salaentrenamiento;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import controller.*;
import java.time.LocalTime;
import java.util.ArrayList;
import modelo.Horario;
import modelo.Servicio;

/**
 *
 * @author admin
 */
public class SalaEntrenamiento {
    public static Controller control;//la variable que contiene el controlador, la cual a su vez contiene la sala
    
        public void leerArchivo(String archivo) throws FileNotFoundException, IOException {//recibe una ruta y imprime linea por linea
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            System.out.println(cadena);
        }
        b.close();
    }
        
        public bool void menuSalir(){
            System.out.println("Desea escoger otra opcion");
            System.out.println("1. Si");
            System.out.println("2. No");
            System.out.println("digite el numero");
            entrada=
            
        }
        
    
        public static void menu1(){
            Scanner entrada = new Scanner(System.in);
            ControlServicio cServicio = new ControlServicio();
            ControlCliente cCliente = new ControlCliente();
            ControlClase cClase = new ControlClase();
            ControlInstructor cInstructor = new ControlInstructor();
            String nombre;
            String horaApertura;
            String horaCierre;
            double costoMatricula;
            double mensualidad;
            int capacidadMaxima;
            int aforoActual;
            System.out.println("-----Configuracion de Sala-----"+"\n");
            System.out.println("Ingrese el nombre de la Sala ");
            nombre = entrada.nextLine();
            System.out.println("Ingrese Hora de Apertura formato HH:mm");
            horaApertura= entrada.nextLine();
            System.out.println("Ingrese Hora de Cierre formato HH:mm");
            horaCierre = entrada.nextLine();
            System.out.println("Ingrese el costo de la matricula");
            costoMatricula = entrada.nextDouble();
            System.out.println("Ingrese el costo de la mensualidad");
            mensualidad = entrada.nextDouble();
            System.out.println("Ingrese la cantidad Maxima de la Sala");
            capacidadMaxima = entrada.nextInt();
            System.out.println("Ingrese el aforo actual");
            aforoActual= entrada.nextInt();
            LocalTime horaX= LocalTime.of(8,10);
            LocalTime horaY= LocalTime.of(22,00);
            Horario horario = new Horario(horaX,horaY);
            control.createSala(nombre, capacidadMaxima, mensualidad, costoMatricula, horario, cServicio, cInstructor, cClase, cCliente);//se crea el objeto sala en el controlador
            
        }
        
        public static void main3(){
            Scanner entrada = new Scanner(System.in);
            String nombre,apellido,cedula,telefono,correo,passw;
            int x=0;
            boolean iter=true;
          //ArrayList<Servicio> servicio;
            System.out.println("----- Creacion de Instructores -----"+"\n");
            System.out.println("Ingrese su nombre");
            nombre= entrada.nextLine();
            System.out.println("Ingrese su apellido");
            apellido= entrada.nextLine();
            System.out.println("Ingrese su cedula");
            cedula= entrada.nextLine();
            System.out.println("Ingrese su telefono. Formato: ####-####");
            telefono= entrada.nextLine();
            System.out.println("Ingrese su correo");
            correo= entrada.nextLine();
            System.out.println("Ingrese su contrasena");
            passw= entrada.nextLine();
            ArrayList<Servicio> listaServicios = control.allServicios();
            ArrayList<Servicio> serviciosInstructor= new ArrayList<Servicio>();
            while(iter=true){
                for(int i=0; i<listaServicios.size();i++ ){// imprime todos los servicios 
                    System.out.println(Integer.toString(i)+". "+listaServicios.get(i).getNombreEvento());
                System.out.println("Escriba el numero del servicio que ofrece o -1 para Salir");
                if(x==-1){
                    iter=false;
                }
                else{
                    x=entrada.nextInt();
                    serviciosInstructor.add(listaServicios.get(x));
                    System.out.println("Desea ingresar ");
                    
                }

            }
                
            }
        }


    public static  void main(String[] args) {

        System.out.println("dasd");
        
    }
    
}
