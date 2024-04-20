package Productos;

import java.util.ArrayList;
import java.util.Scanner;
public class alimentos extends Productos{
    Scanner leer=new Scanner(System.in);
    ArrayList <alimentos> ProductosAlimentos=new ArrayList<>();
    private String FechaDeCaducidad;
    public alimentos(String nombre, double precio, String fechaDeImportacion, int stock, String fechaDeCaducidad) {
        super(nombre, precio, fechaDeImportacion, stock);
        this.FechaDeCaducidad = fechaDeCaducidad;
    }
    public void RegistrarProductoAlimento(String nombre,double precio, String fechaDeImportacion, int stock){
        System.out.println("ingrese la fecha de caducidad con la siguiente estructura: dia/mes/año, ejepmlo: 06/10/24");
        FechaDeCaducidad=leer.nextLine();
        alimentos nuevoAlimento=new alimentos(nombre, precio,fechaDeImportacion, stock, FechaDeCaducidad);
        ProductosAlimentos.add(nuevoAlimento);
    }
    public ArrayList<alimentos> getProductosAlimentos() {
        return ProductosAlimentos;
    }

}
