package Usuarios;

import Biblioteca.Biblioteca;
import Biblioteca.utils.DatosComun;
import Usuarios.utils.Rol;
import Utils.UsuarioEnSesion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
    private static int CANTIDAD_USARIOS = 1;
    private int id;
    private String nombre;
    private String apellido;
    private Rol rol;
    private LocalDate fechaNacimineto;
    private String contrasena;
    private String nombreUsuario;
    private String numeroTelefono;

    public Usuario(String nombre, String apellido, Rol rol, LocalDate fechaNacimiento,String numeroTelefono, String contrasena, String nombreUsuario) {
        this.id= CANTIDAD_USARIOS;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
        this.fechaNacimineto = fechaNacimiento;
        this.numeroTelefono = numeroTelefono;
        this.contrasena = contrasena;
        this.nombreUsuario = nombreUsuario;
        CANTIDAD_USARIOS++;
    }
    @Override
    public String toString(){
        return String.format("ID %d, Nombre completo: %s %s, rol %s", id,nombre,apellido,rol);
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public Rol getRol() {
        return rol;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public LocalDate getFechaNacimineto() {
        return fechaNacimineto;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public static void mostrarUsuarioEspecifico(String nombreUsuario){
        Usuario usuario = null;
        for (ArrayList<Usuario> listaUsuarios : Biblioteca.usuarios.values()) {
            for (Usuario usuarioF : listaUsuarios) {
                if (usuarioF.getNombreUsuario().equals(nombreUsuario)) {
                    usuario = usuarioF;
                }
            }
        }
        if (usuario == null){
            System.out.println("Usuario no valido");
            return;
        }
        if (usuario.getRol() == Rol.Gerente){
            Gerente.mostrarGerente((Gerente) usuario);
        }
        else if (usuario.getRol() == Rol.Trabajador){
            Trabajador.mostrarTrabajador((Trabajador) usuario);
        }
        else if (usuario.getRol() == Rol.Clientes) {
            Cliente.mostrarCliente((Cliente) usuario);
        }
    }

    public static void consultarUsuarios(){
        for (ArrayList<Usuario> listaUsuarios : Biblioteca.usuarios.values()){
            for (Usuario usuario : listaUsuarios){
                if (usuario.getRol() == Rol.Gerente){
                    Gerente.mostrarGerente((Gerente) usuario);
                }
                else if (usuario.getRol() == Rol.Trabajador){
                    Trabajador.mostrarTrabajador((Trabajador) usuario);
                }
                else if (usuario.getRol() == Rol.Clientes) {
                    Cliente.mostrarCliente((Cliente) usuario);
                }
            }
        }
    }

    public static void mostrarUsuario(Usuario usuario){
        System.out.printf("%s - %s %s Fecha de nacimiento: %s",usuario.getNombreUsuario(), usuario.getNombre(), usuario.getApellido(), usuario.getFechaNacimineto());
    }

    public static void mostrarUsuarios(){
        for(ArrayList<Usuario> listaUsuarios : Biblioteca.usuarios.values()){
            for(Usuario usuario : listaUsuarios){
                System.out.println(usuario.getNombreUsuario());
            }
        }
    }

    public static void eliminarUsuario(Usuario usuario) {
        if (UsuarioEnSesion.getUsuarioActual().getNombreUsuario().equals(usuario.getNombreUsuario())) {
            System.out.println("NO SE PUEDE ELIMINAR EL USUARIO QUE ESTA EN SESION");
        } else {
            ArrayList<Usuario> listaUsuarios = Biblioteca.usuarios.get(usuario.getRol());
            if (listaUsuarios != null) {
                listaUsuarios.remove(usuario);
                System.out.println("USUARIO ELIMINADO CORRECTAMENTE. ");
            }
        }
    }


    public static void actualizarDatosComun(){
        Scanner leer = new Scanner(System.in);
        mostrarUsuarios();
        System.out.println("Ingrese el usuario que quiere cambiar: ");
        String nombreUsuario = leer.nextLine();
        Usuario usuarioCambiar = null;
        for(ArrayList<Usuario> listaUsuario : Biblioteca.usuarios.values()){
            for (Usuario usuario : listaUsuario){
                if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                    usuarioCambiar = usuario;
                }
            }
        }
        if (usuarioCambiar != null){
            do{
                System.out.println("Opciones a cambiar: ");
                System.out.println("1. Nombre");
                System.out.println("2. Apellido ");
                System.out.println("3. Contrasena");
                System.out.println("4. Numero de telefono");
                String rolActual = usuarioCambiar.getRol() == Rol.Clientes ? "" : usuarioCambiar.getRol() == Rol.Trabajador ? "5. RFC" : "5. CURP";
                System.out.println(rolActual);
                System.out.println("6. Salir");
                String opcion = leer.nextLine();
                if(opcion.equals("1")){
                    System.out.println("Ingrese el nuevo nombre: ");
                    String nombreN = leer.nextLine();
                    usuarioCambiar.setNombre(nombreN);
                }
                else if(opcion.equals("2")){
                    System.out.println("Ingrese el nuevo apellido: ");
                    String apellidoN = leer.nextLine();
                    usuarioCambiar.setApellido(apellidoN);
                }
                else if(opcion.equals("3")){
                    System.out.println("Ingrese el nuevo contrasena: ");
                    String contrasenaN = leer.nextLine();
                    usuarioCambiar.setContrasena(contrasenaN);
                }
                else if(opcion.equals("4")){
                    String telefonoN = DatosComun.obtenerNumeroTelefono();
                    usuarioCambiar.setNumeroTelefono(telefonoN);
                }
                else if(opcion.equals("5")){
                    if (usuarioCambiar.getRol() == Rol.Gerente){
                        System.out.println("Ingrese el nuevo CURP: ");
                        String curpN = leer.nextLine();
                        Gerente gerente = (Gerente) usuarioCambiar;
                        gerente.setCurp(curpN);
                    }
                    else if (usuarioCambiar.getRol() == Rol.Trabajador){
                        System.out.println("Ingrese el nuevo RFC: ");
                        String rfcN = leer.nextLine();
                        Trabajador trabajador = (Trabajador) usuarioCambiar;
                        trabajador.setRfc(rfcN);
                    }
                }
                else if(opcion.equals("6")){
                    break;
                }
            }while (true);


        }
    }


}
