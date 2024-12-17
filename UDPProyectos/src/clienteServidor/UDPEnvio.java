/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clienteServidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author FP
 */
public class UDPEnvio {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket clienteSocket = new DatagramSocket();

        //DATOS DEL SERVIDOR AL QUE ENVIAR EL MENSAJE
        InetAddress IPServidor = InetAddress.getLocalHost();
        int puerto = 12345;

        //INTRODUCIR POR TECLADO
        System.out.println("Introduce el mensaje: ");
        String cadena = sc.nextLine();

        byte[] enviados = new byte[1024];
        enviados = cadena.getBytes();

        //ENVIANDO DATAGRAMA AL SERVIDOR
        DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPServidor, puerto);
        clienteSocket.send(envio);

        //RECIBIENDO DATAGRAMA DEL SERVIDOR
        byte[] recibidos = new byte[2];
        DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length, IPServidor, puerto);
        System.out.println("Esperando al datagrama...");
        clienteSocket.receive(recibo);
        
        //OBTENER EL NÚMERO DE CARÁCTERES
        byte[] hh = recibo.getData();
        int numero = hh[0];
        System.out.println("Recibo Nº de carácteres que son a --> "+numero);
        
        clienteSocket.close(); //cerrar el socket
    }
}
