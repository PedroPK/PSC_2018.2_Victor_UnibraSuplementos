package modelo.interfaces;

import java.util.List;

import exercicio.Cliente;

public interface ClienteInterface {

	public void cadastrarCliente(Cliente cliente) throws Exception;
	public void removerCliente(Cliente cliente) throws Exception;
	public  List <Cliente> listarClientes();
	public Cliente consultarCliente (Cliente cliente) throws Exception;
	public  List <Cliente> consultarClienteNome(Cliente cliente) throws Exception;
}
