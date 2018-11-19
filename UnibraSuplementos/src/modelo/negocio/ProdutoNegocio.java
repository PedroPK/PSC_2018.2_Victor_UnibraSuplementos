package modelo.negocio;

import java.util.List;

import exercicio.Produto;
import modelo.dao.ProdutoDAO;
import modelo.interfaces.ProdutoInterface;

public class ProdutoNegocio implements ProdutoInterface {

	@Override
	public void cadastrarProduto(Produto produto) throws Exception {

		if(produto==null) {
			throw new Exception("O objeto deve ser instanciado!! ");

		}
		ProdutoDAO.create(produto);

	}

	@Override
	public void removerProduto(Produto produto) throws Exception {
		try {
			ProdutoDAO.delete(produto);
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public List<Produto> listarProdutos() {
		try {
			List<Produto> lista = ProdutoDAO.listarProdutos();
			return lista;
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public Produto consultarProduto(Produto produto) throws Exception {
		try {
			produto = ProdutoDAO.consultarProduto(produto);
			return produto;
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public List<Produto> consultarProdutoNome(Produto produto) throws Exception {
		try {
			List<Produto> consulta = ProdutoDAO.consultarProdutoNome(produto);
			return consulta;
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void atualizarProduto(Produto produto) throws Exception {
		try {
			ProdutoDAO.atualizarProduto(produto);
		} catch (Exception e) {
		throw e;
		}
	
		
	}

}
