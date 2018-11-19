package modelo.interfaces;

import java.util.List;

import exercicio.Vendedor;

public interface VendedorInterface {
	 void cadastrarVendedor(Vendedor vendedor) throws Exception;
	 void removerVendedor(Vendedor vendedor) throws Exception;
	 List<Vendedor> listarVendedores();
	 Vendedor consultarVendedor (Vendedor vendedor) throws Exception;
	 List<Vendedor> consultarVendedorNome (Vendedor vendedor) throws Exception;
	 void atualizarVendedor(Vendedor vendedor) throws Exception;


}
