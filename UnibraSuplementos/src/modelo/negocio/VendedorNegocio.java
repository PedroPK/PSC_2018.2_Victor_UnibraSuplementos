package modelo.negocio;

import java.util.List;
import exercicio.Vendedor;
import modelo.dao.FornecedorDAO;
import modelo.dao.VendedorDAO;
import modelo.interfaces.VendedorInterface;

public class VendedorNegocio implements VendedorInterface {

	@Override
	public void cadastrarVendedor(Vendedor vendedor) throws Exception {
		if(vendedor == null) {
			throw new Exception("O objeto deve ser instanciado! ");

		}
		if(vendedor.getNomeVendedor().trim().isEmpty()) {

			throw new Exception("Informe o nome do vendedor! ");

		}
		VendedorDAO.create(vendedor);
	}

	@Override
	public void removerVendedor(Vendedor vendedor) throws Exception {
		try {
			VendedorDAO.delete(vendedor);
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public List<Vendedor> listarVendedores() {
		try {
			List<Vendedor> lista = VendedorDAO.listarVendedores();
			return lista;
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public Vendedor consultarVendedor(Vendedor vendedor) throws Exception {
		try {
			vendedor = VendedorDAO.consultarVendedor(vendedor);
			return vendedor;
			
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Vendedor> consultarVendedorNome(Vendedor vendedor) throws Exception {
		try {
			List<Vendedor> consultarVendedorNome = VendedorDAO.consultarVendedorNome(vendedor);
			return consultarVendedorNome;

		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public void atualizarVendedor(Vendedor vendedor) throws Exception {
		try {
			
			VendedorDAO.atualizarVendedor(vendedor);

		} catch (Exception e) {
			throw e;
		}
	}
	
	
}
