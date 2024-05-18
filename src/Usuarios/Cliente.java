package Usuarios;

import Biblioteca.Biblioteca;
import Biblioteca.utils.DatosComun;
import Usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Usuario {

    private LocalDate fechaRegistro;

    public Cliente(String nombre, String apellido, LocalDate fechaNacimiento,String telefono, String contrasena, String nombreUsuario) {
        super(nombre, apellido, Rol.Clientes, fechaNacimiento, telefono, contrasena, nombreUsuario);
        this.fechaRegistro= LocalDate.now();
    }

    public LocalDate getFechaRegistro(){
        return fechaRegistro;
    }

    @Override
    public String toString(){
        return String.format("%s, fecha de registro: %s",super.toString(),fechaRegistro);
    }

    public static void registrarCliente() {
        Scanner leer = new Scanner(System.in);
        ArrayList<String> datosComun = DatosComun.obtenerDatosComunes(Rol.Clientes);

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

        Cliente cliente = new Cliente(nombre, apellido, LocalDate.of(ano, mes, dia),telefono, contrasena, usuario);

        if(!Biblioteca.usuarios.containsKey(Rol.Clientes)){
            Biblioteca.usuarios.put(Rol.Clientes, new ArrayList<Usuario>());
        }

        Biblioteca.usuarios.get(Rol.Clientes).add(cliente);

        System.out.println("Cliente agregado correctamente.");
    }

    public static void mostrarCliente(Cliente clienteDado){
        for (Usuario usuario: Biblioteca.usuarios.get(Rol.Clientes)){
            Cliente cliente = (Cliente) usuario;
            if (cliente == clienteDado){
                Usuario.mostrarUsuario(cliente);
                System.out.println(" Fecha de registro: "+cliente.getFechaRegistro());
            }
        }
    }

    public static void mostrarClientes(){
        for (Usuario usuario: Biblioteca.usuarios.get(Rol.Clientes)){
            Cliente cliente = (Cliente) usuario;
            Usuario.mostrarUsuario(cliente);
            System.out.println(" Fecha de registro: "+cliente.getFechaRegistro());
        }
    }

    public static void eliminarCliente(){
        Scanner leer = new Scanner(System.in);
        for (Usuario usuario: Biblioteca.usuarios.get(Rol.Clientes)){
            Cliente cliente = (Cliente) usuario;
            Usuario.mostrarUsuario(cliente);
        }
        System.out.println("Ingrese el usuario a remover: ");
        String nombreUsuario = leer.nextLine();
        for (Usuario usuario: Biblioteca.usuarios.get(Rol.Clientes)){
            Cliente cliente = (Cliente) usuario;
            if (cliente.getNombreUsuario().equals(nombreUsuario)){
                Biblioteca.usuarios.get(Rol.Clientes).remove(cliente);
                System.out.println("Cliente eliminado.");
                return;
            }
        }
        System.out.println("Cliente no encontrado");
    }
}