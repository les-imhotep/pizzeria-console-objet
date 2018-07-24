package service;

import java.util.Scanner;

import fr.pizzeria.MemDao.IPizzaDao;
import fr.pizzeria.exception.AjouterPizzaException;
import fr.pizzeria.exception.ModifierPizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.SupprimerPizzaException;

public abstract class MenuService {

	abstract void executeUC(Scanner scanner, IPizzaDao interfacePizza)
			throws StockageException;

}
