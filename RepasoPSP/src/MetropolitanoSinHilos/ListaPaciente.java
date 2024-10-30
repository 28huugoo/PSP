
package MetropolitanoSinHilos;

/**
 *
 * @author FP
 */
public class ListaPaciente {
    private String nombre;
    private int[] tiempoPacientes;

    public ListaPaciente(String nombre, int[] tiempoPacientes) {
        this.nombre = nombre;
        this.tiempoPacientes = tiempoPacientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int[] getTiempoPacientes() {
        return tiempoPacientes;
    }

    public void setTiempoPacientes(int[] tiempoPacientes) {
        this.tiempoPacientes = tiempoPacientes;
    }
    
}
