import java.util.ArrayList;
class Usuario {
    private String nombre;
    private String apellido;
    private int edad;
    private ArrayList<Libro> librosRentados;
    private ArrayList<Libro> librosComprados;
    public Usuario(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        librosRentados = new ArrayList<>();
        librosComprados = new ArrayList<>();

    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public ArrayList<Libro> getLibrosRentados() {
        return librosRentados;
    }

    public void rentarLibro(Libro libro) {
        librosRentados.add(libro);
        libro.setDisponibilidad(false);
    }
    public void comprarLibro(Libro libro) {
        librosComprados.add(libro);
        libro.setDisponibilidad(false);
    }

    public ArrayList<Libro> getLibrosComprados() {
        return librosComprados;
    }
}
