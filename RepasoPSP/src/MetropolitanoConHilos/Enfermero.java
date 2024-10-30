
package MetropolitanoConHilos;

import MetropolitanoSinHilos.*;

/**
 *
 * @author FP
 */
public class Enfermero extends Thread{
    private String nombre;
    private ListaPaciente lista;
    private long inicio;

    public Enfermero(String nombre, MetropolitanoConHilos.ListaPaciente lista, long inicio) {
        this.nombre = nombre;
        this.lista = lista;
        this.inicio = inicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public MetropolitanoConHilos.ListaPaciente getLista() {
        return lista;
    }

    public void setLista(MetropolitanoConHilos.ListaPaciente lista) {
        this.lista = lista;
    }

    public long getInicio() {
        return inicio;
    }

    public void setInicio(long inicio) {
        this.inicio = inicio;
    }

    
    private void tiempoVacunacion(int segundos){
        try{
        Thread.sleep(segundos*1000);
        }catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }
    public void run(){
        System.out.println("El enfermero "+this.nombre+" comienza a vacunar al cliente "
        +lista.getNombre()+" En el tiempo: "+(System.currentTimeMillis()-inicio)/1000+ " seg");
        for(int i=0; i<lista.getTiempoPacientes().length;i++){
            this.tiempoVacunacion(lista.getTiempoPacientes()[i]);
            System.out.println("Vacunando al paciente "+(i+1)+" ->Tiempo: "
                    +(System.currentTimeMillis()-inicio)/1000+"seg");
        }
        System.out.println("El enfermero "+this.nombre+"ha terminado de vacunar"
                +lista.getNombre()+" En el tiempo: "
                +(System.currentTimeMillis()-inicio)/1000+"seg");
    }
}
