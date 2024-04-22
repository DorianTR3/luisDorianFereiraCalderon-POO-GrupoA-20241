package utils;
import Usuarios.usuario;

public class usuarioEnSesion {
    public static usuarioEnSesion instancia;

    private usuario usuario1;

    private usuarioEnSesion() {
    }
public static usuarioEnSesion getInstance(){
        if (instancia==null){
            instancia=new usuarioEnSesion();
        }return instancia;

}
public usuario getUsuario(){
        return usuario1;
}
    public void setUsuario1(usuario usuario1) {
        this.usuario1 = usuario1;
    }
    public boolean hayUsuarioEnSesion(){
        return usuario1!=null;
    }
    public void cerrarSesion(){
        instancia=null;
        usuario1=null;
    }
}
