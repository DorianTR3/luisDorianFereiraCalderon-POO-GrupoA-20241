import java.util.ArrayList;
import Productos.Productos;

public class Clientes {
    public ArrayList<Clientes> getListaDeClientes() {
        return listaDeClientes;
    }

    ArrayList <Clientes> listaDeClientes=new ArrayList<>();
    private String nombre;
    private String apellido;
    private String fechaDeRegistro;
    private ArrayList<Productos> productosComprados;

    public int getId() {
        return id;
    }

    private int id;

    public Clientes(String nombre, String apellido, int id,String fechaDeRegistro){
        this.nombre=nombre;
        this.apellido=apellido;
        this.fechaDeRegistro=fechaDeRegistro;
        productosComprados = new ArrayList<>();

    }
    public void registrarclientes(String nombre,String apellido,int id, String fechaDeRegistro){
        Clientes nuevoCliente=new Clientes(nombre, apellido, id, fechaDeRegistro);
        listaDeClientes.add(nuevoCliente);
    }
    public void comprarProducto(Productos producto, int cantidad) {
        // Verificar si hay suficiente stock
        if (producto.getStock() >= cantidad) {
            // Reducir el stock del producto
            producto.setStock(producto.getStock() - cantidad);
            // Agregar el producto a la lista de productos comprados por el cliente
            productosComprados.add(producto);
            System.out.println("Compra realizada correctamente.");
        } else {
            System.out.println("No hay suficiente stock del producto.");
        }
    }

    // Método para mostrar la información básica de los clientes (nombre, apellido e id)
    public void mostrarListaClientes() {
        System.out.println("Lista de clientes:");
        for (Clientes cliente : listaDeClientes) {
            System.out.println("Nombre: " + cliente.nombre + ", Apellido: " + cliente.apellido + ", ID: " + cliente.id);
        }
    }

    // Método para mostrar la información completa de un cliente específico por su id
    public void mostrarInfoCliente(int idCliente) {
        for (Clientes cliente : listaDeClientes) {
            if (cliente.id == idCliente) {
                System.out.println("Nombre: " + cliente.nombre);
                System.out.println("Apellido: " + cliente.apellido);
                System.out.println("Fecha de Registro: " + cliente.fechaDeRegistro);
                System.out.println("Productos Comprados:");
                for (Productos producto : cliente.productosComprados) {
                    System.out.println("   - " + producto.getNombre());
                }
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
    }

    // Método para eliminar un cliente por su id si no ha comprado ningún producto
    public void eliminarCliente(int idCliente) {
        for (int i = 0; i < listaDeClientes.size(); i++) {
            Clientes cliente = listaDeClientes.get(i);
            if (cliente.id == idCliente && cliente.productosComprados.isEmpty()) {
                listaDeClientes.remove(i);
                System.out.println("Cliente eliminado correctamente.");
                return;
            }
        }
        System.out.println("No se puede eliminar el cliente.");
    }

    // Método para obtener el número total de clientes
    public int obtenerNumeroTotalClientes() {
        return listaDeClientes.size();
    }
}