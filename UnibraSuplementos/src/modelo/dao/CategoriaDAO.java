package modelo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import exercicio.Categoria;
import util.java.Util;

public abstract class CategoriaDAO {

	public static void create(Categoria categoria) {
		try {
			if(Util.emf == null) {
				Util.getEntityManagerFactory();
			}

			EntityManager em	= Util.emf.createEntityManager();
			beginTransaction(em);
			em.persist(categoria);
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

	public static Categoria consultarCategoria(Categoria categoria) {
		try {

			EntityManager em	= Util.emf.createEntityManager();
			beginTransaction(em);

			if(categoria.getCodCategoria()>0) {
				categoria= em.find(Categoria.class,categoria.getCodCategoria());
			}else {
				String consulta = " Select c from Categoria c  " ;
				consulta          +=" WHERE nomeCategoria = :nomeCategoria ";
				TypedQuery<Categoria> queryConsulta = em.createQuery(consulta,Categoria.class);
				queryConsulta.setParameter("nomeCategoria", categoria.getNomeCategoria());
				categoria= queryConsulta.getSingleResult();

			}
			commitTransaction(em);
			em.close();
			return categoria;

		} catch (Exception e) {
			throw e;
		}


	}



	public static void delete(Categoria categoria) {
		try {
			if(Util.emf == null) {
				Util.emf = Util.getEntityManagerFactory();
			}
			EntityManager 	em	= Util.emf.createEntityManager();
			beginTransaction(em);
			categoria = em.find(Categoria.class,categoria.getCodCategoria());
			em.remove(categoria);
			commitTransaction(em);
			em.close();
		} catch (Exception e) {
			throw e;
		}


	}

	public static  List<Categoria> listarCategorias(){
		try {
			if(Util.emf == null) {
				Util.emf = Util.getEntityManagerFactory();
			}
			EntityManager 	em	= Util.emf.createEntityManager();
			beginTransaction(em);
			List<Categoria> lista = new ArrayList<>();
			String consulta = " Select c From Categoria c" ;
			Query queryConsulta = em.createQuery(consulta,Categoria.class);
			lista= queryConsulta.getResultList();
			commitTransaction(em);
			em.close();
			return lista;
		} catch (Exception e) {
			throw e;
		}







	}

	public static void atualizarCategoria(Categoria categoria) {
		try {
			if(Util.emf == null) {
				Util.emf = Util.getEntityManagerFactory();
			}///*
			EntityManager 	em	= Util.emf.createEntityManager();
			beginTransaction(em);
			String consulta = " UPDATE Categoria  " ;
			consulta +="        SET nomeCategoria = :nomeCategoria ";
			consulta +="        WHERE codCategoria = :codCategoria ";
			Query queryConsulta = em.createQuery(consulta);
			queryConsulta.setParameter("nomeCategoria", categoria.getNomeCategoria());
			queryConsulta.setParameter("codCategoria", categoria.getCodCategoria());
			queryConsulta.executeUpdate();
			commitTransaction(em);
			em.close();//*/
		} catch (Exception e) {
			throw e;
		}



	}

	public static List<Categoria> consultarCategoriaNome(Categoria categoria) throws Exception {
		try {
			if(Util.emf == null) {
				Util.emf = Util.getEntityManagerFactory();
			}
			EntityManager 	em	= Util.emf.createEntityManager();
			beginTransaction(em);
			String consulta = " Select c From Categoria c " ;
			consulta          +=" WHERE c.nomeCategoria LIKE '%'+:nomeCategoria+'%' ";
			Query queryConsulta = em.createQuery(consulta,Categoria.class);
			queryConsulta.setParameter("nomeCategoria", categoria.getNomeCategoria());
			List<Categoria> categoriaConsulta =  queryConsulta.getResultList();
			commitTransaction(em);
			return categoriaConsulta;
		} catch (Exception e) {
			throw e;
		}



	}


}
