package Biblioteca.utils;

import Biblioteca.Biblioteca;
import Usuarios.Usuario;
import Usuarios.utils.Rol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DatosComun {
    public static String obtenerNumeroTelefono() {
        Scanner scanner = new Scanner(System.in);
        boolean numeroExistente = true;
        String telefono = "";

        do {
            System.out.println("Ingresa el numero de telefono");
            telefono = scanner.nextLine();

            numeroExistente = false;
            for (ArrayList<Usuario> listaUsuarios : Biblioteca.usuarios.values()){
                for (Usuario usuario : listaUsuarios){
                    if (usuario.getNumeroTelefono().equals(telefono)) {
                        numeroExistente = true;
                    }
                }
            }

            if (numeroExistente) {
                System.out.println("El numero ya existe. Intenta de nuevo\n");
            }
        } while (numeroExistente);

        return telefono;
    }

    public static String obtenerNombreUsuario() {
        Scanner leer = new Scanner(System.in);
        boolean nombreUsuarioExistente = true;
        String nombreUsuario = "";

        do {
            System.out.println("Ingresa el nombre de usuario");
            nombreUsuario = leer.nextLine();

            nombreUsuarioExistente = false;
            for (ArrayList<Usuario> listaUsuarios : Biblioteca.usuarios.values()){
                for (Usuario usuario : listaUsuarios){
                    if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                        nombreUsuarioExistente = true;
                    }
                }
            }

            if (nombreUsuarioExistente) {
                System.out.println("El nombre de usuario ya existe. Intenta de nuevo\n");
            }
        } while (nombreUsuarioExistente);

        return nombreUsuario;
    }

    public static ArrayList<String> obtenerDatosComunes (Rol rol){
        Scanner leer = new Scanner(System.in);
        ArrayList<String> datosComun = new ArrayList<>();
        String rolActual = rol == Rol.Clientes ? "Cliente" : rol == Rol.Trabajador ? "trabajador" : "Gerente";
        System.out.printf("Registrar %s \n",rolActual);

        System.out.println("Ingrese nombre: ");
        String nombre = leer.nextLine();

        System.out.println("Ingrese el apellido: ");
        String apellido = leer.nextLine();

        String telefono = obtenerNumeroTelefono();

        String nombreUsuario = obtenerNombreUsuario();

        System.out.println("Ingrese contrasena: ");
        String contrasena = leer.nextLine();

        datosComun.addAll(Arrays.asList(nombre, apellido, telefono, nombreUsuario, contrasena));

        return datosComun;
    }
}