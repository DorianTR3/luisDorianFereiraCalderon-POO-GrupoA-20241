
import Productos.*;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        alimentos alimento=new alimentos("", 0, "", 0, "");
        belleza productoBelleza =new belleza("", 0, "", 0, "");
        Productos producto=new Productos("", 0, "",0);
        limpieza productosLimpieza=new limpieza("", 0, "", 0,true);
        electrodomesticos productoElectrodomesticos=new electrodomesticos("", 0, "", 0, 0, false);
        Clientes clientes=new Clientes("", "", 0, "");
        Scanner leer=new Scanner(System.in);
        final String Contraseña="Hola";
        boolean band=true;
        while(band==true) {
            System.out.println("ingrese la contraseña: ");
            String con = leer.nextLine();
            if (con.equals(Contraseña)) {
                System.out.println("contraseña correcta");
                band = false;
            } else {
                System.out.println("contraseña incorrecta;");
            }
        }
        band=true;
        while(band==true) {
            System.out.println("Opciones");
            System.out.println("1. Registrar productos");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Registrar cliente");
            System.out.println("4. Modificar stock de un producto");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Mostrar información de un producto");
            System.out.println("7. Ver número total de clientes");
            System.out.println("8. Salir");
            System.out.println("Introduzca su opción: ");
            int opcion = leer.nextInt();
            switch (opcion){
                case 1:
                    leer.nextLine();
                    System.out.println("que tipo de producto deseas registrar");
                    System.out.println("1. Alimentos");
                    System.out.println("2. Belleza");
                    System.out.println("3. Limpieza");
                    System.out.println("4. Electrodomesticos");
                    System.out.println("seleccione su opcion: ");
                    int opcion2= leer.nextInt();
                    leer.nextLine();
                    if (opcion2==1 || opcion2==2 || opcion2==3 || opcion2==4 ){
                        System.out.println("opcion seleccionada de manera correcta");
                    }else{
                        System.out.println("Opcion no valida"); break;
                    }
                    System.out.println("ingrese nombre del producto: ");
                    String nombre = leer.nextLine();
                    System.out.println("ingrese el precio del producto: ");
                    double precio = leer.nextDouble();
                    leer.nextLine();
                    System.out.println("ingrese la fecha de importacion con la estructura dia/mes/año");
                    String fechaDeimportacion = leer.nextLine();
                    System.out.println("ingrese el numero del stock: ");
                    int stock = leer.nextInt();
                    if (opcion2==1){
                        alimento.RegistrarProductoAlimento(nombre, precio, fechaDeimportacion, stock);
                    } else if (opcion2==2) {
                        productoBelleza.RegistrarProductoBelleza(nombre,precio,fechaDeimportacion,stock);
                    } else if (opcion2==3) {
                        productosLimpieza.RegistrarProductoLimpieza(nombre,precio,fechaDeimportacion,stock);

                    } else if (opcion2==4) {
                        productoElectrodomesticos.registrarProductoElectrodomestico(nombre,precio,fechaDeimportacion,stock);
                    }
                    break;
                case 2:
                    int numeroDeProductos=0;
                    numeroDeProductos=alimento.getProductosAlimentos().size();
                    break;
                case 3:
                    boolean bandcase3=false;
                    leer.nextLine();
                    System.out.println("ingrese el nombre del cliente");
                    nombre= leer.nextLine();
                    System.out.println("ingrese el apeelido del cliente");
                    String apellido=leer.nextLine();
                    int id = 0; // Declarar la variable id fuera del ciclo
                    do {
                        System.out.println("Ingrese el ID del cliente");
                        int idaux = leer.nextInt();
                        bandcase3 = true; // Establecer bandera como verdadera por defecto
                        for (int i = 0; i < clientes.listaDeClientes.size(); i++) {
                            if (clientes.getListaDeClientes().get(i).getId() == idaux) {
                                System.out.println("Este ID no es válido, introduzca uno nuevo");
                                bandcase3 = false;
                                break;
                            }
                        }
                        if (bandcase3) {
                            id = idaux;
                        }
                    } while (!bandcase3);
                    System.out.println("ingrese la fecha de registro con el siguiente formato: dia/mes/año");
                    String fechaDeRegistro= leer.nextLine();
                    clientes.registrarclientes(nombre, apellido, id, fechaDeRegistro);

                break;
                case 4:
                System.out.println("Ingrese el nombre del producto: ");
                String nombreProducto = leer.nextLine();
                Productos productoModificacion = Productos.buscarProductoPorNombre(nombreProducto);
                if (productoModificacion != null) {
                    System.out.println("Ingrese la cantidad a modificar (positiva para aumentar, negativa para disminuir): ");
                    int cantidad = leer.nextInt();
                    producto.modificarStock(cantidad);
                } else {
                    System.out.println("Producto no encontrado.");
                }
                break;
                case 5:

                    System.out.println("Ingrese el nombre del producto a eliminar: ");
                    String nombreProductoEliminar = leer.nextLine();
                    Productos productoEliminar = Productos.buscarProductoPorNombre(nombreProductoEliminar);
                    if (productoEliminar != null) {
                        productoEliminar.eliminarProducto();
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 6:
                    System.out.println("Ingrese el nombre del producto: ");
                    String nombreInfoProducto = leer.nextLine();
                    Productos infoProducto = Productos.buscarProductoPorNombre(nombreInfoProducto);
                    if (infoProducto != null) {
                        infoProducto.mostrarInfoProducto();
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 7:

                    int totalClientes = clientes.obtenerNumeroTotalClientes();
                    System.out.println("El número total de clientes es: " + totalClientes);
                    break;
                case 8:
                    System.out.println("¡Adiós!");
                    band = false;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }
}
