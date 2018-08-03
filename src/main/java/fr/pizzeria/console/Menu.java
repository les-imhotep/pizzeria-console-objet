package fr.pizzeria.console;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import fr.pizzeria.console.service.AjouterPizzaService;
import fr.pizzeria.console.service.ListerPizzaService;
import fr.pizzeria.console.service.MenuService;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.StockageException;

public class Menu {

	private Map<Integer, MenuService> actions = new HashMap<>();

	private Scanner scanner;

	private IPizzaDao pizzaDao;

	public Menu(Scanner sc, IPizzaDao pizzaMemDao) {
		super();
		this.pizzaDao = pizzaMemDao;
		this.scanner = sc;
		initialiser();

	}

	private void initialiser() {
		this.actions.put(1, new ListerPizzaService());
		this.actions.put(2, new AjouterPizzaService());
	}

	public void afficher() {
		System.out.println("\n***** Pizzeria Administration *****\n");

		this.actions.forEach((numero, action) -> {
			System.out.println(numero + ". " + action.getLibelle());
		});

		String saisie = this.scanner.next();

		int saisieInt = Integer.parseInt(saisie);

		MenuService actionChoisie = this.actions.get(saisieInt);

		try {
			actionChoisie.executeUC(scanner, pizzaDao);
		} catch (StockageException e) {
			System.out.println("Erreur Stockage : " + e.getMessage());
		}

		/*
		 * System.out.println("1. Lister les pizzas");
		 * System.out.println("2. Ajouter une nouvelle pizza");
		 * System.out.println("3. Mettre � jour une pizza");
		 * System.out.println("4. Supprimer une pizza");
		 * System.out.println("5. Exporter en PDF la liste des pizzas\n");
		 * System.out.println("99. Sortir");
		 */
	}

}
