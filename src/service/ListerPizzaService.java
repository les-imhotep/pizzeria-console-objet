package service;

import java.util.Scanner;

import formatage.StringUtils;
import fr.pizzeria.MemDao.IPizzaDao;
import fr.pizzeria.model.CategoriePizza;


public class ListerPizzaService extends MenuService{	

	@Override
	public void executeUC(Scanner scan, IPizzaDao pizzaDao) {

		System.out.println("***** Liste des pizzas *****\n");

		System.out.println("Veuillez choisir la catégorie :\n");
		System.out.println("1. Viande");
		System.out.println("2. Poisson");
		System.out.println("3. Sans viande\n");
		System.out.println("4. Toutes les pizzas");

		String categorieString = scan.nextLine();
		int categorie = Integer.parseInt(categorieString);  // bug Scanner

		CategoriePizza selectedCategorie = CategoriePizza.valueOf(categorie);

		for(int i=0; i<pizzaDao.findAllPizzas().size(); i++) {
			String prixFormatte = StringUtils.format(pizzaDao.findAllPizzas().get(i).getPrix(), "0.00");

			if (selectedCategorie==null || pizzaDao.findAllPizzas().get(i).getCategorie().equals(selectedCategorie)){
				System.out.println(pizzaDao.findAllPizzas().get(i).getCode() + " -> " + 
						pizzaDao.findAllPizzas().get(i).getLibelle() + " -> " +
						pizzaDao.findAllPizzas().get(i).getCategorie() + " -> " +
						prixFormatte + "€");
			}
		}

		//		System.out.println("Veuillez saisir la catégorie ");
		//		System.out.println("(Viande, Poisson, Sans viande ou Toutes) :\n");
		//		String libelle = scan.nextLine();
		//
		//		CategoriePizza selectedCategorie = CategoriePizza.valueOfLibelle(libelle);
		//
		//		for(int i=0; i<pizzaDao.findAllPizzas().size(); i++) {
		//			String prixFormatte = StringUtils.format(pizzaDao.findAllPizzas().get(i).getPrix(), "0.00");
		//
		//			if (selectedCategorie==null || pizzaDao.findAllPizzas().get(i).getCategorie().equals(selectedCategorie)){
		//				System.out.println(pizzaDao.findAllPizzas().get(i).getCode() + " -> " + 
		//						pizzaDao.findAllPizzas().get(i).getLibelle() + " -> " +
		//						pizzaDao.findAllPizzas().get(i).getCategorie() + " -> " +
		//						prixFormatte + "€");
		//			}
		//		}

	}

}