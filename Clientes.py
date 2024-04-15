class Clientes:
    def __init__(self, nombre, apellido, id, fecha_de_registro):
        self.nombre = nombre
        self.apellido = apellido
        self.fecha_de_registro = fecha_de_registro
        self.productos_comprados = []

    def registrar_cliente(self, nombre, apellido, id_cliente, fecha_de_registro):
        nuevo_cliente = Clientes(nombre, apellido, id_cliente, fecha_de_registro)
        lista_de_clientes.append(nuevo_cliente)

    def comprar_producto(self, producto, cantidad):
        if producto.stock >= cantidad:
            producto.stock -= cantidad
            self.productos_comprados.append(producto)
            print("Compra realizada correctamente.")
        else:
            print("No hay suficiente stock del producto.")

    def mostrar_lista_clientes(self):
        print("Lista de clientes:")
        for cliente in lista_de_clientes:
            print("Nombre:", cliente.nombre, ", Apellido:", cliente.apellido, ", ID:", cliente.id)

    def mostrar_info_cliente(self, id_cliente):
        for cliente in lista_de_clientes:
            if cliente.id == id_cliente:
                print("Nombre:", cliente.nombre)
                print("Apellido:", cliente.apellido)
                print("Fecha de Registro:", cliente.fecha_de_registro)
                print("Productos Comprados:")
                for producto in cliente.productos_comprados:
                    print("   -", producto.nombre)
                return
        print("Cliente no encontrado.")

    def eliminar_cliente(self, id_cliente):
        for cliente in lista_de_clientes:
            if cliente.id == id_cliente and not cliente.productos_comprados:
                lista_de_clientes.remove(cliente)
                print("Cliente eliminado correctamente.")
                return
        print("No se puede eliminar el cliente.")

    def obtener_numero_total_clientes(self):
        return len(lista_de_clientes)


# Lista de clientes
lista_de_clientes = []
