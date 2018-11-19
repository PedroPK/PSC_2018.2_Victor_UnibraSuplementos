package modelo.dao;

import javax.persistence.EntityManager;
import exercicio.FornecedorProduto;
import util.java.Util;

public class FornecedorProdutoDAO {
	public static void create(FornecedorProduto fp) {
		try {
			if(Util.emf == null) {
				Util.getEntityManagerFactory();
			}
			
			EntityManager em	= Util.emf.createEntityManager();
			beginTransaction(em);
			em.persist(fp);
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
	
	public static void delete(FornecedorProduto fp) {
		try {
			if(Util.emf == null) {
				Util.emf = Util.getEntityManagerFactory();
			}
			EntityManager 	em	= Util.emf.createEntityManager();
			beginTransaction(em);
			em.remove(fp);
			commitTransaction(em);
			em.close();
		} catch (Exception e) {
			throw e;
		}
		
		
	}
}
