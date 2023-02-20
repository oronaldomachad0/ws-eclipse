package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {

	public static void main(String[] args) {

		Account acc = new Account(1001, "Alex", 0.0);

		BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500);

		// UPcasting
		Account acc1 = bacc;
		Account acc2 = new BusinessAccount(1003, "Carlos", 0.0, 110);
		Account acc3 = new SavingsAccount(1004, "ana", 0.0, 1.3);

		// Downcasting
		BusinessAccount acc4 = (BusinessAccount) acc2;
		acc4.loan(100.0);

		// BusinessAccount acc5 = (BusinessAccount)acc3;
		if (acc3 instanceof BusinessAccount) {
			BusinessAccount acc5 = (BusinessAccount) acc3;
			acc5.loan(100.0);
			System.out.println("Emprestimo");
		}

		if (acc3 instanceof SavingsAccount) {
			SavingsAccount acc5 = (SavingsAccount) acc3;
			acc5.updateBalance();
			System.out.println("Update");
			System.out.println(acc.getBalance());
		}

		// override
		System.out.println("override");

		Account acc6 = new Account(1006, "pipo", 1000);

		acc6.withdraw(200.0);
		System.out.println(acc6.getBalance());

		Account acc7 = new SavingsAccount(1007, "joao", 1000.0, 0.01);
		acc7.withdraw(200);
		System.out.println(acc7.getBalance());

		// super
		System.out.println("super");

		Account acc8 = new BusinessAccount(1008, "marco", 1000.0, 500.0);
		acc8.withdraw(200);
		System.out.println(acc8.getBalance());

		// poli
		System.out.println("polimorfismo");
		Account x = new Account(1020, "alex", 1000.0);
		Account y = new SavingsAccount(1023, "maria", 1000.0, 0.01);

		x.withdraw(50.0);
		y.withdraw(50.0);
		
		System.out.println(x.getBalance());
		System.out.println(y.getBalance());

	}

}
