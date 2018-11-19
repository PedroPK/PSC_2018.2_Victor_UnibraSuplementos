package modelo.negocio;

import java.util.ArrayList;
import java.util.List;
import exercicio.Categoria;
import modelo.dao.CategoriaDAO;
import modelo.interfaces.CategoriaInterface;

public class CategoriaNegocio implements CategoriaInterface {

	
	public void cadastrarCategoria(Categoria categoria) throws Exception {
		
		try {
			if (categoria == null) {
				throw new Exception("O objeto deve ser instanciado! Cadastro não efetuado.");
			}
			if(categoria.getNomeCategoria()== null || categoria.getNomeCategoria().trim() == "") {
				throw new Exception("Informe o nome da categoria. Cadastro não efetuado.");
				
			}
			
			CategoriaDAO.create(categoria);
		} catch (Exception e) {
			throw e;
		}
			
		
	}

	
	public void removerCategoria(Categoria categoria) throws Exception{
		try {
			if (categoria == null) {
				throw new Exception();
			}
			CategoriaDAO.delete(categoria);
		} catch (Exception e) {
			throw e;
		}
	
	}


	public List<Categoria> listarCategorias() {
		try {
			List<Categoria> lista = new ArrayList<>();
		    lista = CategoriaDAO.listarCategorias();
			return lista;
		} catch (Exception e) {
			throw e;
		}
		

	}

	 
	public Categoria consultarCategoria(Categoria categoria) throws Exception {
		try {
			if (categoria == null) {
				throw new Exception();
			}
			categoria = CategoriaDAO.consultarCategoria(categoria);
			return categoria; 
			
		} catch (Exception e) {
			throw e;
		}
		

	}
	
	public List<Categoria> consultarCategoriaNome(Categoria categoria)throws Exception {
		try {
			List<Categoria> categoriaConsultada = CategoriaDAO.consultarCategoriaNome(categoria);
			return categoriaConsultada;
			
		} catch (Exception e) {
			throw e;
		}
		
		
		
	}


	@Override
	public void atualizarCategoria(Categoria categoria)  throws Exception{
		try {
			CategoriaDAO.atualizarCategoria(categoria);
			
		} catch (Exception e) {
			throw e;
		}
		
		
	}
	
 

}
