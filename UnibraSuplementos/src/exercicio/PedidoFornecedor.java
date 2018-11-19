package exercicio;


import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PedidoFornecedor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int nrPedido;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	private double valor;
	
	@OneToMany(mappedBy ="pedido")
	private List<FornecedorProduto> itens;

	public int getNrPedido() {
		return nrPedido;
	}

	public void setNrPedido(int nrPedido) {
		this.nrPedido = nrPedido;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<FornecedorProduto> getItens() {
		return itens;
	}

	public void setItens(List<FornecedorProduto> itens) {
		this.itens = itens;
	}
	
	

}
