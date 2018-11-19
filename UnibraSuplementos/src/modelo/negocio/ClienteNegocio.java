package modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import exercicio.Cliente;
import modelo.dao.ClienteDAO;
import modelo.interfaces.ClienteInterface;

public class ClienteNegocio implements ClienteInterface {

	@Override
	public void cadastrarCliente(Cliente cliente) throws Exception {
		try {
			if(cliente.getCpf()=="   .   .   -  ") {
				throw new Exception("Informe o CPF do cliente!");
			}
			if(cliente.getEmail().length()<10) {
				throw new Exception("Mínimo de 10 caracteres para o email do cliente!");
			}
			if(String.valueOf(cliente.getDataNasc())=="  /  /    ") {
				throw new Exception("Informe a data de Nascimento do cliente!");
			}
			if(cliente.getEndereco().trim().isEmpty()) {
				throw new Exception("Informe a data de Nascimento do cliente!");
			
			}
			if(cliente.getTelefone()=="(  ) .    -    ") {
				throw new Exception("Informe o telefone do cliente!");
			}
			ClienteDAO.create(cliente);
			
		} catch (Exception e) {
			throw e;
		}
		


	}

	@Override
	public void removerCliente(Cliente cliente) throws Exception {
		try {
			ClienteDAO.delete(cliente);
		} catch (Exception e) {
			throw e;
		}
		

	}

	@Override
	public List<Cliente> listarClientes() {
		try {
			List<Cliente> lista = new ArrayList<>(); 
					lista=ClienteDAO.listarClientes();
			return lista;
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public Cliente consultarCliente(Cliente cliente) throws Exception {
		try {
			 cliente = ClienteDAO.consultarCliente(cliente);
			return cliente;
		} catch (Exception e) {
			throw e;
		}
		
		
	}

	@Override
	public List<Cliente> consultarClienteNome(Cliente cliente) throws Exception {
		try {
			List<Cliente> consulta = ClienteDAO.consultarClienteNome(cliente);
			return consulta;
		} catch (Exception e) {
			throw e;
		}
		
	}

}
