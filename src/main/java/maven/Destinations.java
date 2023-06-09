// Copyright (C) 2020
// All rights reserved
package maven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Destinations {
	
	private Destinations() {} // Fixed

	// Fixed
	private static List<String> globalDestNames = new ArrayList<String>(Arrays.asList("New York City", "Paris"));

	// Fixed
	private static List<Float> globalDestPrice = new ArrayList<Float>(Arrays.asList(600f, 500f));
	/**
	    * @param destination
	    * @return float
	    */
	// Fixed
	public static float getAddPriceDestination(final String destination) {
		float price = 0f;
		for (int i = 0; i < globalDestNames.size(); i++) {
			//se compara si las ciudades son iguales
			if (globalDestNames.get(i).equals(destination)) {
				price = globalDestPrice.get(i);
				break;
			}
		}
		return price;
	}
}
