package service;

import java.util.Scanner;

import formatage.StringUtils;
import fr.pizzeria.MemDao.IPizzaDao;


public class ListerPizzaService extends MenuService{	

	@Override
	public void executeUC(Scanner scan, IPizzaDao pizzaDao) {

		System.out.println("***** Liste des pizzas *****\n");
		for(int i=0; i<pizzaDao.findAllPizzas().size(); i++) {
			String prixFormatte = StringUtils.format(pizzaDao.findAllPizzas().get(i).getPrix(), "0.00");
			System.out.println(pizzaDao.findAllPizzas().get(i).getCode() + " -> " + pizzaDao.findAllPizzas().get(i).getLibelle() + "(" + prixFormatte + "€)");
		}
		System.out.println("");

	}

}