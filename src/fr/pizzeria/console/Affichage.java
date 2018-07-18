package fr.pizzeria.console;

import formatage.StringUtils;
import fr.pizzeria.model.Pizza;

public class Affichage {

	public static void affichageMenu(){

		System.out.println("***** Pizzeria Administration *****");
		System.out.println("");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("");
		System.out.println("99. Sortir");

	}

	public static void affichageListe(Pizza[] pizzas){

		for(int i=0; i<pizzas.length; i++) {
			String prixFormatte = StringUtils.format(pizzas[i].getPrix(), "0.00");
			System.out.println(pizzas[i].getCode() + " -> " + pizzas[i].getLibelle() + "(" + prixFormatte + "€)");
		}

	}

}




