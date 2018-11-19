package exercicio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(value=FornecedorProdutoPK.class)
public class FornecedorProduto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name="produto_id")
	private Produto produto;
	
	@Id
	@ManyToOne
	@JoinColumn(name="fornecedor_id")
	private Fornecedor fornecedor;
	
	@ManyToOne
	@JoinColumn(name="pedido_id")
	private PedidoFornecedor pedido;
	
	@Column(name="precoCompra")
	private double precoCompra;
	
	@Column(name="qtdCompra")
	private int qtdCompra  ;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public PedidoFornecedor getPedido() {
		return pedido;
	}

	public void setPedido(PedidoFornecedor pedido) {
		this.pedido = pedido;
	}

	public double getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(double precoCompra) {
		this.precoCompra = precoCompra;
	}

	public int getQtdCompra() {
		return qtdCompra;
	}

	public void setQtdCompra(int qtdCompra) {
		this.qtdCompra = qtdCompra;
	}

	

	
	
	
}
