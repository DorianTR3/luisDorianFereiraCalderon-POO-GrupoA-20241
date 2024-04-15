import Productos.Productos
class Limpieza(Productos):
    def __init__(self, nombre, precio, fecha_de_importacion, stock, eco_friendly):
        super().__init__(nombre, precio, fecha_de_importacion, stock)
        self.eco_friendly = eco_friendly
        self.productos_limpieza = []
        self.leer = input  # Cambio Scanner por input en Python

    def registrar_producto_limpieza(self, nombre, precio, fecha_de_importacion, stock):
        band = True
        print("¿El producto es EcoFriendly? Ingrese 'si' o 'no'")
        while band:
            s = input().upper()  # Cambio nextLine() por input() en Python
            if s == "SI":
                self.eco_friendly = True
                band = False
            elif s == "NO":
                self.eco_friendly = False
                band = False
            else:
                print("Ingrese 'si' o 'no'")
        nuevo_producto_limpieza = Limpieza(nombre, precio, fecha_de_importacion, stock, self.eco_friendly)
        self.productos_limpieza.append(nuevo_producto_limpieza)