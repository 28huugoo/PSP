/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hilos2;

/**
 *
 * @author FP
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        Tarea tarea = new Tarea();
        Tarea2 tarea2 = new Tarea2();        
        System.out.println("Soy el hilo principal y sigo currando");

        tarea.start();
        tarea.join();
        tarea2.start();
        tarea2.join();
        System.out.println("FINNNN");
    }

}
