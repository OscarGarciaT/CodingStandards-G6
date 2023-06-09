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
		Pattern patternName = Pattern.compile("^[A-Za-z\\s-]+$");
		Pattern patternNumbers = Pattern.compile("^[0-9]+$");

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
			int pasajeros = Integer.parseInt(cantidadPasajeros);
			int dias = Integer.parseInt(cantidad);
			Vacation v = new Vacation(destino, pasajeros, dias);
			AddOns.showAddOns();
			
			System.out.print("Desea agregar un adicional? SI/NO ");
			String respuesta = sc.nextLine();
			while (respuesta.equals("SI")) {
				System.out.print("Escriba el numero de opcion:");
				int option = Integer.parseInt(sc.nextLine());
				System.out.println("Valor adicional: "+v.sumAddOn(option));
				System.out.print("Desea agregar un adicional? SI/NO ");
				respuesta = sc.nextLine();
				System.out.println();
			}
			
			sc.close();
			
			System.out.println(v.getTotalForTrip());
		} else {
			System.out.println(-1);
		}
	}
	//CHECKSTYLE:ON
}
