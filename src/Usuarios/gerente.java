package Usuarios;

import Usuarios.utils.Rol;

public class gerente extends usuario {
    private double salario;
    private int numeroDeEmpleadosACargo;
    private int NumeroDeIdiomasQueHabla;

    public gerente(String nombre, String Apellido, int numeroDeEmpleadosACargo,int NumeroDeIdiomasQueHabla) {
        super(nombre, Apellido, Rol.GERENTE);
        this.numeroDeEmpleadosACargo=numeroDeEmpleadosACargo;
        this.NumeroDeIdiomasQueHabla=NumeroDeIdiomasQueHabla;
    }
    @Override
    public String toString(){
        return String.format("%s, Numero de empleados a cargo: %d, numero de Idiomas Que Habla: %d",super.toString(),numeroDeEmpleadosACargo,NumeroDeIdiomasQueHabla);
    }
}
