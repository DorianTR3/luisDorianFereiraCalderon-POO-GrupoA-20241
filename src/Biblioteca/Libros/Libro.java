package Biblioteca.Libros;

import Biblioteca.Libros.Constantes.Genero;

import java.time.LocalDate;

public abstract class Libro {
    public static int CANTIDAD_LIBROS = 1;
    private int id;
    private String titulo;
    private String autor;
    private String editorial;
    private LocalDate fecha;
    private Genero genero;
    private double precio;
    private int stock;

    public Libro (String titulo, String autor, String editorial, LocalDate fecha, Genero genero, double precio, int stock) {
        this.id = CANTIDAD_LIBROS;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.fecha = fecha;
        this.genero = genero;
        this.precio = precio;
        this.stock = stock;
        CANTIDAD_LIBROS ++;
    }

    protected void mostrarLibro(){
        System.out.println("ID: " + this.id);
        System.out.println("Título: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("Editorial: " + this.editorial);
        System.out.println("Fecha: " + this.fecha);
        System.out.println("Género: " + this.genero);
        System.out.println("Precio: " + this.precio);
        System.out.println("Stock: " + this.stock);
    }

    protected abstract void eliminarLibro();

    protected abstract void filtradoPrecio(double precio);

    protected abstract void filtradoGenero();

    protected abstract void filtradoStock(int stock);

    protected abstract void filtradoAutor(String autor);

    protected abstract void filtradoTitulo(String titulo);

    public double getPrecio(){
        return precio;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getFechaString() {
        return fecha.toString();
    }

    public Genero getGenero() {
        return genero;
    }

    public int getStock() {
        return stock;
    }
}