package exercicio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(value = CupomProdutoPK.class)
public class CupomProduto implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne 
	@JoinColumn(name="cupom_id")
	private CupomFiscal cupom;
	
	@Id
	@ManyToOne 
	@JoinColumn(name="produto_id")
	private Produto produto;
	
	@Column(name="valorUnit")
	private double valorUnit;
	
	@Column(name="qtdVenda")
	private int qtdVenda  ;

	public CupomFiscal getCupom() {
		return cupom;
	}

	public void setCupom(CupomFiscal cupom) {
		this.cupom = cupom;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public double getValorUnit() {
		return valorUnit;
	}

	public void setValorUnit(double valorUnit) {
		this.valorUnit = valorUnit;
	}

	public int getQtdVenda() {
		return qtdVenda;
	}

	public void setQtdVenda(int qtdVenda) {
		this.qtdVenda = qtdVenda;
	}
	
	
	

	
	

	

	
	
	
	
	
	
	
	
	
	

}
