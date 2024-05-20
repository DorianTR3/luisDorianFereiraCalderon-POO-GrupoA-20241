import Biblioteca.Menu;
import Biblioteca.Biblioteca;

public class Main {
    public static void main(String[] args) {
        Menu menu= new Menu();
       // menu.iniciarSesion();
        Biblioteca.writeUsuarios();
        Biblioteca.writeLibros();

    }
}