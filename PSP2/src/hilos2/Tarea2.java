/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilos2;

/**
 *
 * @author FP
 */
public class Tarea2 extends Thread {

    @Override
    public void run() {
        for (int i = 20; i < 30; i++) {
            System.out.println("Soy el hilo " + i + " no valgo pa na");
        }
    }
}
