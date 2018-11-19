package managedBean;

import java.util.Collection;

import javax.annotation.ManagedBean;

import exercicio.Cliente;
import modelo.dao.ClienteDAO;

@ManagedBean
public class ClienteMB {

	private Cliente cliente;
	private ClienteDAO conex;
	private Collection<Cliente> aColecaoClientes;
	

	public Cliente getCliente() {
		if (this.cliente == null) {
			this.cliente = new Cliente();
		}
		return this.cliente;
	}

	public void setCliente(Cliente pCliente) {
		this.cliente = pCliente;
	}

	public Collection<Cliente> getColecaoClientes() {
		if (this.aColecaoClientes == null) {
			this.aColecaoClientes = conex.listarClientes();
		}
		return aColecaoClientes;
	}

	

}
