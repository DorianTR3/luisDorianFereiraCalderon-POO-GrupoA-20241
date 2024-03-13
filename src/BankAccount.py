class BankAccount:
    def __init__(self, account_number, account_type):
        self.account_number = account_number
        self.amount = 0
        self.type = account_type

    def get_account_number(self):
        return self.account_number

    def get_type(self):
        return self.type

    def get_amount(self):
        return self.amount

    def deposit(self, amount):
        if self.type == 'A':
            if self.amount + amount <= 50000:
                self.amount += amount
            else:
                print("No puede tener más de 50,000 cuenta A")
        elif self.type == 'B':
            if self.amount + amount <= 100000:
                self.amount += amount
            else:
                print("No puede tener más de 100,000 cuenta B")
        else:
            self.amount += amount

    def withdraw(self, amount):
        min_balance = 0
        if self.type == 'A':
            min_balance = 1000
        elif self.type == 'B':
            min_balance = 5000
        else:
            min_balance = 10000

        if self.amount - amount >= min_balance:
            self.amount -= amount
        else:
            print("No puede retirar esa cantidad, saldo insuficiente o mínimo no alcanzado.")
