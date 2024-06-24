package main.java.tpi;

import java.util.ArrayList;
import java.util.List;

public class SimuladorControlador {
	
	private SimuladorServicio simuladorServicio;
	private List<Logueo> logueos;
	private final String SALTO_DE_LINEA = "\n";
	private Logueo logueoInicial;
	private Logueo logueoFinal;
	private Integer cantidadDeSubsistemas;
	private List<Subsistema> subsistemas;
	private Integer tiempoDeSimulacion;
	private Integer tiempo;
	private Integer tpll;
	
	public SimuladorControlador() {
		super();
		this.simuladorServicio = new SimuladorServicio();
		this.logueos = new ArrayList<Logueo>();
		this.cantidadDeSubsistemas = 5;
		this.subsistemas = new ArrayList<Subsistema>();
		for (int i = 0; i < this.cantidadDeSubsistemas; i++) {
			Subsistema subsistema = new Subsistema();
			subsistema.setIdentificador(i + 1);
			subsistema.setCantidadDePersonasQuePasaron(0);
			subsistema.setCantidadDePersonas(0);
			subsistema.setTiempoDeProximaSalida(Integer.MAX_VALUE);
			subsistema.setSumatoriaDeTiempoDePermanencia(0);
			subsistema.setSumatoriaDeTiempoDeAtencion(0);
			subsistema.setSumatoriaDeTiempoOcioso(0);
			subsistema.setComienzoDeTiempoOcioso(0);
			subsistema.setPromedioDePermanencia(0F);
			subsistema.setPromedioDeTiempoDeAtencion(0F);
			subsistema.setPromedioDeEsperaEnCola(0F);
			subsistema.setPorcentajeDeTiempoOcioso(0F);
			subsistemas.add(subsistema);			
		}
		this.tiempoDeSimulacion = 20;
		this.tiempo = 0;
		this.tpll= 0;
		
		
	}
	
	public void ejecutar() {

		this.logueoInicial = this.simuladorServicio.generarLogueoInicial();
		

		
		
		do {
			
			
			Logueo logueo = new Logueo(this.tiempo,"");
			
			logueo.setTexto(logueo.getTexto().concat("INSTANTE " + this.tiempo) + SALTO_DE_LINEA );
			
			for (Subsistema subsistema : subsistemas) {
				logueo.setTexto(logueo.getTexto().concat("Subsistema: " + subsistema.getIdentificador() + SALTO_DE_LINEA ));
			}
			
			
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
