package Usuarios;

import Usuarios.utils.Rol;

import java.time.LocalDate;

public class cliente extends usuario{
    private LocalDate fechaDeRegisto;
    public cliente(String nombre, String apellido){
        super(nombre ,apellido, Rol.CLIENTE);
        this.fechaDeRegisto=LocalDate.now();
    }

    public LocalDate getFechaDeRegisto() {
        return fechaDeRegisto;
    }
    @Override
    public String toString(){
        return String.format("%s, Fecha de Registro :%s",super.toString(),fechaDeRegisto);
    }
}

