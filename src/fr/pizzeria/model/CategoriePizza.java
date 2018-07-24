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

	public static CategoriePizza valueOf(int p) {
		CategoriePizza[] categs = values();
		if (p==1) {
			return categs [0];
		}
		if (p==2) {
			return categs [1];
		}
		if (p==3) {
			return categs [2];
		}
		return null;
	}


}
