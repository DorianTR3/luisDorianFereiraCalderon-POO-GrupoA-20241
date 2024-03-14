class Libro:
    def __init__(self, codigo_del_libro, titulo, autor, apellido_autor, disponibilidad):
        self.codigo_del_libro = codigo_del_libro
        self.titulo = titulo
        self.autor = autor
        self.apellido_autor = apellido_autor
        self.disponibilidad = disponibilidad

    def set_disponibilidad(self, disponibilidad):
        self.disponibilidad = disponibilidad