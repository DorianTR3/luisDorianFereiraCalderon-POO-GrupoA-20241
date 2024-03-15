from BankAccount import BankAccount

class Employee:
    def __init__(self, name, last_name, account_number, account_type):
        self.name = name
        self.last_name = last_name
        self.accounts = []
        self.add_account(account_number, account_type)

    def add_account(self, account_number, account_type):
        self.accounts.append(BankAccount(account_number, account_type))

    def get_name(self):
        return self.name

    def get_last_name(self):
        return self.last_name

    def get_accounts(self):
        return self.accounts