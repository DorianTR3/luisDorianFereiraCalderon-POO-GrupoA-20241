package Biblioteca.Libros;


import Biblioteca.Biblioteca;
import Biblioteca.Libros.Constantes.Genero;
import Biblioteca.Libros.UtilsLibros.LibrosUtils;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class LibroComedia extends Libro{

    public LibroComedia(String titulo, String autor, String editorial, LocalDate fecha, double precio, int stock) {
        super(titulo, autor, editorial, fecha, Genero.Comedia, precio, stock);
    }

    public static void registrarLibroComedia(){
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> datosComun = LibrosUtils.getLibrosComun();

        String nombre = datosComun.get(0);
        String autor = datosComun.get(1);
        String editorial = datosComun.get(2);
        LocalDate fechaPublicacion = LocalDate.parse(datosComun.get(3));
        double precio = Double.parseDouble(datosComun.get(4));
        int stock = Integer.parseInt(datosComun.get(5));

        LibroComedia librocomedia = new LibroComedia(nombre, autor, editorial, fechaPublicacion, precio, stock);
    }

    public static LibroComedia seleccionarLibroComedia(){
        Scanner scanner = new Scanner(System.in);
        String titulo = null;
        LibroComedia libroComedia = null;
        do{
            for (Libro libro : Biblioteca.libros.get(Genero.Comedia)){
                libro.mostrarLibro();
            }
            System.out.print("Ingrese el Titulo: ");
            titulo = scanner.nextLine();
            for (Libro libro : Biblioteca.libros.get(Genero.Comedia)){
                if(titulo == libro.getTitulo()){
                    libroComedia = (LibroComedia) libro;
                    break;
                }
            }
            if(titulo == null){ System.out.println("El Titulo no existe"); }
        }while(libroComedia == null);
        return libroComedia;
    }

    @Override
    public void eliminarLibro() {
        Biblioteca.libros.get(Genero.Comedia).remove(this);
    }

    @Override
    public void filtradoTitulo(String titulo){
        Biblioteca.libros.get(Genero.Comedia).stream()
                .filter(libro -> libro.getTitulo().contains(titulo))
                .forEach(libro -> libro.mostrarLibro());
    }

    @Override
    public void filtradoPrecio(double precio) {
        Biblioteca.libros.get(Genero.Comedia).stream()
                .filter(libro -> libro.getPrecio()>precio)
                .forEach(libro -> libro.mostrarLibro());
    }

    @Override
    public void filtradoGenero() {
    }

    @Override
    public void filtradoStock(int stock) {
        Biblioteca.libros.get(Genero.Comedia).stream()
                .filter(libro -> libro.getStock()>stock)
                .forEach(libro -> libro.mostrarLibro());
    }

    @Override
    public void filtradoAutor(String autor) {
        Biblioteca.libros.get(Genero.Comedia).stream()
                .filter(libro -> libro.getAutor().contains(autor))
                .forEach(libro -> libro.mostrarLibro());
    }
}