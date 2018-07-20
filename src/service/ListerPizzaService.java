package service;

import java.util.Scanner;

import formatage.StringUtils;
import fr.pizzeria.MemDao.IPizzaDao;


public class ListerPizzaService extends MenuService{	

	@Override
	public void executeUC(Scanner scan, IPizzaDao pizzaDao) {

		System.out.println("***** Liste des pizzas *****\n");
		for(int i=0; i<pizzaDao.findAllPizzas().length; i++) {
			String prixFormatte = StringUtils.format(pizzaDao.findAllPizzas()[i].getPrix(), "0.00");
			System.out.println(pizzaDao.findAllPizzas()[i].getCode() + " -> " + pizzaDao.findAllPizzas()[i].getLibelle() + "(" + prixFormatte + "�)");
		}
		System.out.println("");

	}

}