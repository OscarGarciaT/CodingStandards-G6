// Copyright (C) 2020
// All rights reserved
package maven;

import java.util.ArrayList;
import java.util.Arrays;

public class Destinations {

	private static ArrayList<String> globalDestinationNames = new ArrayList<String>(Arrays.asList("New York City", "Paris"));

	private static ArrayList<Float> globalDestinationPrice = new ArrayList<Float>(Arrays.asList(600f, 500f));
	/**
	    * @param destination
	    * @return float
	    */
	public static float getAddPriceDestination(final String destination) {
		for (int i = 0; i < globalDestinationNames.size(); i++) {
			//se compara si las ciudades son iguales
			if (globalDestinationNames.get(i).equals(destination)) {
				return globalDestinationPrice.get(i);
			}
		}
		return 0f;
	}
}
