
package MetropolitanoConHilos;

import MetropolitanoSinHilos.*;

/**
 *Con hilos es mas eficiente
 * @author FP
 */
public class Principal {
    public static void main(String[] args) {
        //Creamos las listas
        ListaPaciente lista1= new ListaPaciente("pm1",new int[]{3,6,10,1,5});
        ListaPaciente lista2= new ListaPaciente("pm2",new int[]{7,2,1,10,4});
        
        //Cogemos el tiempo de referencia
        long inicio= System.currentTimeMillis();
        Enfermero enf1=new Enfermero("Valentino",lista1,inicio);
        Enfermero enf2=new Enfermero("Mark",lista1,inicio);
        
        //Empezamos a vacunar
        enf1.start();
        enf2.start();
    }
}
