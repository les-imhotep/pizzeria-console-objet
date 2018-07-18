package fr.pizzeria.model;

public class Pizza {
	
	private int id;
	private String code;
	private String libelle;
	private double prix;
	
	static int compteur;
	
	/* ------ Constructeurs ------ */
	
	public Pizza (){
		
	}
	
	public Pizza (String code, String libelle, double prix){
		compteur++;
		this.id = compteur;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
	
	public Pizza (int id, String code, String libelle, double prix){
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
	
	/* ------ getter ------ */
	
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
	
	/* ------ setter ------ */
	
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

}
