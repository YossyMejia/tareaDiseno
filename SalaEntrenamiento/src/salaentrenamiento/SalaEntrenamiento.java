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

    /**
     *
     */
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
        int horaApertura, minutoApertura;
        int horaCierre, minutoCierre;
        double costoMatricula;
        double mensualidad;
        int capacidadMaxima;
        int aforoActual;
        System.out.println("-----Configuracion de Sala-----" + "\n");
        System.out.println("Ingrese el nombre de la Sala ");
        nombre = entrada.nextLine();

        System.out.println("Ingrese Hora de Apertura formato 24H");
        minutoApertura = entrada.nextInt();

        System.out.println("Ingrese el minuto de apertura");
        horaApertura = entrada.nextInt();

        System.out.println("Ingrese Hora de Cierre formato 24H");
        horaCierre = entrada.nextInt();

        System.out.println("Ingrese Minuto de Cierre");
        minutoCierre = entrada.nextInt();

        System.out.println("Ingrese el costo de la matricula");
        costoMatricula = entrada.nextDouble();
        System.out.println("Ingrese el costo de la mensualidad");
        mensualidad = entrada.nextDouble();
        System.out.println("Ingrese la cantidad Maxima de la Sala");
        capacidadMaxima = entrada.nextInt();
        System.out.println("Ingrese el aforo actual");
        aforoActual = entrada.nextInt();
        LocalTime horaX = LocalTime.of(horaApertura, minutoApertura);
        LocalTime horaY = LocalTime.of(horaCierre, minutoCierre);
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
        while (iter == true) {
            for (int i = 0; i < listaServicios.size(); i++) {// imprime todos los servicios 
                System.out.println(Integer.toString(i) + ". " + listaServicios.get(i).getNombreEvento());
            }
            x = entrada.nextInt();
            System.out.println("Escriba el numero del servicio que ofrece o -1 para Salir");
            if (x == -1) {
                iter = false;
            } else {

                if (x > 0 && x < listaServicios.size()) {
                    serviciosInstructor.add(listaServicios.get(x));
                    System.out.println("Desea ingresar otra opcion");
                    System.out.println("1. Si");
                    System.out.println("2. No");
                    System.out.println("digite una opcion");
                    x = entrada.nextInt();

                }

                if (x != 1) {
                    iter = false;
                }
            }
        }
        control.nuevoInstructor(nombre, apellido, cedula, telefono, correo, passw, Estado.FIJO.name(), serviciosInstructor);
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
        String xhoraInicio, yhoraFinal, dia, cedula;
        boolean isInstructor = false;
        int numServicio, capacidad;
        Scanner entrada = new Scanner(System.in);
        int num = 0;
        System.out.println("--- Programar Clase -----");

        System.out.println("Por favor ingrese su cedula para programar una clase");
        cedula = entrada.nextLine();
        Instructor instructor = null;
        ArrayList<Instructor> lista = control.allInstructores();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCedula().equals(cedula)) {
                isInstructor = true;
                instructor= lista.get(i);
                System.out.println(lista.get(i).getCedula()+ " "+ cedula);
            }
        }
        if (isInstructor) {
            //System.out.println("Escriba el digito perteneciente a su nombre");
            //num = entrada.nextInt();
            //Instructor instructor = lista.get(num);
            System.out.println("Calendario Actual");
            calendario();
            System.out.println("Ingrese el numero que corresponda al dia en el que desesa crear la clase");
            int a = 1;
            for (Dia day : Dia.values()) {
                System.out.print(a);
                System.out.println(". " + day);
                a++;
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
        } else {
            System.out.println("Su cédula no se encuentra registrada en el sistema, por favor ingrese una cédula válida para poder programar una clase");
        }

    }

    public static void verClase() {
        System.out.println("----- Ver Información de clase -----" + "\n");
        ArrayList<Clase> Classes = control.allClaseMes();

        //Mostrando las clases disponibles
        for (int i = 0; i < Classes.size(); i++) {
            Clase clase = Classes.get(i);
            System.out.println("Clase #" + (i + 1));
            System.out.println(clase.getServicio().getNombreEvento());
            System.out.println(clase.getHorario().getHoraInicio() + "-->" + clase.getHorario().getHoraFinal());
            System.out.println("----------------");
        }

        //Respuesta del usuario
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el número de clase que desea visualizar: " + "\n");
        int numClass = entrada.nextInt() - 1;

        //Visualización de la información de la clase
        System.out.println("Número identificador de la clase: " + Classes.get(numClass).getIdClase());
        System.out.println("Capacidad: " + Classes.get(numClass).getCapacidad() + " personas");
        System.out.println("Horario: " + Classes.get(numClass).getHorario().getHoraInicio() + "-->" + Classes.get(numClass).getHorario().getHoraFinal());
        System.out.println("Instructor: " + Classes.get(numClass).getInstructor().getNombre() + " " + Classes.get(numClass).getInstructor().getApellido());
        System.out.println("Servicio: " + Classes.get(numClass).getServicio().getNombreEvento());
        System.out.println("Descripcion de Servicio: " + Classes.get(numClass).getServicio().getDescripcion());
        System.out.println();
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
            if (control.allClientes().get(i).getCedula().equals(cedula)) {
//                System.out.println(control.allClientes().get(i).getCedula());
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
                System.out.println("Nombre de la clase: " + clases.get(i).getServicio().getNombreEvento() + "\n");
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

    public static void allClientes() {
        ArrayList<Cliente> lista = control.allClientes();
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("\nCliente #" + (i + 1));
            System.out.println(lista.get(i).getNombre() + " " + lista.get(i).getApellido());
            System.out.println(lista.get(i).getCedula());
        }

    }

    public static void completarDatos() {
        //Crear servicios
        control.createServicio("Cxworx", "Se enfoca en trabajar principalmente la zona central del cuerpo, también llamado core. Se ejercitan los músculos del abdomen, oblicuos y espalda baja con trabajo de fuerza y tono, otros nombres no tan comerciales es core training");
        control.createServicio("Bosu", "Se pueden realizar ejercicios aeróbicos como caminar, correr, saltar; o se puede hacer ejercicios de fuerza, de tono, de abdomen, funcionales y de estabilidad encima del bosu. Es un entrenamiento basado en equilibrio y balance.");
        control.createServicio("BodyJam", "Se basa en realizar ejercicio aeróbico mediante el baile principalmente con música funk, Groove, hip hop, disco y Jazz. Promueve un aumento de la conciencia corporal, mejora la calidad del movimiento, ayuda a quemar grasa y desarrolla la noción del ritmo.");
        control.createServicio("TRX", "Utiliza ejercicios funcionales con el peso corporal pero con la gran diferencia de estar en suspensión mediante unos arneses que se fijan a una puerta, pared o algún elemento elevado y a su vez a las manos o pies.");
        control.createServicio("CrossFit", "Se basa en realizar ejercicios funcionales, de alta intensidad y corta duración, constantemente variados y muy creativos, como puede ser subir una cuerda, golpear una llanta con un mazo hasta el ejercicio menos imaginado.");
        control.createServicio("BodyPump", "Es una clase que se realiza con una barra y discos, desarrolla la fuerza y resistencia y da tono muscular, pero también está diseñada para incrementar el gasto calórico de tal forma que ayuda también a mejorar la composición corporal y por tanto a perder grasa.");
        control.createServicio("Entrenamiento funcional", "Se basa en realizar ejercicios que imitan los movimientos o trabajos físicos de la vida cotidiana, se utiliza el peso corporal y accesorios tales como poleas, mancuernas, pelotas medicinales, trampolines, conos, colchonetas, bandas elásticas y steps ente otros.");
        control.createServicio("Aerobox", "Esta actividad incluye movimientos de kickboxing mezclados con aerobics, por lo que se trata de una opción muy diferente. Mejora la resistencia física, el tono muscular, ayuda en la pérdida de grasa corporal.");
        control.createServicio("TaeBo", "Incrementa la resistencia cardiaca, la fuerza, la flexibilidad y ayuda en la perdida de grasa corporal. Si tienes gusto por las artes marciales sin contacto y quieres tener un buen entrenamiento cardiovascular al mismo tiempo esta es tu opción. ");
        control.createServicio("Zumba", "Es un una actividad en donde se combinan movimientos de baile con rutinas aeróbicas principalmente con música latina como salsa, merengue, cumbia, reggaetón y samba.");

        //Crear Clientes
        Date fecha = new Date();
        control.createClient("Ruben", "Palma", "64286277", "63588868", "Ruben@gmail.com", "78968136", fecha, fecha);
        control.createClient("Rafael", "Frances", "33323492", "63588868", "Rafael@gmail.com", "78968136", fecha, fecha);
        control.createClient("Santiago", "Ye", "55223165", "63588868", "Santiago@gmail.com", "78968136", fecha, fecha);
        control.createClient("Carlos", "Alberto", "95854526", "63588868", "Carlos@gmail.com", "78968136", fecha, fecha);
        control.createClient("Segundo", "Alcaraz", "92193077", "63588868", "Segundo@gmail.com", "78968136", fecha, fecha);
        control.createClient("Anna", "Olmo", "94851247", "63588868", "Anna@gmail.com", "78968136", fecha, fecha);
        control.createClient("Sarai", "Cervantes", "92507729", "63588868", "Sarai@gmail.com", "78968136", fecha, fecha);
        control.createClient("Maria", "Salud", "53651750", "63588868", "Maria@gmail.com", "78968136", fecha, fecha);
        control.createClient("Iria", "Arribas", "68194728", "63588868", "Iria@gmail.com", "78968136", fecha, fecha);

        //Crear Instructores
        ArrayList<Servicio> servicios = new ArrayList<Servicio>();

        servicios.add(control.allServicios().get(0));
        servicios.add(control.allServicios().get(1));
        control.nuevoInstructor("Oscar", "Segura", "109760070", "83679661", "mayecedeno@gmail.com", "maye1234", Estado.FIJO.toString(), servicios);

        servicios.clear();
        servicios.add(control.allServicios().get(2));
        servicios.add(control.allServicios().get(3));
        control.nuevoInstructor("Melissa", "Fuentes", "109876534", "88238572", "melifuentes80@gmail.com", "meli1234", Estado.TEMPORAL.toString(), servicios);

        servicios.clear();
        servicios.add(control.allServicios().get(4));
        servicios.add(control.allServicios().get(5));
        control.nuevoInstructor("César", "Milán", "102367128", "82348817", "encantadordeperros@gmail.com", "cesar1234", Estado.FIJO.toString(), servicios);

        servicios.clear();
        servicios.add(control.allServicios().get(6));
        servicios.add(control.allServicios().get(7));
        control.nuevoInstructor("Jennifer", "Zamora", "105788345", "89908223", "jenni0987@gmail.com", "jenni1234", Estado.FIJO.toString(), servicios);

        servicios.clear();
        servicios.add(control.allServicios().get(8));
        servicios.add(control.allServicios().get(9));
        control.nuevoInstructor("Bryan", "Rodríguez", "106753456", "85983919", "bryan0104@gmail.com", "bryan1234", Estado.TEMPORAL.toString(), servicios);

        servicios.clear();

        //Crear Clases
        control.nuevaClase(15, "LUNES", LocalTime.of(7, 0), LocalTime.of(8, 0), control.allInstructores().get(0), control.allServicios().get(1));
        control.nuevaClase(15, "MARTES", LocalTime.of(8, 0), LocalTime.of(9, 0), control.allInstructores().get(1), control.allServicios().get(0));
        control.nuevaClase(15, "LUNES", LocalTime.of(9, 0), LocalTime.of(10, 0), control.allInstructores().get(2), control.allServicios().get(8));
        control.nuevaClase(15, "MIERCOLES", LocalTime.of(7, 0), LocalTime.of(8, 0), control.allInstructores().get(3), control.allServicios().get(4));
        control.nuevaClase(15, "VIERNES", LocalTime.of(12, 0), LocalTime.of(13, 0), control.allInstructores().get(4), control.allServicios().get(5));
        control.nuevaClase(15, "JUEVES", LocalTime.of(7, 0), LocalTime.of(8, 0), control.allInstructores().get(2), control.allServicios().get(7));
        control.nuevaClase(15, "MARTES", LocalTime.of(9, 0), LocalTime.of(10, 0), control.allInstructores().get(3), control.allServicios().get(9));
        control.nuevaClase(15, "LUNES", LocalTime.of(15, 0), LocalTime.of(17, 0), control.allInstructores().get(2), control.allServicios().get(2));

    }

    public static void main(String[] args) {
        control = new Controller();

        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        System.out.println(" Bienvenido al Sistema De Gestion del Gimnasio ");
        while (opcion != 11) {
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
            System.out.println(" 10. Visualizacion de Clientes ");
            System.out.println(" 11. Salir ");

            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    crearSala();
                    completarDatos();
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
                    break;
                case 10:
                    allClientes();
                    break;
                case 11:
                    System.exit(0);

            }
        }

    }

}
