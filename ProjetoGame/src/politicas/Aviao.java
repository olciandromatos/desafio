package politicas;

import java.util.ArrayList;
import java.util.List;

public class Aviao {
	
	private List<String> tripulates = new ArrayList<String>();

	public List<String> getTripulates() {
		return tripulates;
	}

	public void adicionarTripulantesNoAviao(String tripulate) {
		this.tripulates.add(tripulate);
	}

}
