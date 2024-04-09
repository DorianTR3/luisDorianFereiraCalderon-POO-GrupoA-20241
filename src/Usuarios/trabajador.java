package Usuarios;

import Usuarios.utils.Rol;

import java.time.LocalDate;

public class trabajador extends usuario {
    private double salario;
    private String RFC;
    public trabajador(String nombre, String Apeelido, double salario, String RFC) {
        super(nombre, Apeelido, Rol.TRABAJADOR);
        this.RFC=RFC;
        this.salario=salario;
    }
    @Override
    public String toString(){
        return String.format("%s, RFC: %s, salario: %.2f",super.toString(), RFC, salario);
    }
}
