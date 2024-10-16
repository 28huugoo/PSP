/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package executorservice;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author FP
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Set<Callable<String>> callables = new HashSet<Callable<String>>();
        //Añado cada uno de los objetos a la cola
        //Cada uno con su operación
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Tarea 1";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Tarea 2";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Tarea 3";
            }
        });
        //Declaro la lista de objetos future
        //y utilizo el método para llamar a todos
        java.util.List<Future<String>> futures
                = executorService.invokeAll(callables);

        //recojo las soluciones de cada uno de los objetos Future
        for (Future<String> future : futures) {
            System.out.println("future.get=" + future.get());
        }
        //Hay que terminar el proceso
        executorService.shutdown();
    }

}
