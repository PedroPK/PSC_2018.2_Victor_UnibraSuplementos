package managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import exercicio.Categoria;
import modelo.negocio.CategoriaNegocio;

@ManagedBean
public class CategoriaMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	Categoria categoria = new Categoria();
	
	List<Categoria> listaCategorias;
	
	public CategoriaMB() {
		if (this.categoria == null) {
			this.categoria = new Categoria();
		}
		
	}

	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public List<Categoria> getListaCategorias() {
		listaCat();
		return listaCategorias;
	}
	
	public void setListaCategorias(List<Categoria> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}
	
	public void inserir() {
		if ( this.categoria != null ) { 
			CategoriaNegocio conex = new CategoriaNegocio();
			
			try {
				conex.cadastrarCategoria(categoria);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			this.listaCategorias = conex.listarCategorias();
		}
	
	}
	
	public List<Categoria> listaCat() {
		CategoriaNegocio conex = new CategoriaNegocio();
		
		if ( this.categoria.getNomeCategoria() != null ) { 
		try {
			this.listaCategorias = conex.listarCategorias();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else if ( this.categoria != null ){
			this.listaCategorias = conex.listarCategorias();
			
		}
		return listaCategorias;
	}

}
