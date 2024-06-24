package main.java.tpi;

public class Subsistema {
	
	private Integer identificador;
	private Integer cantidadDePersonasQuePasaron;
	private Integer cantidadDePersonas;
	private Integer tiempoDeProximaSalida;
	private Integer sumatoriaDeTiempoDePermanencia;
	private Integer sumatoriaDeTiempoDeAtencion;
	private Integer sumatoriaDeTiempoOcioso;
	private Integer comienzoDeTiempoOcioso;
	private Float promedioDePermanencia;
	private Float promedioDeEsperaEnCola;
	private Float promedioDeTiempoDeAtencion;
	private Float porcentajeDeTiempoOcioso;
	
	
	
	public Subsistema() {
		super();
	}

	public Subsistema(Integer identificador, Integer cantidadDePersonasQuePasaron, Integer cantidadDePersonas,
			Integer tiempoDeProximaSalida, Integer sumatoriaDeTiempoDePermanencia, Integer sumatoriaDeTiempoDeAtencion,
			Integer sumatoriaDeTiempoOcioso, Integer comienzoDeTiempoOcioso, Float promedioDePermanencia,
			Float promedioDeEsperaEnCola, Float promedioDeTiempoDeAtencion, Float porcentajeDeTiempoOcioso) {
		super();
		this.identificador = identificador;
		this.cantidadDePersonasQuePasaron = cantidadDePersonasQuePasaron;
		this.cantidadDePersonas = cantidadDePersonas;
		this.tiempoDeProximaSalida = tiempoDeProximaSalida;
		this.sumatoriaDeTiempoDePermanencia = sumatoriaDeTiempoDePermanencia;
		this.sumatoriaDeTiempoDeAtencion = sumatoriaDeTiempoDeAtencion;
		this.sumatoriaDeTiempoOcioso = sumatoriaDeTiempoOcioso;
		this.comienzoDeTiempoOcioso = comienzoDeTiempoOcioso;
		this.promedioDePermanencia = promedioDePermanencia;
		this.promedioDeEsperaEnCola = promedioDeEsperaEnCola;
		this.promedioDeTiempoDeAtencion = promedioDeTiempoDeAtencion;
		this.porcentajeDeTiempoOcioso = porcentajeDeTiempoOcioso;
	}

	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public Integer getCantidadDePersonasQuePasaron() {
		return cantidadDePersonasQuePasaron;
	}

	public void setCantidadDePersonasQuePasaron(Integer cantidadDePersonasQuePasaron) {
		this.cantidadDePersonasQuePasaron = cantidadDePersonasQuePasaron;
	}

	public Integer getCantidadDePersonas() {
		return cantidadDePersonas;
	}

	public void setCantidadDePersonas(Integer cantidadDePersonas) {
		this.cantidadDePersonas = cantidadDePersonas;
	}

	public Integer getTiempoDeProximaSalida() {
		return tiempoDeProximaSalida;
	}

	public void setTiempoDeProximaSalida(Integer tiempoDeProximaSalida) {
		this.tiempoDeProximaSalida = tiempoDeProximaSalida;
	}

	public Integer getSumatoriaDeTiempoDePermanencia() {
		return sumatoriaDeTiempoDePermanencia;
	}

	public void setSumatoriaDeTiempoDePermanencia(Integer sumatoriaDeTiempoDePermanencia) {
		this.sumatoriaDeTiempoDePermanencia = sumatoriaDeTiempoDePermanencia;
	}

	public Integer getSumatoriaDeTiempoDeAtencion() {
		return sumatoriaDeTiempoDeAtencion;
	}

	public void setSumatoriaDeTiempoDeAtencion(Integer sumatoriaDeTiempoDeAtencion) {
		this.sumatoriaDeTiempoDeAtencion = sumatoriaDeTiempoDeAtencion;
	}

	public Integer getSumatoriaDeTiempoOcioso() {
		return sumatoriaDeTiempoOcioso;
	}

	public void setSumatoriaDeTiempoOcioso(Integer sumatoriaDeTiempoOcioso) {
		this.sumatoriaDeTiempoOcioso = sumatoriaDeTiempoOcioso;
	}

	public Integer getComienzoDeTiempoOcioso() {
		return comienzoDeTiempoOcioso;
	}

	public void setComienzoDeTiempoOcioso(Integer comienzoDeTiempoOcioso) {
		this.comienzoDeTiempoOcioso = comienzoDeTiempoOcioso;
	}

	public Float getPromedioDePermanencia() {
		return promedioDePermanencia;
	}

	public void setPromedioDePermanencia(Float promedioDePermanencia) {
		this.promedioDePermanencia = promedioDePermanencia;
	}

	public Float getPromedioDeEsperaEnCola() {
		return promedioDeEsperaEnCola;
	}

	public void setPromedioDeEsperaEnCola(Float promedioDeEsperaEnCola) {
		this.promedioDeEsperaEnCola = promedioDeEsperaEnCola;
	}

	public Float getPromedioDeTiempoDeAtencion() {
		return promedioDeTiempoDeAtencion;
	}

	public void setPromedioDeTiempoDeAtencion(Float promedioDeTiempoDeAtencion) {
		this.promedioDeTiempoDeAtencion = promedioDeTiempoDeAtencion;
	}

	public Float getPorcentajeDeTiempoOcioso() {
		return porcentajeDeTiempoOcioso;
	}

	public void setPorcentajeDeTiempoOcioso(Float porcentajeDeTiempoOcioso) {
		this.porcentajeDeTiempoOcioso = porcentajeDeTiempoOcioso;
	}

}
