package salleDeConcert;

import salleDeConcert.repositories.JpaContext;

public class AppTest {
	
	
	public static void main(String[] args) {
		JpaContext.getEntityManagerFactory();
		

		
		JpaContext.destroy();

	}
	

	/* 
	 Menu Principal
	 1) Se connecter 
	 2) Creer un compte 
	 2) Quitter 
	 
	 Menu Admin 
	 1) Gestion des resa
	 2) Gestion des evenements 
	 	-Gestion des organisteurs 
	 	-Gestion des artistes
	 	-...
	 3) Gestion des comptes client
	 4) Se deconnecter 
	 
	 
	 Menu Client 
	 1) Faire une reservation 
	 2) Listes des evenements 
	 	-Filtrer par artiste/Type  d'evenement/Date 
	 3) Voir mes réservations (annulation, modification)
	 4) Se deconnecter 
	 
	 
	 
	 
	 
	 */
	
	
	
	
	/*
	 * 
	 * 
	 */
	
	
	

}
