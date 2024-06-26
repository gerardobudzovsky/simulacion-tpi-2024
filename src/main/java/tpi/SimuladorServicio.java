package main.java.tpi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimuladorServicio {
	
	private final String SALTO_DE_LINEA = "\n";
	
	public Logueo generarLogueoInicial() {
		Logueo logueoInicial = new Logueo(0, "");
		//logueoInicial.setTexto("Logueo Inicial " + SALTO_DE_LINEA);
		//System.out.println("Logueo Inicial " + SALTO_DE_LINEA);
		logueoInicial.setTexto(logueoInicial.getTexto().concat("____________________________________________________________________________________________" + SALTO_DE_LINEA));
		//System.out.println("____________________________________________________________________________________________" + SALTO_DE_LINEA);
		logueoInicial.setTexto(logueoInicial.getTexto().concat(SALTO_DE_LINEA));
		System.out.println(SALTO_DE_LINEA);
		return logueoInicial;
	}
	
	public Logueo generarLogueoFinal(Integer tiempoFinal, List<Subsistema> subsistemas) {
		Logueo logueoFinal = new Logueo(tiempoFinal, "");
		logueoFinal.setTexto(logueoFinal.getTexto().concat("____________________________________________________________________________________________" + SALTO_DE_LINEA));
		System.out.println("____________________________________________________________________________________________" + SALTO_DE_LINEA);
		logueoFinal.setTexto(logueoFinal.getTexto().concat("Logueo Final " + SALTO_DE_LINEA));
		//System.out.println("Logueo Final " + SALTO_DE_LINEA);
		
		List<Float> promediosTE = new ArrayList<Float>();
		for (Subsistema subsistema : subsistemas) {
			Float PTEi = (subsistema.getSumatoriaDeTiempoDePermanencia().floatValue() - subsistema.getSumatoriaDeTiempoDeAtencion().floatValue())/subsistema.getCantidadDePersonasQuePasaron().floatValue();
			PTEi = Math.max(0, PTEi);
			promediosTE.add(PTEi);
			System.out.println("El promedio de tiempo de espera para el Subsistema " + subsistema.getIdentificador() + " es: " + PTEi + this.SALTO_DE_LINEA);
			
		}
		
		float suma = 0.0f;
		for (Float PTEi : promediosTE) {
		    suma += PTEi;
		}	
		Float tiempoDeEsperaPromedio = suma / promediosTE.size();
		System.out.println("El tiempo de espera promedio de la simulación es: " + tiempoDeEsperaPromedio);
		
		
		return logueoFinal;
	}
	
	public void imprimirSubsistemas(List<Subsistema> subsistemas) {
      for (Subsistema subsistema : subsistemas) {
    	  System.out.println(subsistema);
      }
      System.out.println();
	}
	
	public List<Subsistema> inicializarSubsistemas(Integer cantidadDeSubsistemas){
		List<Subsistema> subsistemas= new ArrayList<Subsistema>();
		
		for (int i = 0; i < cantidadDeSubsistemas; i++) {
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
		
		return subsistemas;
		
	}
	
	public List<Subsistema> inicializarSubsistemasConDatosDePrueba(Integer cantidadDeSubsistemas){
		 
		List<Subsistema> subsistemas = new ArrayList<>();
	    Random random = new Random();

	     for (int i = 0; i < 5; i++) {
		     Subsistema subsistema = new Subsistema();
		     subsistema.setIdentificador(i);
		     subsistema.setCantidadDePersonasQuePasaron(random.nextInt(100));
		     subsistema.setCantidadDePersonas(random.nextInt(100));
		     subsistema.setTiempoDeProximaSalida(random.nextInt(100));
		     subsistema.setSumatoriaDeTiempoDePermanencia(random.nextInt(100));
		     subsistema.setSumatoriaDeTiempoDeAtencion(random.nextInt(100));
		     subsistema.setSumatoriaDeTiempoOcioso(random.nextInt(100));
		     subsistema.setComienzoDeTiempoOcioso(random.nextInt(100));
		     subsistema.setPromedioDePermanencia(random.nextFloat());
		     subsistema.setPromedioDeEsperaEnCola(random.nextFloat());
		     subsistema.setPromedioDeTiempoDeAtencion(random.nextFloat());
		     subsistema.setPorcentajeDeTiempoOcioso(random.nextFloat());
		     subsistemas.add(subsistema);
	     }
		
		return subsistemas;
		
	}
	
    public Subsistema obtenerSubsistemaConMenorTiempoDeProximaSalida(List<Subsistema> subsistemas) {
        Subsistema subsistemaConMenorTiempoDeProximaSalida = null;

        for (Subsistema subsistema : subsistemas) {
            if (subsistemaConMenorTiempoDeProximaSalida == null || subsistema.getTiempoDeProximaSalida() < subsistemaConMenorTiempoDeProximaSalida.getTiempoDeProximaSalida()) {
                subsistemaConMenorTiempoDeProximaSalida = subsistema;
            }
        }

        return subsistemaConMenorTiempoDeProximaSalida;
    }
    
    public List<Subsistema> actualizarSumatoriaDeTiempoDePermanencia(List<Subsistema> subsistemas, Integer tpllOTps, Integer t) {
        for (Subsistema subsistema : subsistemas) {
            Integer sumatoriaDeTiempoDePermanenciaEnSistemaActual = subsistema.getSumatoriaDeTiempoDePermanencia();
            Integer cantidadDePersonasEnSistemaActual = subsistema.getCantidadDePersonas();
            Integer diferencia= tpllOTps - t;
            subsistema.setSumatoriaDeTiempoDePermanencia(sumatoriaDeTiempoDePermanenciaEnSistemaActual + (diferencia*cantidadDePersonasEnSistemaActual));
        }
        return subsistemas;
    }
    
    public Integer obtenerIntervaloEntreArribos() {

        Random random = new Random();
        double mean = 29;
        double sd = 3;//0;
        
        int randomVariable = (int) (mean + sd * random.nextGaussian());
        return Math.max(0, randomVariable);
//    	  return 29;
    }

    public Integer obtenerTiempoDeAtencion() {
    	
        Random random = new Random();
        double mean = 353;
        double sd = 30;//1;
        int randomVariable = (int) (mean + sd * random.nextGaussian());
        return Math.max(0, randomVariable);
//    	return 353;
    }
    
    public Subsistema obtenerSubsistemaConMenorCantidadDePersonas(List<Subsistema> subsistemas) {
        Subsistema subsistemaConMenorCantidadDePersonas = null;

        for (Subsistema subsistema : subsistemas) {
            if (subsistemaConMenorCantidadDePersonas == null || subsistema.getCantidadDePersonas() < subsistemaConMenorCantidadDePersonas.getCantidadDePersonas()) {
                subsistemaConMenorCantidadDePersonas = subsistema;
            }
        }

        return subsistemaConMenorCantidadDePersonas;
    }
	
}
