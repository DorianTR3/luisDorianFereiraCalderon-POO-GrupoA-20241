package Productos;
import java.util.ArrayList;
import java.util.Scanner;
public class limpieza extends Productos{
    ArrayList <limpieza> ProductosLimpieza= new ArrayList<>();
    //si es false no es ecoFriendly si es true si lo es;
    private boolean ecoFriendly;
    Scanner leer=new Scanner(System.in);

    public limpieza(String nombre, double precio, String fechaDeImportacion, int stock, boolean ecoFriendly) {
        super(nombre, precio, fechaDeImportacion, stock);
        this.ecoFriendly=ecoFriendly;
    }
    public void RegistrarProductoLimpieza(String nombre,double precio, String fechaDeImportacion, int stock){
        Boolean band=true;
        System.out.println("el producto es EcoFriendly?, ingrese si o no");
        while(band==true){
        String s=leer.nextLine().toUpperCase();
            if (s.equals("SI")){
                ecoFriendly=true;
                band=false;
            } else if (s.equals("NO")) {
                ecoFriendly=false;
                band=false;
            }else{
                System.out.println("ingrese si o no");
            }
        }
        limpieza productoNuevoLimpieza=new limpieza(nombre, precio, fechaDeImportacion, stock, ecoFriendly);
        ProductosLimpieza.add(productoNuevoLimpieza);
    }
}
