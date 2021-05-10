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
		
		adicionarTripulantesEsperadosNoAviao();
		
		long quantidadeNoAviao =  AVIAO.stream().count();
		
		if(!AVIAO.contains(CHEFE_DE_SERVIÇO_DE_BORDO)) {
			AVIAO.add(CHEFE_DE_SERVIÇO_DE_BORDO);
		}
		
		System.out.println("");
		System.out.println("Veiculo chegou no avião.");
		System.out.println("");
		
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
					if(VEICULO.contains(policial.getProfissao()) && VEICULO.contains(presidiario.getProfissao()) && terminal.contains("CHEFE_DE_SERVIÇO_DE_VOO")) {
						AVIAO.add(policial.getProfissao());
						AVIAO.add(presidiario.getProfissao());
						VEICULO.remove(0);
						VEICULO.remove(0);
						
						if(AVIAO.contains(piloto.getProfissao())) {
							VEICULO.add(piloto.getProfissao());
							AVIAO.remove(piloto.getProfissao());
					    } else {
					    	
					    	System.out.println("O VEÍCULO TEM QUE SER PILOTADO POR ALGUÉM CAPACITADO! E NÃO TEM OUTRA PESSOA QUE SAIBA PILOTAR O VEICULO NO AVIÃO");
							System.out.println("O PRESIDIARIO NÃO PODE FICAR SOZINHO COM OS TRIPULANTES SEM A PRESENÇA DO POLICIAL NO TERMINAL!");
							System.out.println("------------------------------------------------------------------------------------");
							System.out.println("NÃO DEU CERTO, TENTE NOVAMENTE!");
							System.out.println("");
							
							AVIAO.remove(presidiario.getProfissao());
							AVIAO.remove(policial.getProfissao());
							terminal.add(policial.getProfissao());
							terminal.add(presidiario.getProfissao());
					    }
						
					} else {
						AVIAO.add(policial.getProfissao());
						AVIAO.add(presidiario.getProfissao());
						VEICULO.remove(0);
						VEICULO.remove(0);
					}
				}
			}
			
		if(VEICULO.contains(piloto.getProfissao()) && VEICULO.contains(oficial_1.getProfissao()) || VEICULO.contains(piloto.getProfissao()) && VEICULO.contains(oficial_2.getProfissao())) {
			if(!AVIAO.contains(oficial_1.getProfissao()) || !AVIAO.contains(oficial_2.getProfissao())) {
					
				if(VEICULO.contains(oficial_1.getProfissao())) {
					AVIAO.add(oficial_1.getProfissao());
					VEICULO.remove(1);
				} else {
					AVIAO.add(oficial_1.getProfissao());
					VEICULO.remove(1);
				}
			}
		}
		
		conseguiu = verificarRegrasNoAviao(conseguiu, oficial_1, oficial_2, AVIAO, presidiario, policial, VEICULO,
				terminal, quantidadeNoAviao, chefeServicoVoo);
		
		return conseguiu;
	}

	private void adicionarTripulantesEsperadosNoAviao() {
		tripulatesEsperados.add(CHEFE_DE_SERVIÇO_DE_BORDO);
		tripulatesEsperados.add("COMISSARIA_01");
		tripulatesEsperados.add("COMISSARIA_02");
		tripulatesEsperados.add("CHEFE_DE_SERVIÇO_DE_VOO");
		tripulatesEsperados.add("OFICIAL_01");
		tripulatesEsperados.add("OFICIAL_02");
		tripulatesEsperados.add("PILOTO");
		tripulatesEsperados.add("POLICIAL");
		tripulatesEsperados.add("PRESIDIARIO");
	}

	private Boolean verificarRegrasNoAviao(Boolean conseguiu, Oficial_1 oficial_1, Oficial_2 oficial_2,
			List<String> AVIAO, Presidiario presidiario, Policial policial, List<String> VEICULO, List<String> terminal,
			long quantidadeNoAviao, ChefeServicoVoo chefeServicoVoo) {
		
		if(quantidadeNoAviao < 3 && AVIAO.contains(CHEFE_DE_SERVIÇO_DE_BORDO) && AVIAO.contains(oficial_1.getProfissao()) 
				|| quantidadeNoAviao < 3 && AVIAO.contains(CHEFE_DE_SERVIÇO_DE_BORDO) && AVIAO.contains(oficial_2.getProfissao())) {
			
			System.out.println("");
			System.out.println("NENHUM DOS OFICIAIS PODEM FICAR SOZINHO COM O CHEFE DE SERVIÇO DE BORDO");
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("NÃO DEU CERTO, TENTE NOVAMENTE!");
			System.out.println("");
			
			if (VEICULO.contains(chefeServicoVoo.getProfissao())) {
				VEICULO.remove(chefeServicoVoo.getProfissao());
				terminal.add(chefeServicoVoo.getProfissao());
			}

			if(AVIAO.contains(oficial_1.getProfissao())) {
				AVIAO.remove(oficial_1.getProfissao());
				terminal.add(oficial_1.getProfissao());
			} else {
				AVIAO.remove(oficial_2.getProfissao());
				terminal.add(oficial_2.getProfissao());
			}
			
		} else if (AVIAO.contains(presidiario.getProfissao()) && !AVIAO.contains(policial.getProfissao())) {
			
			System.out.println("");
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("O PRESIDIARIO NÃO PODE FICAR SOZINHO COM OS TRIPULANTES SEM A PRESENÇA DO POLICIAL NO TERMINAL!");
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("NÃO DEU CERTO, TENTE NOVAMENTE!");
			System.out.println("");
			
			AVIAO.remove(presidiario.getProfissao());
			terminal.add(presidiario.getProfissao());
		
		} else {
			
			System.out.println("------------------------------------------------------------------------------------");
			AVIAO.stream().forEach((elemento) -> System.out.println("TRIPULANTES NO AVIÃO: " + elemento));
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("");
			System.out.println("------------------------------------------------------------------------------------");
			terminal.stream().forEach((elemento) -> System.out.println("OS QUE CONTINUAM NO TERMINAL: " + elemento));
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("");
			System.out.println("------------------------------------------------------------------------------------");
			VEICULO.stream().forEach((elemento) -> System.out.println("OS QUE ESTÃO NO VEICULO DEPOIS DE PASSAR NO AVIÃO: " + elemento));
			System.out.println("CONTINUE LEVANDO MAIS...!");
			System.out.println("------------------------------------------------------------------------------------");
			
			if(quantidadeNoAviao > 8) {
				conseguiu = true;
			}
		}
		
		return conseguiu;
	}
}