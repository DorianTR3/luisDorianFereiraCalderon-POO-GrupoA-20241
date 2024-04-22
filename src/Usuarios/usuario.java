package Usuarios;

import Usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.ArrayList;

import biblioteca.biblioteca;

public class usuario {
    private static int Cantidad_usuarios=1;
    private int id;
    biblioteca biblioteca;

    public String getContraseña() {
        return contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    private String nombre;

    public String getNumeroDeTelefono() {
        return numeroDeTelefono;
    }

    private String numeroDeTelefono;

    public String getApellido() {
        return apellido;
    }

    private String apellido;

    public Rol getRol() {
        return rol;
    }

    private Rol rol;
    LocalDate fechaDeNaciento;
    private String contraseña;

    public String getUsuario() {
        return Usuario;
    }

    private String Usuario;


    public usuario(String nombre, String Apellido, Rol rol, String numeroDeTelefono, String Usuario, String contraseña, LocalDate fechaDeNaciento){
        this.nombre=nombre;
        this.apellido=Apellido;
        this.contraseña=contraseña;
        this.Usuario=Usuario;
        this.rol=rol;
        this.id= Cantidad_usuarios;
        this.fechaDeNaciento=fechaDeNaciento;
        Cantidad_usuarios++;
        this.numeroDeTelefono=numeroDeTelefono;
    }
    @Override
    public String toString(){
        return String.format("id: %d, nombre: %s %s, Rol: %s", id, nombre, apellido, rol);
    }

    public boolean ComprobarUsuario(String Usuario) {
        // Itera sobre cada lista de usuarios en el HashMap
        for (ArrayList<usuario> listaUsuarios : biblioteca.ListaDeUsuarios.values()) {
            // Busca el usuario en la lista actual
            for (usuario usuario : listaUsuarios) {
                if (Usuario.equals(usuario.getUsuario())) {
                    System.out.println("Usuario registrado.");
                    return false; // Retorna false si encuentra el usuario
                }
            }
        }
        return true; // Retorna true si no encuentra el usuario en ninguna lista
    }
}
