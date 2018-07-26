package fr.service;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

import java.util.Scanner;

import fr.pizzeria.MemDao.PizzaMemDao;
import fr.pizzeria.exception.StockageException;

public class AjouterPizzaServiceTest {

	/** Création d'une "Rule" qui va permettre
	 * de substituer le System.in utilisé par le Scanner
	 * par un mock: systemInMock */
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Test(expected=StockageException.class)
	public void testExecuteUCNonPassant() throws StockageException {
		systemInMock.provideLines("00", "libelle", "1.0", "1");
		PizzaMemDao pizzaDao = new PizzaMemDao();

		AjouterPizzaService ajout = new AjouterPizzaService();
		ajout.executeUC(new Scanner(System.in), pizzaDao);

	}
	
	@Test
	public void testExecuteUCPassant(){
		systemInMock.provideLines("00", "libelle", "6.0", "1");
		PizzaMemDao pizzaDao = new PizzaMemDao();

		AjouterPizzaService ajout = new AjouterPizzaService();
		try {
			ajout.executeUC(new Scanner(System.in), pizzaDao);
			assertTrue(pizzaDao.findAllPizzas().size()==9);
		} catch (StockageException e) {
			fail("Echec !");
		}

	}

}
