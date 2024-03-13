class Usuario:
    def __init__(self, nombre, apellido, edad):
        self.nombre = nombre
        self.apellido = apellido
        self.edad = edad
        self.libros_rentados = []
        self.libros_comprados = []

    def rentar_libro(self, libro):
        self.libros_rentados.append(libro)
        libro.set_disponibilidad(False)

    def comprar_libro(self, libro):
        self.libros_comprados.append(libro)
        libro.set_disponibilidad(False)