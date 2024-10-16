/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sincronizacion;

/**
 *
 * @author FP
 */
public class RecursoJardin extends Thread{

//clase que simula las entradas y las salidas al Jardin
    private int cuenta; //para contar las entradas y las salidas del jardín

    public RecursoJardin() {
        cuenta = 100;
    }

    public synchronized void  incrementaCuenta() {
        System.out.println("hilo " + Thread.currentThread().getName() + "----- Entra en Jardin");
        cuenta++;
        System.out.println(cuenta + " en jardin");
    }

    public synchronized void decrementaCuenta() {
        System.out.println("hilo " + Thread.currentThread().getName() + "----- Sale en Jardin");
        cuenta--;
        System.out.println(cuenta + " en jardin");
    }

}
