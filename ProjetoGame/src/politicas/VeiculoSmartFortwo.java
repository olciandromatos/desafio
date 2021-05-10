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

public class VeiculoSmartFortwo {
	
	private List<String> passageiros = new ArrayList<String>();
	List<String> AVIAO = new ArrayList<String>();

	public List<String> getTripulates() {
		return passageiros;
	}

	public void adicionarPassageirosNoVeiculo(String passageiro) {
		this.passageiros.add(passageiro);
	}
	
	public List<String> selecionarOcupantesParaVeiculo(Piloto piloto, Policial policial,
			ChefeServicoVoo chefeServicoVoo, Oficial_1 oficial_1, Oficial_2 oficial_2,
			Comissaria_1 comissaria_1, Comissaria_2 comissaria_2, Presidiario presidiario, List<String> VEICULO,
			Integer tripulanteEscolhido, List<String> terminal) {
		
		if(tripulanteEscolhido == 1) {
			if(policial.getProfissao() != null) {
				if(!VEICULO.contains(policial.getProfissao())) {
					policial.setProfissao("POLICIAL");
					System.out.println("Escolheu: " + policial.getProfissao());
					VEICULO.add(policial.getProfissao());
					terminal.remove(policial.getProfissao());
				}
			} else {
				if(tripulanteEscolhido == 1 && VEICULO.contains(chefeServicoVoo.getProfissao())) {
					
				}
				policial.setProfissao("POLICIAL");
				System.out.println("Escolheu: " + policial.getProfissao());
				VEICULO.add(policial.getProfissao());
				terminal.remove(policial.getProfissao());
			}
		} else if (tripulanteEscolhido == 2) {
			if(piloto.getProfissao() != null) {
				if(!VEICULO.contains(piloto.getProfissao())) {
					piloto.setProfissao("PILOTO");
					System.out.println("Escolheu: " + piloto.getProfissao());
					VEICULO.add(piloto.getProfissao());
					terminal.remove(piloto.getProfissao());
				}
			} else {
				piloto.setProfissao("PILOTO");
				System.out.println("Escolheu: " + piloto.getProfissao());
				VEICULO.add(piloto.getProfissao());
				terminal.remove(piloto.getProfissao());
			}
		} else if (tripulanteEscolhido == 3) {
			if(chefeServicoVoo.getProfissao() != null) {
				if(!VEICULO.contains(chefeServicoVoo.getProfissao())) {
					chefeServicoVoo.setProfissao("CHEFE_DE_SERVIÇO_DE_VOO");
					System.out.println("Escolheu: " + chefeServicoVoo.getProfissao());
					VEICULO.add(chefeServicoVoo.getProfissao());
					terminal.remove(chefeServicoVoo.getProfissao());
				}
			} else {
				chefeServicoVoo.setProfissao("CHEFE_DE_SERVIÇO_DE_VOO");
				System.out.println("Escolheu: " + chefeServicoVoo.getProfissao());
				VEICULO.add(chefeServicoVoo.getProfissao());
				terminal.remove(chefeServicoVoo.getProfissao());
			}
		} else if(tripulanteEscolhido == 4) {
			if(oficial_1.getProfissao() != null) {
				if(!VEICULO.contains(oficial_1.getProfissao())) {
					oficial_1.setProfissao("OFICIAL_01");
					System.out.println("Escolheu: " + oficial_1.getProfissao());
					VEICULO.add(oficial_1.getProfissao());
					terminal.remove(oficial_1.getProfissao());
			}
				
			} else {
				oficial_1.setProfissao("OFICIAL_01");
				System.out.println("Escolheu: " + oficial_1.getProfissao());
				VEICULO.add(oficial_1.getProfissao());
				terminal.remove(oficial_1.getProfissao());
			}
		} else if(tripulanteEscolhido == 5) {
			if(oficial_2.getProfissao() != null) {
				if(!VEICULO.contains(oficial_2.getProfissao())) {
					oficial_2.setProfissao("OFICIAL_02");
					System.out.println("Escolheu: " + oficial_2.getProfissao());
					VEICULO.add(oficial_2.getProfissao());
					terminal.remove(oficial_2.getProfissao());
				}
			} else {
				oficial_2.setProfissao("OFICIAL_02");
				VEICULO.add(oficial_2.getProfissao());
				System.out.println("Escolheu: " + oficial_2.getProfissao());
				terminal.remove(oficial_2.getProfissao());
			}
		} else if(tripulanteEscolhido == 6) {
			if(comissaria_1.getProfissao() != null) {
				if(!VEICULO.contains(comissaria_1.getProfissao())) {
					comissaria_1.setProfissao("COMISSARIA_01");
					System.out.println("Escolheu: " + comissaria_1.getProfissao());
					VEICULO.add(comissaria_1.getProfissao());
					terminal.remove(comissaria_1.getProfissao());
				}
				VEICULO.remove(comissaria_1.getProfissao());
			} else {
				comissaria_1.setProfissao("COMISSARIA_01");
				System.out.println("Escolheu: " + comissaria_1.getProfissao());
				VEICULO.add(comissaria_1.getProfissao());
				terminal.remove(comissaria_1.getProfissao());
			}
		} else if(tripulanteEscolhido == 7) {
			if(comissaria_2.getProfissao() != null) {
				if(!VEICULO.contains(comissaria_2.getProfissao())) {
					comissaria_2.setProfissao("COMISSARIA_02");
					System.out.println("Escolheu: " + comissaria_2.getProfissao());
					VEICULO.add(comissaria_2.getProfissao());
					terminal.remove(comissaria_2.getProfissao());
				}
			} else {
				comissaria_2.setProfissao("COMISSARIA_02");
				System.out.println("Escolheu: " + comissaria_2.getProfissao());
				VEICULO.add(comissaria_2.getProfissao());
				terminal.remove(comissaria_2.getProfissao());
			}
		} else if(tripulanteEscolhido == 8) {
			if(presidiario.getProfissao() != null) {
				if(!VEICULO.contains(presidiario.getProfissao())) {
					presidiario.setProfissao("PRESIDIARIO");
					System.out.println("Escolheu: " + presidiario.getProfissao());
					VEICULO.add(presidiario.getProfissao());
					terminal.remove(presidiario.getProfissao());
				}
			} else {
				presidiario.setProfissao("PRESIDIARIO");
				System.out.println("Escolheu: " + presidiario.getProfissao());
				VEICULO.add(presidiario.getProfissao());
				terminal.remove(presidiario.getProfissao());
			}
		} else {
			System.out.println("escolha um número válido!");
		}
		return VEICULO;
	}
	
	public Boolean verificarRegraDeQuemEstaNoVeiculo(Boolean conseguiu, Aviao aviao, List<String> VEICULO, Comissaria_1 comissaria_1, Piloto piloto, 
			Policial policial, Comissaria_2 comissaria_2, Oficial_1 oficial_1, Oficial_2 oficial_2, Presidiario presidiario, ChefeServicoVoo chefeServicoVoo, List<String> terminal) {
		
		Long quantidadeNoTerminal = terminal.stream().count();
		
		System.out.println("------------------------------------------------------------------------------");
		VEICULO.stream().forEach((elemento) -> System.out.println("OS QUE ESTÃO NO VEICULO: " + elemento));
		System.out.println("------------------------------------------------------------------------------");
		
		if(VEICULO.contains(piloto.getProfissao()) &&  VEICULO.contains(comissaria_1.getProfissao()) 
				|| VEICULO.contains(piloto.getProfissao()) &&  VEICULO.contains(comissaria_2.getProfissao())) {
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("NENHUMA DAS COMISSÁRIAS PODEM FICAR SOZINHA COM O PILOTO!");
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("NÃO DEU CERTO, TENTE NOVAMENTE!");
			System.out.println("");
			
			VEICULO.remove(comissaria_1.getProfissao());
			terminal.add(comissaria_1.getProfissao());
			
		} else if (quantidadeNoTerminal > 1 && VEICULO.contains(policial.getProfissao()) && terminal.contains("PRESIDIARIO")) {
			
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("O PRESIDIARIO NÃO PODE FICAR SOZINHO COM OS TRIPULANTES SEM A PRESENÇA DO POLICIAL NO TERMINAL!");
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("NÃO DEU CERTO, TENTE NOVAMENTE!");
			System.out.println("");
			
			if(VEICULO.contains(chefeServicoVoo.getProfissao())) {
				VEICULO.remove(chefeServicoVoo.getProfissao());
				terminal.add(chefeServicoVoo.getProfissao());
			}
			
			VEICULO.remove(policial.getProfissao());
			terminal.add(policial.getProfissao());
			
		} else if (VEICULO.contains(chefeServicoVoo.getProfissao()) && VEICULO.contains(presidiario.getProfissao())) {	
			
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("O PRESIDIARIO NÃO PODE FICAR SOZINHO COM OS TRIPULANTES SEM A PRESENÇA DO POLICIAL NO TERMINAL!");
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("NÃO DEU CERTO, TENTE NOVAMENTE!");
			System.out.println("");
			
			VEICULO.remove(presidiario.getProfissao());
			terminal.add(presidiario.getProfissao());
		
		} else if (VEICULO.contains(piloto.getProfissao()) && VEICULO.contains(presidiario.getProfissao())) {
			
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("O PRESIDIARIO NÃO PODE FICAR SOZINHO COM OS TRIPULANTES SEM A PRESENÇA DO POLICIAL NO TERMINAL!");
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("NÃO DEU CERTO, TENTE NOVAMENTE!");
			System.out.println("");
			
			VEICULO.remove(presidiario.getProfissao());
			terminal.add(presidiario.getProfissao());
			VEICULO.remove(piloto.getProfissao());
			terminal.add(piloto.getProfissao());
				
		} else {
			conseguiu = aviao.adicionarTripulantesNoAviao(conseguiu, oficial_1, oficial_2, AVIAO, presidiario, policial, piloto, chefeServicoVoo, VEICULO, comissaria_1, comissaria_2, terminal);
			System.out.println("");
			System.out.println("Jogo Finalizado: " + conseguiu);
		}
		return conseguiu;
	}
}
