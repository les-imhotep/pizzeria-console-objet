package fr.pizzeria.MemDao;

import fr.pizzeria.model.Pizza;

public class PizzaMemDao implements IPizzaDao {
	
	private Pizza[] pizzas;
	private Pizza[] pizzasTemp = null;
	private	Pizza[] pizzasTemp2 = null;
	
	public PizzaMemDao () {
		
		pizzas = new Pizza[8];
		pizzas[0] = new Pizza (0, "PEP", "Pépéroni", 12.50);
		pizzas[1] = new Pizza (1, "MAR", "Margherita", 14.00);
		pizzas[2] = new Pizza (2, "REI", "La Reine", 11.50);
		pizzas[3] = new Pizza (3, "FRO", "La 4 fromages", 12.00);
		pizzas[4] = new Pizza (4, "CAN", "La Cannibale", 12.50);
		pizzas[5] = new Pizza (5, "SAV", "La Savoyarde", 13.00);
		pizzas[6] = new Pizza (6, "ORI", "L'Orientale", 13.50);
		pizzas[7] = new Pizza (7, "IND", "L'indienne", 14.00);
		
	}

	@Override
	public Pizza[] findAllPizzas() {
		return pizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {

		pizzasTemp = new Pizza[pizzas.length + 1];
		for (int i=0; i<pizzas.length; i++){
			pizzasTemp[i] = pizzas[i];
		}
		pizzasTemp[pizzas.length] = pizza;
		pizzas = pizzasTemp;
		
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		
		for (int i=0; i<pizzas.length; i++) {
			if (pizzas[i].getCode().equals(codePizza)){
				pizzas[i].setCode(pizza.getCode());
				pizzas[i].setLibelle(pizza.getLibelle());
				pizzas[i].setPrix(pizza.getPrix());
			}
		}
		
	}

	@Override
	public void deletePizza(String codePizza) {
		
		for (int i=0; i<pizzas.length; i++) {
			if (pizzas[i].getCode().equals(codePizza)){
				pizzasTemp2 = new Pizza[pizzas.length - 1];
				for (int j=0; j<i; j++){
					pizzasTemp2[j] = pizzas[j];
				}
				for (int j=i + 1; j<pizzas.length; j++){
					pizzasTemp2[j-1] = pizzas[j];
				}
				pizzas = pizzasTemp2;
			}
		}
		
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}
}
