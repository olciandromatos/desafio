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
			List<String> VEICULO, Comissaria_1 comissaria_1, Comissaria_2 comissaria_2, List<String> terminal) {
		
		tripulatesEsperados.add(CHEFE_DE_SERVIÇO_DE_BORDO);
		tripulatesEsperados.add("COMISSARIA_01");
		tripulatesEsperados.add("COMISSARIA_02");
		tripulatesEsperados.add("CHEFE_DE_SERVIÇO_DE_VOO");
		tripulatesEsperados.add("OFICIAL_01");
		tripulatesEsperados.add("OFICIAL_02");
		tripulatesEsperados.add("PILOTO");
		tripulatesEsperados.add("POLICIAL");
		tripulatesEsperados.add("PRESIDIARIO");
		
		long countAviao = 0;
		long countVeiculo = 0;
		
		if(!AVIAO.contains(CHEFE_DE_SERVIÇO_DE_BORDO)) {
			AVIAO.add(CHEFE_DE_SERVIÇO_DE_BORDO);
		}
		
		System.out.println("");
		System.out.println("Veiculo chegou no avião.");
		System.out.println("");
		
		countVeiculo = VEICULO.stream().count();
			
			if(VEICULO.contains(chefeServicoVoo.getProfissao()) && VEICULO.contains(comissaria_1.getProfissao())) {
				if(!AVIAO.contains(comissaria_1.getProfissao()) ) {
					AVIAO.add(comissaria_1.getProfissao());
					VEICULO.remove(1);
				}
			}
			
			if(VEICULO.contains(chefeServicoVoo.getProfissao()) && VEICULO.contains(comissaria_2.getProfissao())) {
				if(!AVIAO.contains(comissaria_2.getProfissao()) ) {
					AVIAO.add(comissaria_2.getProfissao());
					VEICULO.remove(1);
				}
			}
			
			if(VEICULO.contains(chefeServicoVoo.getProfissao()) && VEICULO.contains(oficial_1.getProfissao())) {
				if(!AVIAO.contains(oficial_1.getProfissao()) ) {
					AVIAO.add(oficial_1.getProfissao());
					VEICULO.remove(1);
				}
			}
			
			if(VEICULO.contains(chefeServicoVoo.getProfissao()) && VEICULO.contains(oficial_2.getProfissao())) {
				if(!AVIAO.contains(oficial_2.getProfissao()) ) {
					AVIAO.add(oficial_2.getProfissao());
					VEICULO.remove(1);
				}
			}
			
			if(VEICULO.contains(chefeServicoVoo.getProfissao()) && VEICULO.contains(piloto.getProfissao())) {
				if(VEICULO.contains(chefeServicoVoo.getProfissao()) && VEICULO.contains(policial.getProfissao()) && terminal.isEmpty()) {
					if(!AVIAO.contains(piloto.getProfissao()) || !AVIAO.contains(chefeServicoVoo.getProfissao()) ) {
						AVIAO.add(piloto.getProfissao());
						AVIAO.add(chefeServicoVoo.getProfissao());
						VEICULO.remove(0);
						VEICULO.remove(0);
					}
				} else {
					if(!AVIAO.contains(piloto.getProfissao()) ) {
						AVIAO.add(piloto.getProfissao());
						VEICULO.remove(0);
					}
				}
			}
			
			if(VEICULO.contains(chefeServicoVoo.getProfissao()) && VEICULO.contains(policial.getProfissao())) {
				if(!AVIAO.contains(chefeServicoVoo.getProfissao()) ) {
					AVIAO.add(chefeServicoVoo.getProfissao());
					VEICULO.remove(0);
				}
			}
			
			if(VEICULO.contains(policial.getProfissao()) && VEICULO.contains(presidiario.getProfissao())) {
				if(!AVIAO.contains(policial.getProfissao()) || !AVIAO.contains(presidiario.getProfissao())) {
					if(VEICULO.contains(policial.getProfissao()) && VEICULO.contains(presidiario.getProfissao()) && terminal.contains(chefeServicoVoo.getProfissao())) {
						AVIAO.add(policial.getProfissao());
						AVIAO.add(presidiario.getProfissao());
						VEICULO.remove(0);
						VEICULO.remove(0);
						VEICULO.add(piloto.getProfissao());
						AVIAO.remove(piloto.getProfissao());
					} else {
						AVIAO.add(policial.getProfissao());
						AVIAO.add(presidiario.getProfissao());
						VEICULO.remove(0);
						VEICULO.remove(0);
					}
				}
			}
		
		countAviao = AVIAO.stream().count();
		
		
		if(countAviao < 3 && AVIAO.contains(CHEFE_DE_SERVIÇO_DE_BORDO) && AVIAO.contains(oficial_1.getProfissao()) 
				|| countAviao < 3 && AVIAO.contains(CHEFE_DE_SERVIÇO_DE_BORDO) && AVIAO.contains(oficial_2.getProfissao())) {
			
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
			
			AVIAO.stream().forEach((elemento) -> System.out.println("TRIPULANTES NO AVIÃO: " + elemento));
			System.out.println("");
			terminal.stream().forEach((elemento) -> System.out.println("OS QUE CONTINUAM NO TERMINAL: " + elemento));
			System.out.println("");
			VEICULO.stream().forEach((elemento) -> System.out.println("OS QUE ESTÃO NO VEICULO DEPOIS DE PASSAR NO AVIÃO: " + elemento));
			
			if(countAviao > 8) {
				conseguiu = true;
			}
		}
		
		return conseguiu;
	}

}
