package fr.pizzeria.model;

public enum CategoriePizza {

	VIANDE ("Viande"),
	POISSON ("Poisson"),
	VEGETARIEN ("Sans viande");

	private String libelle = "";

	
	public String getLibelle() {
		return libelle;
	}



	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	private CategoriePizza(String libelle) {
		this.libelle = libelle;
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

	

	public static CategoriePizza valueOfLibelle(String libelle) {
		CategoriePizza[] categs = values();
		for (CategoriePizza categ: categs){
			if (categ.getLibelle().equals(libelle)){
				
				return categ;
			}
		}
		return null;
		
	}


}
