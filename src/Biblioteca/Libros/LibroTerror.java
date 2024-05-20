package Biblioteca.Libros;

import Biblioteca.Biblioteca;
import Biblioteca.Libros.Constantes.Genero;
import Biblioteca.Libros.Constantes.SubGeneroTerror;
import Biblioteca.Libros.UtilsLibros.LibrosUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibroTerror extends Libro {

    private SubGeneroTerror subGeneroTerror;
    public LibroTerror(String titulo, String autor, String editorial, LocalDate fecha, double precio, int stock, SubGeneroTerror subGeneroTerror) {
        super(titulo, autor, editorial, fecha,Genero.Terror, precio, stock);
        this.subGeneroTerror = subGeneroTerror;
    }

    public static void registrarLibroTerror() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> datosComun = LibrosUtils.getLibrosComun();

        String nombre = datosComun.get(0);
        String autor = datosComun.get(1);
        String editorial = datosComun.get(2);
        LocalDate fechaPublicacion = LocalDate.parse(datosComun.get(3));
        double precio = Double.parseDouble(datosComun.get(4));
        int stock = Integer.parseInt(datosComun.get(5));

        System.out.println("Ingresa el subgenero del libro");
        System.out.println("Selecciona una opción");
        System.out.println("1. Psicológico");
        System.out.println("2. Crímen");

        int opcionSubgenero;
        SubGeneroTerror subgeneroInput = null;
        while (true) {
            try {
                System.out.println("Ingresa la opcion: ");
                opcionSubgenero = scanner.nextInt();

                if (opcionSubgenero == 1  || opcionSubgenero == 2) {
                    break;
                } else {
                    System.out.println("Opcion no existente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número entero.");
                scanner.nextLine();
            }
        }

        if (opcionSubgenero == 1) {
            subgeneroInput = SubGeneroTerror.Psicologico;
        } else {
            subgeneroInput = SubGeneroTerror.Crimen;
        }

        LibroTerror libroTerror = new LibroTerror(nombre, autor, editorial, fechaPublicacion, precio, stock, subgeneroInput);

    }

    public static LibroTerror seleccionarLibroTerror(){
        Scanner scanner = new Scanner(System.in);
        String titulo = null;
        LibroTerror libroterror = null;
        do{
            for (Libro libro : Biblioteca.libros.get(Genero.Terror)){
                libro.mostrarLibro();
            }
            System.out.print("Ingrese el Titulo: ");
            titulo = scanner.nextLine();
            for (Libro libro : Biblioteca.libros.get(Genero.Terror)){
                if(titulo == libro.getTitulo()){
                    libroterror = (LibroTerror) libro;
                    break;
                }
            }
            if(titulo == null){
                System.out.println("El Titulo no existe");
            }
        }while(libroterror == null);
        return libroterror;
    }

    @Override
    public void filtradoPrecio(double precio) {
        Biblioteca.libros.get(Genero.Terror).stream()
                .filter(libro -> libro.getPrecio()>precio)
                .forEach(libro -> libro.mostrarLibro());

    }

    @Override
    public void eliminarLibro() {
        Biblioteca.libros.get(Genero.Terror).remove(this);
    }

    @Override
    public void filtradoTitulo(String titulo){
        Biblioteca.libros.get(Genero.Terror).stream()
                .filter(libro -> libro.getTitulo().contains(titulo))
                .forEach(libro -> libro.mostrarLibro());
    }

    @Override
    public void filtradoGenero() {
    }

    @Override
    public void filtradoStock(int stock) {
        Biblioteca.libros.get(Genero.Terror).stream()
                .filter(libro -> libro.getStock()>stock)
                .forEach(libro -> libro.mostrarLibro());
    }

    @Override
    public void filtradoAutor(String autor) {
        Biblioteca.libros.get(Genero.Terror).stream()
                .filter(libro -> libro.getAutor().contains(autor))
                .forEach(libro -> libro.mostrarLibro());
    }

    public SubGeneroTerror getSubGeneroTerror() {
        return subGeneroTerror;
    }
}