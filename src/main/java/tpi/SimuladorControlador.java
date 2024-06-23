package main.java.tpi;

import java.util.ArrayList;
import java.util.List;

public class SimuladorControlador {
	
	private SimuladorServicio simuladorServicio;
	private List<Logueo> logueos;
	
	public SimuladorControlador() {
		super();
		this.simuladorServicio = new SimuladorServicio();
		this.logueos = new ArrayList<Logueo>();
	}
	
	public void ejecutar() {
		this.logueos.add(this.simuladorServicio.obtenerLogueoInicial());
		this.logueos.add(new Logueo(1, "Logueo Instante 1"));
		
	}
		
	public List<Logueo> getLogueos() {
		return logueos;
	}
	
	public void setLogueos(List<Logueo> logueos) {
		this.logueos = logueos;
	}
}
