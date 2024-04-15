import Productos.Productos

class Electrodomesticos(Productos):
    def __init__(self, nombre, precio, fecha_de_importacion, stock, peso_en_kg, garantia):
        super().__init__(nombre, precio, fecha_de_importacion, stock)
        self.peso_en_kg = peso_en_kg
        self.garantia = garantia
        self.leer = input  # Cambio Scanner por input en Python

    def registrar_producto_electrodomestico(self, nombre, precio, fecha_de_importacion, stock):
        print("Ingrese el peso en Kg del producto:")
        self.peso_en_kg = float(input())  # Cambio nextDouble() por float(input()) en Python
        print("Ingrese si el producto tiene garantía o no (si/no):")
        while True:
            s = input().upper()  # Cambio nextLine().toUpperCase() por input().upper() en Python
            if s == "SI":
                self.garantia = True
                break
            elif s == "NO":
                self.garantia = False
                break
            else:
                print("Ingrese 'si' o 'no'")
        nuevo_producto = Electrodomesticos(nombre, precio, fecha_de_importacion, stock, self.peso_en_kg, self.garantia)
