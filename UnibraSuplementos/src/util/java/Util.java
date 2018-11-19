package util.java;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class Util {

	public static EntityManagerFactory emf;
	

	
	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("HM");
			
		}
		return emf;
	}

	
	public static void closeEntityManageFactory() {
		if(emf!=null) {
			
			emf.close();	
		}
		
	
	}

}
