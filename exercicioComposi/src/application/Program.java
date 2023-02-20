package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Entre com o nome do departamento: ");
		String departmentName = sc.nextLine();
		System.out.println("Entre com os dados do trabalhor ");
		System.out.print("Nome: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Salario Base: ");
		double baseSalary = sc.nextDouble();

		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary,
				new Department(departmentName));

		System.out.print("Quantos contratos esse trabalhador tem? ");
        int n = sc.nextInt();
		for (int i = 1; i <=n; i++) {
			System.out.println("Entre com contrato #" + i + "data: ");
			System.out.println("Data (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double ValuePerHour = sc.nextDouble();
			System.out.print("Duração do contrato: ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, ValuePerHour, hours);
			worker.addContract(contract);
		}

		System.out.println();
		System.out.println("Entre com mês e ano para calcular o salario: ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));

		System.out.println("Name: " + worker.getName());
		System.out.println("Departamento: " + worker.getDepartment().getName());
		System.out.println("Salario: " + monthAndYear + ":" + String.format("%.2f", worker.income(year, month)));
		sc.close();

	}

}
