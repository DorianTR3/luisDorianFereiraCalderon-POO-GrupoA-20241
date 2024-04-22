package Usuarios;

import Usuarios.utils.Rol;

import java.time.LocalDate;

public class trabajador extends usuario {
    private double salario;
    private String RFC;
    private LocalDate fechaDeNaciento;
    private String contraseña;
    private String Usuario;
    public trabajador(String nombre, String Apellido, double salario, String RFC, String numeroDeTelefono,String Usuario, String contraseña, LocalDate fechaDeNaciento) {
        super(nombre, Apellido, Rol.TRABAJADOR, numeroDeTelefono, Usuario,contraseña, fechaDeNaciento);
        this.RFC=RFC;
        this.salario=salario;
    }
    @Override
    public String toString(){
        return String.format("%s, RFC: %s, salario: %.2f",super.toString(), RFC, salario);
    }
}
