package modelo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import exercicio.Fornecedor;
import util.java.Util;

public class FornecedorDAO {
	public static void create(Fornecedor fornecedor) {
		try {
			if(Util.emf == null) {
				Util.getEntityManagerFactory();
			}

			EntityManager em	= Util.emf.createEntityManager();
			beginTransaction(em);
			em.persist(fornecedor);
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



	public static void delete(Fornecedor fornecedor) {
		try {
			if(Util.emf == null) {
				Util.emf = Util.getEntityManagerFactory();
			}
			EntityManager 	em	= Util.emf.createEntityManager();
			beginTransaction(em);
			fornecedor = em.find(Fornecedor.class, fornecedor.getCodFornecedor());
			em.remove(fornecedor);
			commitTransaction(em);
			em.close();
		} catch (Exception e) {
			throw e;
		}

	}

	public static  List<Fornecedor> listarFornecedores(){
		try {
			if(Util.emf == null) {
				Util.emf = Util.getEntityManagerFactory();
			}
			EntityManager 	em	= Util.emf.createEntityManager();
			beginTransaction(em);
			List<Fornecedor> lista = new ArrayList<>();
			String consulta = " Select f From Fornecedor f " ;
			Query queryConsulta = em.createQuery(consulta,Fornecedor.class);
			lista= queryConsulta.getResultList();
			commitTransaction(em);
			em.close();
			//Util.closeEntityManageFactory();
			return lista;
		} catch (Exception e) {
			throw e;
		}






	}

	public static List<Fornecedor> consultarFornecedorNome(Fornecedor f)  {
		try {
			if(Util.emf == null) {
				Util.emf = Util.getEntityManagerFactory();
			}
			EntityManager 	em	= Util.emf.createEntityManager();
			beginTransaction(em);
			String consulta = " Select f From Fornecedor f " ;
			consulta          +=" WHERE f.nomeFor LIKE '%'+:nomeFor+'%' ";
			Query queryConsulta = em.createQuery(consulta,Fornecedor.class);
			queryConsulta.setParameter("nomeFor", f.getNomeFor());
			List<Fornecedor>  fornecedorConsulta =  queryConsulta.getResultList();
			commitTransaction(em);
			return fornecedorConsulta;
		} catch (Exception e) {
			throw e;
		}


	}

	public static Fornecedor consultarFornecedor(Fornecedor f) {
		try {
			
			if(Util.emf == null) {
			Util.emf = Util.getEntityManagerFactory();
		}
			
			EntityManager em	= Util.emf.createEntityManager();
			beginTransaction(em);

			if(f.getCodFornecedor()>0) {
				f= em.find(Fornecedor.class,f.getCodFornecedor());
				
			}else {
				String consulta = " Select f From Fornecedor f " ;
				consulta          +=" WHERE f.nomeFor = :nomeFor ";
				TypedQuery<Fornecedor> queryConsulta = em.createQuery(consulta,Fornecedor.class);
				queryConsulta.setParameter("nomeFor", f.getNomeFor());
				f= queryConsulta.getSingleResult();

			}
			commitTransaction(em);
			em.close();
			return f;
		} catch (Exception e) {
			throw e;
		}


	}
	
	public static void atualizarFornecedor(Fornecedor f) throws Exception{
		
		try {
			
			if(Util.emf == null) {
				Util.emf = Util.getEntityManagerFactory();
			}
			EntityManager em	= Util.emf.createEntityManager();
			beginTransaction(em);
			String atualizacao = " Update Fornecedor Set nomeFor = :nomeFor ,telSac = :telSac " ;
			atualizacao          +=" WHERE codFornecedor = :codFornecedor ";
			Query query = em.createQuery(atualizacao);
			query.setParameter("nomeFor", f.getNomeFor());
			query.setParameter("telSac", f.getTelSac());
			query.setParameter("codFornecedor", f.getCodFornecedor());
			query.executeUpdate();
			commitTransaction(em);
			em.close();
			
		} 
		catch (Exception e) {
			throw e;
		}
	}

}
