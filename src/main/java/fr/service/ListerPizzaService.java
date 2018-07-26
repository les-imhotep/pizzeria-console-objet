package fr.service;

import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

import fr.pizzeria.MemDao.IPizzaDao;
import fr.pizzeria.exception.ListerPizzaException;
import fr.pizzeria.model.CategoriePizza;


public class ListerPizzaService extends MenuService{	

	@Override
	public void executeUC(Scanner scan, IPizzaDao pizzaDao) throws ListerPizzaException{

		int categorie;

		System.out.println("***** Liste des pizzas *****\n");

		System.out.println("Veuillez choisir la catégorie :\n");
		System.out.println("1. Viande");
		System.out.println("2. Poisson");
		System.out.println("3. Sans viande");
		System.out.println("4. Toutes les pizzas");
		String categorieString = scan.nextLine();
		
		if (!(NumberUtils.isCreatable(categorieString))){
			throw new ListerPizzaException("Catégorie non valide");
		}		
		else {
			categorie = Integer.parseInt(categorieString); // bug Scanner
			if (categorie < 1 || categorie > CategoriePizza.values().length +1 ){
				throw new ListerPizzaException("Catégorie non valide");				
			}
		}


		CategoriePizza selectedCategorie = CategoriePizza.valueOf(categorie);

		for(int i=0; i<pizzaDao.findAllPizzas().size(); i++) {
			
			if (selectedCategorie==null || pizzaDao.findAllPizzas().get(i).getCategorie().equals(selectedCategorie)){
				System.out.println(pizzaDao.findAllPizzas().get(i));
			}
		}

	}

}