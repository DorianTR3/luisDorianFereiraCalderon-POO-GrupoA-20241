package Biblioteca;

import Usuarios.Usuario;
import Utils.UsuarioEnSesion;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.jar.JarOutputStream;

public class Menu {

    static Scanner leer= new Scanner(System.in);
    static Biblioteca biblioteca = new Biblioteca();


    public void iniciarSesion(){

        boolean datoscorrectos= false;
        int cont = 5;
        biblioteca.registrarGerente();

        do {
            System.out.println("BIENVENIDO AL SISTEMA DE LA BIBLIOTECA.");
            System.out.printf("Inicia sesion para continuar, tienes %d intentos: \n",cont);

            System.out.println("Ingresa tu nombre de usuario: ");
            String user= leer.nextLine();

            System.out.println("Ingresa tu contraseña: ");
            String contra= leer.nextLine();

            Usuario actual= biblioteca.verificarInicioSesion(user,contra);

            if (actual != null && cont > 0){
                UsuarioEnSesion.getInstancia().setUsuario(actual);
                seleccionarMenu();
                cont = 5;
            } else if (cont == 1) {
                System.out.println("INTENTOS TERMINADOS, TERMINANDO EL PROGRAMA. ");
                datoscorrectos=true;
            } else{
                System.out.println("DATOS INCCORRECTOS. ");
                cont--;
            }

        } while (!datoscorrectos);

    }

    private static void seleccionarMenu(){
        switch (UsuarioEnSesion.getInstancia().getUsuarioActual().getRol()){
            case Gerente -> ejecutarMenuGerente(); //la flechita es una funcion lambda, sirve en versiones de java mas actuales
            case Trabajador -> ejecutarMenuTrabajador();
            case Clientes -> ejecutarMenuCliente();
        }
    }


    private static void ejecutarMenuCliente(){
        String option = "";
        Scanner leer = new Scanner(System.in);
        do{
            System.out.println("1 - Ver rentas");
            System.out.println("2 - Ver tu informacion");
            System.out.println("3 - Ver libros disponibles");
            System.out.println("E - Cerrar sesion.");
            option=leer.nextLine();
            switch (option){
                case "1" :
                    break;
                case "2" :
                    break;
                case "3" :
                    break;
                case "E" :
                    UsuarioEnSesion.getInstancia().cerrarSesion();
                    break;
                default :
                    System.out.println("Opcion invalida");
                    break;
            }
        }while(!option.equals("E"));
    }
    private static void ejecutarMenuTrabajador(){
        String option = "" ;
        Scanner leer = new Scanner(System.in);
        do{
            System.out.println("1 - Registrar cliente");
            System.out.println("2 - Actualizar la informacion del cliente");
            System.out.println("3 - Eliminar cliente");
            System.out.println("4 - Registrar libro");
            System.out.println("5 - Actualizar la informacion del libro");
            System.out.println("6 - Eliminar libro");
            System.out.println("E - Cerrar sesion.");
            option=leer.nextLine();
            switch (option){
                case "1" :
                    biblioteca.registrarCliente();
                    break;
                case "2" :
                    break;
                case "3" :
                    break;
                case "4" :
                    break;
                case "5" :
                    break;
                case "6" :
                    break;
                case "E" :
                    UsuarioEnSesion.getInstancia().cerrarSesion();
                    break;
                default :
                    System.out.println("Opcion invalida");
                    break;
            }
        }while(!option.equals("E"));
    }
    private static void ejecutarMenuGerente(){
        String option = "";
        Scanner leer = new Scanner(System.in);
        do{
            System.out.println("1 - Registrar cliente");
            System.out.println("2 - Actualizar la informacion del cliente");
            System.out.println("3 - Eliminar cliente");
            System.out.println("4 - Registrar trabajador");
            System.out.println("5 - Actualizar la informacion del trabajador");
            System.out.println("6 - Eliminar trabajador");
            System.out.println("7 - Registrar gerente");
            System.out.println("8 - Actualizar la informacion del gerente");
            System.out.println("9 - Eliminar gerente");
            System.out.println("11 - Mostrar clientes");
            System.out.println("12 - Mostrar trabajadores");
            System.out.println("13 - Mostrar gerentes");
            System.out.println("14 - Mostrar usuario especifico");
            System.out.println("15 - Mostrar usuarios");
            System.out.println("E - Cerrar sesion.");
            option=leer.nextLine();
            switch (option){
                case "1" :
                    biblioteca.registrarCliente();
                    break;
                case "2" :
                    biblioteca.actualizarUsuario();
                    break;
                case "3" :
                    biblioteca.eliminarCliente();
                    break;
                case "4" :
                    biblioteca.registrarTrabajador();
                    break;
                case "5" :
                    biblioteca.actualizarUsuario();
                    break;
                case "6" :
                    biblioteca.eliminarTrabajador();
                    break;
                case "7":
                    biblioteca.registrarGerente();
                    break;
                case "8":
                    biblioteca.actualizarUsuario();
                    break;
                case "9" :
                    biblioteca.eliminarGerente();
                    break;
                case "10" :
                    biblioteca.mostrarClientes();
                    break;
                case "11":
                    biblioteca.mostrarTrabajadores();
                    break;
                case "12":
                    biblioteca.mostrarGerentes();
                    break;
                case "13" :
                    biblioteca.mostrarUsuarios();
                    String usuario = leer.nextLine();
                    biblioteca.mostrarUsuarioEspecifico(usuario);
                    break;
                case "14" :
                    biblioteca.consultarUsuarios();
                    break;
                case "15":
                    biblioteca.mostrarUsuarios();
                    break;
                case "E" :
                    UsuarioEnSesion.getInstancia().cerrarSesion();
                    break;
                default :
                    System.out.println("Opcion invalida");
                    break;
            }
        }while(!option.equals("E"));
    }

    public void RegistrarLibroMenu(){
        Scanner leer = new Scanner(System.in);
        int opcion = 0;
        boolean esDatoValido=false;
        do {
            System.out.println("Registrar libro");
            System.out.println("Seleccionar Opcion");
            System.out.println("1. Terro");
            System.out.println("2. Comedia");
            System.out.println("3. Accion");
            System.out.println("4. Regresar al menu principal");

            while(!esDatoValido) {
                try {
                    opcion = leer.nextInt();
                    if (opcion < 1 || opcion > 4) {
                        throw new IndexOutOfBoundsException();
                    }
                    esDatoValido=true;
                } catch (InputMismatchException error) {
                    System.out.println("Opcion invalida. intente De nuevo");
                }finally {
                    leer.nextLine();
                }
            }
            esDatoValido=false;
            

        }while (opcion!=4);
    }

}