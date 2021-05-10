package execucao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import politicas.Aviao;
import politicas.VeiculoSmartFortwo;
import seguranca.Policial;
import seguranca.Presidiario;
import tripulacaocabine.ChefeServicoVoo;
import tripulacaocabine.Comissaria_1;
import tripulacaocabine.Comissaria_2;
import tripulacaotecnica.Oficial_1;
import tripulacaotecnica.Oficial_2;
import tripulacaotecnica.Piloto;

public class Processador {
	
	Piloto piloto = new Piloto();
	Oficial_1 oficial_1 = new Oficial_1();
	Oficial_2 oficial_2 = new Oficial_2();
	Comissaria_1 comissaria_1 = new Comissaria_1();
	Comissaria_2 comissaria_2 = new Comissaria_2();
	Policial policial = new Policial();
	Presidiario presidiario = new Presidiario();
	ChefeServicoVoo chefeServicoVoo = new ChefeServicoVoo();
	VeiculoSmartFortwo veiculo = new VeiculoSmartFortwo();
	Aviao aviao = new Aviao();
	List<String> VEICULO = new ArrayList<String>();
	private Scanner opcao = new Scanner(System.in);
	private Boolean conseguiu = false;
	Integer contador = 3;
	List<String> terminal = new ArrayList<String>();
	
	public void processarGame() {
		carregarDadosTerminal(terminal);
		System.out.println("LEVE OS TRIPULANTES DO TERMIONAL PARA O AVIÃO.");
		System.out.println("MAS CUIDADO! ESCOLHA BEM QUEM VAI PILOTAR O VEÍCULO.");
		
		do {
			
			if(terminal.size() > 1) {
				for(Integer numeroInterno = 1; numeroInterno < contador; numeroInterno++) {
					
						if(numeroInterno == 2) {
							MensagemTextoParaProximo();
						} else {
							MensagemTextoParaEscolherPassageiroDoVeiculo();
						}
					
					Integer tripulanteEscolhido = opcao.nextInt();
					if(numeroInterno == 1 && tripulanteEscolhido == 1 && VEICULO.contains(chefeServicoVoo.getProfissao())) {
						VEICULO.remove(chefeServicoVoo.getProfissao());
						terminal.add(chefeServicoVoo.getProfissao());
					}
					
					VEICULO = veiculo.selecionarOcupantesParaVeiculo(piloto, policial, chefeServicoVoo, oficial_1, oficial_2, comissaria_1, comissaria_2, presidiario, VEICULO, tripulanteEscolhido, terminal);
				}
			} else {
				MensagemTextoParaProximo();
				Integer tripulanteEscolhido = opcao.nextInt();
				VEICULO = veiculo.selecionarOcupantesParaVeiculo(piloto, policial, chefeServicoVoo, oficial_1, oficial_2, comissaria_1, comissaria_2, presidiario, VEICULO, tripulanteEscolhido, terminal);
			}
			
			conseguiu = veiculo.verificarRegraDeQuemEstaNoVeiculo(conseguiu, aviao, VEICULO, comissaria_1, piloto, policial, comissaria_2, oficial_1, oficial_2, presidiario, chefeServicoVoo, terminal);
			
		} while (!conseguiu);
		
		System.out.println("PARABÉNS!! Conseguiu Resolver!");
	}

	private void carregarDadosTerminal(List<String> terminal) {
		terminal.add("PILOTO");
		terminal.add("CHEFE_DE_SERVIÇO_DE_VOO");
		terminal.add("OFICIAL_01");
		terminal.add("OFICIAL_02");
		terminal.add("COMISSARIA_01");
		terminal.add("COMISSARIA_02");
		terminal.add("POLICIAL");
		terminal.add("PRESIDIARIO");
	}

	private void MensagemTextoParaEscolherPassageiroDoVeiculo() {
		System.out.println("");
		System.out.println("ESCOLHA OS 2 QUE VÃO NO VEÍCULO.");
		System.out.println("Digite 1 para a escolha do POLICIAL");
		System.out.println("Digite 2 para a escolha do PILOTO");
		System.out.println("Digite 3 para a escolha do CHEFE DE SERVIÇO DE VOO");
		System.out.println("Digite 4 para a escolha do OFICIAL_01.");
		System.out.println("Digite 5 para a escolha do OFICIAL_02.");
		System.out.println("Digite 6 para a escolha do COMISSARIA_01.");
		System.out.println("Digite 7 para a escolha do COMISSARIA_02.");
		System.out.println("Digite 8 para a escolha do PRESIDIARIO.");
		System.out.println("");
		System.out.print("Digite o número escolhido: ");
	}
	
	private void MensagemTextoParaProximo() {
		System.out.println("");
		System.out.println("ESCOLHA OS 2 QUE VÃO NO VEÍCULO.");
		System.out.println("Digite 1 para escolher o POLICIAL");
		System.out.println("Digite 2 para escolher o PILOTO");
		System.out.println("Digite 3 para escolher o CHEFE DE SERVIÇO DE VOO");
		System.out.println("Digite 4 para escolher o OFICIAL_01.");
		System.out.println("Digite 5 para escolher o OFICIAL_02.");
		System.out.println("Digite 6 para escolher a COMISSARIA_01.");
		System.out.println("Digite 7 para escolher a COMISSARIA_02.");
		System.out.println("Digite 8 para escolher o PRESIDIARIO.");
		System.out.println("");
		System.out.print("Digite o nome do próximo que vai entrar no veículo: ");
	}

}
