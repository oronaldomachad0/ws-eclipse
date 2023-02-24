package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entities.Employee;
import Entities.OutsourcedEmployee;


public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Locale.setDefault(Locale.US);

		List<Employee> list = new ArrayList<>();

		System.out.print("Quantidade de funcionarios: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Funcionario # " + i + " dados:");
			System.out.print("Funcionario é tercerizado? (y/n): ");
			char ch = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Horas: ");
			int hours = sc.nextInt();
			System.out.print("Valor por hora: ");
			double valuePerHour = sc.nextDouble();

			if (ch == 'y') {
				System.out.print("Pagamento adicional: ");
				double additionalCharge = sc.nextDouble();
				list.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));

			} else {
				Employee emp = new Employee(name, hours, valuePerHour);
				list.add(emp);
			}
		}

		System.out.println();
		System.out.println("Pagamentos");

		for (Employee emp: list) {
			System.out.println(emp.getName() + " - $" + String.format("%.2f", emp.payment()));
		}

		sc.close();
	}

}