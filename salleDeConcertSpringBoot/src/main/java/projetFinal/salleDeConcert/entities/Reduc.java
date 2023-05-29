package projetFinal.salleDeConcert.entities;



public enum Reduc {
	Enfant(0.2), Etudiant(0.1), Autre(0);
	
	private double reduc;
	
	private Reduc(double reduc) {
		this.reduc = reduc;
	}
	
	
}
