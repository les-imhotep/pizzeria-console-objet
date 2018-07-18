package fr.pizzeria.console;

import java.text.DecimalFormat;

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
		
		DecimalFormat formatteur = new DecimalFormat("0.00");

		for(int i=0; i<pizzas.length; i++) {
			
			String prixFormatte = formatteur.format(pizzas[i].getPrix());
			System.out.println(pizzas[i].getCode() + " -> " + pizzas[i].getLibelle() + "(" + prixFormatte + "€)");
		}

	}

}




