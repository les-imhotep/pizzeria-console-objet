package service;

import java.util.Scanner;

import fr.pizzeria.MemDao.IPizzaDao;
import fr.pizzeria.console.Affichage;

public class SupprimerPizzaService extends MenuService{

	@Override
	public void executeUC(Scanner sc, IPizzaDao pizzaMemDao) {
		
		System.out.println("***** Suppression d'une pizza *****");
		System.out.println("");
		Affichage.affichageListe(pizzaMemDao.findAllPizzas());
		System.out.println("");
		System.out.println("Veuillez choisir le code de la pizza à supprimer :");
		String codeASupprimer = sc.next();
		pizzaMemDao.deletePizza(codeASupprimer);
		
	}


}
