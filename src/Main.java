import Usuarios.cliente;
import Usuarios.usuario;
import Usuarios.utils.Rol;
import Usuarios.gerente;
import Usuarios.trabajador;
import biblioteca.menu;
import biblioteca.biblioteca;

import java.time.LocalDate;
//tarea
//-Must Registro de cleinte, trabajador y gerente, consulta de ellos
//-Must consulta individual
//-Nice to Have- Tratar de implemetar el inicio de sesion con el singleton


public class Main {
    public static void main(String[] args) {
        biblioteca biblioteca=new biblioteca();
        menu menu=new menu(biblioteca);

        gerente gerente=new gerente("antonio","soto", 45, 2, LocalDate.now(), "", " ","");
        cliente cliente= new cliente("marco", "solis", LocalDate.of(2004,8,12), LocalDate.now(), "", "","");
        trabajador trabajador=new trabajador("pedro", "pascal", 34000, "A44dsg24fg", "", "", "",LocalDate.now());
        System.out.println(cliente.getFechaDeRegisto());
        System.out.println(cliente.toString());
        System.out.println(trabajador.toString());
        System.out.println(gerente.toString());
        menu.seleccionarMenu(gerente);


    }
}