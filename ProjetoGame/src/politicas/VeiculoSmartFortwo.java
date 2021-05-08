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
				VEICULO = new ArrayList<String>();
				System.out.println("escolheu POLICIAL");
				policial.setProfissao("POLICIAL");
				VEICULO.add(policial.getProfissao());
			} else {
				System.out.println("escolheu POLICIAL");
				policial.setProfissao("POLICIAL");
				VEICULO.add(policial.getProfissao());
			}
		} else if (pilotagemVeiculo == 2) {
			if(piloto.getProfissao() != null) {
				VEICULO = new ArrayList<String>();
				System.out.println("escolheu PILOTO");
				piloto.setProfissao("PILOTO");
				VEICULO.add(piloto.getProfissao());
			} else {
				System.out.println("escolheu PILOTO");
				piloto.setProfissao("PILOTO");
				VEICULO.add(piloto.getProfissao());
			}
		} else if (pilotagemVeiculo == 3) {
			if(chefeServicoVoo.getProfissao() != null) {
				VEICULO = new ArrayList<String>();
				System.out.println("escolheu CHEFE DE SERVIÇO DE VOO");
				chefeServicoVoo.setProfissao("CHEFE_DE_SERVIÇO_DE_VOO");
				VEICULO.add(chefeServicoVoo.getProfissao());
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
				VEICULO = new ArrayList<String>();
				System.out.println("escolheu OFICIAL_01");
				oficial_1.setProfissao("OFICIAL_01");
				VEICULO.add(oficial_1.getProfissao());
			} else {
				System.out.println("escolheu OFICIAL_01");
				oficial_1.setProfissao("OFICIAL_01");
				VEICULO.add(oficial_1.getProfissao());
			}
		} else if(tripulanteEscolhido == 5) {
			if(oficial_2.getProfissao() != null) {
				VEICULO = new ArrayList<String>();
				System.out.println("escolheu OFICIAL_02");
				oficial_2.setProfissao("OFICIAL_02");
				VEICULO.add(oficial_2.getProfissao());
			} else {
				System.out.println("escolheu OFICIAL_02");
				oficial_2.setProfissao("OFICIAL_02");
				VEICULO.add(oficial_2.getProfissao());
			}
		} else if(tripulanteEscolhido == 6) {
			if(comissaria_1.getProfissao() != null) {
				VEICULO = new ArrayList<String>();
				System.out.println("escolheu COMISSARIA_01");
				comissaria_1.setProfissao("COMISSARIA_01");
				VEICULO.add(comissaria_1.getProfissao());
			} else {
				System.out.println("escolheu COMISSARIA_01");
				comissaria_1.setProfissao("COMISSARIA_01");
				VEICULO.add(comissaria_1.getProfissao());
			}
		} else if(tripulanteEscolhido == 7) {
			if(comissaria_2.getProfissao() != null) {
				VEICULO = new ArrayList<String>();
				System.out.println("escolheu COMISSARIA_02");
				comissaria_2.setProfissao("COMISSARIA_02");
				VEICULO.add(comissaria_2.getProfissao());
			} else {
				System.out.println("escolheu COMISSARIA_02");
				comissaria_2.setProfissao("COMISSARIA_02");
				VEICULO.add(comissaria_2.getProfissao());
			}
		} else if(tripulanteEscolhido == 8) {
			if(presidiario.getProfissao() != null) {
				VEICULO = new ArrayList<String>();
				System.out.println("escolheu PRESIDIARIO");
				presidiario.setProfissao("PRESIDIARIO");
				VEICULO.add(presidiario.getProfissao());
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

}
