package Usuarios;

import Usuarios.utils.Rol;

import java.time.LocalDate;

public class usuario {
    private static int Cantidad_usuarios=1;
    private int id;
    private String nombre;
    private String apellido;
    private Rol rol;
    LocalDate fechaDeNaciento;
    private String contraseña;
    private String Usuario;


    public usuario(String nombre, String Apellido, Rol rol, String Usuario, String contraseña, LocalDate fechaDeNaciento){
        this.nombre=nombre;
        this.apellido=Apellido;
        this.contraseña=contraseña;
        this.Usuario=Usuario;
        this.rol=rol;
        this.id= Cantidad_usuarios;
        this.fechaDeNaciento=fechaDeNaciento;
        Cantidad_usuarios++;
    }
    @Override
    public String toString(){
        return String.format("id: %d, nombre: %s %s, Rol: %s", id, nombre, apellido, rol);
    }
}
