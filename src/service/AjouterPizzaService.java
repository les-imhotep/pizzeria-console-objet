package service;

import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

import fr.pizzeria.MemDao.IPizzaDao;
import fr.pizzeria.exception.AjouterPizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaService extends MenuService{

	@Override
	public void executeUC(Scanner sc, IPizzaDao pizzaDao) throws AjouterPizzaException {

		double newPrix;

		System.out.println("\n***** Ajout d'une nouvelle pizza *****\n");
		System.out.println("Veuillez saisir le code :");
		String newCode = sc.nextLine();
		for (int i=0; i<pizzaDao.findAllPizzas().size();i++){
			if (pizzaDao.findAllPizzas().get(i).getCode().equals(newCode)){
				throw new AjouterPizzaException("Pizza déjà créée");
			}
		}
		System.out.println("Veuillez saisir le nom :");
		String newLibelle = sc.nextLine();
		System.out.println("Veuillez saisir le prix :");
		String newPrixString = sc.nextLine();

		if (!(NumberUtils.isCreatable(newPrixString))){
			throw new AjouterPizzaException("Le prix n'est pas valide");
		}
		newPrix = Double.parseDouble(newPrixString);  // bug Scanner


		int newCategorie;

		do {
			System.out.println("\nVeuillez choisir la catégorie :\n");
			System.out.println("1. Viande");
			System.out.println("2. Poisson");
			System.out.println("3. Sans viande");
			String newCategorieString = sc.nextLine();

			if (!(NumberUtils.isCreatable(newCategorieString))){
				throw new AjouterPizzaException("Catégorie non valide");
			}		
			else {
				newCategorie = Integer.parseInt(newCategorieString); // bug Scanner
				if (newCategorie < 1 || newCategorie > CategoriePizza.values().length){
					throw new AjouterPizzaException("Catégorie non valide");				
				}
			}
				Pizza newPizza = new Pizza(newCode, newLibelle, newPrix, CategoriePizza.valueOf(newCategorie));
				pizzaDao.saveNewPizza(newPizza);

		} while (newCategorie < 1 || newCategorie > CategoriePizza.values().length);

	}

}
