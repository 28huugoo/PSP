/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package filosofos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author FP
 */
public class Filosofos extends Thread {

    private Semaphore tenedorIzq, tenedorDer;
    private int id;

    public Filosofos(Semaphore tenedorIzq, Semaphore tenedorDer, int id) {
        this.tenedorIzq = tenedorIzq;
        this.tenedorDer = tenedorDer;
        this.id = id;
    }

    public void run() {
        try {
            while (true) {
                System.out.println("Filósofo " + id + " está pensando.");
                tenedorIzq.acquire();
                System.out.println("Filósofo " + id + " ha tomado el tenedor izquierdo");
                tenedorDer.acquire();
                System.out.println("Filósofo " + id + " ha tomado el tenedor derecho");
                System.out.println("Filósofo " + id + " está comiendo");
                tenedorIzq.release();
                System.out.println("Filósofo " + id + " ha soltado el tenedor izquierdo");
                tenedorDer.release();
                System.out.println("Filósofo " + id + " ha soltado el tenedor derecho");

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
