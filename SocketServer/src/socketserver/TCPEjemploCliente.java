/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socketserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author FP
 */
public class TCPEjemploCliente {
    public static void main(String[] args) throws IOException {
        String Host="localhost";
        int puerto=6000;
        System.out.println("Cliente INICIADO");
        Socket cliente=new Socket(Host,puerto);
        
       
        DataOutputStream flujoSalida=new DataOutputStream(cliente.getOutputStream());
        
        flujoSalida.writeUTF("raasclat");
        
        DataInputStream flujoEntrada=new DataInputStream(cliente.getInputStream());
        
        System.out.println("Recibiendo del servidor "+flujoEntrada.readUTF());
        
        
        flujoEntrada.close();
        flujoSalida.close();
        cliente.close();
        
    }
}
