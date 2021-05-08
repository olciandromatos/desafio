package politicas;

import java.util.ArrayList;
import java.util.List;

import tripulacaotecnica.Oficial_1;
import tripulacaotecnica.Oficial_2;

public class Aviao {
	
	private List<String> tripulates = new ArrayList<String>();
	private Integer CHEFE_DE_SERVIÇO_DE_BORDO = null;

	public List<String> getTripulates() {
		return tripulates;
	}

	public void adicionarTripulantesNoAviao(String tripulate) {
		this.tripulates.add(tripulate);
	}
	
	public Boolean verificarTripulantes(Boolean conseguiu, Oficial_1 oficial_1, Oficial_2 oficial_2,
			List<String> AVIAO) {
		if(AVIAO.contains(oficial_1.getProfissao()) || AVIAO.contains(oficial_2.getProfissao())) {
			System.out.println("NENHUM DOS OFICIAIS PODEM FICAR SOZINHO COM O CHEFE DE SERVIÇO DE BORDO");
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("NÃO DEU CERTO, TENTE NOVAMENTE!");
		} else {
			conseguiu = false;
		}
		return conseguiu;
	}

}
