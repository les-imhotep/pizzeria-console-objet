package service;

import java.util.Scanner;

import fr.pizzeria.MemDao.IPizzaDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaService extends MenuService{

	@Override
	public void executeUC(Scanner sc, IPizzaDao pizzaDao) {

		System.out.println("***** Ajout d'une nouvelle pizza *****\n");
		System.out.println("Veuillez saisir le code :");
		String newCode = sc.nextLine();
		System.out.println("Veuillez saisir le nom (sans espace) :");
		String newLibelle = sc.nextLine();
		System.out.println("Veuillez saisir le prix :");
		String newPrixString = sc.nextLine();
		double newPrix = Double.parseDouble(newPrixString);  // bug Scanner
		
		int newCategorie;

		do {
			System.out.println("\nVeuillez choisir la catégorie :\n");
			System.out.println("1. Viande");
			System.out.println("2. Poisson");
			System.out.println("3. Sans viande");
			
			String newCategorieString = sc.nextLine();
			newCategorie = Integer.parseInt(newCategorieString);  // bug Scanner
			
			Pizza newPizza = new Pizza(newCode, newLibelle, newPrix, CategoriePizza.valueOf(newCategorie));
			pizzaDao.saveNewPizza(newPizza);
			
			if (newCategorie < 1 || newCategorie >= CategoriePizza.values().length-1 ){
				System.out.println("Catégorie non valide");
			}
			
			} while (newCategorie < 1 || newCategorie >= CategoriePizza.values().length-1);
	
	}

}
