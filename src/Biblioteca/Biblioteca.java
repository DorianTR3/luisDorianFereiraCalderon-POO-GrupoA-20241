package Biblioteca;
import Biblioteca.Libros.Constantes.Genero;
import Biblioteca.Libros.Libro;
import Biblioteca.Libros.LibroAccion;
import Biblioteca.Libros.LibroComedia;
import Biblioteca.Libros.LibroTerror;
import Usuarios.Cliente;
import Usuarios.Gerente;
import Usuarios.Trabajador;
import Usuarios.Usuario;
import Usuarios.utils.Rol;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class Biblioteca {

    @SuppressWarnings("RawTypes")
    public static HashMap<Rol,ArrayList<Usuario>> usuarios = new HashMap<>(); //el rol es la llave, el arraylist es el valor que se le da a cada llave
    public static HashMap<Genero,ArrayList<Libro>> libros = new HashMap<>();

    public Biblioteca (){
        inicializarLlaves();
    }

    private void inicializarLlaves(){
        usuarios.put(Rol.Trabajador,new ArrayList<>());
        usuarios.put(Rol.Clientes,new ArrayList<>());
        usuarios.put(Rol.Gerente,new ArrayList<>());

        libros.put(Genero.Terror,new ArrayList<>());
        libros.put(Genero.Accion,new ArrayList<>());
        libros.put(Genero.Comedia,new ArrayList<>());
    }

    public static void registrarTerror(){
        LibroTerror.registrarLibroTerror();
    }

    public static void registrarComedia(){
        LibroComedia.registrarLibroComedia();
    }

    public static void registrarAccion(){
        LibroAccion.registrarLibroAccion();
    }



    public Usuario verificarInicioSesion(String nombreUsuario, String contrasena) {
        for (ArrayList<Usuario> listaUsuarios : usuarios.values()) {
            if (listaUsuarios != null) {
                for (Usuario usuario : listaUsuarios) {
                    if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasena().equals(contrasena)) {
                        return usuario;
                    }
                }
            }
        }

        System.out.println("Usuario o contraseña incorrectos, inténtelo nuevamente");
        return null;
    }

    // Usuarios
    public void mostrarUsuarios(){
        Usuario.mostrarUsuarios();
    }

    public void consultarUsuarios(){
        Usuario.consultarUsuarios();
    }

    public void mostrarUsuarioEspecifico(String nombreUsuario){
        Usuario.mostrarUsuarioEspecifico(nombreUsuario);
    }

    // Clientes
    public void mostrarClientes(){
        Cliente.mostrarClientes();
    }

    public void registrarCliente() {
        Cliente.registrarCliente();
    }

    public void eliminarCliente() {
        Cliente.eliminarCliente();
    }

    // Trabajadores
    public void mostrarTrabajadores(){
        Trabajador.mostrarTrabajadores();
    }

    public void registrarTrabajador(){
        Trabajador.registrarTrabajador();
    }

    public void eliminarTrabajador(){
        Trabajador.eliminarTrabajador();
    }

    // Gerentes
    public void mostrarGerentes(){
        Gerente.mostrarGerentes();
    }

    public void registrarGerente(){
        Gerente.registrarGerente();
    }

    public void eliminarGerente(){
        Gerente.eliminarGerente();
    }

    public void actualizarUsuario(){
        Usuario.actualizarDatosComun();
    }

    // Libros Accion
    public void mostrarLibrosAccion(){

    }

    public void registrarLibroAccion(){
        LibroAccion.registrarLibroAccion();
    }

    public void eliminarLibroAccion(LibroAccion libroAccion){
        libroAccion.eliminarLibro();
    }

    public void actualizarLibroAccion(){
        Usuario.actualizarDatosComun();
    }

}