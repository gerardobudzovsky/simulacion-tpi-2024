package main.java.tpi;

public class SimuladorServicio {
	
	private final String SALTO_DE_LINEA = "\n";
	
	public Logueo generarLogueoInicial() {
		Logueo logueoInicial = new Logueo(0, "");
		logueoInicial.setTexto("Logueo Inicial " + SALTO_DE_LINEA);
		logueoInicial.setTexto(logueoInicial.getTexto().concat("____________________________________________________________________________________________" + SALTO_DE_LINEA));
		logueoInicial.setTexto(logueoInicial.getTexto().concat(SALTO_DE_LINEA) );
		return logueoInicial;
	}
	
	public Logueo generarLogueoFinal(Integer tiempoFinal) {
		Logueo logueoFinal = new Logueo(tiempoFinal, "");
		logueoFinal.setTexto(logueoFinal.getTexto().concat("____________________________________________________________________________________________" + SALTO_DE_LINEA));
		logueoFinal.setTexto(logueoFinal.getTexto().concat("Logueo Final " + SALTO_DE_LINEA));
		return logueoFinal;
	}
}
