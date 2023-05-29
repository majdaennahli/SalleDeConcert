package projetFinal.salleDeConcert.entities;

public enum TypePlace {
	Fosse(25), Assise(20), PMR(20);
	
	private double prix;
	
	private TypePlace(double prix) {
		this.prix = prix;
	}
	
	
}
