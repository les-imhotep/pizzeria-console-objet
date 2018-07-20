package service;

import java.util.Scanner;

import fr.pizzeria.MemDao.IPizzaDao;

public abstract class MenuService {
	
	abstract void executeUC(Scanner scanner, IPizzaDao interfacePizza);

}
