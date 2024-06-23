package main.java.tpi;

public class SimuladorServicio {
	
	private final String SALTO_DE_LINEA = "\n";
	
	public Logueo obtenerLogueoInicial() {
		
		Logueo logueoInicial = new Logueo(0, "Logueo Inicial Instante 0" + SALTO_DE_LINEA);
		
		return logueoInicial;
		
	}
}
