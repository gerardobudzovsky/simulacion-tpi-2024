package main.java.tpi;

import java.util.ArrayList;
import java.util.List;

public class SimuladorControlador {
	
	private SimuladorServicio simuladorServicio;
	private List<Logueo> logueos;
	private Integer tiempo;
	private Integer tiempoDeSimulacion;
	private final String SALTO_DE_LINEA = "\n";
	private Logueo logueoInicial;
	private Logueo logueoFinal;
	
	public SimuladorControlador() {
		super();
		this.simuladorServicio = new SimuladorServicio();
		this.logueos = new ArrayList<Logueo>();
		this.tiempo = 0;
		this.tiempoDeSimulacion = 20;
	}
	
	public void ejecutar() {

		this.logueoInicial = this.simuladorServicio.generarLogueoInicial();
		
		
		do {
			Logueo logueo = new Logueo(this.tiempo,"");
			
			logueo.setTexto(logueo.getTexto().concat("INSTANTE " + this.tiempo) + SALTO_DE_LINEA );
			
			
			this.logueos.add(logueo);
			this.tiempo++;
			
		} while(this.tiempo <= this.tiempoDeSimulacion);
		
		this.logueoFinal = this.simuladorServicio.generarLogueoFinal(this.tiempo);
		
	}
		
	public List<Logueo> getLogueos() {
		return logueos;
	}
	
	public void setLogueos(List<Logueo> logueos) {
		this.logueos = logueos;
	}
	
	public Logueo getLogueoInicial() {
		return logueoInicial;
	}
	
	public void setLogueoInicial(Logueo logueoInicial) {
		this.logueoInicial = logueoInicial;
	}
	
	public Logueo getLogueoFinal() {
		return logueoFinal;
	}
	
	public void setLogueoFinal(Logueo logueoFinal) {
		this.logueoFinal = logueoFinal;
	}
	
}
