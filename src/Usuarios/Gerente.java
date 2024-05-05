package Usuarios;

import Biblioteca.Biblioteca;
import Biblioteca.utils.DatosComun;
import Usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Gerente extends Usuario {

    private String curp;

    public Gerente(String nombre, String apellido, String curp, LocalDate fechaNacimiento, String telefono, String contrasena, String nombreUsuario) {
        super(nombre, apellido, Rol.Gerente, fechaNacimiento,telefono, contrasena, nombreUsuario);
        this.curp=curp;
    }

    public String getCurp() { return this.curp; }

    public static void registrarGerente(){
        Scanner leer = new Scanner(System.in);
        ArrayList<String> datosComun = DatosComun.obtenerDatosComunes(Rol.Gerente);

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

        System.out.println("Ingrese CURP: ");
        String curp= leer.nextLine();

        Gerente gerente = new Gerente(nombre, apellido, curp, LocalDate.of(ano, mes, dia),telefono, contrasena, usuario);

        if(!Biblioteca.usuarios.containsKey(Rol.Gerente)){
            Biblioteca.usuarios.put(Rol.Gerente, new ArrayList<Usuario>());
        }

        Biblioteca.usuarios.get(Rol.Gerente).add(gerente);

        System.out.println("Gerente agregado correctamente.");
    }

    public static void mostrarGerente(Gerente gerenteDado){
        for (Usuario usuario: Biblioteca.usuarios.get(Rol.Gerente)){
            Gerente gerente = (Gerente) usuario;
            if(gerente == gerenteDado){
                Usuario.mostrarUsuario(gerente);
                System.out.println(" CURP: "+gerente.getCurp());
            }
        }
    }

    public static void mostrarGerentes(){
        for (Usuario usuario: Biblioteca.usuarios.get(Rol.Gerente)){
            Gerente gerente = (Gerente) usuario;
            Usuario.mostrarUsuario(gerente);
            System.out.println(" CURP: "+gerente.getCurp());
        }
    }

    public static void eliminarGerente(){
        Scanner leer = new Scanner(System.in);
        for (Usuario usuario: Biblioteca.usuarios.get(Rol.Gerente)){
            Gerente gerente = (Gerente) usuario;
            Usuario.mostrarUsuario(gerente);
        }
        System.out.println("Ingrese el usuario a remover: ");
        String nombreUsuario = leer.nextLine();
        for (Usuario usuario: Biblioteca.usuarios.get(Rol.Gerente)){
            Gerente gerente = (Gerente) usuario;
            if (gerente.getNombreUsuario().equals(nombreUsuario)){
                Biblioteca.usuarios.get(Rol.Gerente).remove(gerente);
                System.out.println("Gerente eliminado.");
                return;
            }
        }
        System.out.println("Gerente no encontrado");
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }
    public void checharEntrada(){
        System.out.println("se ha registrado su entrada");
    }
    public void checarSalida(){
        System.out.print("se ha registrado su salida");
    }
}