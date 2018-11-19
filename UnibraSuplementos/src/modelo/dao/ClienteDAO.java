package modelo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import exercicio.Cliente;
import util.java.Util;

public class ClienteDAO {
	
	public static void create(Cliente cliente) {
		try {
			if(Util.emf == null) {
				Util.getEntityManagerFactory();
			}

			EntityManager em	= Util.emf.createEntityManager();
			beginTransaction(em);
			em.persist(cliente);
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

	public static void delete(Cliente cliente) {
		try {
			if(Util.emf == null) {
				Util.emf = Util.getEntityManagerFactory();
			}
			EntityManager 	em	= Util.emf.createEntityManager();
			beginTransaction(em);
			cliente=em.find(Cliente.class, cliente.getCodCliente());
			em.remove(cliente);
			commitTransaction(em);
			em.close();

		} catch (Exception e) {
			throw e;
		}

	}

	public static  List<Cliente> listarClientes(){
		try {
			if(Util.emf == null) {
				Util.emf = Util.getEntityManagerFactory();
			}
			EntityManager 	em	= Util.emf.createEntityManager();
			beginTransaction(em);
			List<Cliente> lista = new ArrayList<>();
			String consulta = " Select c From Cliente c " ;
			Query queryConsulta = em.createQuery(consulta,Cliente.class);
			lista =  queryConsulta.getResultList();
			commitTransaction(em);
			em.close();
			return lista;
		} catch (Exception e) {
			throw e;
		}






	}

	public static List<Cliente> consultarClienteNome(Cliente cliente) throws Exception {
		try {
			if(Util.emf == null) {
				Util.emf = Util.getEntityManagerFactory();
			}
			EntityManager 	em	= Util.emf.createEntityManager();
			beginTransaction(em);
			String consulta = " Select c From Cliente c " ;
			consulta          +=" WHERE c.nomeCli LIKE '%'+:nomeCli+'%' ";
			Query queryConsulta = em.createQuery(consulta,Cliente.class);
			queryConsulta.setParameter("nomeCli", cliente.getNomeCli());
			List<Cliente> clienteConsulta =  queryConsulta.getResultList();
			commitTransaction(em);
			return clienteConsulta;
		} catch (Exception e) {
			throw e;
		}



	}

	public static Cliente consultarCliente(Cliente cliente) {
		try {
			
			EntityManager em	= Util.emf.createEntityManager();
			beginTransaction(em);

			if(cliente.getCodCliente()>0) {
				cliente= em.find(Cliente.class,cliente.getCodCliente());
				

			}else {
				String consulta = " Select c From Cliente c " ;
				consulta          +=" WHERE c.nomeCli = :nomeCli ";
				TypedQuery<Cliente> queryConsulta = em.createQuery(consulta,Cliente.class);
				queryConsulta.setParameter("nomeCli", cliente.getNomeCli());
				cliente= queryConsulta.getSingleResult();

			}
			commitTransaction(em);
			em.close();
			return cliente;
			
		} catch (Exception e) {
			throw e;
		}


	}

}
