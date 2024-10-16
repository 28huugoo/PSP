/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filosofos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author FP
 */
public class Principal {

    public static void main(String[] args) {
        final int numFilosofos = 5;
        Semaphore[] tenedores = new Semaphore[numFilosofos];
        Filosofos[] filosofos = new Filosofos[numFilosofos];

        for (int i = 0; i < numFilosofos; i++) {
            tenedores[i] = new Semaphore(1);
        }

        for (int i = 0; i < numFilosofos; i++) {
            Semaphore tenedorIzq = tenedores[i];
            Semaphore tenedorDer = tenedores[(i + 1) % numFilosofos];

            filosofos[i] = new Filosofos(tenedorIzq, tenedorDer, i);
            filosofos[i].start();
        }
    }
}
