package modelo.interfaces;

import java.util.List;
import exercicio.Produto;


public interface ProdutoInterface {
	
	 void cadastrarProduto(Produto produto) throws Exception;
	 void removerProduto(Produto produto) throws Exception;
	 List<Produto> listarProdutos();
	 Produto consultarProduto (Produto  produto) throws Exception;
	 List<Produto> consultarProdutoNome (Produto  produto) throws Exception;
	 void atualizarProduto (Produto produto)throws Exception;

}
