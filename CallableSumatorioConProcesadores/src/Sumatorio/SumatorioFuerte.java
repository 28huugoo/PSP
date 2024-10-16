/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sumatorio;

import java.util.ArrayList;
import java.util.concurrent.FutureTask;

/**
 *
 * @author FP
 */
public class SumatorioFuerte {

    public static void main(String[] args) {
        Long index1 = 1L;
        Long index2 = 100L;

        try {
            Runtime runtime = Runtime.getRuntime();
            int num_procesadores = runtime.availableProcessors();
            System.out.println("Dvidiendo la tarea " + num_procesadores + " hilos");

            Long incremento = ((index2 - index1) / (num_procesadores - 1));

            ArrayList<FutureTask<Long>> sumaFuerte = new ArrayList<FutureTask<Long>>();
            Thread VectorHilos[] = new Thread[num_procesadores];
            for (int i = 0; i < num_procesadores; i++) {
                long ini = index1 + incremento * i;
                long fin = index1 + incremento * (i + 1) - 1;
                if (fin > index2) {
                    fin = index2;
                }

                Suma sumaParcial = new Suma(ini, fin);
                sumaFuerte.add(new FutureTask<Long>(sumaParcial));

                VectorHilos[i] = new Thread(sumaFuerte.get(i));
                VectorHilos[i].setName("Hilo " + i);
                VectorHilos[i].start();

            }
            long ac = 0;
            for (int i = 0; i < num_procesadores; i++) {
                VectorHilos[i].join();
                ac = ac+sumaFuerte.get(i).get();
            }
            System.out.println("Suma total = "+ac);
            
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
