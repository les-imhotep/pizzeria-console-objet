package fr.pizzeria.console.service;

import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.ListerPizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ListerPizzaService extends MenuService {

	@Override
	public String getLibelle() {
		return "Lister les pizzas";
	}

	@Override
	public void executeUC(Scanner scan, IPizzaDao pizzaDao) throws ListerPizzaException {

		int categorie;

		System.out.println("***** Liste des pizzas *****\n");

		System.out.println("Veuillez choisir la cat�gorie :\n");
		System.out.println("1. Viande");
		System.out.println("2. Poisson");
		System.out.println("3. Sans viande");
		System.out.println("4. Toutes les pizzas");
		String categorieString = scan.nextLine();

		if (!(NumberUtils.isCreatable(categorieString))) {
			throw new ListerPizzaException("Cat�gorie non valide");
		} else {
			categorie = Integer.parseInt(categorieString); // bug Scanner
			if (categorie < 1 || categorie > CategoriePizza.values().length + 1) {
				throw new ListerPizzaException("Cat�gorie non valide");
			}
		}

		CategoriePizza selectedCategorie = CategoriePizza.valueOf(categorie);

		for (Pizza p : pizzaDao.findAllPizzas()) {
			if (selectedCategorie == null || p.getCategorie().equals(selectedCategorie)) {
				System.out.println(p);
			}
		}

		pizzaDao.findAllPizzas().stream()
				.filter(p -> selectedCategorie == null || p.getCategorie().equals(selectedCategorie))
				.forEach(p -> System.out.println(p));

	}

}