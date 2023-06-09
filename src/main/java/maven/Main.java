// Copyright (C) 2020
// All rights reserved
package maven;
import java.util.regex.Pattern;
import java.util.Scanner;

public final class Main {
	//CHECKSTYLE:OFF
	private Main() { }
	/**
	    * @param args
	    */
	public static void main(final String[] args) {

		//expresion regular para validar nombre de ciudades
		final Pattern patternName = Pattern.compile("^[A-Za-z\\s-]+$");
		final Pattern patternNumbers = Pattern.compile("^[0-9]+$");

		final Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Ingrese el destino: ");
			final String destino = sc.nextLine();

			System.out.print("Ingrese la cantidad de pasajeros: ");
			final String cantidadPasajeros = sc.nextLine();

			System.out.print("Ingrese la cantidad de dias: ");
			final String cantidad = sc.nextLine();

			final boolean verifyDestination = patternName.matcher(destino).find();
			final boolean verifyNTravelers = patternNumbers.matcher(cantidadPasajeros).find();
			final boolean verifyDays = patternNumbers.matcher(cantidad).find();

			if (verifyDestination && verifyNTravelers && verifyDays) {
				final int pasajeros = Integer.parseInt(cantidadPasajeros);
				final int dias = Integer.parseInt(cantidad);
				final Vacation v = new Vacation(destino, pasajeros, dias);
				AddOns.showAddOns();
				
				System.out.print("Desea agregar un adicional? SI/NO ");
				String respuesta = sc.nextLine();
				while ("SI".equals(respuesta)) {
					System.out.print("Escriba el numero de opcion:");
					final int option = Integer.parseInt(sc.nextLine());
					System.out.println("Valor adicional: "+v.sumAddOn(option));
					System.out.print("Desea agregar un adicional? SI/NO ");
					respuesta = sc.nextLine();
					System.out.println();
				}
				System.out.println(v.getTotalForTrip());
			} else {
				System.out.println(-1);
			}
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		} finally {
			sc.close();
		}
	}
	
	
	//CHECKSTYLE:ON
}
