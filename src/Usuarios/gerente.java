package Usuarios;

import Usuarios.utils.Rol;

import java.time.LocalDate;

public class gerente extends usuario {
    private int numeroDeEmpleadosACargo;
    private int NumeroDeIdiomasQueHabla;

    public gerente(String nombre, String Apellido, int numeroDeEmpleadosACargo,int NumeroDeIdiomasQueHabla, LocalDate fechaDeNacimiento, String numeroDeTelefono,String Usuario, String Contraseña) {
        super(nombre, Apellido, Rol.GERENTE, numeroDeTelefono,Usuario, Contraseña, fechaDeNacimiento);
        this.numeroDeEmpleadosACargo=numeroDeEmpleadosACargo;
        this.NumeroDeIdiomasQueHabla=NumeroDeIdiomasQueHabla;
    }
    @Override
    public String toString(){
        return String.format("%s, Numero de empleados a cargo: %d, numero de Idiomas Que Habla: %d",super.toString(),numeroDeEmpleadosACargo,NumeroDeIdiomasQueHabla);
    }
}
