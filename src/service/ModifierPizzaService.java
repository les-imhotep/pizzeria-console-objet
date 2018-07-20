package service;

import java.util.Scanner;

import fr.pizzeria.MemDao.IPizzaDao;
import fr.pizzeria.console.Affichage;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaService extends MenuService{

	@Override
	public void executeUC(Scanner sc, IPizzaDao pizzaMemDao) {
		
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
		
	}



}
