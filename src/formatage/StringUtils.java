package formatage;

import java.lang.reflect.Field;
import java.text.DecimalFormat;

import fr.pizzeria.utils.ToString;

public class StringUtils {

	public static String format (double d, String format) {
		DecimalFormat ff = new DecimalFormat(format);
		return ff.format(d);
	}

	public static String toString(Object o) {

		String chaine = "";
		Class<?> maClasse = o.getClass();
		
		
		Field[] fieldList = maClasse.getDeclaredFields();

		for (Field field : fieldList) {
			
			if (field.isAnnotationPresent(ToString.class)){

				ToString monAnnotation = field.getAnnotation(ToString.class);
				String avant = monAnnotation.avant();
				String apres = monAnnotation.apres();
				String format = monAnnotation.format();
				boolean upperCase = monAnnotation.upperCase();

				try {
					field.setAccessible(true);
					Object valeur = field.get(o);
					String valeurStr = "";
					if (valeur != null && upperCase){
						valeurStr = valeur.toString().toUpperCase();
					}
					else if (valeur != null && !format.equals("")){
						valeurStr = format(Double.parseDouble(valeur.toString()), format) +"€";
					}
					else if (valeur != null) {
						valeurStr = valeur.toString();
					}
					chaine+= avant + valeurStr + apres;
				} catch (Exception e) {

					e.printStackTrace();
				}
			}

		}
		return chaine;
	}
}