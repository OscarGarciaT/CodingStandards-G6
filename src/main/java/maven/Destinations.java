package maven;

import java.util.ArrayList;
import java.util.Arrays;

public class Destinations {
	public static ArrayList<String> globalDestinationNames = new ArrayList<String>(Arrays.asList("New York City", "Paris"));
	public static ArrayList<Float> globalDestinationPrice = new ArrayList<Float>(Arrays.asList(600f,500f));
	
	public static float getAddPriceDestination(String destination) {
		for(int i = 0; i < globalDestinationNames.size(); i++) {
			
			//se compara si las ciudades son iguales
			if(globalDestinationNames.get(i).equals(destination)) {
				return globalDestinationPrice.get(i);
			}
		}
		
		return 0f;
	}
}
