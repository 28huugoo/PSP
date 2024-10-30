/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examenpsphugo1;

/**
 *
 * @author FP
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creamos las listas
        ListaPedido pedido1 = new ListaPedido("pedido1", new int[]{3, 6, 10, 1, 5});
        ListaPedido pedido2 = new ListaPedido("pedido2", new int[]{7, 2, 1, 10, 4});
        ListaPedido pedido3 = new ListaPedido("pedido3", new int[]{2, 2, 1, 7, 3});
        ListaPedido pedido4 = new ListaPedido("pedido4", new int[]{12, 2, 1, 1, 5});

        
            ListaPedido[] agrup1 = new ListaPedido[]{pedido1, pedido2};
        //Cogemos el tiempo de referencia
        long inicio = System.currentTimeMillis();

        Repartidor rep1 = new Repartidor("Don Damian", agrup1, inicio);
        Repartidor rep2 = new Repartidor("Gonzalo", pedido1, inicio);

        System.out.println("(COMIENZO DE EL APARTADO A)");
        System.out.println("");
        System.out.println("=============================");

        rep1.start();
        rep2.start();
        rep1.setLista(pedido2);
        rep2.setLista(pedido2);
        rep1.resume();
        rep2.resume();
        rep1.setLista(pedido3);
        rep2.setLista(pedido3);
        rep1.resume();
        rep2.resume();
        rep1.setLista(pedido4);
        rep2.setLista(pedido4);

        rep1.start();
        rep2.start();
        //Empezamos a repartir
    }

}
