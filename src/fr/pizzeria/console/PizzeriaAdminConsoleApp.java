package fr.pizzeria.console;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int choix;

		do{
			Affichage.affichage();
			choix = sc.nextInt();

			switch (choix) {
			case 1:
				System.out.println("***** Liste des pizzas *****");
				break;
			case 2:
				System.out.println("***** Ajout d'une nouvelle pizza *****");
				break;
			case 3:
				System.out.println("***** Mise à jour d'une pizza *****");
				break;
			case 4:
				System.out.println("***** Suppression d'une pizza *****");
				break;
			case 99:
				System.out.println("***** Au revoir *****");
				break;
			}
		} while (choix != 99);
		sc.close();
	}

}
