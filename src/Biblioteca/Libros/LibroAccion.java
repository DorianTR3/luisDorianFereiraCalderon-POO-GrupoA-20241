package Biblioteca.Libros;
import Biblioteca.Biblioteca;
import Biblioteca.Libros.Constantes.Genero;
import Biblioteca.Libros.UtilsLibros.LibrosUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibroAccion extends Libro {

    public LibroAccion(String titulo, String autor, String editorial, LocalDate fecha, double precio, int stock) {
        super(titulo, autor, editorial, fecha, Genero.Terror, precio, stock);
    }

    public static void registrarLibroAccion(){
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> datosComun = LibrosUtils.getLibrosComun();

        String nombre = datosComun.get(0);
        String autor = datosComun.get(1);
        String editorial = datosComun.get(2);
        LocalDate fechaPublicacion = LocalDate.parse(datosComun.get(3));
        double precio = Double.parseDouble(datosComun.get(4));
        int stock = Integer.parseInt(datosComun.get(5));

        LibroAccion libroaccion = new LibroAccion(nombre, autor, editorial, fechaPublicacion, precio, stock);

    }

    public static LibroAccion seleccionarLibroAccion(){
        Scanner scanner = new Scanner(System.in);
        String titulo = null;
        LibroAccion libroaccion = null;
        do{
            for (Libro libro : Biblioteca.libros.get(Genero.Accion)){
                libro.mostrarLibro();
            }
            System.out.print("Ingrese el Titulo: ");
            titulo = scanner.nextLine();
            for (Libro libro : Biblioteca.libros.get(Genero.Accion)){
                if(titulo == libro.getTitulo()){
                    libroaccion = (LibroAccion) libro;
                    break;
                }
            }
            if(titulo == null){
                System.out.println("El Titulo no existe");
            }
        }while(libroaccion == null);
        return libroaccion;
    }

    @Override
    public void eliminarLibro() {
        Biblioteca.libros.get(Genero.Accion).remove(this);
    }

    @Override
    public void filtradoTitulo(String titulo){
        Biblioteca.libros.get(Genero.Accion).stream()
                .filter(libro -> libro.getTitulo().contains(titulo))
                .forEach(libro -> libro.mostrarLibro());
    }

    @Override
    public void filtradoPrecio(double precio) {
        Biblioteca.libros.get(Genero.Accion).stream()
                .filter(libro -> libro.getPrecio()>precio)
                .forEach(libro -> libro.mostrarLibro());
    }

    @Override
    public void filtradoGenero() {
    }

    @Override
    public void filtradoStock(int stock) {
        Biblioteca.libros.get(Genero.Accion).stream()
                .filter(libro -> libro.getStock()>stock)
                .forEach(libro -> libro.mostrarLibro());
    }

    @Override
    public void filtradoAutor(String autor) {
        Biblioteca.libros.get(Genero.Accion).stream()
                .filter(libro -> libro.getAutor().contains(autor))
                .forEach(libro -> libro.mostrarLibro());
    }
}