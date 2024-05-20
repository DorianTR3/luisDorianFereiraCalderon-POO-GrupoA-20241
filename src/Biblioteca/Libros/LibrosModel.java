package Biblioteca.Libros;
import java.util.ArrayList;

public class LibrosModel {

    private ArrayList<LibroAccion> librosAccion=new ArrayList<>();

    private ArrayList<LibroTerror> libroTerror=new ArrayList<>();

    private ArrayList<LibroComedia> libroComedia=new ArrayList<>();


    public ArrayList<LibroComedia> getLibroComedia() {

        return libroComedia != null ? libroComedia : new ArrayList<>();
    }

    public ArrayList<LibroAccion> getLibrosAccion() {
        return librosAccion != null ? librosAccion : new ArrayList<>();
    }

    public ArrayList<LibroTerror> getLibroTerrors() {
        return libroTerror != null ? libroTerror : new ArrayList<>();
    }

}
