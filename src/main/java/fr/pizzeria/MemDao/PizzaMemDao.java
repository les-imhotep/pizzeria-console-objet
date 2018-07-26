package fr.pizzeria.MemDao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaMemDao implements IPizzaDao {
	
	private List<Pizza> pizzas;
	
	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	public PizzaMemDao () {
		
		pizzas = new ArrayList<Pizza>();
		pizzas.add(new Pizza (0, "pep", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza (1, "mar", "Margherita", 14.00, CategoriePizza.VEGETARIEN));
		pizzas.add(new Pizza (2, "rei", "La Reine", 11.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza (3, "fro", "La 4 fromages", 12.00, CategoriePizza.VEGETARIEN));
		pizzas.add(new Pizza (4, "can", "La Cannibale", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza (5, "sav", "La Savoyarde", 13.00, CategoriePizza.VIANDE));
		pizzas.add(new Pizza (6, "ori", "L'Orientale", 13.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza (7, "ind", "L'indienne", 14.00, CategoriePizza.VIANDE));
		
	}

	@Override
	public List<Pizza> findAllPizzas() {
		return pizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		
		pizzas.add(pizza);		
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		
		for (int i=0; i<pizzas.size(); i++) {
			if (pizzas.get(i).getCode().equals(codePizza)){
				pizzas.get(i).setCode(pizza.getCode());
				pizzas.get(i).setLibelle(pizza.getLibelle());
				pizzas.get(i).setPrix(pizza.getPrix());
				pizzas.get(i).setCategorie(pizza.getCategorie());
			}
		}
		
	}

	@Override
	public void deletePizza(String codePizza) {
		
		for (int i=0; i<pizzas.size(); i++) {
			if (pizzas.get(i).getCode().equals(codePizza)){
				pizzas.remove(i);
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
