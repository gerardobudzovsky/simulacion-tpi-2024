package main.java.tpi;

public class Logueo {
	
	private Integer instante;
	private String texto;
	
	public Logueo() {
		super();
	}

	public Logueo(Integer instante, String texto) {
		super();
		this.instante = instante;
		this.texto = texto;
	}

	public Integer getInstante() {
		return instante;
	}

	public void setInstante(Integer instante) {
		this.instante = instante;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}
