package service;

import java.util.Scanner;

import fr.pizzeria.MemDao.IPizzaDao;

public class SupprimerPizzaService extends MenuService{

	@Override
	public void executeUC(Scanner sc, IPizzaDao pizzaDao) {
		
		System.out.println("***** Suppression d'une pizza *****\n");
		System.out.println("Veuillez choisir le code de la pizza à supprimer :");
		String codeASupprimer = sc.next();
		pizzaDao.deletePizza(codeASupprimer);
		
	}


}
