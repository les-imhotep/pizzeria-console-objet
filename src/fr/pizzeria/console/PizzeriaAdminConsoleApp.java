package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.MemDao.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {



	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int choix;

		PizzaMemDao pizzaMemDao = new PizzaMemDao ();


		do{
			Affichage.affichageMenu();
			choix = sc.nextInt();

			switch (choix) {
			case 1:
				System.out.println("***** Liste des pizzas *****");
				System.out.println("");
				Affichage.affichageListe(pizzaMemDao.findAllPizzas());
				System.out.println("");
				break;
			case 2:
				System.out.println("***** Ajout d'une nouvelle pizza *****");
				System.out.println("");
				System.out.println("Veuillez saisir le code :");
				String newCode = sc.next();
				System.out.println("Veuillez saisir le nom (sans espace) :");
				String newLibelle = sc.next();
				System.out.println("Veuillez saisir le prix :");
				String newPrixString = sc.next();
				double newPrix = Double.parseDouble(newPrixString);  // bug Scanner
				
				Pizza newPizza = new Pizza(newCode, newLibelle, newPrix);
				pizzaMemDao.saveNewPizza(newPizza);
				Affichage.affichageListe(pizzaMemDao.findAllPizzas());
				break;

				case 3:
				System.out.println("***** Mise à jour d'une pizza *****");
				System.out.println("");
				Affichage.affichageListe(pizzaMemDao.findAllPizzas());
				System.out.println("");
				System.out.println("Veuillez choisir le code de la pizza à modifier :");
				String codeAModifier = sc.next();
				System.out.println("Veuillez saisir le nouveau code :");
				String codeModifie = sc.next();
				System.out.println("Veuillez saisir le nouveau nom (sans espace) :");
				String libelleModifie = sc.next();
				System.out.println("Veuillez saisir le prix :");
				String prixModifieString = sc.next();
				double prixModifie = Double.parseDouble(prixModifieString);  // bug Scanner
				
				Pizza updatePizza = new Pizza(codeModifie, libelleModifie, prixModifie);
				pizzaMemDao.updatePizza(codeAModifier, updatePizza);
				
				Affichage.affichageListe(pizzaMemDao.findAllPizzas());
				break;
			/*case 4:
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
				break;*/
			case 99:
				System.out.println("***** Au revoir *****");
				break;
			}
		} while (choix != 99);
		sc.close();
	}

}
