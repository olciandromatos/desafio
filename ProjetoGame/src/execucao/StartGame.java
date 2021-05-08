package execucao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import politicas.VeiculoSmartFortwo;
import seguranca.Policial;
import seguranca.Presidiario;
import tripulacaocabine.ChefeServicoVoo;
import tripulacaocabine.Comissaria_1;
import tripulacaocabine.Comissaria_2;
import tripulacaotecnica.Oficial_1;
import tripulacaotecnica.Oficial_2;
import tripulacaotecnica.Piloto;

public class StartGame {
	
	public static void main(String[] args) {
		Scanner opcao = new Scanner(System.in);
		Integer count = 0;
		Boolean conseguiu = true;
		
		Piloto piloto = new Piloto();
		Oficial_1 oficial_1 = new Oficial_1();
		Oficial_2 oficial_2 = new Oficial_2();
		Comissaria_1 comissaria_1 = new Comissaria_1();
		Comissaria_2 comissaria_2 = new Comissaria_2();
		Policial policial = new Policial();
		Presidiario presidiario = new Presidiario();
		ChefeServicoVoo chefeServicoVoo = new ChefeServicoVoo();
		VeiculoSmartFortwo veiculo = new VeiculoSmartFortwo();
		
		Integer CHEFE_DE_SERVI�O_DE_BORDO = null;
		
		List<String> AVIAO = new ArrayList<String>();
		List<String> VEICULO = new ArrayList<String>();
		
		System.out.println("Leve os tripulantes do terminal ao avi�o.");
		
		processarGame(opcao, count, conseguiu, piloto, oficial_1, oficial_2, comissaria_1, comissaria_2, policial,
				presidiario, chefeServicoVoo, veiculo, AVIAO, VEICULO);
		
		System.out.println("Conseguiu Resolver! Parab�ns!!");
	}

	private static void processarGame(Scanner opcao, Integer count, Boolean conseguiu, Piloto piloto,
			Oficial_1 oficial_1, Oficial_2 oficial_2, Comissaria_1 comissaria_1, Comissaria_2 comissaria_2,
			Policial policial, Presidiario presidiario, ChefeServicoVoo chefeServicoVoo, VeiculoSmartFortwo veiculo,
			List<String> AVIAO, List<String> VEICULO) {
		do {
			
		System.out.println("Escolha quem vai pilotar o ve�culo Smart Fortwo.");
		System.out.println("digite 1 para a escolha do POLICIAL");
		System.out.println("digite 2 para a escolha do PILOTO");
		System.out.println("digite 3 para a escolha do CHEFE DE SERVI�O DE VOO");
		System.out.print("digite o n�mero escolhido: ");
		
		Integer pilotagemVeiculo = opcao.nextInt();
		
		VEICULO = veiculo.verificarRegraDoVeiculoParaPilotos(piloto, policial, chefeServicoVoo, VEICULO, pilotagemVeiculo);
		
		System.out.println("");
		System.out.println("Escolha quem vai ir junto com o escolhiodo pra pilotar.");
		System.out.println("digite 4 para a escolha do OFICIAL_01.");
		System.out.println("digite 5 para a escolha do OFICIAL_02.");
		System.out.println("digite 6 para a escolha do COMISSARIA_01.");
		System.out.println("digite 7 para a escolha do COMISSARIA_02.");
		System.out.println("digite 8 para a escolha do PRESIDIARIO.");
		System.out.print("digite o n�mero escolhido: ");
		
		Integer tripulanteEscolhido = opcao.nextInt();
		
		VEICULO = veiculo.verificarRegraDoVeiculoParaCompaheiroDoVeiculo(oficial_1, oficial_2, comissaria_1, comissaria_2,
				presidiario, VEICULO, tripulanteEscolhido);
		
		if(VEICULO.contains(piloto.getProfissao()) &&  AVIAO.contains(comissaria_1.getProfissao()) || VEICULO.contains(piloto.getProfissao()) &&  AVIAO.contains(comissaria_2.getProfissao())) {
			System.out.println("NENHUMA DAS COMISS�RIAS PODEM FICAR SOZINHA COM O PILOTO.");
			System.out.println("TENTE NOVAMENTE!");
			System.out.println("------------------------------------------------------------------------------------");
		} else {
			
			for (String pessoa : VEICULO) {
				System.out.println("Veiculo indo ao avi�o... ");
				AVIAO.add(pessoa);
			}
			
			for (String tripulante : AVIAO) {
				System.out.println("Veiculo chegou no avi�o. ");
				count++;
				if(tripulante.equals(policial.getProfissao())) {
					System.out.print("POLICIAL");
				}
				
			}
			
			System.out.println("Tripulantes no Avi�o: " + count);
			System.out.println("------------------------------------------------------------------------------------");
			
			if(AVIAO.contains(oficial_1.getProfissao()) || AVIAO.contains(oficial_2.getProfissao())) {
				System.out.println("NENHUM DOS OFICIAIS PODEM FICAR SOZINHO COM O CHEFE DE SERVI�O DE BORDO");
				System.out.println("TENTE NOVAMENTE!");
				System.out.println("------------------------------------------------------------------------------------");
			} else {
				conseguiu = false;
			}
		
		}
		
		} while (conseguiu);
	}

}
