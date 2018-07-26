package fr.service;

import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

import fr.pizzeria.MemDao.IPizzaDao;
import fr.pizzeria.exception.ModifierPizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaService extends MenuService{

	@Override
	public void executeUC(Scanner sc, IPizzaDao pizzaDao) throws ModifierPizzaException {
		
		double prixModifie;
		int compteur=0;
		
		System.out.println("***** Mise à jour d'une pizza *****\n");
		System.out.println("Veuillez choisir le code de la pizza à modifier :");
		String codeAModifier = sc.nextLine();
		for (int i=0; i<pizzaDao.findAllPizzas().size();i++){
			if (!(pizzaDao.findAllPizzas().get(i).getCode().equals(codeAModifier))){
				compteur++;
			}
		}
		if (compteur == pizzaDao.findAllPizzas().size()){
			throw new ModifierPizzaException("Pizza inexistante");
		}
		System.out.println("Veuillez saisir le nouveau code :");
		String codeModifie = sc.nextLine();
		System.out.println("Veuillez saisir le nouveau nom :");
		String libelleModifie = sc.nextLine();
		System.out.println("Veuillez saisir le nouveau prix :");
		String prixModifieString = sc.nextLine();
		
		if (!(NumberUtils.isCreatable(prixModifieString))){
			throw new ModifierPizzaException("Le prix n'est pas valide");
		}
		prixModifie = Double.parseDouble(prixModifieString);  // bug Scanner

		
		int categorieModifie;

		do {
			System.out.println("\nVeuillez choisir la catégorie :\n");
			System.out.println("1. Viande");
			System.out.println("2. Poisson");
			System.out.println("3. Sans viande");
			String categorieModifieString = sc.nextLine();
			
			if (!(NumberUtils.isCreatable(categorieModifieString))){
				throw new ModifierPizzaException("Catégorie non valide");
			}		
			else {
				categorieModifie = Integer.parseInt(categorieModifieString); // bug Scanner
				if (categorieModifie < 1 || categorieModifie > CategoriePizza.values().length){
					throw new ModifierPizzaException("Catégorie non valide");				
				}
			}
				Pizza updatePizza = new Pizza(codeModifie, libelleModifie, prixModifie, CategoriePizza.valueOf(categorieModifie));
				pizzaDao.updatePizza(codeAModifier, updatePizza);
			
			} while (categorieModifie < 1 || categorieModifie > CategoriePizza.values().length);
	}



}
