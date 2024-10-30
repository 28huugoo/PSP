/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenpsphugo1;

/**
 *
 * @author FP
 */
public class ListaPedido {

    private String nombrePedido1;

    private int[] tiempoPedidos;

    public ListaPedido(String nombrePedido1, int[] tiempoPedidos) {
        this.nombrePedido1 = nombrePedido1;
    }

    public String getNombrePedido1() {
        return nombrePedido1;
    }

    public void setNombrePedido1(String nombrePedido1) {
        this.nombrePedido1 = nombrePedido1;
    }

    public int[] getTiempoPedidos() {
        return tiempoPedidos;
    }

    public void setTiempoPedidos(int[] tiempoPedidos) {
        this.tiempoPedidos = tiempoPedidos;
    }

}
