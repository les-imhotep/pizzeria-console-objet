package fr.pizzeria.console;

import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

import fr.pizzeria.MemDao.IPizzaDao;
import fr.pizzeria.MemDao.PizzaMemDao;
import fr.pizzeria.exception.StockageException;
import service.*;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		IPizzaDao pizzaMemDao = new PizzaMemDao();
		int choix;
		String choixString;

		ListerPizzaService listerPizza = new ListerPizzaService();
		AjouterPizzaService ajouterPizza = new AjouterPizzaService();
		ModifierPizzaService modifierPizza = new ModifierPizzaService();
		SupprimerPizzaService supprimerPizza = new SupprimerPizzaService();
		ExporterPdfService exporterPdf = new ExporterPdfService();

		do {
			do {
				Affichage.affichageMenu();
				choixString = sc.nextLine();
			} while (!(NumberUtils.isCreatable(choixString)));
			choix = Integer.parseInt(choixString); // bug Scanner
			try {
				switch (choix) {
				case 1:
					listerPizza.executeUC(sc, pizzaMemDao);
					break;
				case 2:
					ajouterPizza.executeUC(sc, pizzaMemDao);
					break;
				case 3:
					modifierPizza.executeUC(sc, pizzaMemDao);
					break;
				case 4:
					supprimerPizza.executeUC(sc, pizzaMemDao);
					break;
				case 5 :
					exporterPdf.executeUC(sc, pizzaMemDao);
					break;
				case 99:
					System.out.println("***** Au revoir *****");
					break;
				}
			} catch (StockageException e) {
				System.out.println(e.getMessage());
			}
		} while (choix != 99);
		sc.close();
	}

}
