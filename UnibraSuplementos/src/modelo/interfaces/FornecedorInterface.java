package modelo.interfaces;

import java.util.List;

import exercicio.Fornecedor;


public interface FornecedorInterface {

	void cadastrarFornecedor(Fornecedor fornecedor) throws Exception;
	void removerFornecedor(Fornecedor fornecedor) throws Exception;
	List<Fornecedor> listarFornecedores();
	Fornecedor consultarFornecedor (Fornecedor fornecedor) throws Exception;
	List<Fornecedor> consultarFornecedorNome (Fornecedor fornecedor) throws Exception;
	void atualizarFornecedor(Fornecedor f) throws Exception;
}
