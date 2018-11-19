package modelo.interfaces;

import exercicio.PedidoFornecedor;

public interface PedidoInterface {
	
	void GerarPedido(PedidoFornecedor pedido);
	void CancelarPedido(PedidoFornecedor pedido);

}
