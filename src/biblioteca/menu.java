package biblioteca;
import java.util.Scanner;
public class menu {
    static biblioteca biblioteca=new biblioteca();
    static Scanner leer=new Scanner(System.in);
    //cliente
    //ver sus rentas, su ifo, ver libros disponiles

    //trabajador
    //Registrar Clientes y libtos (CRUD)
    // C- create
    // R- Read
    // U- Update
    // D- Delete

    //gerente
    //todo lo del trabajador
    public static void ejecutarMenuCliete(){
        System.out.println("opciones:");
        System.out.println("1. Rentar un Libro");//mostrar libros disponibles para seleccionar un libro por rentar
        System.out.println("2. ver libros retados");
        System.out.println("3. Regresar Libros Rentados");
        System.out.println("4. ver informacion personal");
        System.out.println("Introducir opcion");
        int Opcion=leer.nextInt();
        switch (Opcion){
            case 1:
                //mostrar libros disponibles
                System.out.println("Seleccione el libro que desee rentar");
                break;

            case 2:
                System.out.println("los libros que tienes rentados son: ");
                //mostrar arraylist de libros rentados (solo los del cliente que esta registrado)
                break;

            case 3:
                biblioteca.RegresarLibro();
                break;
            case 4:
                System.out.println("mostrar informacion personal:");
                System.out.println("NOMBRE COMPLETO ");
        }
        System.out.println("");
    }

    public static void menuParaEmpleados(){
        System.out.println("opciones");
        System.out.println("1. registrar clientes");
        System.out.println("2. registrar Libros");
        System.out.println("3. mostrar lista de clientes"); //dentro de este metodo colocar otro donde pregntar si se desea ver la informacion de un usuario en especifico
        System.out.println("4. mostrar libros");//mostrar si estan rentados o no
        System.out.println("5. actualizar");
        System.out.println("6. Eliminar clientes");
        System.out.println("7. eliminar un libro");
        System.out.println("selecione la opcion que desea");
        int opcion= leer.nextInt();
        switch (opcion){
            case 1: //metodo registrar cliente
                break;
            case 2: //metodo de registrar un libro
                break;
            case 3: //metodo de mostrar clientes
                //metodo para mostrar la informacion detallada de un cliente
                break;
            case 4: //metodo de mostrar clientes
                //mostrar si los libros estan disponibles o no
                break;
            case 5: //metodo para actualizar informacion
                break;
            case 6: //metodo para eliminar clientes
                break;
            case 7: //metodo para eliminar libros;
        }
    }
    public static void menuParaGerentes(){
        System.out.println("opciones");
        System.out.println("1. registrar clientes");
        System.out.println("2. registrar Libros");
        System.out.println("3. mostrar lista de clientes"); //dentro de este metodo colocar otro donde pregntar si se desea ver la informacion de un usuario en especifico
        System.out.println("4. mostrar libros");//mostrar si estan rentados o no
        System.out.println("5. actualizar");
        System.out.println("6. Eliminar clientes");
        System.out.println("7. eliminar un libro");
        System.out.println("8. agregar un empleado");
        System.out.println("9. Mostrar empleados");
        System.out.println("10. eliminar un empleado");
        System.out.println("selecione la opcion que desea");
        int opcion= leer.nextInt();
        switch (opcion){
            case 1: //metodo registrar cliente
                break;
            case 2: //metodo de registrar un libro
                break;
            case 3: //metodo de mostrar clientes
                //metodo para mostrar la informacion detallada de un cliente
                break;
            case 4: //metodo de mostrar clientes
                //mostrar si los libros estan disponibles o no
                break;
            case 5: //metodo para actualizar informacion
                break;
            case 6: //metodo para eliminar clientes
                break;
            case 7: //metodo para eliminar libros;
                break;
            case 8: //agregar un empleado
                break;
            case 9: //mostrar empleados
                break;
            case 10: //eliminar empleado
                break;
        }
    }
}
