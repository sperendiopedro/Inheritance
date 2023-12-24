package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutSourcedEmployee;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Employee> list = new ArrayList<>();

		System.out.println("Enter the number of employees: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("----Employee #" + i + "Data: ------");
			System.out.println("Outsorced? (y/n): ");
			char c = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Hours worked; ");
			int hours = sc.nextInt();
			System.out.print("Value per hour; ");
			double value = sc.nextDouble();

			if (c == 'y') {
				System.out.println("Tipe the additional charge: ");
				double ac = sc.nextDouble();

				list.add(new OutSourcedEmployee(name, hours, value, ac));
			} else {
				list.add(new Employee(name, hours, value));
			}
		}
		
		System.out.println();
		System.out.println("PAYMENT: ");
		
		for(Employee emp : list) {
			System.out.println(emp.getName() + " -$ " + String.format("%.2f", emp.payment()));
		}
		
		sc.close();
	}
}
