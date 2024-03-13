def main():
    biblioteca = Biblioteca()

    while True:
        print("-----------------------MENU----------------------")
        print("1. Agregar usuario")
        print("2. Mostrar información de los usuarios")
        print("3. Agregar libro")
        print("4. Lista de libros")
        print("5. Rentar un libro")
        print("6. Comprar un libro")
        print("7. Listar libros rentados")
        print("8. Listar libros no rentados")
        print("9. Listar libros comprados")
        print("10. Salir")
        opcion = int(input("Ingrese la opción: "))

        if opcion == 1:
            biblioteca.agregar_usuario()
        elif opcion == 2:
            biblioteca.mostrar_usuarios()
        elif opcion == 3:
            biblioteca.agregar_libro()
        elif opcion == 4:
            biblioteca.mostrar_libros()
        elif opcion == 5:
            biblioteca.rentar_libro()
        elif opcion == 6:
            biblioteca.comprar_libro()
        elif opcion == 7:
            biblioteca.mostrar_libros_rentados()
        elif opcion == 8:
            biblioteca.mostrar_libros_no_rentados()
        elif opcion == 9:
            biblioteca.mostrar_libros_comprados()
        elif opcion == 10:
            print("Saliendo del programa...")
            break
        else:
            print("Opción no válida. Por favor, ingrese un número del 1 al 10.")

if __name__ == "__main__":
    main()

