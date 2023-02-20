package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entitites.Empregado;
import entitites.EmpregadoTercerizado;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Empregado> list = new ArrayList<>();
		
		System.out.print("Entre com o numero de empregados ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Empregado #" + i + " dados:");
			System.out.print("Tercerizado (y/n)? ");
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
				list.add(new EmpregadoTercerizado(name, hours, valuePerHour, additionalCharge));
			}
			else {
				list.add(new Empregado(name, hours, valuePerHour));
			}
		}
		
		System.out.println();
		System.out.println("Pagamentos:");
		for (Empregado empregado  : list) {
			System.out.println(empregado.getNome() + " - $ " + String.format("%.2f", empregado.pagamento()));
		}
		
		sc.close();
	}
}
