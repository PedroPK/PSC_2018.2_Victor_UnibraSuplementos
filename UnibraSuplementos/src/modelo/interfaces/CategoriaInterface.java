package modelo.interfaces;

import java.util.List;

import exercicio.Categoria;

public interface CategoriaInterface {

	 void cadastrarCategoria(Categoria categoria) throws Exception;
	 void removerCategoria(Categoria categoria) throws Exception;
	 List <Categoria> listarCategorias();
	 Categoria consultarCategoria (Categoria categoria) throws Exception;
	 List<Categoria> consultarCategoriaNome(Categoria categoria) throws Exception;
	 void atualizarCategoria(Categoria categoria) throws Exception;
	 
	
}
