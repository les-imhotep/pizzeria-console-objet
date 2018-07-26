package fr.pizzeria.MemDao;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaMemDaoTest {

	@Test
	public void testPizzaMemDao() {
		
		PizzaMemDao pizzaDao = new PizzaMemDao();
		assertNotNull(pizzaDao.getPizzas());
		assertTrue(pizzaDao.getPizzas().size()==8);
		//fail("Not yet implemented");
	}

	@Test
	public void testFindAllPizzas() {
		
		PizzaMemDao pizzaDao = new PizzaMemDao();
		assertTrue(pizzaDao.findAllPizzas().size()==8);
		
		//fail("Not yet implemented");
	}

	@Test
	public void testSaveNewPizza() {
		
		PizzaMemDao pizzaDao = new PizzaMemDao();
		Pizza pizza = new Pizza();
		assertTrue(pizzaDao.findAllPizzas().size()==8);
		
		pizzaDao.saveNewPizza(pizza);
		assertTrue(pizzaDao.findAllPizzas().size()==9);
	}

	@Test
	public void testUpdatePizza() {
		PizzaMemDao pizzaDao = new PizzaMemDao();
		int compteur=0;
		Pizza pizzaTest = new Pizza("01", "lib1", 1.0, CategoriePizza.VEGETARIEN);
		Pizza pizzaTest2 = new Pizza("02", "lib2", 2.0, CategoriePizza.POISSON);
		
		pizzaDao.saveNewPizza(pizzaTest);
		for (int i=0; i<pizzaDao.findAllPizzas().size();i++){
			if (!(pizzaDao.findAllPizzas().get(i).getCode().equals(pizzaTest.getCode()))){
				compteur++;
			}
		}
		assertTrue(compteur != pizzaDao.findAllPizzas().size());
		
		pizzaDao.updatePizza(pizzaTest.getCode(), pizzaTest2);

	}

	@Test
	public void testDeletePizza() {
		PizzaMemDao pizzaDao = new PizzaMemDao();
		int compteur=0;
		Pizza pizzaTest = new Pizza("01", "lib1", 1.0, CategoriePizza.VEGETARIEN);
		
		pizzaDao.saveNewPizza(pizzaTest);
		assertTrue(pizzaDao.findAllPizzas().size()==9);
		pizzaDao.deletePizza(pizzaTest.getCode());
		assertTrue(pizzaDao.findAllPizzas().size()==8);
		for (int i=0; i<pizzaDao.findAllPizzas().size();i++){
			if (!(pizzaDao.findAllPizzas().get(i).getCode().equals(pizzaTest.getCode()))){
				compteur++;
			}
		}
		assertTrue(compteur == pizzaDao.findAllPizzas().size());
		
		
	}

//	@Test
//	public void testFindPizzaByCode() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testPizzaExists() {
//		fail("Not yet implemented");
//	}

}
