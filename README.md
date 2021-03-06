# Application Console Pizzéria

L'objectif est de créer une application Java qui permet d'administrer une pizzéria en mode console.

Menu :

```
** Application Pizzeria **
1. Lister pizzas
2. Créer une nouvelle pizza
3. Supprimer une pizza
99. Quitter

Veuillez sélectionner une action : _
```

## Utilisation
* Il s'agit d'un projet Maven, vous pouvez l'importer en tant que tel dans votre IDE.

* La classe `main` a exécuté est `fr.pizzeria.console.PizzeriaAdminConsoleApp`.

* Dans la classe `fr.pizzeria.console.PizzeriaAdminConsoleApp`, il est possible de choisir l'implémentation de la couche persistance :

```java
public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		// ici vous pouvez choisir une autre implémentation Dao
		// par exemple : new PizzaJdbcDao()
		IPizzaDao pizzaMemDao = new PizzaMemDao();

```

## Architecture
Cette application est conçue sur une architecture 2-tiers :
* **Une couche IHM** : partie console responsable de l'intéraction avec l'utilisateur
* **Une couche Persistance** : responsable du stockage des données
	* Plusieurs implémentations ont été réalisées pour la partie persistance : stockage en mémoire, en base données via JDBC, en base de données via JPA.
	
![](images/architecture.jpg)
	
	
## A propos de moi

PHOTO + une petite bio
	

