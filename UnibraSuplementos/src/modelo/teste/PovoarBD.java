package modelo.teste;

import exercicio.Categoria;
import modelo.negocio.CategoriaNegocio;

public class PovoarBD {

	public static void cadastrarCategoria(String categoria) throws Exception {

		Categoria cat = new Categoria();
		cat.setNomeCategoria(categoria);

		CategoriaNegocio validaC = new CategoriaNegocio();
		validaC.cadastrarCategoria(cat);

	}

	public static void main(String[] args) {

		try {
			cadastrarCategoria("Prote�nas");
			
			cadastrarCategoria("Vitaminas");
			
			cadastrarCategoria("Bebidas");
			
			cadastrarCategoria("BarrasCereais");
			
			cadastrarCategoria("Diet");
			
			cadastrarCategoria("Equipamentos Muscula��o");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
