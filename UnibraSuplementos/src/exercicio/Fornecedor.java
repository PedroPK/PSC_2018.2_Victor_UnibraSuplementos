package exercicio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fornecedor implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codFornecedor;
	
	@Column(length = 30)
	private String telSac ;
	
	@Column(length = 100)
	private String nomeFor;



	public int getCodFornecedor() {
		return codFornecedor;
	}

	public void setCodFornecedor(int codFornecedor) {
		this.codFornecedor = codFornecedor;
	}

	public String getTelSac() {
		return telSac;
	}

	public void setTelSac(String telSac) {
		this.telSac = telSac;
	}

	public String getNomeFor() {
		return nomeFor;
	}

	public void setNomeFor(String nomeFor) {
		this.nomeFor = nomeFor;
	}

	
	
	
	

}
