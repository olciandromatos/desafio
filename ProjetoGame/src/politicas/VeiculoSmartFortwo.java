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
	
	public List<String> verificarRegraDoVeiculoParaPilotos(Piloto piloto, Policial policial,
			ChefeServicoVoo chefeServicoVoo, List<String> VEICULO, Integer pilotagemVeiculo) {
		
		if(pilotagemVeiculo == 1) {
			if(policial.getProfissao() != null) {
				if(!VEICULO.contains(policial.getProfissao())) {
					VEICULO = new ArrayList<String>();
					System.out.println("escolheu POLICIAL");
					policial.setProfissao("POLICIAL");
					VEICULO.add(policial.getProfissao());
				}
			} else {
				System.out.println("escolheu POLICIAL");
				policial.setProfissao("POLICIAL");
				VEICULO.add(policial.getProfissao());
			}
		} else if (pilotagemVeiculo == 2) {
			if(piloto.getProfissao() != null) {
				if(!VEICULO.contains(piloto.getProfissao())) {
					VEICULO = new ArrayList<String>();
					System.out.println("escolheu PILOTO");
					piloto.setProfissao("PILOTO");
					VEICULO.add(piloto.getProfissao());
				}
			} else {
				System.out.println("escolheu PILOTO");
				piloto.setProfissao("PILOTO");
				VEICULO.add(piloto.getProfissao());
			}
		} else if (pilotagemVeiculo == 3) {
			if(chefeServicoVoo.getProfissao() != null) {
				if(!VEICULO.contains(chefeServicoVoo.getProfissao())) {
					VEICULO = new ArrayList<String>();
					System.out.println("escolheu CHEFE DE SERVIÇO DE VOO");
					chefeServicoVoo.setProfissao("CHEFE_DE_SERVIÇO_DE_VOO");
					VEICULO.add(chefeServicoVoo.getProfissao());
				}
			} else {
				System.out.println("escolheu CHEFE DE SERVIÇO DE VOO");
				chefeServicoVoo.setProfissao("CHEFE_DE_SERVIÇO_DE_VOO");
				VEICULO.add(chefeServicoVoo.getProfissao());
			}
		} else {
			System.out.println("escolha um número válido!");
		}
		return VEICULO;
	} 
	
	public List<String> verificarRegraDoVeiculoParaCompaheiroDoVeiculo(Oficial_1 oficial_1, Oficial_2 oficial_2,
			Comissaria_1 comissaria_1, Comissaria_2 comissaria_2, Presidiario presidiario, List<String> VEICULO,
			Integer tripulanteEscolhido) {
		
		if(tripulanteEscolhido == 4) {
			if(oficial_1.getProfissao() != null) {
				if(!VEICULO.contains(oficial_1.getProfissao())) {
					VEICULO = new ArrayList<String>();
					System.out.println("escolheu OFICIAL_01");
					oficial_1.setProfissao("OFICIAL_01");
					VEICULO.add(oficial_1.getProfissao());
				}
				
			} else {
				System.out.println("escolheu OFICIAL_01");
				oficial_1.setProfissao("OFICIAL_01");
				VEICULO.add(oficial_1.getProfissao());
			}
		} else if(tripulanteEscolhido == 5) {
			if(oficial_2.getProfissao() != null) {
				if(!VEICULO.contains(oficial_2.getProfissao())) {
					VEICULO = new ArrayList<String>();
					System.out.println("escolheu OFICIAL_02");
					oficial_2.setProfissao("OFICIAL_02");
					VEICULO.add(oficial_2.getProfissao());
				}
			} else {
				System.out.println("escolheu OFICIAL_02");
				oficial_2.setProfissao("OFICIAL_02");
				VEICULO.add(oficial_2.getProfissao());
			}
		} else if(tripulanteEscolhido == 6) {
			if(comissaria_1.getProfissao() != null) {
				if(!VEICULO.contains(comissaria_1.getProfissao())) {
					VEICULO = new ArrayList<String>();
					System.out.println("escolheu COMISSARIA_01");
					comissaria_1.setProfissao("COMISSARIA_01");
					VEICULO.add(comissaria_1.getProfissao());
				}
				VEICULO.remove(comissaria_1.getProfissao());
			} else {
				System.out.println("escolheu COMISSARIA_01");
				comissaria_1.setProfissao("COMISSARIA_01");
				VEICULO.add(comissaria_1.getProfissao());
			}
		} else if(tripulanteEscolhido == 7) {
			if(comissaria_2.getProfissao() != null) {
				if(!VEICULO.contains(comissaria_2.getProfissao())) {
					VEICULO = new ArrayList<String>();
					System.out.println("escolheu COMISSARIA_02");
					comissaria_2.setProfissao("COMISSARIA_02");
					VEICULO.add(comissaria_2.getProfissao());
				}
			} else {
				System.out.println("escolheu COMISSARIA_02");
				comissaria_2.setProfissao("COMISSARIA_02");
				VEICULO.add(comissaria_2.getProfissao());
			}
		} else if(tripulanteEscolhido == 8) {
			if(presidiario.getProfissao() != null) {
				if(!VEICULO.contains(presidiario.getProfissao())) {
					VEICULO = new ArrayList<String>();
					System.out.println("escolheu PRESIDIARIO");
					presidiario.setProfissao("PRESIDIARIO");
					VEICULO.add(presidiario.getProfissao());
				}
			} else {
				System.out.println("escolheu PRESIDIARIO");
				presidiario.setProfissao("PRESIDIARIO");
				VEICULO.add(presidiario.getProfissao());
			}
		} else {
			System.out.println("escolha um número válido!");
		}
		return VEICULO;
	}
	
	public void verificarRegraDeQuemEstaNoVeiculo(Boolean conseguiu, Aviao aviao, List<String> VEICULO, Comissaria_1 comissaria_1, Piloto piloto, 
			Policial policial, Comissaria_2 comissaria_2, Oficial_1 oficial_1, Oficial_2 oficial_2, Presidiario presidiario, ChefeServicoVoo chefeServicoVoo) {
		
		if(VEICULO.contains(piloto.getProfissao()) &&  VEICULO.contains(comissaria_1.getProfissao()) 
				|| VEICULO.contains(piloto.getProfissao()) &&  VEICULO.contains(comissaria_2.getProfissao())) {
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("NENHUMA DAS COMISSÁRIAS PODEM FICAR SOZINHA COM O PILOTO!");
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("NÃO DEU CERTO, TENTE NOVAMENTE!");
			System.out.println("");
			
		} else if (VEICULO.contains(policial.getProfissao()) && !VEICULO.contains(presidiario.getProfissao())) {
			
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("O PRESIDIARIO NÃO PODE FICAR SOZINHO COM OS TRIPULANTES SEM A PRESENÇA DO POLICIAL NO TERMINAL!");
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("NÃO DEU CERTO, TENTE NOVAMENTE!");
			System.out.println("");
			
			VEICULO = new ArrayList<String>();
			
		} else {
			conseguiu = aviao.adicionarTripulantesNoAviao(conseguiu, oficial_1, oficial_2, AVIAO, presidiario, policial, piloto, chefeServicoVoo, VEICULO, comissaria_1, comissaria_2);
		}
	}

}
