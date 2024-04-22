package biblioteca;

import java.time.LocalDate;
import java.util.Scanner;
import Usuarios.usuario;
import Usuarios.utils.Rol;
import utils.usuarioEnSesion;

public class menu {
    private biblioteca biblioteca;
    private Scanner leer = new Scanner(System.in);
usuarioEnSesion usuarioEnSesion;
    public menu(biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void ejecutarMenuCliente() {
        System.out.println("Opciones:");
        System.out.println("1. Rentar un Libro"); // Mostrar libros disponibles para seleccionar un libro por rentar
        System.out.println("2. Ver libros rentados");
        System.out.println("3. Regresar libros rentados");
        System.out.println("4. Ver información personal");
        System.out.println("Introducir opción:");
        int opcion = leer.nextInt();
        switch (opcion) {
            case 1:
                // Mostrar libros disponibles
                System.out.println("Seleccione el libro que desee rentar");
                break;
            case 2:
                System.out.println("Los libros que tienes rentados son: ");
                // Mostrar ArrayList de libros rentados (solo los del cliente que está registrado)
                break;
            case 3:
                //regresa libros
                break;
            case 4:
                System.out.println("Mostrar información personal:");
                System.out.println("NOMBRE COMPLETO ");
                break;
        }
        System.out.println("");
    }

    public void menuParaEmpleados() {
        System.out.println("Opciones:");
        System.out.println("1. Registrar clientes");
        System.out.println("2. Registrar libros");
        System.out.println("3. Mostrar lista de clientes"); // Dentro de este método colocar otro donde pregunte si se desea ver la información de un usuario en específico
        System.out.println("4. Mostrar libros"); // Mostrar si están rentados o no
        System.out.println("5. Actualizar");
        System.out.println("6. Eliminar clientes");
        System.out.println("7. Eliminar un libro");
        System.out.println("Selecciona la opción que deseas:");
        int opcion = leer.nextInt();
        switch (opcion) {
            case 1: biblioteca.Registrarcliente();
                break;
            case 2: // Método de registrar un libro
                break;
            case 3: // Método de mostrar clientes
                // Método para mostrar la información detallada de un cliente
                break;
            case 4:
                // Mostrar si los libros están disponibles o no
                break;
            case 5: // Método para actualizar información
                break;
            case 6: // Método para eliminar clientes
                break;
            case 7: // Método para eliminar libros;
                break;
        }
    }

    public void menuParaGerentes() {
        System.out.println("Opciones:");
        System.out.println("1. Registrar clientes");
        System.out.println("2. Registrar libros");
        System.out.println("3. Mostrar lista de clientes");
        System.out.println("4. Mostrar libros"); // Mostrar si están rentados o no
        System.out.println("5. Actualizar");
        System.out.println("6. Eliminar clientes");
        System.out.println("7. Eliminar un libro");
        System.out.println("8. Agregar un empleado");
        System.out.println("9. Mostrar empleados");
        System.out.println("10. Eliminar un empleado");
        System.out.println("Selecciona la opción que deseas:");
        int opcion = leer.nextInt();
        switch (opcion) {
            case 1:
                biblioteca.Registrarcliente();
                break;
            case 2: // Método de registrar un libro
                break;
            case 3:
                biblioteca.mostrarClientes();
                break;
            case 4:
                String usuarios = "";
                System.out.println("ingrese el usuario del cliente que desea ver la informacion");
                usuarios= leer.nextLine();
                biblioteca.mostrarClienteEspecifico(usuarios);
                // Mostrar si los libros están disponibles o no
                break;
            case 5: // Método para actualizar información
                break;
            case 6: // Método para eliminar clientes
                break;
            case 7: // Método para eliminar libros;
                break;
            case 8:
                biblioteca.registrarTrabajador();
                break;
            case 9:
                biblioteca.MostrarTrabajadores();
                break;
            case 10: // Eliminar empleado
                break;
            case 11:
                usuarioEnSesion.cerrarSesion();
                break;
        }
    }

    public void iniciarSesion() {
        boolean datosCorrectos = false;
        int cont = 0;
        do {
            System.out.println("BIENVENIDO AL SISTEMA DE LA BIBLIOTECA.");
            System.out.println("Inicia sesión para continuar, tienes 5 intentos: ");

            System.out.println("Ingresa tu nombre de usuario: ");
            String user = leer.next();

            System.out.println("Ingresa tu contraseña: ");
            String contra = leer.next();
            cont++;

            usuario actual = biblioteca.verificarInicioSesion(user, contra);

            if (actual != null && cont < 5) {
                seleccionarMenu(actual);
            } else if (cont >= 5) {
                System.out.println("INTENTOS TERMINADOS, TERMINANDO EL PROGRAMA. ");
                datosCorrectos = true;
            } else {
                System.out.println("DATOS INCORRECTOS. ");
            }
        } while (!datosCorrectos);
    }

    public void seleccionarMenu(usuario user) {
        switch (user.getRol()) {
            case GERENTE:
                menuParaGerentes();
                break;
            case TRABAJADOR:
                menuParaEmpleados();
                break;
            case CLIENTE:
                ejecutarMenuCliente();
                break;
        }
    }
}
