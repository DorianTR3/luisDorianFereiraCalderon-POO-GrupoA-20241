import Productos.Productos

class Belleza(Productos):
    def __init__(self, nombre, precio, fecha_de_importacion, stock, color):
        super().__init__(nombre, precio, fecha_de_importacion, stock)
        self.color = color
        self.productos_belleza = []

    def registrar_producto_belleza(self, nombre, precio, fecha_de_importacion, stock):
        print("Ingrese el color del producto de belleza:")
        self.color = input()
        nuevo_producto_belleza = Belleza(nombre, precio, fecha_de_importacion, stock, self.color)
        self.productos_belleza.append(nuevo_producto_belleza)
