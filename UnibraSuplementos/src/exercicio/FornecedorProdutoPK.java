package exercicio;
import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class FornecedorProdutoPK implements Serializable {


	private Produto produto;
	
	
	private Fornecedor fornecedor;

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

	
	
}

