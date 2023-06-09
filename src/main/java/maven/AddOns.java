//Copyright (C) 2020
//All rights reserved
package maven;

import java.util.ArrayList;
import java.util.Arrays;

public class AddOns {

	private static ArrayList<String> globalAddOnNames = new ArrayList<String>(Arrays.asList("All-Inclusive Package", "Adventure Activities Package", "Spa and Wellness Package"));

	private static ArrayList<Float> globalAddOnPrice = new ArrayList<Float>(Arrays.asList(200f, 150f, 100f));
	
	public static float getAddOn(final int option) {
		globalAddOnNames.get(option-1);
		return globalAddOnPrice.get(option-1);
	}
	
	public static void showAddOns() {
		System.out.println("Opciones:");
		for (int i = 0; i < globalAddOnNames.size(); i++) {
			System.out.println((i+1)+"."+globalAddOnNames.get(i)+": "+globalAddOnPrice.get(i));
		}
	}
}