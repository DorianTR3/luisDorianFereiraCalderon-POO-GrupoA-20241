package biblioteca;
import java.time.LocalDate;
import java.util.ArrayList;
import Usuarios.cliente;
import Usuarios.gerente;
import Usuarios.trabajador;
import Usuarios.usuario;
import Usuarios.utils.Rol;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
//tarea: refactor para separar la clase
public class biblioteca {
    Scanner leer=new Scanner(System.in);
    usuario usuario;
    public HashMap<Rol, ArrayList<usuario>> ListaDeUsuarios=new HashMap<Rol, ArrayList<usuario>>();
    private ArrayList<cliente> Listaclientes = new ArrayList<>();
    private ArrayList<gerente> Listagerentes = new ArrayList<>();
    private ArrayList<trabajador> Listatrabajadores = new ArrayList<>();

    public usuario verificarInicioSesion(String nombreUsuario, String contrasena) {
        for (ArrayList<usuario> listaUsuarios : ListaDeUsuarios.values()) {
            // Busca el usuario en la lista correspondiente al rol
            for (usuario usuario : listaUsuarios) {
                if (usuario.getUsuario().equals(nombreUsuario) && usuario.getContraseña().equals(contrasena)) {
                    return usuario;
                }
            }
        }
        // Si no se encuentra el usuario, retorna null
        return null;
    }
    public void RegresarLibro(){

    }
    private void agregarUsuario(usuario usuario, Rol rol) {
        if (!ListaDeUsuarios.containsKey(rol)) {
            ListaDeUsuarios.put(rol, new ArrayList<>());
        }
        ListaDeUsuarios.get(rol).add(usuario);
    }

    public void Registrarcliente() {
        ArrayList<String> datosComun=obtenerDatosEnComun(Rol.CLIENTE);
        String nombre =datosComun.get(0);
        String apellido =datosComun.get(1);
        System.out.println("Ingrese el año de nacimiento:");
        int año = leer.nextInt();
        System.out.println("Ingrese mes de nacimiento:");
        int mes = leer.nextInt();
        System.out.println("Ingrese el día de nacimiento:");
        int dia = leer.nextInt();
        leer.nextLine();
        String telefono=datosComun.get(3);
        String Usuario = datosComun.get(4);
        String Contraseña = datosComun.get(5);
        cliente cliente = new cliente(nombre, apellido, LocalDate.of(año, mes, dia),LocalDate.now(),telefono,Usuario, Contraseña);
        agregarCliente(cliente);
    }
    public void agregarCliente(cliente cliente) {
            agregarUsuario(cliente, Rol.CLIENTE);
            Listaclientes.add(cliente);
    }

    public void agregarGerente(gerente gerente) {
        agregarUsuario(gerente, Rol.GERENTE);
        Listagerentes.add(gerente);
    }

    public void agregarTrabajador(trabajador trabajador) {
        agregarUsuario(trabajador, Rol.TRABAJADOR);
        Listatrabajadores.add(trabajador);
    }
    public void registrarTrabajador(){
        System.out.println("Ingrese el nombre del trabajador:");
        String nombre = leer.nextLine();
        System.out.println("Ingrese el apellido del traajador:");
        String apellido = leer.nextLine();
        System.out.println("Ingrese el año de nacimiento:");
        int año = leer.nextInt();
        System.out.println("Ingrese mes de nacimiento:");
        int mes = leer.nextInt();
        System.out.println("Ingrese el día de nacimiento:");
        int dia = leer.nextInt();
        leer.nextLine(); // Limpia el buffer del scanner
        System.out.println("ingrese el sueldo del Trabajador");
        double sueldo= leer.nextDouble();
        System.out.println("ingrese el RFC");
        String RFC=leer.nextLine();
        String Usuario = "";
        String telefono=obtenerNumeroDeTelefono();
        while (true) {
            System.out.println("Ingrese el usuario que desea registrar:");
            Usuario = leer.nextLine();
            if (!usuario.ComprobarUsuario(Usuario)) {
                System.out.println("El usuario ya está registrado. Intente con otro.");
            } else {
                break;
            }
        }

        System.out.println("Ingrese la contraseña:");
        String Contraseña = leer.nextLine();
        trabajador trabajador=new trabajador(nombre, apellido, sueldo,RFC, telefono,Usuario, Contraseña, LocalDate.of(año,mes,dia));
        agregarTrabajador(trabajador);
    }
    public void mostrarUsuarios() {
            System.out.println(usuario.getNombre()+"su rol es: "+usuario.getRol());

    }
    public void mostrarClientes() {
        System.out.println("Lista De clientes Registrados");
        ArrayList<usuario> clientes = ListaDeUsuarios.get(Rol.CLIENTE);
        for (int i = 0; clientes != null && i < clientes.size(); i++) {
            System.out.println(i + ".- " + clientes.get(i).toString());
        }
    }
    public void MostrarTrabajadores(){
        System.out.println("Lista De trabajadores Registrados");
        ArrayList<usuario> trabajador = ListaDeUsuarios.get(Rol.TRABAJADOR);
        for (int i = 0; trabajador != null && i < trabajador.size(); i++) {
            System.out.println(i + ".- " + trabajador.get(i).toString());
        }
    }
    public void mostrarClienteEspecifico(String usuario){
        for (int i = 0; i < Listaclientes.size(); i++) {
            if (usuario.equals(Listaclientes.get(i).getUsuario())){
                System.out.println("nombre: "+Listaclientes.get(i).getNombre()+Listaclientes.get(i).getApellido());
                System.out.println("fecha de Registro"+Listaclientes.get(i).getFechaDeRegisto());

                break;
            }else{
                System.out.println("usuario no encontrado, asegurese de que lo introduzca de manera correcta ");
            }
        }
    }
    public String obtenerNumeroDeTelefono() {
        String telefono = "";
        boolean numeroUsuarioExistente = true;
        do {
            System.out.println("Ingrese el número de teléfono:");
            telefono = leer.nextLine();
            numeroUsuarioExistente = false;
            // Recorre cada lista de usuarios en el HashMap
            for (ArrayList<usuario> listaUsuarios : ListaDeUsuarios.values()) {
                // Verifica si el número de teléfono está en alguna lista de usuarios
                for (usuario usuario : listaUsuarios) {
                    if (usuario.getNumeroDeTelefono().equals(telefono)) {
                        numeroUsuarioExistente = true;
                        break;
                    }
                }
                // Si ya se encontró el número en alguna lista, sal del bucle
                if (numeroUsuarioExistente) {
                    break;
                }
            }
        } while (numeroUsuarioExistente);
        return telefono;
    }
    private ArrayList<String> obtenerDatosEnComun(Rol Rol) {
        String RolActual=Rol == Rol.CLIENTE ? "cliente" : Rol==Rol.TRABAJADOR? "Trabajador":"GERENTE";
        System.out.println(String.format("\nRegistrar %s", RolActual));
        ArrayList <String> datosEnComun=new ArrayList();
        System.out.println("Ingrese el nombre del cliente:");
        String nombre = leer.nextLine();
        System.out.println("Ingrese el apellido del cliente:");
        String apellido = leer.nextLine();
        String telefono=obtenerNumeroDeTelefono();
        String Usuario="";
        while (true) {
            System.out.println("Ingrese el usuario que desea registrar:");
            Usuario = leer.nextLine();
            if (!usuario.ComprobarUsuario(Usuario)) {
                System.out.println("El usuario ya está registrado. Intente con otro.");
            } else {
                break;
            }
        }
        System.out.println("Ingrese la contrasña");
        String contraseña= leer.nextLine();
        Arrays.asList(nombre, apellido, telefono, usuario, contraseña).addAll(datosEnComun);
        return datosEnComun;
    }

}
