from Usuario import Usuario
from Libro import Libro

class Biblioteca:
    def __init__(self):
        self.lista_usuarios = []
        self.lista_libros = []

    def agregar_usuario(self):
        nombre = input("Ingrese nombre del usuario: ")
        apellido = input("Ingrese el apellido del usuario: ")
        edad = int(input("Ingrese la edad del usuario: "))
        self.lista_usuarios.append(Usuario(nombre, apellido, edad))
        print("Usuario registrado exitosamente.")

    def mostrar_usuarios(self):
        print("------------LISTA DE USUARIOS------------")
        for usuario in self.lista_usuarios:
            print("Nombre:", usuario.nombre)
            print("Apellido:", usuario.apellido)
            print("Edad:", usuario.edad)
            print("----------------------------------------")

    def agregar_libro(self):
        codigo_del_libro = int(input("Ingrese el Codigo identificador del libro: "))
        titulo = input("Ingrese el titulo del libro: ")
        autor = input("Ingrese el nombre del autor: ")
        apellido_autor = input("Ingrese el apellido del autor: ")
        self.lista_libros.append(Libro(codigo_del_libro, titulo, autor, apellido_autor, True))
        print("Libro registrado exitosamente.")

    def mostrar_libros(self):
        print("------------LISTA DE LIBROS------------")
        for libro in self.lista_libros:
            print("Codigo del libro:", libro.codigo_del_libro)
            print("Titulo:", libro.titulo)
            print("Autor:", libro.autor, libro.apellido_autor)
            print("Disponibilidad:", "Disponible" if libro.disponibilidad else "No disponible")
            print("----------------------------------------")

    def rentar_libro(self):
        nombre_usuario = input("Ingrese el nombre del usuario que desea rentar: ")
        usuario = self.buscar_usuario(nombre_usuario)
        if usuario:
            print("Seleccione el libro que desea rentar:")
            self.mostrar_libros()
            codigo_libro = int(input("Ingrese el código del libro: "))
            libro = self.buscar_libro(codigo_libro)
            if libro and libro.disponibilidad:
                usuario.rentar_libro(libro)
                print("¡Libro rentado con éxito!")
            else:
                print("El libro no está disponible para rentar.")
        else:
            print("El usuario no existe.")

    def mostrar_libros_rentados(self):
        print("------------LIBROS RENTADOS------------")
        for usuario in self.lista_usuarios:
            if usuario.libros_rentados:
                print("Usuario:", usuario.nombre, usuario.apellido)
                print("Libros Rentados:")
                for libro in usuario.libros_rentados:
                    print("-", libro.titulo)
                print("---------------------------------------")

    def mostrar_libros_no_rentados(self):
        print("------------LIBROS NO RENTADOS------------")
        for libro in self.lista_libros:
            if libro.disponibilidad:
                print("-", libro.titulo)
        print("------------------------------------------")

    def buscar_usuario(self, nombre_usuario):
        for usuario in self.lista_usuarios:
            if usuario.nombre.lower() == nombre_usuario.lower():
                return usuario
        return None

    def buscar_libro(self, codigo_libro):
        for libro in self.lista_libros:
            if libro.codigo_del_libro == codigo_libro:
                return libro
        return None

    def comprar_libro(self):
        nombre_usuario = input("Ingrese el nombre del usuario que desea comprar: ")
        usuario = self.buscar_usuario(nombre_usuario)
        if usuario:
            print("Seleccione el libro que desea comprar:")
            self.mostrar_libros()
            codigo_libro = int(input("Ingrese el código del libro: "))
            libro = self.buscar_libro(codigo_libro)
            if libro and libro.disponibilidad:
                usuario.comprar_libro(libro)
                print("¡Libro comprado con éxito!")
            else:
                print("El libro no está disponible para comprar.")
        else:
            print("El usuario no existe.")

    def mostrar_libros_comprados(self):
        print("------------LIBROS COMPRADOS------------")
        for usuario in self.lista_usuarios:
            if usuario.libros_comprados:
                print("Usuario:", usuario.nombre, usuario.apellido)
                print("Libros Comprados:")
                for libro in usuario.libros_comprados:
                    print("-", libro.titulo)
                print("---------------------------------------")
