package salleDeConcert.entities;

public enum TypePlace {
	Fosse(70,25), Assise(50,20), PMR(5,20);
	
	private int place;
	private double prix;
	
	private TypePlace(int place, double prix) {
		this.place = place;
		this.prix = prix;
	}
	
	
}
