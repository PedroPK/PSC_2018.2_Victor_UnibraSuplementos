package exercicio;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class CupomFiscal implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int codVenda;
	
	@Column(name="valorTotal")
	private double valorTotal ;
	
	@Temporal(TemporalType.DATE)
	private Date dataVenda ;
	
	@ManyToOne
	@JoinColumn(name="vendedor_id")
	private Vendedor eloVendedor;
	
	@ManyToOne
	@JoinColumn(name= "cliente_id")
	private Cliente cliente ;
		
	@OneToMany (mappedBy ="cupom",cascade =CascadeType.ALL)  
	private List<CupomProduto> cupomProduto ;

	public int getCodVenda() {
		return codVenda;
	}

	public void setCodVenda(int codVenda) {
		this.codVenda = codVenda;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Vendedor getEloVendedor() {
		return eloVendedor;
	}

	public void setEloVendedor(Vendedor eloVendedor) {
		this.eloVendedor = eloVendedor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<CupomProduto> getCupomProduto() {
		return cupomProduto;
	}

	public void setCupomProduto(List<CupomProduto> cupomProduto) {
		this.cupomProduto = cupomProduto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cupomProduto == null) ? 0 : cupomProduto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CupomFiscal other = (CupomFiscal) obj;
		if (cupomProduto == null) {
			if (other.cupomProduto != null)
				return false;
		} else if (!cupomProduto.equals(other.cupomProduto))
			return false;
		return true;
	}
	

	
	

	
	

	
	
	
	
	
	

}
