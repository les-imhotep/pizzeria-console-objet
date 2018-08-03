package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaMemDao;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		IPizzaDao pizzaMemDao = new PizzaMemDao();

		Menu menu = new Menu(sc, pizzaMemDao);
		menu.afficher();
		sc.close();
	}

}
