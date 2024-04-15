import Productos.Productos

class Alimentos(Productos):
    def __init__(self, nombre, precio, fecha_de_importacion, stock, fecha_de_caducidad):
        super().__init__(nombre, precio, fecha_de_importacion, stock)
        self.fecha_de_caducidad = fecha_de_caducidad
        self.productos_alimentos = []

    def registrar_producto_alimento(self, nombre, precio, fecha_de_importacion, stock):
        print("Ingrese la fecha de caducidad con la siguiente estructura: día/mes/año, ejemplo: 06/10/24")
        self.fecha_de_caducidad = input()
        nuevo_alimento = Alimentos(nombre, precio, fecha_de_importacion, stock, self.fecha_de_caducidad)
        self.productos_alimentos.append(nuevo_alimento)

    def get_productos_alimentos(self):
        return self.productos_alimentos
