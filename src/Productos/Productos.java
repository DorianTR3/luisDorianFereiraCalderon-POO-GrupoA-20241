package Productos;

import java.util.ArrayList;

public class Productos {
    private String nombre;
    private double precio;
    private String fechaDeImportacion;
    private int stock;
    private static int NumeroDelProducto = 1;
    private int NumeroDeSerie;
    public static ArrayList<Productos> listaDeProductos = new ArrayList<>();

    public Productos(String nombre, double precio, String fechaDeImportacion, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.fechaDeImportacion = fechaDeImportacion;
        this.stock = stock;
        this.NumeroDeSerie = NumeroDelProducto;
        NumeroDelProducto++;
    }

    // Métodos getter y setter
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }
    public void modificarStock(int cantidad) {
        this.stock += cantidad;
        System.out.println("Stock modificado correctamente para el producto: " + this.nombre);
    }

    // Método para eliminar un producto si nunca ha sido comprado
    public void eliminarProducto() {
        if (this.stock > 0) {
            System.out.println("No se puede eliminar el producto " + this.nombre + ", ya que tiene stock.");
        } else {
            for (Productos producto : listaDeProductos) {
                if (producto == this) {
                    listaDeProductos.remove(this);
                    System.out.println("Producto " + this.nombre + " eliminado correctamente.");
                    return;
                }
            }
        }
    }
    public void mostrarInfoProducto() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("Fecha de Importación: " + fechaDeImportacion);
        System.out.println("Stock: " + stock);
    }
    public static Productos buscarProductoPorNombre(String nombre) {
        for (Productos producto : listaDeProductos) {
            if (producto.nombre.equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

    public static Productos buscarProductoPorNumeroSerie(int numeroSerie) {
        for (Productos producto : listaDeProductos) {
            if (producto.NumeroDeSerie == numeroSerie) {
                return producto;
            }
        }
        return null;
    }
}