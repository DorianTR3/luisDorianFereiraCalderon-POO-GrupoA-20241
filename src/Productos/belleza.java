package Productos;
import java.util.Scanner;
import java.util.ArrayList;
public class belleza extends Productos{
    ArrayList <belleza> productosBelleza=new ArrayList<belleza>();
    Scanner leer=new Scanner(System.in);
    private String color;
    public belleza(String nombre, double precio, String fechaDeImportacion, int stock, String color) {
        super(nombre, precio, fechaDeImportacion, stock);
        this.color=color;

    }
    public void RegistrarProductoBelleza(String nombre,double precio, String fechaDeImportacion, int stock){
        System.out.println("ingrese la fecha de caducidad con la siguiente estructura: dia/mes/año, ejepmlo: 06/10/24");
        color=leer.nextLine();
        belleza belleza=new belleza(nombre, precio, fechaDeImportacion, stock,color);
        productosBelleza.add(belleza);
    }
}
