package Usuarios;

import Biblioteca.Biblioteca;
import Biblioteca.utils.DatosComun;
import Usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Trabajador extends Usuario {

    private String rfc;

    public Trabajador(String nombre, String apellido, String rfc, LocalDate fechaNacimiento,String telefono, String contrasena, String nombreUsuario) {
        super(nombre, apellido, Rol.Trabajador, fechaNacimiento, telefono, contrasena, nombreUsuario);
        this.rfc=rfc;
    }

    public String getRfc() {return this.rfc;}

    public static void registrarTrabajador(){
        Scanner leer = new Scanner(System.in);
        ArrayList<String> datosComun = DatosComun.obtenerDatosComunes(Rol.Trabajador);

        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String telefono = datosComun.get(2);
        String usuario = datosComun.get(3);
        String contrasena = datosComun.get(4);

        System.out.println("Ingrese dia de nacimiento: ");
        int dia = leer.nextInt();
        System.out.println("Ingrese mes de nacimiento: ");
        int mes = leer.nextInt();
        System.out.println("Ingrese ano de nacimiento: ");
        int ano = leer.nextInt();
        leer.nextLine();

        System.out.println("Ingrese RFC: ");
        String rfc= leer.nextLine();

        Trabajador trabajador = new Trabajador(nombre, apellido, rfc, LocalDate.of(ano, mes, dia),telefono, contrasena, usuario);

        if(!Biblioteca.usuarios.containsKey(Rol.Trabajador)){
            Biblioteca.usuarios.put(Rol.Trabajador, new ArrayList<Usuario>());
        }

        Biblioteca.usuarios.get(Rol.Trabajador).add(trabajador);

        System.out.println("Trabajador agregado correctamente.");
    }

    public static void mostrarTrabajador(Trabajador trabajadorDado){
        for (Usuario usuario: Biblioteca.usuarios.get(Rol.Trabajador)){
            Trabajador trabajador = (Trabajador) usuario;
            if(trabajador == trabajadorDado){
                Usuario.mostrarUsuario(trabajador);
                System.out.println(" RFC: "+trabajador.getRfc());
            }
        }
    }

    public static void mostrarTrabajadores(){
        for (Usuario usuario: Biblioteca.usuarios.get(Rol.Trabajador)){
            Trabajador trabajador = (Trabajador) usuario;
            Usuario.mostrarUsuario(trabajador);
            System.out.println(" RFC: "+trabajador.getRfc());
        }
    }

    public static void eliminarTrabajador(){
        Scanner leer = new Scanner(System.in);
        for (Usuario usuario: Biblioteca.usuarios.get(Rol.Trabajador)){
            Trabajador trabajador = (Trabajador) usuario;
            Usuario.mostrarUsuario(trabajador);
        }
        System.out.println("Ingrese el usuario a remover: ");
        String nombreUsuario = leer.nextLine();
        for (Usuario usuario: Biblioteca.usuarios.get(Rol.Trabajador)){
            Trabajador trabajador = (Trabajador) usuario;
            if (trabajador.getNombreUsuario().equals(nombreUsuario)){
                Biblioteca.usuarios.get(Rol.Trabajador).remove(trabajador);
                System.out.println("Trabajador eliminado.");
                return;
            }
        }
        System.out.println("Trabajador no encontrado");
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
    public void checharEntrada(){
        System.out.println("se ha registrado su entrada");
    }
    public void checarSalida(){
        System.out.print("se ha registrado su salida");
    }
}