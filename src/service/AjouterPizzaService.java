package service;

import java.util.Scanner;

import fr.pizzeria.MemDao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaService extends MenuService{

	@Override
	public void executeUC(Scanner sc, IPizzaDao pizzaDao) {

		System.out.println("***** Ajout d'une nouvelle pizza *****\n");
		System.out.println("Veuillez saisir le code :");
		String newCode = sc.next();
		System.out.println("Veuillez saisir le nom (sans espace) :");
		String newLibelle = sc.next();
		System.out.println("Veuillez saisir le prix :");
		String newPrixString = sc.next();
		double newPrix = Double.parseDouble(newPrixString);  // bug Scanner
		Pizza newPizza = new Pizza(newCode, newLibelle, newPrix);
		pizzaDao.saveNewPizza(newPizza);
	}

}
