/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chattcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author FP
 */
public class ComunHilos {

    int CONEXIONES;
    int ACTUALES;
    int MAXIMO;
    Socket tabla[] = new Socket[MAXIMO];
    String mensajes;


    /*
    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket()) {

            System.out.println("HOLA CARACOLA");

        } catch (IOException ex) {

            System.out.println("ERROR TETE");

        }

    }*/
    public ComunHilos(int CONEXIONES, int ACTUALES, int MAXIMO, Socket[] tabla) {
        this.CONEXIONES = CONEXIONES;
        this.ACTUALES = ACTUALES;
        this.MAXIMO = MAXIMO;
        this.tabla = tabla;
        mensajes = "";
    }

    public int getMAXIMO() {
        return MAXIMO;
    }

    public void setMAXIMO(int MAXIMO) {
        this.MAXIMO = MAXIMO;
    }

    public int getCONEXIONES() {
        return CONEXIONES;
    }

    public int getACTUALES() {
        return ACTUALES;
    }

    public Socket getElementoTabla(int i) {
        return tabla[i];
    }

    public String getMensajes() {
        return mensajes;
    }

    public synchronized void setCONEXIONES(int CONEXIONES) {
        this.CONEXIONES = CONEXIONES;
    }

    public synchronized void setACTUALES(int ACTUALES) {
        this.ACTUALES = ACTUALES;
    }

    public synchronized void setMensajes(String mensajes) {
        this.mensajes = mensajes;
    }

    public synchronized void addTabla(Socket s, int i) {
        tabla[i] = s;
    }

}
