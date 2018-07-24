package service;

import java.util.Scanner;

import fr.pizzeria.MemDao.IPizzaDao;
import fr.pizzeria.exception.SupprimerPizzaException;

public class SupprimerPizzaService extends MenuService{

	@Override
	public void executeUC(Scanner sc, IPizzaDao pizzaDao) throws SupprimerPizzaException {
		
		int compteur=0;
		
		System.out.println("***** Suppression d'une pizza *****\n");
		System.out.println("Veuillez choisir le code de la pizza à supprimer :");
		String codeASupprimer = sc.nextLine();
		
		for (int i=0; i<pizzaDao.findAllPizzas().size();i++){
			if (!(pizzaDao.findAllPizzas().get(i).getCode().equals(codeASupprimer))){
				compteur++;
			}
		}
		if (compteur == pizzaDao.findAllPizzas().size()){
			throw new SupprimerPizzaException("Pizza inexistante");
		}
		
		pizzaDao.deletePizza(codeASupprimer);
		
	}


}
