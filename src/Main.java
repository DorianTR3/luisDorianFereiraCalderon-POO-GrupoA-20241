import Usuarios.cliente;
import Usuarios.usuario;
import Usuarios.utils.Rol;
import Usuarios.gerente;
import Usuarios.trabajador;
public class Main {
    public static void main(String[] args) {
        gerente gerente=new gerente("antonio","soto", 45, 2);
        cliente cliente= new cliente("marco", "solis");
        trabajador trabajador=new trabajador("pedro", "pascal", 34000, "A44dsg24fg");
        System.out.println(cliente.getFechaDeRegisto());
        System.out.println(cliente.toString());
        System.out.println(trabajador.toString());
        System.out.println(gerente.toString());


    }
}