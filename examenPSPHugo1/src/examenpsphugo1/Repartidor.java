/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenpsphugo1;

/**
 *
 * @author FP
 */
public class Repartidor extends Thread {

    private String nombre;
    private ListaPedido lista;
    private long inicio;

    public Repartidor(String nombre, ListaPedido[] lista, long inicio) {
        this.nombre = nombre;
        this.lista = lista;
        this.inicio = inicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaPedido getLista() {
        return lista;
    }

    public void setLista(ListaPedido lista) {
        this.lista = lista;
    }

    public long getInicio() {
        return inicio;
    }

    public void setInicio(long inicio) {
        this.inicio = inicio;
    }

    private void tiempoPedido(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void run() {
        System.out.println("El repartidor " + this.nombre + " comienza a repartir el pedido "
                + lista.getNombrePedido1() + " En el tiempo: " + (System.currentTimeMillis() - inicio) / 1000 + " seg");
        for (int i = 0; i < lista.getTiempoPedidos().length; i++) {
            this.tiempoPedido(lista.getTiempoPedidos()[i]);
            System.out.println("Repartiendo el pedido " + (i + 1) + " ->Tiempo: "
                    + (System.currentTimeMillis() - inicio) / 1000 + "seg");
        }
        System.out.println("El repartidor " + this.nombre + " ha terminado de repartir el "
                + lista.getNombrePedido1() + " En el tiempo: "
                + (System.currentTimeMillis() - inicio) / 1000 + "seg");

        //
        //
        //
        /*
        System.out.println("El repartidor " + this.nombre + " comienza a repartir el pedido "
                + lista.getNombrePedido1() + " En el tiempo: " + (System.currentTimeMillis() - inicio) / 1000 + " seg");
        for (int i = 0; i < lista.getTiempoPedidos().length; i++) {
            this.tiempoPedido(lista.getTiempoPedidos()[i]);
            System.out.println("Repartiendo el pedido " + (i + 1) + " ->Tiempo: "
                    + (System.currentTimeMillis() - inicio) / 1000 + "seg");
        }
        System.out.println("El repartidor " + this.nombre + " ha terminado de repartir el "
                + lista.getNombrePedido1() + " En el tiempo: "
                + (System.currentTimeMillis() - inicio) / 1000 + "seg");
        //
        //
        //
        System.out.println("El repartidor " + this.nombre + " comienza a repartir el pedido "
                + lista.getNombrePedido1() + " En el tiempo: " + (System.currentTimeMillis() - inicio) / 1000 + " seg");
        for (int i = 0; i < lista.getTiempoPedidos().length; i++) {
            this.tiempoPedido(lista.getTiempoPedidos()[i]);
            System.out.println("Repartiendo el pedido " + (i + 1) + " ->Tiempo: "
                    + (System.currentTimeMillis() - inicio) / 1000 + "seg");
        }
        System.out.println("El repartidor " + this.nombre + " ha terminado de repartir el "
                + lista.getNombrePedido1() + " En el tiempo: "
                + (System.currentTimeMillis() - inicio) / 1000 + "seg");
        //
        //*/
    }
}
