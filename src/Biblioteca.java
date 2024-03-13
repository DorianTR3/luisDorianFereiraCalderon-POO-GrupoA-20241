import java.util.ArrayList;
import java.util.Scanner;
class Biblioteca {
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Libro> listaLibros;

    public Biblioteca() {
        listaUsuarios = new ArrayList<>();
        listaLibros = new ArrayList<>();
    }

    public void agregarUsuario() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese nombre del usuario:");
        String nombre = leer.nextLine();
        System.out.println("Ingrese el apellido del usuario:");
        String apellido = leer.nextLine();
        System.out.println("Ingrese la edad del usuario:");
        int edad = leer.nextInt();
        listaUsuarios.add(new Usuario(nombre, apellido, edad));
        System.out.println("Usuario registrado exitosamente.");
    }

    public void mostrarUsuarios() {
        System.out.println("------------LISTA DE USUARIOS------------");
        for (Usuario usuario : listaUsuarios) {
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Apellido: " + usuario.getApellido());
            System.out.println("Edad: " + usuario.getEdad());
            System.out.println("----------------------------------------");
        }
    }

    public void agregarLibro() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el Codigo identificador del libro:");
        int codigoDelLibro = leer.nextInt();
        leer.nextLine(); // Consumir la nueva línea residual
        System.out.println("Ingrese el titulo del libro:");
        String titulo = leer.nextLine();
        System.out.println("Ingrese el nombre del autor:");
        String autor = leer.nextLine();
        System.out.println("Ingrese el apellido del autor:");
        String apellidoAutor = leer.nextLine();
        listaLibros.add(new Libro(codigoDelLibro, titulo, autor, apellidoAutor, true));
        System.out.println("Libro registrado exitosamente.");
    }

    public void mostrarLibros() {
        System.out.println("------------LISTA DE LIBROS------------");
        for (Libro libro : listaLibros) {
            System.out.println("Codigo del libro: " + libro.getCodigoDelLibro());
            System.out.println("Titulo: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor() + " " + libro.getApellidoAutor());
            System.out.println("Disponibilidad: " + (libro.getDisponibilidad() ? "Disponible" : "No disponible"));
            System.out.println("----------------------------------------");
        }
    }

    public void rentarLibro() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el nombre del usuario que desea rentar:");
        String nombreUsuario = leer.nextLine();
        Usuario usuario = buscarUsuario(nombreUsuario);
        if (usuario != null) {
            System.out.println("Seleccione el libro que desea rentar:");
            mostrarLibros();
            System.out.print("Ingrese el código del libro: ");
            int codigoLibro = leer.nextInt();
            Libro libro = buscarLibro(codigoLibro);
            if (libro != null && libro.getDisponibilidad()) {
                usuario.rentarLibro(libro);
                System.out.println("¡Libro rentado con éxito!");
            } else {
                System.out.println("El libro no está disponible para rentar.");
            }
        } else {
            System.out.println("El usuario no existe.");
        }
    }

    public void mostrarLibrosRentados() {
        System.out.println("------------LIBROS RENTADOS------------");
        for (Usuario usuario : listaUsuarios) {
            if (!usuario.getLibrosRentados().isEmpty()) {
                System.out.println("Usuario: " + usuario.getNombre() + " " + usuario.getApellido());
                System.out.println("Libros Rentados:");
                for (Libro libro : usuario.getLibrosRentados()) {
                    System.out.println("- " + libro.getTitulo());
                }
                System.out.println("---------------------------------------");
            }
        }
    }

    public void mostrarLibrosNoRentados() {
        System.out.println("------------LIBROS NO RENTADOS------------");
        for (Libro libro : listaLibros) {
            if (libro.getDisponibilidad()) {
                System.out.println("- " + libro.getTitulo());
            }
        }
        System.out.println("------------------------------------------");
    }

    private Usuario buscarUsuario(String nombreUsuario) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombre().equalsIgnoreCase(nombreUsuario)) {
                return usuario;
            }
        }
        return null;
    }

    private Libro buscarLibro(int codigoLibro) {
        for (Libro libro : listaLibros) {
            if (libro.getCodigoDelLibro() == codigoLibro) {
                return libro;
            }
        }
        return null;
    }
    public void comprarLibro() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el nombre del usuario que desea comprar:");
        String nombreUsuario = leer.nextLine();
        Usuario usuario = buscarUsuario(nombreUsuario);
        if (usuario != null) {
            System.out.println("Seleccione el libro que desea comprar:");
            mostrarLibros();
            System.out.print("Ingrese el código del libro: ");
            int codigoLibro = leer.nextInt();
            Libro libro = buscarLibro(codigoLibro);
            if (libro != null && libro.getDisponibilidad()) {
                usuario.comprarLibro(libro);
                System.out.println("¡Libro comprado con éxito!");
            } else {
                System.out.println("El libro no está disponible para comprar.");
            }
        } else {
            System.out.println("El usuario no existe.");
        }
    }

    public void mostrarLibrosComprados() {
        System.out.println("------------LIBROS COMPRADOS------------");
        for (Usuario usuario : listaUsuarios) {
            if (!usuario.getLibrosComprados().isEmpty()) {
                System.out.println("Usuario: " + usuario.getNombre() + " " + usuario.getApellido());
                System.out.println("Libros Comprados:");
                for (Libro libro : usuario.getLibrosComprados()) {
                    System.out.println("- " + libro.getTitulo());
                }
                System.out.println("---------------------------------------");
            }
        }
    }
}