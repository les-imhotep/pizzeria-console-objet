package fr.pizzeria.model;

import fr.pizzeria.utils.Rule;
import fr.pizzeria.utils.StringUtils;
import fr.pizzeria.utils.ToString;

public class Pizza {

	
	private int id;
	
	@ToString (apres= " -> ", upperCase=true)
	private String code;
	
	@ToString (apres= " -> ", upperCase=false)
	private String libelle;
	
	@Rule (min=5)
	@ToString (apres= "€ -> ", format="0.00")
	private double prix;

	@ToString (upperCase=false)
	private CategoriePizza categorie;

	static int compteur;

	/* ------ Constructeurs ------ */

	public Pizza (){

	}

	public Pizza (String code, String libelle, double prix, CategoriePizza categorie){
		compteur++;
		this.id = compteur;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.categorie = categorie;
	}

	public Pizza (int id, String code, String libelle, double prix, CategoriePizza categorie){
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.categorie = categorie;
	}

	@Override
	public String toString() {

		return StringUtils.toString(this);
	}

	/* ------ getter / setter ------ */


	public int getId (){
		return id;
	}

	public String getCode (){
		return code;
	}

	public String getLibelle (){
		return libelle;
	}

	public double getPrix (){
		return prix;
	}


	public void setId (int id){
		this.id = id;
	}

	public void setCode (String code){
		this.code = code;
	}

	public void setLibelle (String libelle){
		this.libelle = libelle;
	}

	public void setPrix (double prix){
		this.prix = prix;
	}

	public CategoriePizza getCategorie() {
		return categorie;
	}

	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}


}
