package main.java.tpi;

import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de agentes:");
        int cantidadDeAgentes = scanner.nextInt();

        System.out.println("Ingrese la duracion de la simulación en segundos:");
        int duracionDeLaSimulacion = scanner.nextInt();

    	SimuladorControlador simuladorControlador= new SimuladorControlador();
    	
    	simuladorControlador.ejecutar(cantidadDeAgentes,duracionDeLaSimulacion);

        
    }

}
