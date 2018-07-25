package service;

import java.util.Scanner;

import fr.pizzeria.MemDao.IPizzaDao;
import fr.pizzeria.exception.StockageException;

public abstract class MenuService {

	abstract void executeUC(Scanner scanner, IPizzaDao interfacePizza)
			throws StockageException;

}
