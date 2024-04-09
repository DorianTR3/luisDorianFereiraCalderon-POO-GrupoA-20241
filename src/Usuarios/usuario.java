package Usuarios;

import Usuarios.utils.Rol;

public class usuario {
    private static int Cantidad_usuarios=1;
    private int id;
    private String nombre;
    private String apellido;
    private Rol rol;

    public usuario(String nombre, String Apellido, Rol rol){
        this.nombre=nombre;
        this.apellido=Apellido;
        this.rol=rol;
        this.id= Cantidad_usuarios;
        Cantidad_usuarios++;
    }
    @Override
    public String toString(){
        return String.format("id: %d, nombre: %s %s, Rol: %s", id, nombre, apellido, rol);
    }
}
