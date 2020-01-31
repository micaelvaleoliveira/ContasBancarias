package application;

import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Account;
import model.exptions.DomainException;

public class Program {
											//lança exceptions
	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		double balance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		double withdrawLimit = sc.nextDouble();
		Account acc = new Account(number, holder, balance, withdrawLimit); //constructor
		System.out.println();
		System.out.print("Enter amount for withdraw: ");
		double amount = sc.nextDouble();
		try {

			acc.withdraw(amount); //vai verificar as condiçoes se pode efectuar o levantamento (metodo na class Acount)
			System.out.println("New balance: " + String.format("%.2f", acc.getBalance())); //se prenche todos os requesitos faz o levantamento e mostra o saldo actual
		}
		catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage()); //se nao preencher todos os requesitos imprime esta msg

		}
		sc.close();

	}

}