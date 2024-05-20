package Usuarios;

import java.util.ArrayList;

public class UsuarioModel {
    private ArrayList<Cliente> Clientes = new ArrayList<>();
    private ArrayList<Gerente> Gerente = new ArrayList<>();
    private ArrayList<Trabajador> Trabajador = new ArrayList<>();

    public ArrayList<Cliente> getClientes() {
        return Clientes != null ? Clientes : new ArrayList<>();
    }

    public ArrayList<Gerente> getGerentes() {
        return Gerente != null ? Gerente : new ArrayList<>();
    }

    public ArrayList<Trabajador> getTrabajadores() {
        return Trabajador != null ? Trabajador : new ArrayList<>();
    }
}