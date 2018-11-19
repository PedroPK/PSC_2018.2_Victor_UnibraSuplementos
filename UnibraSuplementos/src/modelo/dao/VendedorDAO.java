package modelo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import exercicio.Vendedor;
import util.java.Util;

public class VendedorDAO {
	public static void create(Vendedor vendedor) {
		try {
			if(Util.emf == null) {
				Util.getEntityManagerFactory();
			}

			EntityManager em	= Util.emf.createEntityManager();
			beginTransaction(em);
			em.persist(vendedor);
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

	public static void delete(Vendedor vendedor) {
		try {
			if(Util.emf == null) {
				Util.emf = Util.getEntityManagerFactory();
			}
			EntityManager 	em	= Util.emf.createEntityManager();
			beginTransaction(em);
			vendedor=em.find(Vendedor.class, vendedor.getCodFun());
			em.remove(vendedor);
			commitTransaction(em);
			em.close();
		} catch (Exception e) {
			throw e;
		}
		
	}

	public static  List<Vendedor> listarVendedores(){
		try {
			if(Util.emf == null) {
				Util.emf = Util.getEntityManagerFactory();
			}
			EntityManager 	em	= Util.emf.createEntityManager();
			beginTransaction(em);
			//Adicionei merge para teste de remoção
			List<Vendedor> lista = new ArrayList<>();
			String consulta = " Select v From Vendedor v " ;
			Query queryConsulta = em.createQuery(consulta,Vendedor.class);
			lista= queryConsulta.getResultList();
			commitTransaction(em);
			em.close();
			//Util.closeEntityManageFactory();
			return lista;

		} catch (Exception e) {
			throw e;
		}
	




	}

	public static List<Vendedor> consultarVendedorNome(Vendedor v) throws Exception {
		if(Util.emf == null) {
			Util.emf = Util.getEntityManagerFactory();
		}
		try {
			EntityManager 	em	= Util.emf.createEntityManager();
			beginTransaction(em);
			String consulta = " Select v From Vendedor v " ;
			consulta          +=" WHERE v.nomeVendedor LIKE '%'+:nomeVen+'%' ";
			Query queryConsulta = em.createQuery(consulta,Vendedor.class);
			queryConsulta.setParameter("nomeVen", v.getNomeVendedor());
			List<Vendedor> vendedorConsulta =  queryConsulta.getResultList();
			commitTransaction(em);
			return vendedorConsulta;
		} catch (Exception e) {
			throw e;
		}


	}

	public static Vendedor consultarVendedor(Vendedor v) {
		try {
			if(Util.emf == null) {
				Util.emf = Util.getEntityManagerFactory();
			}
			EntityManager em	= Util.emf.createEntityManager();
			beginTransaction(em);

			if(v.getCodFun()>0) {
				v= em.find(Vendedor.class,v.getCodFun());
				

			}else {
				String consulta = " Select v From Vendedor v " ;
				consulta          +=" WHERE v.nomeVendedor = :nomeVendedor ";
				TypedQuery<Vendedor> queryConsulta = em.createQuery(consulta,Vendedor.class);
				queryConsulta.setParameter("nomeVendedor", v.getNomeVendedor());
				v= queryConsulta.getSingleResult();

			}
			commitTransaction(em);
			em.close();
			return v;
		} catch (Exception e) {
			throw e;
		}
	


	}

	
	public static void atualizarVendedor(Vendedor v) {
		if(Util.emf == null) {
			Util.emf = Util.getEntityManagerFactory();
		}
		EntityManager em	= Util.emf.createEntityManager();
		beginTransaction(em);
		String consulta = " Update  Vendedor Set nomeVendedor= :nome,  telefone = :tel  " ;
		consulta          +=" WHERE codFun = :cod ";
		Query atualizacao = em.createQuery(consulta);
		atualizacao.setParameter("nome", v.getNomeVendedor());
		atualizacao.setParameter("tel", v.getTelefone());
		atualizacao.setParameter("cod", v.getCodFun());
		atualizacao.executeUpdate();
		commitTransaction(em);
		em.close();
	}

}
