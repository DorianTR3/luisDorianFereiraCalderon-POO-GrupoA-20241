package Biblioteca;
import Usuarios.Cliente;
import Usuarios.Gerente;
import Usuarios.Trabajador;
import Usuarios.Usuario;
import Usuarios.utils.Rol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Biblioteca {

    static Scanner leer= new Scanner(System.in);

    public static final HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap();

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

}