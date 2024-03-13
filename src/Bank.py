class Bank:
    def __init__(self):
        self.employees = []

    def add_employee(self, name, last_name, account_number, account_type):
        self.employees.append(Employee(name, last_name, account_number, account_type))

    def show_all_employees(self):
        for employee in self.employees:
            for account in employee.get_accounts():
                print(f"El empleado {employee.get_name()} {employee.get_last_name()} tiene la cuenta " +
                      f"{account.get_account_number()} con saldo de ${account.get_amount()} " +
                      f"y es de tipo {account.get_type()}")

    def show_employee_info(self, account_number):
        for employee in self.employees:
            for account in employee.get_accounts():
                if account.get_account_number() == account_number:
                    print(f"El empleado {employee.get_name()} {employee.get_last_name()} tiene la cuenta " +
                          f"{account.get_account_number()} con saldo de ${account.get_amount()} " +
                          f"y es de tipo {account.get_type()}")
                    return
        print("No se encontró ningún empleado con ese número de cuenta.")

    def deposit_to_account(self, account_number, amount):
        for employee in self.employees:
            for account in employee.get_accounts():
                if account.get_account_number() == account_number:
                    account.deposit(amount)
                    print(f"Se depositaron ${amount} en la cuenta {account_number}")
                    return
        print("No se encontró ninguna cuenta con ese número.")

    def withdraw_from_account(self, account_number, amount):
        for employee in self.employees:
            for account in employee.get_accounts():
                if account.get_account_number() == account_number:
                    account.withdraw(amount)
                    print(f"Se retiraron ${amount} de la cuenta {account_number}")
                    return
        print("No se encontró ninguna cuenta con ese número.")

if __name__ == "__main__":
    main = Main()
    main.run()