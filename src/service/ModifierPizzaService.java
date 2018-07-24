package service;

import java.util.Scanner;

import fr.pizzeria.MemDao.IPizzaDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaService extends MenuService{

	@Override
	public void executeUC(Scanner sc, IPizzaDao pizzaDao) {
		
		System.out.println("***** Mise à jour d'une pizza *****\n");
		System.out.println("Veuillez choisir le code de la pizza à modifier :");
		String codeAModifier = sc.nextLine();
		System.out.println("Veuillez saisir le nouveau code :");
		String codeModifie = sc.nextLine();
		System.out.println("Veuillez saisir le nouveau nom (sans espace) :");
		String libelleModifie = sc.nextLine();
		System.out.println("Veuillez saisir le nouveau prix :");
		String prixModifieString = sc.nextLine();
		double prixModifie = Double.parseDouble(prixModifieString);  // bug Scanner
		
		int categorieModifie;

		do {
			System.out.println("\nVeuillez choisir la catégorie :\n");
			System.out.println("1. Viande");
			System.out.println("2. Poisson");
			System.out.println("3. Sans viande");
			
			String categorieModifieString = sc.nextLine();
			categorieModifie = Integer.parseInt(categorieModifieString);  // bug Scanner
			
			Pizza updatePizza = new Pizza(codeModifie, libelleModifie, prixModifie, CategoriePizza.valueOf(categorieModifie));
			pizzaDao.updatePizza(codeAModifier, updatePizza);
			
			if (categorieModifie < 1 || categorieModifie >= CategoriePizza.values().length-1 ){
				System.out.println("Catégorie non valide");
			}
			
			} while (categorieModifie < 1 || categorieModifie >= CategoriePizza.values().length-1);
	}



}
