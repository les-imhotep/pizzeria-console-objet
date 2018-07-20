package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.MemDao.PizzaMemDao;
import service.*;

public class PizzeriaAdminConsoleApp {



	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PizzaMemDao pizzaMemDao = new PizzaMemDao();
		int choix;

		ListerPizzaService listerPizza = new ListerPizzaService();
		AjouterPizzaService ajouterPizza = new AjouterPizzaService();
		ModifierPizzaService modifierPizza = new ModifierPizzaService();
		SupprimerPizzaService supprimerPizza = new SupprimerPizzaService();


		do{
			Affichage.affichageMenu();
			choix = sc.nextInt();

			switch (choix) {
			case 1:
				listerPizza.executeUC(sc, pizzaMemDao);
				break;
			case 2:
				listerPizza.executeUC(sc, pizzaMemDao);
			    ajouterPizza.executeUC(sc, pizzaMemDao);
				break;
			case 3:
				listerPizza.executeUC(sc, pizzaMemDao);
				modifierPizza.executeUC(sc, pizzaMemDao);
				break;
			case 4:
				listerPizza.executeUC(sc, pizzaMemDao);
				supprimerPizza.executeUC(sc, pizzaMemDao);
				break;
			case 99:
				System.out.println("***** Au revoir *****");
				break;
			}
		} while (choix != 99);
		sc.close();
	}

}
