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

		Pizza[] pizzasTemp = null;
		Pizza[] pizzasTemp2 = null;


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
				System.out.println("");
				System.out.println("Veuillez saisir le code :");
				String newCode = sc.next();
				System.out.println("Veuillez saisir le nom (sans espace) :");
				String newNom = sc.next();
				System.out.println("Veuillez saisir le prix :");
				String newPrixString = sc.next();
				double newPrix = Double.parseDouble(newPrixString);  // bug Scanner

				pizzasTemp = new Pizza[pizzas.length + 1];
				for (int i=0; i<pizzas.length; i++){
					pizzasTemp[i] = pizzas[i];
				}
				pizzasTemp[pizzas.length] = new Pizza (newCode, newNom, newPrix);
				pizzas = pizzasTemp;
				Affichage.affichageListe(pizzas);
				break;
			case 3:
				System.out.println("***** Mise à jour d'une pizza *****");
				System.out.println("");
				Affichage.affichageListe(pizzas);
				System.out.println("");
				System.out.println("Veuillez choisir le code de la pizza à modifier :");
				String codeAModifier = sc.next();
				System.out.println("Veuillez saisir le nouveau code :");
				String codeModifie = sc.next();
				System.out.println("Veuillez saisir le nouveau nom (sans espace) :");
				String libelleModifie = sc.next();
				System.out.println("Veuillez saisir le prix :");
				String prixModifieString = sc.next();
				double priModifie = Double.parseDouble(prixModifieString);  // bug Scanner
				for (int i=0; i<pizzas.length; i++) {
					if (pizzas[i].getCode().equals(codeAModifier)){
						pizzas[i].setCode(codeModifie);
						pizzas[i].setLibelle(libelleModifie);
						pizzas[i].setPrix(priModifie);
					}
				}
				Affichage.affichageListe(pizzas);
				break;
			case 4:
				System.out.println("***** Suppression d'une pizza *****");
				System.out.println("");
				Affichage.affichageListe(pizzas);
				System.out.println("");
				System.out.println("Veuillez choisir le code de la pizza à supprimer :");
				String codeASupprimer = sc.next();
				for (int i=0; i<pizzas.length; i++) {
					if (pizzas[i].getCode().equals(codeASupprimer)){
						pizzasTemp2 = new Pizza[pizzas.length - 1];
						for (int j=0; j<i; j++){
							pizzasTemp2[j] = pizzas[j];
						}
						for (int j=i + 1; j<pizzas.length; j++){
							pizzasTemp2[j-1] = pizzas[j];
						}
						pizzas = pizzasTemp2;
						Affichage.affichageListe(pizzas);
					}
				}
				break;
			case 99:
				System.out.println("***** Au revoir *****");
				break;
			}
		} while (choix != 99);
		sc.close();
	}

}
