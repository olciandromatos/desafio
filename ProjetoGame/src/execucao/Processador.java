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
	private Boolean conseguiu = true;
	
	public void processarGame() {
		
		System.out.println("LEVE OS TRIPULANTES DO TERMIONAL PARA O AVIÃO.");
		System.out.println("MAS CUIDADO! ESCOLHA BEM QUEM VAI PILOTAR O VEÍCULO.");
		
		do {
			
		criarMensagemTextoParaEscolherPilotoDoVeiculo();
		
		Integer pilotagemVeiculo = opcao.nextInt();
		
		VEICULO = veiculo.verificarRegraDoVeiculoParaPilotos(piloto, policial, chefeServicoVoo, VEICULO, pilotagemVeiculo);
		
		criarMensagemTextoParaEscolherPassageiroDoVeiculo();
		
		Integer tripulanteEscolhido = opcao.nextInt();
		
		VEICULO = veiculo.verificarRegraDoVeiculoParaCompaheiroDoVeiculo(oficial_1, oficial_2, comissaria_1, comissaria_2,
				presidiario, VEICULO, tripulanteEscolhido);
		
		veiculo.verificarRegraDeQuemEstaNoVeiculo(conseguiu, aviao, VEICULO, comissaria_1, piloto, policial, comissaria_2, oficial_1, oficial_2, presidiario, chefeServicoVoo);
		
		} while (conseguiu);
		
		System.out.println("PARABÉNS!! Conseguiu Resolver!");
	}

	private void criarMensagemTextoParaEscolherPassageiroDoVeiculo() {
		System.out.println("");
		System.out.println("Escolha quem vai ir junto com o escolhiodo pra pilotar.");
		System.out.println("");
		System.out.println("digite 4 para a escolha do OFICIAL_01.");
		System.out.println("digite 5 para a escolha do OFICIAL_02.");
		System.out.println("digite 6 para a escolha do COMISSARIA_01.");
		System.out.println("digite 7 para a escolha do COMISSARIA_02.");
		System.out.println("digite 8 para a escolha do PRESIDIARIO.");
		System.out.println("");
		System.out.print("digite o número escolhido: ");
		System.out.println("");
	}

	private void criarMensagemTextoParaEscolherPilotoDoVeiculo() {
		System.out.println("Escolha quem vai pilotar o veículo SmartFortwo.");
		System.out.println("");
		System.out.println("digite 1 para a escolha do POLICIAL");
		System.out.println("digite 2 para a escolha do PILOTO");
		System.out.println("digite 3 para a escolha do CHEFE DE SERVIÇO DE VOO");
		System.out.println("");
		System.out.print("digite o número escolhido: ");
		System.out.println("");
	}

}
