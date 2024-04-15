package Productos;
import java.util.Scanner;
public class electrodomesticos extends Productos{
    Scanner leer=new Scanner(System.in);
private double pesoEnKg;
private boolean garantia;
    public electrodomesticos(String nombre, double precio, String fechaDeImportacion, int stock, double pesoEnKg, boolean garantia) {
        super(nombre, precio, fechaDeImportacion, stock);
        this.garantia=garantia;
    }
public void registrarProductoElectrodomestico(String nombre,double precio, String fechaDeImportacion, int stock){
    System.out.println("ingrese el peso en Kg del producto");
    boolean band=true;
    pesoEnKg= leer.nextDouble();
    System.out.println("ingrese si el producto tiene garantia o no: ");
    while(band==true){
        String s=leer.nextLine().toUpperCase();
        if (s.equals("SI")){
            garantia=true;
            break;
        } else if (s.equals("NO")) {
            garantia=false;
            break;
        }else{
            System.out.println("ingrese si o no");
        }
    }
    electrodomesticos nuevoProducto=new electrodomesticos(nombre,precio,fechaDeImportacion,stock,pesoEnKg,garantia);
}
}
