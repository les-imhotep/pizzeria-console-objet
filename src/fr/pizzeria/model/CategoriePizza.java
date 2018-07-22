package fr.pizzeria.model;

public enum CategoriePizza {
	
	VIANDE ("Viande"),
	POISSON ("Poisson"),
	SANS_VIANDE ("Sans viande");
	
	private String categorie = "";
	
	// Constructeur privé ??? 
	
	private CategoriePizza (String categorie){
		this.categorie = categorie;
	}

	
	public String getCategorie() {
		return categorie;
	}
	
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	

}
