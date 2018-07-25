package fr.pizzeria.utils;

import java.lang.reflect.Field;

import fr.pizzeria.exception.StockageException;

public class Validator {

	public static void validator(Object o) throws StockageException {

		Class<?> maClasse = o.getClass();

		Field[] fieldList = maClasse.getDeclaredFields();

		for (Field field : fieldList) {

			if (field.isAnnotationPresent(Rule.class)) {

				Rule monAnnotation = field.getAnnotation(Rule.class);
				int min = monAnnotation.min();

				field.setAccessible(true);
				Object valeur = null;
				try {
					valeur = field.get(o);
				} catch (IllegalAccessException e) {
					throw new RuntimeException("ECHEC !");
				}
				
				if (valeur != null && min != 0) {
					double valeurDouble = Double.parseDouble(valeur.toString());
					if (valeurDouble < min) {
						throw new StockageException("La valeur du " + field.getName() + " est inférieur à " + min);
					}
				}
			}

		}

	}
}
