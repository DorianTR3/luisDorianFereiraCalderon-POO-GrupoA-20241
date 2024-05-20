package Biblioteca;
import Biblioteca.Libros.*;
import Biblioteca.Libros.Constantes.Genero;
import Usuarios.*;
import Usuarios.utils.Rol;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
public class Biblioteca {

    @SuppressWarnings("RawTypes")
    public static HashMap<Rol,ArrayList<Usuario>> usuarios = new HashMap<>(); //el rol es la llave, el arraylist es el valor que se le da a cada llave
    public static HashMap<Genero,ArrayList<Libro>> libros = new HashMap<>();

    public Biblioteca (){
        inicializarLlaves();
    }

    private void inicializarLlaves(){
        usuarios.put(Rol.Trabajador,new ArrayList<>());
        usuarios.put(Rol.Clientes,new ArrayList<>());
        usuarios.put(Rol.Gerente,new ArrayList<>());

        libros.put(Genero.Terror,new ArrayList<>());
        libros.put(Genero.Accion,new ArrayList<>());
        libros.put(Genero.Comedia,new ArrayList<>());
    }

    public static void registrarTerror(){
        LibroTerror.registrarLibroTerror();
    }

    public static void registrarComedia(){
        LibroComedia.registrarLibroComedia();
    }

    public static void registrarAccion(){
        LibroAccion.registrarLibroAccion();
    }



    public Usuario verificarInicioSesion(String nombreUsuario, String contrasena) {
        for (ArrayList<Usuario> listaUsuarios : usuarios.values()) {
            if (listaUsuarios != null) {
                for (Usuario usuario : listaUsuarios) {
                    if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasena().equals(contrasena)) {
                        return usuario;
                    }
                }
            }
        }

        System.out.println("Usuario o contraseña incorrectos, inténtelo nuevamente");
        return null;
    }

    // Usuarios
    public void mostrarUsuarios(){
        Usuario.mostrarUsuarios();
    }

    public void consultarUsuarios(){
        Usuario.consultarUsuarios();
    }

    public void mostrarUsuarioEspecifico(String nombreUsuario){
        Usuario.mostrarUsuarioEspecifico(nombreUsuario);
    }

    // Clientes
    public void mostrarClientes(){
        Cliente.mostrarClientes();
    }

    public void registrarCliente() {
        Cliente.registrarCliente();
    }

    public void eliminarCliente() {
        Cliente.eliminarCliente();
    }

    // Trabajadores
    public void mostrarTrabajadores(){
        Trabajador.mostrarTrabajadores();
    }

    public void registrarTrabajador(){
        Trabajador.registrarTrabajador();
    }

    public void eliminarTrabajador(){
        Trabajador.eliminarTrabajador();
    }

    // Gerentes
    public void mostrarGerentes(){
        Gerente.mostrarGerentes();
    }

    public void registrarGerente(){
        Gerente.registrarGerente();
    }

    public void eliminarGerente(){
        Gerente.eliminarGerente();
    }

    public void actualizarUsuario(){
        Usuario.actualizarDatosComun();
    }

    // Libros Accion
    public void mostrarLibrosAccion(){

    }

    public void registrarLibroAccion(){
        LibroAccion.registrarLibroAccion();
    }

    public void eliminarLibroAccion(LibroAccion libroAccion){
        libroAccion.eliminarLibro();
    }

    public void actualizarLibroAccion(){
        Usuario.actualizarDatosComun();
    }
    public static void writeUsuarios(){
        Gson json = new GsonBuilder().setPrettyPrinting().create();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.json"));
            json.toJson(usuarios, writer);
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void writeLibros(){
        Gson json = new GsonBuilder().setPrettyPrinting().create();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Libros.json"));
            json.toJson(libros, writer);
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void deserialize() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("usuarios.json"));
            Gson gson = new Gson();
            UsuarioModel usuariosModel = gson.fromJson(reader, UsuarioModel.class);

            ArrayList<Usuario> usuariosTrabajadores = new ArrayList<>(usuariosModel.getTrabajadores());
            ArrayList<Usuario> usuariosCliente = new ArrayList<>(usuariosModel.getClientes());
            ArrayList<Usuario> usuariosGerentes = new ArrayList<>(usuariosModel.getGerentes());

            BufferedReader readerL = new BufferedReader(new FileReader("libros.json"));
            LibrosModel librosModel = gson.fromJson(readerL, LibrosModel.class);
            readerL.close();

            ArrayList<Libro> librosAccion = new ArrayList<>(librosModel.getLibrosAccion());
            ArrayList<Libro> librosComedia = new ArrayList<>(librosModel.getLibroComedia());
            ArrayList<Libro> libroTerror = new ArrayList<>(librosModel.getLibroTerrors());

            libros.put(Genero.Accion, librosAccion);
            libros.put(Genero.Comedia, librosComedia);
            libros.put(Genero.Terror, libroTerror);
            usuarios.put(Rol.Trabajador, usuariosTrabajadores);
            usuarios.put(Rol.Clientes, usuariosCliente);
            usuarios.put(Rol.Gerente, usuariosGerentes);




        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } catch (JsonSyntaxException e) {
            System.out.println(e);
        } catch (JsonParseException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}