package modelo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import exercicio.CupomFiscal;
import exercicio.Vendedor;
import util.java.Util;

public class CupomFiscalDAO {

	public static void create(CupomFiscal cupom) {
		try {
			if(Util.emf == null) {
				Util.getEntityManagerFactory();
			}
			
			EntityManager em	= Util.emf.createEntityManager();
			beginTransaction(em);
			em.persist(cupom);
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

	
	
	public static void delete(CupomFiscal cupom) {
		try {
			if(Util.emf == null) {
				Util.emf = Util.getEntityManagerFactory();
			}
			EntityManager 	em	= Util.emf.createEntityManager();
			beginTransaction(em);
			em.remove(cupom);
			commitTransaction(em);
			em.close();
		} catch (Exception e) {
			throw e;
		}
		
	
	}
	
	public static  List<CupomFiscal> listarCupons(){
		try {
			if(Util.emf == null) {
				Util.emf = Util.getEntityManagerFactory();
			}
			EntityManager 	em	= Util.emf.createEntityManager();
			beginTransaction(em);
			//Adicionei merge para teste de remoção
	       List<CupomFiscal> lista = new ArrayList<>();
	       String consulta = " Select c From CupomFiscal c " ;
	       Query queryConsulta = em.createQuery(consulta,CupomFiscal.class);
		   lista= queryConsulta.getResultList();
	     	commitTransaction(em);
			em.close();
			//Util.closeEntityManageFactory();
			return lista;
		} catch (Exception e) {
			throw e;
		}
		
		
		
		
		
		
	}
}
