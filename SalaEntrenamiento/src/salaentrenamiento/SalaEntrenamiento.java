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
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import modelo.Cliente;
import modelo.Clase;
import modelo.Horario;
import modelo.Instructor;
import modelo.Servicio;

/**
 *
 * @author admin
 */
enum Estado {
    TEMPORAL, FIJO, INVITADO;
}

enum Dia {
    LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO;
}

public class SalaEntrenamiento {

    public static Controller control;//la variable que contiene el controlador, la cual a su vez contiene la sala

    public void leerArchivo(String archivo) throws FileNotFoundException, IOException {//recibe una ruta y imprime linea por linea
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            System.out.println(cadena);
        }
        b.close();
    }

//        public bool void menuSalir(){
//            System.out.println("Desea escoger otra opcion");
//            System.out.println("1. Si");
//            System.out.println("2. No");
//            System.out.println("digite el numero");
//            entrada=
//            
//        }
    public static void crearSala() {
        Scanner entrada = new Scanner(System.in);
        String nombre;
        String horaApertura;
        String horaCierre;
        double costoMatricula;
        double mensualidad;
        int capacidadMaxima;
        int aforoActual;
        System.out.println("-----Configuracion de Sala-----" + "\n");
        System.out.println("Ingrese el nombre de la Sala ");
        nombre = entrada.nextLine();
        System.out.println("Ingrese Hora de Apertura formato HH:mm");
        horaApertura = entrada.nextLine();
        System.out.println("Ingrese Hora de Cierre formato HH:mm");
        horaCierre = entrada.nextLine();
        System.out.println("Ingrese el costo de la matricula");
        costoMatricula = entrada.nextDouble();
        System.out.println("Ingrese el costo de la mensualidad");
        mensualidad = entrada.nextDouble();
        System.out.println("Ingrese la cantidad Maxima de la Sala");
        capacidadMaxima = entrada.nextInt();
        System.out.println("Ingrese el aforo actual");
        aforoActual = entrada.nextInt();
        LocalTime horaX = LocalTime.of(8, 10);
        LocalTime horaY = LocalTime.of(22, 00);
        Horario horario = new Horario(horaX, horaY);
        control.createSala(nombre, capacidadMaxima, mensualidad, costoMatricula, horario);//se crea el objeto sala en el controlador

    }

    public static void registrarServicios() {
        Scanner entrada = new Scanner(System.in);
        String nombre, descripcion;
        System.out.println("---- Registrar Servicio ----");
        System.out.println("Ingrese el nombre del servicio que desea anadir");
        nombre = entrada.nextLine();
        System.out.println("Ingrese la descripcion del servicio");
        descripcion = entrada.nextLine();
        control.createServicio(nombre, descripcion);
    }

    public static void allServicios() {
        ArrayList<Servicio> lista = control.allServicios();
        for (Servicio s : lista) {
            System.out.println("Servicio: " + s.getNombreEvento());
            System.out.println("Descripcion: " + s.getDescripcion());
            System.out.println("-----------------------------------------");
        }
    }

    public static void registroInstructores() {
        Scanner entrada = new Scanner(System.in);
        String nombre, apellido, cedula, telefono, correo, passw;
        int x = 0;
        boolean iter = true;
        //ArrayList<Servicio> servicio;
        System.out.println("----- Creacion de Instructores -----" + "\n");
        System.out.println("Ingrese su nombre");
        nombre = entrada.nextLine();
        System.out.println("Ingrese su apellido");
        apellido = entrada.nextLine();
        System.out.println("Ingrese su cedula");
        cedula = entrada.nextLine();
        System.out.println("Ingrese su telefono. Formato: ####-####");
        telefono = entrada.nextLine();
        System.out.println("Ingrese su correo");
        correo = entrada.nextLine();
        System.out.println("Ingrese su contrasena");
        passw = entrada.nextLine();
        ArrayList<Servicio> listaServicios = control.allServicios();
        ArrayList<Servicio> serviciosInstructor = new ArrayList<Servicio>();
        while (iter = true) {
            for (int i = 0; i < listaServicios.size(); i++) {// imprime todos los servicios 
                System.out.println(Integer.toString(i) + ". " + listaServicios.get(i).getNombreEvento());
                System.out.println("Escriba el numero del servicio que ofrece o -1 para Salir");
                if (x == -1) {
                    iter = false;
                } else {
                    x = entrada.nextInt();
                    serviciosInstructor.add(listaServicios.get(x));
                    System.out.println("Desea ingresar otra opcion");
                    System.out.println("1. Si");
                    System.out.println("2. No");
                    System.out.println("digite una opcion");
                    x = entrada.nextInt();
                    if (x != 1) {
                        iter = false;
                    }
                }
            }
        }
        control.nuevoInstructor(nombre, apellido, cedula, telefono, correo, passw, Estado.FIJO.name(), listaServicios);
    }

    public static void allInstructores() {
        ArrayList<Instructor> lista = control.allInstructores();
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + 1);
            System.out.println(lista.get(i).getNombre() + " " + lista.get(i).getApellido());
            System.out.println("Servicios: ");
            for (int x = 0; x < lista.get(i).getServicios().size(); x++) {
                System.out.println(lista.get(i).getServicios().get(x).getNombreEvento());
            }
        }

    }

    public static void calendario() {
        ArrayList<Clase> listita = control.allClaseMes();
        for (int c = 0; c < listita.size(); c++) {
            System.out.println(listita.get(c).getServicio().getNombreEvento());
            System.out.println(listita.get(c).getHorario().getDia());
            System.out.println(listita.get(c).getHorario().getHoraInicio());
            System.out.println(listita.get(c).getHorario().getHoraFinal());
        }
    }

    public static void matriculaCliente() {
        System.out.println("----- Matricular cliente -----" + "\n");

        //Ingresar los datos de la persona
        Scanner entrada = new Scanner(System.in);
        String nombre, apellido, cedula, telefono, correo, passw;
        System.out.println("Ingrese su nombre");
        nombre = entrada.nextLine();
        System.out.println("Ingrese su apellido");
        apellido = entrada.nextLine();
        System.out.println("Ingrese su cedula");
        cedula = entrada.nextLine();
        System.out.println("Ingrese su telefono. Formato: ####-####");
        telefono = entrada.nextLine();
        System.out.println("Ingrese su correo");
        correo = entrada.nextLine();
        System.out.println("Ingrese su contrasena");
        passw = entrada.nextLine();
        //Fecha de pago de la mensualidad
        Date now = new Date();
        control.createClient(nombre, apellido, cedula, telefono, correo, passw, now, now);
    }

    public static void programarClase() {
        String xhoraInicio, yhoraFinal, dia;
        int numServicio, capacidad;
        Scanner entrada = new Scanner(System.in);
        int num = 0;
        System.out.println("--- Programar Clase -----");
        ArrayList<Instructor> lista = control.allInstructores();
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i);
            System.out.println(lista.get(i).getNombre() + " " + lista.get(i).getApellido());
        }
        System.out.println("Escriba el digito perteneciente a su nombre");
        num = entrada.nextInt();
        Instructor instructor = lista.get(num);
        System.out.println("Calendario Actual");
        calendario();
        System.out.println("Ingrese el numero que corresponda al dia en el que desesa crear la clase");
        int a = 1;
        for (Dia day : Dia.values()) {
            System.out.print(a);
            System.out.println(". " + day);
        }
        int opcion = entrada.nextInt();
        dia = Dia.values()[opcion].name();
        System.out.println("Ingrese la Hora de Inicio");
        xhoraInicio = entrada.nextLine();
        System.out.println("Ingrese la Hora de Finalizacion");
        yhoraFinal = entrada.nextLine();
        System.out.println("Ingrese la Capacidad maxima de Clientes en la clase");
        capacidad = entrada.nextInt();
        for (int w = 0; w < instructor.getServicios().size(); w++) {
            System.out.print(w + 1);
            System.out.println(". " + instructor.getServicios().get(w).getNombreEvento());
        }
        System.out.println("Ingrese el digito que representa el servicio que desea impartir ");
        numServicio = entrada.nextInt();
        String[] arrayInicio = xhoraInicio.split(":", 2);//se parsea la hora para convertirlo a formato localTIme
        int horaI = Integer.parseInt(arrayInicio[0]);
        int minutosI = Integer.parseInt(arrayInicio[1]);
        LocalTime horaInicio = LocalTime.of(horaI, minutosI);

        String[] arrayFinal = yhoraFinal.split(":", 2);
        int horaF = Integer.parseInt(arrayFinal[0]);
        int minutosF = Integer.parseInt(arrayFinal[1]);
        LocalTime horaFinal = LocalTime.of(horaF, minutosF);
        control.nuevaClase(capacidad, dia, horaInicio, horaFinal, instructor, instructor.getServicios().get(numServicio));

    }

    public static void verClase() {
        System.out.println("----- Ver Información de clase -----" + "\n");
        ArrayList Classes = control.allClaseMes();

        //Mostrando las clases disponibles
        Iterator it = Classes.iterator();
        int cont = 1;
        while (it.hasNext()) {
            System.out.println(cont + "-->" + it.next());
            cont++;
        }
        //Respuesta del usuario
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el número de clase que desea visualizar: " + "\n");
        String numClassS = entrada.nextLine();
        int numClass = Integer.parseInt(numClassS);
        //Visualización de la información de la clase
        System.out.println(Classes.get(numClass));
    }

    public static void reservarClase() {
        Scanner entrada = new Scanner(System.in);
        String cedula;
        int opcionClase;
        boolean esCliente = false;

        int x = 0;
        boolean iter = true;
        //ArrayList<Servicio> servicio;
        System.out.println("----- Menú de reserva de espacio para una clase -----" + "\n");
        System.out.println("Por favor ingrese su cédula para poder solicitar un espacio en las clases:");
        cedula = entrada.nextLine();
        Cliente cliente = null;
        for (int i = 0; i < control.allClientes().size(); i++) {
            if (control.allClientes().get(i).getCedula() == cedula) {
                cliente = control.allClientes().get(i);
                esCliente = true;
            }
        }
        if (esCliente) {
            int secuenciaClases = 1;
            System.out.println("Esta es la lista de posibles clases a matricular: ");
            ArrayList<Clase> clases = control.allClaseMes();
            for (int i = 0; i < clases.size(); i++) {
                System.out.println("------------------------------------------------------------------");
                System.out.println("Identificador de la clase: " + secuenciaClases);
                System.out.println("Nombre de la clase: " + clases.get(i).getServicio().getDescripcion() + "\n");
                System.out.println("Instructor: " + clases.get(i).getInstructor().getNombre() + "\n");
                System.out.println("La clase se imparte el día: " + clases.get(i).getHorario().getDia() + "\n");
                System.out.println("Hora de inicio: " + clases.get(i).getHorario().getHoraInicio() + "\n");
                System.out.println("Hora de finalización: " + clases.get(i).getHorario().getHoraFinal() + "\n");
                System.out.println("------------------------------------------------------------------");
                System.out.println("\n\n");
                secuenciaClases++;
            }
            System.out.println("Ingrese el número de identificador de la clase que desea matricular " + "\n");
            opcionClase = entrada.nextInt() - 1;
            if (opcionClase >= secuenciaClases) {
                System.out.println("El identificador no pertenece a ningúna de nuestras clases, por favor verifique que sea un identificador válido");
            } else {
                control.reservarEspacio(cedula, clases.get(opcionClase).getIdClase());
                System.out.println("Usted se ha matriculado correctamente en la clase con el identificador: " + opcionClase + 1 + "\n");
            }
        } else {
            System.out.println("Su cédula no se encuentra registrada en el sistema, por favor ingrese una cédula válida para poder reservar un espacio en las clases");
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion;
        System.out.println(" Bienvenido al Sistema De Gestion del Gimnasio ");
        System.out.println(" ------ Menu Principal ------");
        System.out.println(" 1. Crear Sala ");
        System.out.println(" 2. Registro de Servicios ");
        System.out.println(" 3. Ver todos los servicios ");
        System.out.println(" 4. Registro de Instructores ");
        System.out.println(" 5. Visualizacion de Instructores ");
        System.out.println(" 6. Matricula de Cliente ");
        System.out.println(" 7. Programar Clase ");
        System.out.println(" 8. Reservar Clase ");
        System.out.println(" 9. Ver Clase ");
        opcion = entrada.nextInt();

        switch (opcion) {
            case 1:
                crearSala();
                break;
            case 2:
                registrarServicios();
                break;
            case 3:
                allServicios();
                break;
            case 4:
                registroInstructores();
                break;
            case 5:
                allInstructores();
                break;
            case 6:
                matriculaCliente();
                break;
            case 7:
                programarClase();
                break;
            case 8: 
                reservarClase();
                break;
            case 9:
                verClase();

        }

    }

}
