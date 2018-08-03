package fr.pizzeria.console.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.StockageException;

public abstract class MenuService {

	abstract public void executeUC(Scanner scanner, IPizzaDao interfacePizza) throws StockageException;

	public String getLibelle() {
		// TODO Auto-generated method stub
		return null;
	}
}
