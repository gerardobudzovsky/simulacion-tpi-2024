package main.java.tpi;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        ArrayList<Subsistema> subsistemas = new ArrayList<>();
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

        for (Subsistema subsistema : subsistemas) {
            System.out.println(subsistema);
        }

        //Subsistema subsistemaWithLowestTiempoDeProximaSalida = obtenerSubsistemaConMenorTiempoDeProximaSalida(subsistemas);
        //System.out.println("Subsistema with lowest tiempo de proxima salida: " + subsistemaWithLowestTiempoDeProximaSalida);

        ArrayList<Subsistema> updatedSubsistemas = actualizarSumatoriaDeTiempoDePermanencia(3, 1, 1, subsistemas);
        System.out.println("Updated subsistemas:");
        for (Subsistema subsistema : updatedSubsistemas) {
            System.out.println(subsistema);
        }
    }

    public static Subsistema obtenerSubsistemaConMenorTiempoDeProximaSalida(ArrayList<Subsistema> subsistemas) {
        Subsistema subsistemaConMenorTiempoDeProximaSalida = null;

        for (Subsistema subsistema : subsistemas) {
            if (subsistemaConMenorTiempoDeProximaSalida == null || subsistema.getTiempoDeProximaSalida() < subsistemaConMenorTiempoDeProximaSalida.getTiempoDeProximaSalida()) {
                subsistemaConMenorTiempoDeProximaSalida = subsistema;
            }
        }

        return subsistemaConMenorTiempoDeProximaSalida;
    }

    public static ArrayList<Subsistema> actualizarSumatoriaDeTiempoDePermanencia(Integer tpll, Integer t, Integer ns, ArrayList<Subsistema> subsistemas) {
        for (Subsistema subsistema : subsistemas) {
            Integer sumatoriaDeTiempoDePermanenciaActual = subsistema.getSumatoriaDeTiempoDePermanencia();
            subsistema.setSumatoriaDeTiempoDePermanencia(sumatoriaDeTiempoDePermanenciaActual + ((tpll - t) * ns));
        }
        return subsistemas;
    }

}
