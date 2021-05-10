package execucao;

import java.util.ArrayList;
import java.util.Iterator;
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
		System.out.println("LEVE OS TRIPULANTES DO TERMINAL PARA O AVIÃO.");
		System.out.println("MAS CUIDADO! ESCOLHA BEM QUEM VAI PILOTAR O VEÍCULO. SÓ CABEM 2 NO VEÍCULO. ");
		System.out.println("DIGITE O NÚMERO QUE CORRESPONDA QUEM VAI SER ESCOLHIDO, LEMBRE-SE QUE VOCÊ VAI ESCOLHER QUEM VAU PILOTAR E QUEM VAI ACOMPANHAR.");
		
		do {
			String nomeEscolhido = null;
			if(terminal.size() > 1) {
				for(Integer numeroInterno = 1; numeroInterno < contador; numeroInterno++) {
					
						if(numeroInterno == 2) {
							MensagemTextoParaProximo();
						} else {
							MensagemTextoParaEscolherPassageiroDoVeiculo();
						}
					
					Integer tripulanteEscolhido = opcao.nextInt();
					
					nomeEscolhido = buscarNomeRelativoAoDigitado(tripulanteEscolhido, terminal);
					VEICULO = veiculo.selecionarOcupantesParaVeiculo(piloto, policial, chefeServicoVoo, oficial_1, oficial_2, comissaria_1, comissaria_2, presidiario, VEICULO, tripulanteEscolhido, terminal, nomeEscolhido);
				}
			} else {
				MensagemTextoParaProximo();
				Integer tripulanteEscolhido = opcao.nextInt();
				VEICULO = veiculo.selecionarOcupantesParaVeiculo(piloto, policial, chefeServicoVoo, oficial_1, oficial_2, comissaria_1, comissaria_2, presidiario, VEICULO, tripulanteEscolhido, terminal, nomeEscolhido);
			}
			
			conseguiu = veiculo.verificarRegraDeQuemEstaNoVeiculo(conseguiu, aviao, VEICULO, comissaria_1, piloto, policial, comissaria_2, oficial_1, oficial_2, presidiario, chefeServicoVoo, terminal);
			
		} while (!conseguiu);
		
		System.out.println("-----------------------------------");
		System.out.println("PARABÉNS!! CONSEGUIU RESOLVER!");
		System.out.println("-----------------------------------");
	}

	private String buscarNomeRelativoAoDigitado(Integer tripulanteEscolhido, List<String> terminal) {
		String nome = null;
		Integer count = 1;
		for (String nomeDaVez : terminal) {
			if(tripulanteEscolhido == count) {
				nome = nomeDaVez;
			} 
			count++;
		}
		return nome;
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
		
		Integer count = 0;
		
		for (Iterator iterator = terminal.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			count++;
			System.out.println("Digite " + count + " para escolher: " + string);
		}
		
		System.out.println("");
		System.out.print("Digite o número de quem é apto a pilotar: ");
	}
	
	private void MensagemTextoParaProximo() {
		System.out.println("");
		System.out.println("ESCOLHA OS 2 QUE VÃO NO VEÍCULO.");
		Integer count = 0;
		
		for (Iterator iterator = terminal.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			count++;
			System.out.println("Digite " + count + " para escolher: " + string);
		}
		
		System.out.println("");
		System.out.print("Digite o nome do próximo que vai entrar no veículo: ");
	}

}
