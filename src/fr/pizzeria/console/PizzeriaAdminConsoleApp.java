package fr.pizzeria.console;

import java.util.Scanner;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int choix;
		
		Pizza[] pizzas = new Pizza[8];
		pizzas[0] = new Pizza (0, "PEP", "Pépéroni", 12.50);
		pizzas[1] = new Pizza (1, "MAR", "Margherita", 14.00);
		pizzas[2] = new Pizza (2, "REI", "La Reine", 11.50);
		pizzas[3] = new Pizza (3, "FRO", "La 4 fromages", 12.00);
		pizzas[4] = new Pizza (4, "CAN", "La Cannibale", 12.50);
		pizzas[5] = new Pizza (5, "SAV", "La Savoyarde", 13.00);
		pizzas[6] = new Pizza (6, "ORI", "L'Orientale", 13.50);
		pizzas[7] = new Pizza (7, "IND", "L'indienne", 14.00);
		

		do{
			Affichage.affichageMenu();
			choix = sc.nextInt();

			switch (choix) {
			case 1:
				System.out.println("***** Liste des pizzas *****");
				System.out.println("");
				Affichage.affichageListe(pizzas);
				System.out.println("");
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
