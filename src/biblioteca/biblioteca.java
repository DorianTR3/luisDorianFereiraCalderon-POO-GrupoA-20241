package biblioteca;
import java.util.ArrayList;

import Usuarios.cliente;
import Usuarios.gerente;
import Usuarios.trabajador;
import Usuarios.usuario;

public class biblioteca {
    private ArrayList<usuario> ListaDeUsuarios = new ArrayList<>();
    private ArrayList<cliente> Listaclientes = new ArrayList<>();
    private ArrayList<gerente> Listagerentes = new ArrayList<>();
    private ArrayList<trabajador> Listatrabajadores = new ArrayList<>();

    public  usuario verificarInicioSesion(String nombreusuario, String contrasena){
        for (usuario usuario: ListaDeUsuarios){
            if (usuario.getUsuario().equals(nombreusuario)){
                if (usuario.getContraseña().equals(contrasena)){
                    return usuario;
                }
            }
        }
        return null;
    }
    public void RegresarLibro(){

    }
    public void agregarCliente(cliente cliente) {
        ListaDeUsuarios.add(cliente);
        Listaclientes.add(cliente);
    }

    public void agregarGerente(gerente gerente) {
        ListaDeUsuarios.add(gerente);
        Listagerentes.add(gerente);
    }

    public void agregarTrabajador(trabajador trabajador) {
        ListaDeUsuarios.add(trabajador);
        Listatrabajadores.add(trabajador);
    }

    public void mostrarUsuarios() {
        for (usuario usuario : ListaDeUsuarios) {
            System.out.println(usuario.getNombre());
        }
    }
}
