from Productos import alimentos
from Productos import limpieza
from Productos import belleza
from Productos import electrodomesticos
from Productos import Productos
import Clientes

if __name__ == "__main__":
    alimento = alimentos.Alimentos("", 0, "", 0, "")
    producto_belleza = belleza.Belleza("", 0, "", 0, "")
    producto = Productos.Productos("", 0, "", 0)
    productos_limpieza = limpieza.Limpieza("", 0, "", 0, True)
    producto_electrodomesticos = electrodomesticos.Electrodomesticos("", 0, "", 0, 0, False)
    clientes = Clientes.Clientes("", "", 0, "")
    contrasena = "Hola"
    band = True
    while band:
        print("Ingrese la contraseña: ")
        con = input()
        if con == contrasena:
            print("Contraseña correcta")
            band = False
        else:
            print("Contraseña incorrecta")

    band = True
    while band:
        print("Opciones")
        print("1. Registrar productos")
        print("2. Mostrar productos")
        print("3. Registrar cliente")
        print("Introduzca su opción: ")
        opcion = int(input())

        if opcion == 1:
            print("¿Qué tipo de producto desea registrar?")
            print("1. Alimentos")
            print("2. Belleza")
            print("3. Limpieza")
            print("4. Electrodomésticos")
            print("Seleccione su opción: ")
            opcion2 = int(input())

            if opcion2 in [1, 2, 3, 4]:
                print("Opción seleccionada de manera correcta")
            else:
                print("Opción no válida")
                break

            print("Ingrese nombre del producto: ")
            nombre = input()
            print("Ingrese el precio del producto: ")
            precio = float(input())
            print("Ingrese la fecha de importación con la estructura día/mes/año")
            fecha_de_importacion = input()
            print("Ingrese el número del stock: ")
            stock = int(input())

            if opcion2 == 1:
                alimento.registrar_producto_alimento(nombre, precio, fecha_de_importacion, stock)
            elif opcion2 == 2:
                producto_belleza.registrar_producto_belleza(nombre, precio, fecha_de_importacion, stock)
            elif opcion2 == 3:
                productos_limpieza.registrar_producto_limpieza(nombre, precio, fecha_de_importacion, stock)
            elif opcion2 == 4:
                producto_electrodomesticos.registrar_producto_electrodomestico(nombre, precio, fecha_de_importacion,
                                                                               stock)

        elif opcion == 2:
            numero_de_productos = len(alimento.get_productos_alimentos())
            print("Número de productos:", numero_de_productos)

        elif opcion == 3:
            bandcase3 = False
            print("Ingrese el nombre del cliente")
            nombre = input()
            print("Ingrese el apellido del cliente")
            apellido = input()
            id_cliente = 0
            while not bandcase3:
                print("Ingrese el ID del cliente")
                idaux = int(input())
                bandcase3 = True
                for cliente in clientes.lista_de_clientes:
                    if cliente.get_id() == idaux:
                        print("Este ID no es válido, introduzca uno nuevo")
                        bandcase3 = False
                        break
                if bandcase3:
                    id_cliente = idaux
            print("Ingrese la fecha de registro con el siguiente formato: día/mes/año")
            fecha_de_registro = input()
            clientes.registrar_cliente(nombre, apellido, id_cliente, fecha_de_registro)

        elif opcion == 4:
            print("Ingrese el nombre del producto: ")
            nombre_producto = input()
            producto_modificacion = Productos.buscar_producto_por_nombre(nombre_producto)
            if producto_modificacion is not None:
                print("Ingrese la cantidad a modificar (positiva para aumentar, negativa para disminuir): ")
                cantidad = int(input())
                producto.modificar_stock(cantidad)
            else:
                print("Producto no encontrado.")

        elif opcion == 5:
            print("Ingrese el nombre del producto a eliminar: ")
            nombre_producto_eliminar = input()
            producto_eliminar = Productos.buscar_producto_por_nombre(nombre_producto_eliminar)
            if producto_eliminar is not None:
                producto_eliminar.eliminar_producto()
            else:
                print("Producto no encontrado.")

        elif opcion == 6:
            print("Ingrese el nombre del producto: ")
            nombre_info_producto = input()
            info_producto = Productos.buscar_producto_por_nombre(nombre_info_producto)
            if info_producto is not None:
                info_producto.mostrar_info_producto()
            else:
                print("Producto no encontrado.")

        elif opcion == 7:
            total_clientes = clientes.obtener_numero_total_clientes()
            print("El número total de clientes es:", total_clientes)

        elif opcion == 8:
            print("¡Adiós!")
            band = False

        else:
            print("Opción inválida")