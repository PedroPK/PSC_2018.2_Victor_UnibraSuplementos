package exercicio;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class CupomProdutoPK implements Serializable{

	
	private static final long serialVersionUID = 1L;

	private CupomFiscal cupom;
	
	
	private Produto produto ;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cupom == null) ? 0 : cupom.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
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
		CupomProdutoPK other = (CupomProdutoPK) obj;
		if (cupom == null) {
			if (other.cupom != null)
				return false;
		} else if (!cupom.equals(other.cupom))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}

	

	
	
	
	

}
