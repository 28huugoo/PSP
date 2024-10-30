/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conectarseAColegas;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author FP
 */
public class conexionCliente {
        public static void main(String[] args) throws IOException {
        
        String host = "10.1.9.116";
        int puerto = 5080;
        //ABRIR SOCKET
        Socket cliente = new Socket(host, puerto);
        InetAddress i = cliente.getInetAddress();
        System.out.println("Puerto local(cliente)"+cliente.getLocalPort());
        System.out.println("Puerto remoto(servidor)"+cliente.getPort());
        System.out.println("Nombre Host/ip(cliente)"+cliente.getInetAddress());
        System.out.println("Host remoto(servidor)"+i.getHostName().toString());
        System.out.println("IP Host remoto(servidor"+i.getHostAddress().toString());

        cliente.close();
    }
}
