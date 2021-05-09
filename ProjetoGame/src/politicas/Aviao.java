package politicas;

import java.util.ArrayList;
import java.util.List;

import seguranca.Policial;
import seguranca.Presidiario;
import tripulacaocabine.ChefeServicoVoo;
import tripulacaocabine.Comissaria_1;
import tripulacaocabine.Comissaria_2;
import tripulacaotecnica.Oficial_1;
import tripulacaotecnica.Oficial_2;
import tripulacaotecnica.Piloto;

public class Aviao {
	
	private List<String> tripulates = new ArrayList<String>();
	private String CHEFE_DE_SERVIÇO_DE_BORDO = "CHEFE_DE_SERVIÇO_DE_BORDO";
	private List<String> tripulatesEsperados = new ArrayList<String>();

	public List<String> getTripulates() {
		return tripulates;
	}

	public void adicionarTripulantesNoAviao(String tripulate) {
		this.tripulates.add(tripulate);
	}
	
	public Boolean adicionarTripulantesNoAviao(Boolean conseguiu, Oficial_1 oficial_1, Oficial_2 oficial_2,
			List<String> AVIAO, Presidiario presidiario, Policial policial, Piloto piloto, ChefeServicoVoo chefeServicoVoo, 
			List<String> VEICULO, Comissaria_1 comissaria_1, Comissaria_2 comissaria_2) {
		
		tripulatesEsperados.add(CHEFE_DE_SERVIÇO_DE_BORDO);
		tripulatesEsperados.add("COMISSARIA_01");
		tripulatesEsperados.add("COMISSARIA_02");
		tripulatesEsperados.add("CHEFE_DE_SERVIÇO_DE_VOO");
		tripulatesEsperados.add("OFICIAL_01");
		tripulatesEsperados.add("OFICIAL_02");
		tripulatesEsperados.add("PILOTO");
		tripulatesEsperados.add("POLICIAL");
		tripulatesEsperados.add("PRESIDIARIO");
		
		Integer countAviao = 0;
		Integer countVeiculo = 0;
		
		if(!AVIAO.contains(CHEFE_DE_SERVIÇO_DE_BORDO)) {
			AVIAO.add(CHEFE_DE_SERVIÇO_DE_BORDO);
		}
		
		System.out.println("");
		System.out.println("Veiculo chegou no avião.");
		System.out.println("");
		
		for (String pessoa : VEICULO) {
			
			countVeiculo++;
			
			if(VEICULO.contains(chefeServicoVoo.getProfissao()) && VEICULO.contains(comissaria_1.getProfissao())) {
					AVIAO.add(comissaria_1.getProfissao());
			}
		}
		
		
		if(AVIAO.contains(CHEFE_DE_SERVIÇO_DE_BORDO) && AVIAO.contains(oficial_1.getProfissao()) 
				|| AVIAO.contains(CHEFE_DE_SERVIÇO_DE_BORDO) && AVIAO.contains(oficial_2.getProfissao())) {
			
			System.out.println("");
			System.out.println("NENHUM DOS OFICIAIS PODEM FICAR SOZINHO COM O CHEFE DE SERVIÇO DE BORDO");
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("NÃO DEU CERTO, TENTE NOVAMENTE!");
			System.out.println("");
			
			AVIAO = new ArrayList<String>();
			
		} else if (AVIAO.contains(presidiario.getProfissao()) && !AVIAO.contains(policial.getProfissao())) {
			
			System.out.println("");
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("O PRESIDIARIO NÃO PODE FICAR SOZINHO COM OS TRIPULANTES SEM A PRESENÇA DO POLICIAL NO TERMINAL!");
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("NÃO DEU CERTO, TENTE NOVAMENTE!");
			System.out.println("");
			
			AVIAO = new ArrayList<String>();
		
		} else {
			AVIAO.stream().forEach((elemento) -> System.out.println("Tripulantes no avião: " + elemento));
			conseguiu = false;
		}
		return conseguiu;
	}

}
