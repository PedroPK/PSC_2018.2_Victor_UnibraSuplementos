package modelo.dao;

import javax.persistence.EntityManager;
import exercicio.CupomProduto;
import util.java.Util;

public class CupomProdutoDAO {
	public static void create(CupomProduto cp) {
		try {
			if(Util.emf == null) {
				Util.getEntityManagerFactory();
			}
			
			EntityManager em	= Util.emf.createEntityManager();
			beginTransaction(em);
			em.persist(cp);
			commitTransaction(em);
			em.close();
		
		} catch (Exception e) {
			throw e;
		}
	
		
	}

	private static void commitTransaction(EntityManager em) {
		em.getTransaction().commit();
	}

	private static void beginTransaction(EntityManager em) {
		em.getTransaction().begin();
	}
	
	public static void delete(CupomProduto cp) {
		try {
			if(Util.emf == null) {
				Util.emf = Util.getEntityManagerFactory();
			}
			EntityManager 	em	= Util.emf.createEntityManager();
			beginTransaction(em);
			em.remove(cp);
			commitTransaction(em);
			em.close();
		} catch (Exception e) {
			throw e;
		}
		
	
	}
}
