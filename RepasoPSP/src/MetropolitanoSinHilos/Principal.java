
package MetropolitanoSinHilos;

/**
 *
 * @author FP
 */
public class Principal {
    public static void main(String[] args) {
        //Creamos las listas
        ListaPaciente lista1= new ListaPaciente("pm1",new int[]{3,6,10,1,5});
        ListaPaciente lista2= new ListaPaciente("pm2",new int[]{7,2,1,10,4});
        
        Enfermero enf1=new Enfermero("Valentino");
        Enfermero enf2=new Enfermero("Mark");
        
        //Cogemos el tiempo de referencia
        long inicio= System.currentTimeMillis();
        
        //Empezamos a vacunar
        enf1.vacunar(lista1, inicio);
        enf2.vacunar(lista2, inicio);
    }
    
}
