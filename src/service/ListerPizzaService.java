package service;

import java.util.Scanner;

import formatage.StringUtils;
import fr.pizzeria.MemDao.IPizzaDao;
import fr.pizzeria.MemDao.PizzaMemDao;


public class ListerPizzaService extends MenuService{	

	@Override
	public void executeUC(Scanner scan, IPizzaDao pizzaMemDao) {

		System.out.println("***** Liste des pizzas *****");
		System.out.println("");
		for(int i=0; i<pizzaMemDao.findAllPizzas().length; i++) {
			String prixFormatte = StringUtils.format(pizzaMemDao.findAllPizzas()[i].getPrix(), "0.00");
			System.out.println(pizzaMemDao.findAllPizzas()[i].getCode() + " -> " + pizzaMemDao.findAllPizzas()[i].getLibelle() + "(" + prixFormatte + "€)");
		}
		System.out.println("");

	}

}
