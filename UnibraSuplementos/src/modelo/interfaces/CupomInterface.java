package modelo.interfaces;

import java.util.List;

import exercicio.CupomFiscal;

public interface CupomInterface {

	public void GerarCupom(CupomFiscal cupom) throws Exception;
	public void removerCupom(CupomFiscal cupom) throws Exception;
	public  List <CupomFiscal> listarCupons();
}
