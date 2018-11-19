package modelo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import exercicio.Produto;
import util.java.Util;

public class ProdutoDAO {

	public static void create(Produto produto) {
		try {
			if(Util.emf == null) {
				Util.getEntityManagerFactory();
			}

			EntityManager em	= Util.emf.createEntityManager();
			beginTransaction(em);
			em.merge(produto);
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

	public static void delete(Produto produto) {
		try {
			if(Util.emf == null) {
				Util.emf = Util.getEntityManagerFactory();
			}
			EntityManager 	em	= Util.emf.createEntityManager();
			beginTransaction(em);
			produto=em.find(Produto.class, produto.getCodProd());
			em.remove(produto);
			commitTransaction(em);
			em.close();
		} catch (Exception e) {
			throw e;
		}
		

	}

	public static  List<Produto> listarProdutos(){
		try {
			if(Util.emf == null) {
				Util.emf = Util.getEntityManagerFactory();
			}
			EntityManager 	em	= Util.emf.createEntityManager();
			beginTransaction(em);
			List<Produto> lista = new ArrayList<>();
			String consulta = " Select p From Produto p " ;
			consulta+=" Join p.categoria ";
			Query queryConsulta = em.createQuery(consulta,Produto.class);
			lista= queryConsulta.getResultList();
			commitTransaction(em);
			em.close();
			return lista;
		} catch (Exception e) {
			throw e;
		}
		





	}

	public static List<Produto> consultarProdutoNome(Produto produto)  {
		try {

			if(Util.emf == null) {
				Util.emf = Util.getEntityManagerFactory();
			}
			List<Produto> consultaProduto= new ArrayList<>();
			EntityManager 	em	= Util.emf.createEntityManager();
			beginTransaction(em);
			String consulta = " Select p From Produto p " ;
			consulta          +=" WHERE p.nomeprod LIKE '%'+:nomeprod+'%' ";
			Query queryConsulta = em.createQuery(consulta,Produto.class);
			queryConsulta.setParameter("nomeprod", produto.getNomeprod());
			consultaProduto = queryConsulta.getResultList();
			return consultaProduto;
		} catch (Exception e) {
			throw e;
		}



	}

	public static Produto consultarProduto(Produto p) {
		try {
			
			EntityManager em	= Util.emf.createEntityManager();
			beginTransaction(em);

			if(p.getCodProd()>0) {
				String consulta = " Select p From Produto p " ;
				consulta          +=" Join p.categoria WHERE p.codProd = :codProd ";
				TypedQuery<Produto> queryConsulta = em.createQuery(consulta,Produto.class);
				queryConsulta.setParameter("codProd", p.getCodProd());
				p= queryConsulta.getSingleResult();

			}else {
			
				String consulta = " Select p From Produto p " ;
				consulta          +=" Join p.categoria WHERE p.nomeprod = :nomeprod ";
				TypedQuery<Produto> queryConsulta = em.createQuery(consulta,Produto.class);
				queryConsulta.setParameter("nomeprod", p.getNomeprod());
				p= queryConsulta.getSingleResult();

			}
			commitTransaction(em);
			em.close();
			return p;
		} catch (Exception e) {
			throw e;
		}


	}

	public static void atualizarProduto(Produto produto) throws Exception {
		try {
			EntityManager em	= Util.emf.createEntityManager();
			beginTransaction(em);
			String atualizacao = " Update Produto Set nomeProd = :nomeProd ,precoMedio = :preco, " ;
			atualizacao+=" qtdEstoque = :qtdEstoque, categoria_id = :cat_id ";
			atualizacao          +=" WHERE codProd = :cod ";
			Query query = em.createQuery(atualizacao);
			query.setParameter("nomeProd", produto.getNomeprod());
			query.setParameter("preco", produto.getPrecoMedio());
			query.setParameter("qtdEstoque", produto.getQtdEstoque());
			query.setParameter("cat_id", produto.getCategoria().getCodCategoria());
			query.setParameter("cod", produto.getCodProd());
			query.executeUpdate();
			commitTransaction(em);
			em.close();
			
		} 
		catch (Exception e) {
			throw e;
		}
		
	}

}
