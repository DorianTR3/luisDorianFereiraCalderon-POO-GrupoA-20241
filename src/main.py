import random

class Main:
    def __init__(self):
        self.bank = Bank()

    def run(self):
        while True:
            print("Menu:")
            print("1. Agregar empleado")
            print("2. Mostrar información de todos los empleados")
            print("3. Mostrar información de un empleado")
            print("4. Depositar dinero en una cuenta")
            print("5. Retirar dinero de una cuenta")
            print("6. Salir")
            option = int(input("Ingrese la opción: "))
            if option == 1:
                name = input("Ingrese el nombre del empleado: ")
                last_name = input("Ingrese el apellido del empleado: ")
                account_number = random.randint(10000, 99999)
                account_type = input("Ingrese el tipo de cuenta (A, B o C): ")
                self.bank.add_employee(name, last_name, account_number, account_type)
            elif option == 2:
                self.bank.show_all_employees()
            elif option == 3:
                account_number = int(input("Ingrese el número de cuenta del empleado: "))
                self.bank.show_employee_info(account_number)
            elif option == 4:
                account_number = int(input("Ingrese el número de cuenta en la que desea depositar: "))
                deposit_amount = float(input("Ingrese la cantidad a depositar: "))
                self.bank.deposit_to_account(account_number, deposit_amount)
            elif option == 5:
                account_number = int(input("Ingrese el número de cuenta de la que desea retirar: "))
                withdraw_amount = float(input("Ingrese la cantidad a retirar: "))
                self.bank.withdraw_from_account(account_number, withdraw_amount)
            elif option == 6:
                print("Saliendo del programa...")
                break
            else:
                print("Opción no válida. Inténtelo de nuevo.")