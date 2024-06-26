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
	private Integer tiempoActual;
	private Integer tiempoDeProximaLlegada;
	
	public SimuladorControlador() {
		super();
		this.simuladorServicio = new SimuladorServicio();
		this.logueos = new ArrayList<Logueo>();
		this.subsistemas = new ArrayList<Subsistema>();
		this.tiempoActual = 0;
		this.tiempoDeProximaLlegada= 0;
		
		
	}
	
	public void ejecutar(Integer cantidadDeSubsistemas, Integer tiempoDeSimulacion) {
		
		this.tiempoDeSimulacion = tiempoDeSimulacion;
		this.cantidadDeSubsistemas = cantidadDeSubsistemas;
		this.subsistemas = this.simuladorServicio.inicializarSubsistemas(cantidadDeSubsistemas);
		System.out.println("");
		System.out.println("Ejecutando simulador con " + cantidadDeSubsistemas + " agentes y una duracion de " + tiempoDeSimulacion + " segundos.");
		//this.logueoInicial = this.simuladorServicio.generarLogueoInicial();
		System.out.println("Estado Inicial de los subsistemas");
		this.simuladorServicio.imprimirSubsistemas(this.subsistemas);
		System.out.println("");
		
				
		do {
			
			Logueo logueo = new Logueo(this.tiempoActual,"");
			logueo.setTexto(logueo.getTexto().concat("INSTANTE " + this.tiempoActual + SALTO_DE_LINEA));
			//System.out.println("INSTANTE " + this.tiempoActual + SALTO_DE_LINEA);
			
			Subsistema subsistemaConMenorTiempoDeProximaSalida = this.simuladorServicio.obtenerSubsistemaConMenorTiempoDeProximaSalida(this.subsistemas);
			//System.out.println("Subsistema con menor tiempo de proxima salida: " + subsistemaConMenorTiempoDeProximaSalida);
			
			if (this.tiempoDeProximaLlegada <= subsistemaConMenorTiempoDeProximaSalida.getTiempoDeProximaSalida()) {
				//System.out.println("RAMA de Llegadas " + SALTO_DE_LINEA);
				
				this.subsistemas = this.simuladorServicio.actualizarSumatoriaDeTiempoDePermanencia(this.subsistemas, this.tiempoDeProximaLlegada, this.tiempoActual);
				//System.out.println("Subsistemas con STP actualizado" + SALTO_DE_LINEA);
				//this.simuladorServicio.imprimirSubsistemas(this.subsistemas);
				
				this.tiempoActual= this.tiempoDeProximaLlegada;
				Integer intervaloEntreArribos= this.simuladorServicio.obtenerIntervaloEntreArribos();
				//System.out.println("Intervalo entre arribos: " + intervaloEntreArribos + SALTO_DE_LINEA);
				
				this.tiempoDeProximaLlegada = this.tiempoDeProximaLlegada + intervaloEntreArribos;
				
				Subsistema subsistemaConMenorCantidadDePersonas = this.simuladorServicio.obtenerSubsistemaConMenorCantidadDePersonas(this.subsistemas);
				//System.out.println("Subsistema con menor cantidad de personas: " + subsistemaConMenorCantidadDePersonas+ SALTO_DE_LINEA);
				
				subsistemaConMenorCantidadDePersonas.setCantidadDePersonas(subsistemaConMenorCantidadDePersonas.getCantidadDePersonas() + 1);
				subsistemaConMenorCantidadDePersonas.setCantidadDePersonasQuePasaron(subsistemaConMenorCantidadDePersonas.getCantidadDePersonasQuePasaron() + 1);
				//System.out.println("Subsistema con menor cantidad de personas con NS y N actualizado: " + subsistemaConMenorCantidadDePersonas + SALTO_DE_LINEA);
				

				if (subsistemaConMenorCantidadDePersonas.getCantidadDePersonas() == 1) {
					Integer tiempoDeAtencion = this.simuladorServicio.obtenerTiempoDeAtencion();
					//System.out.println("Tiempo de Atencion: " + tiempoDeAtencion + SALTO_DE_LINEA);
					subsistemaConMenorCantidadDePersonas.setTiempoDeProximaSalida(this.tiempoActual + tiempoDeAtencion);
					subsistemaConMenorCantidadDePersonas.setSumatoriaDeTiempoDeAtencion(subsistemaConMenorCantidadDePersonas.getSumatoriaDeTiempoDeAtencion() + tiempoDeAtencion);
					subsistemaConMenorCantidadDePersonas.setSumatoriaDeTiempoOcioso(subsistemaConMenorCantidadDePersonas.getSumatoriaDeTiempoOcioso() + (this.tiempoActual - subsistemaConMenorCantidadDePersonas.getComienzoDeTiempoOcioso()));
				}
				
				//System.out.println("Subsistema con menor cantidad de personas con TPS, STA y STO actualizados: " + subsistemaConMenorCantidadDePersonas + SALTO_DE_LINEA);
				//System.out.println();
				
			} else {
				//System.out.println("RAMA de Salidas " + SALTO_DE_LINEA);
				
				this.subsistemas = this.simuladorServicio.actualizarSumatoriaDeTiempoDePermanencia(this.subsistemas, subsistemaConMenorTiempoDeProximaSalida.getTiempoDeProximaSalida(), this.tiempoActual);
				//System.out.println("Subsistemas con STP actualizado");
				//this.simuladorServicio.imprimirSubsistemas(this.subsistemas);
				
				
				this.tiempoActual= subsistemaConMenorTiempoDeProximaSalida.getTiempoDeProximaSalida();
				
				subsistemaConMenorTiempoDeProximaSalida.setCantidadDePersonas(subsistemaConMenorTiempoDeProximaSalida.getCantidadDePersonas() - 1);
				
				if (subsistemaConMenorTiempoDeProximaSalida.getCantidadDePersonas() >= 1) {
					Integer tiempoDeAtencion = this.simuladorServicio.obtenerTiempoDeAtencion();
					subsistemaConMenorTiempoDeProximaSalida.setTiempoDeProximaSalida(this.tiempoActual + tiempoDeAtencion);
					subsistemaConMenorTiempoDeProximaSalida.setSumatoriaDeTiempoDeAtencion(subsistemaConMenorTiempoDeProximaSalida.getSumatoriaDeTiempoDeAtencion() + tiempoDeAtencion);					
				} else {
					subsistemaConMenorTiempoDeProximaSalida.setComienzoDeTiempoOcioso(this.tiempoActual);
					subsistemaConMenorTiempoDeProximaSalida.setTiempoDeProximaSalida(Integer.MAX_VALUE);
				}		
				
			}
						
			this.logueos.add(logueo);
			
		} while(this.tiempoActual <= this.tiempoDeSimulacion);
		
		System.out.println("Estado Final de los subsistemas");
		this.simuladorServicio.imprimirSubsistemas(this.subsistemas);
		
		this.logueoFinal = this.simuladorServicio.generarLogueoFinal(this.tiempoActual, this.subsistemas);
		
	}
		
	public SimuladorServicio getSimuladorServicio() {
		return simuladorServicio;
	}

	public void setSimuladorServicio(SimuladorServicio simuladorServicio) {
		this.simuladorServicio = simuladorServicio;
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
