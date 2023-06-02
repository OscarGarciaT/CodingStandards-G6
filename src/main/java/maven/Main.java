// Copyright (C) 2020
// All rights reserved
package maven;
import java.util.regex.*;
import java.util.Scanner;

public class Main {
	/**
	    * @param args
	    */
	//CHECKSTYLE:OFF
	public static void main(String[] args) {
		
		//expresion regular para validar nombre de ciudades
		Pattern patternName = Pattern.compile("^[A-Za-z\\s-]+$");
		Pattern patternNumbers = Pattern.compile("^[0-9]+$");
		
		Matcher matcher = patternName.matcher("New York City");
		Matcher matcherNumber = patternNumbers.matcher("15");

		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese el destino: ");
		String destino = sc.nextLine();
		
		System.out.print("Ingrese la cantidad de pasajeros: ");
		String cantidadPasajeros = sc.nextLine();
		
		System.out.print("Ingrese la cantidad de dias: ");
		String cantidad = sc.nextLine();
		
		boolean verifyDestination = patternName.matcher(destino).find();
		boolean verifyNumberTravelers = patternNumbers.matcher(cantidadPasajeros).find();
		boolean verifyDays = patternNumbers.matcher(cantidad).find();
		
		if (verifyDestination && verifyNumberTravelers && verifyDays) {
			Vacation v = new Vacation(destino, Integer.parseInt(cantidadPasajeros), Integer.parseInt(cantidad));
			System.out.println(v.getTotalForTrip());
		} else {
			System.out.println(-1);
		}
		
		
		
		
	}
	//CHECKSTYLE:ON
}
