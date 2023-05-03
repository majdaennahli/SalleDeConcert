package salleDeConcert.repositories;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaContext {
	private static EntityManagerFactory emf=null;

	
	public static EntityManagerFactory getEntityManagerFactory() {
		if(emf==null) {
			emf=Persistence.createEntityManagerFactory("salle_concert");
		}
		return emf;
	}
	
	public static void destroy() {
		if(emf!=null) {
			emf.close();
			emf=null;
		}
	}

	

	}

