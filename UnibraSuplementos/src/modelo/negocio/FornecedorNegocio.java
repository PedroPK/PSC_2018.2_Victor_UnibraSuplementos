package modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import exercicio.Fornecedor;
import modelo.dao.FornecedorDAO;
import modelo.interfaces.FornecedorInterface;

public class FornecedorNegocio implements FornecedorInterface{

	@Override
	public void cadastrarFornecedor(Fornecedor fornecedor) throws Exception {
		if(fornecedor == null) {
			throw new Exception("O objeto deve ser instanciado! ");

		}
		if(fornecedor.getNomeFor().trim().isEmpty()) {

			throw new Exception("Informe o nome do fornecedor! ");

		}
		FornecedorDAO.create(fornecedor);

	}

	@Override
	public void removerFornecedor(Fornecedor fornecedor) throws Exception {
		try {
			FornecedorDAO.delete(fornecedor);
		} catch (Exception e) {
			throw e;
		}


	}

	@Override
	public List<Fornecedor> listarFornecedores() {
		try {
			List<Fornecedor> lista = FornecedorDAO.listarFornecedores();
			return lista;
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public Fornecedor consultarFornecedor(Fornecedor fornecedor) throws Exception {
		try {
			Fornecedor  consulta = new Fornecedor();
			consulta=FornecedorDAO.consultarFornecedor(fornecedor);
			return consulta;
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public List<Fornecedor> consultarFornecedorNome(Fornecedor f) throws Exception {
		try {
			List<Fornecedor>  consulta = new ArrayList<>();
			consulta=FornecedorDAO.consultarFornecedorNome(f);

			return consulta;
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void atualizarFornecedor(Fornecedor f) throws Exception {
		try {
			FornecedorDAO.atualizarFornecedor(f);
		} catch (Exception e) {
			throw e;
		}




	}

}
