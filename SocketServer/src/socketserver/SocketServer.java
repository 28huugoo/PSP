/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package socketserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author FP
 */
public class SocketServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       int numeroPuerto=6000;
       ServerSocket servidor=new ServerSocket(numeroPuerto);
       Socket clienteConectado=null;
        System.out.println("Esperando al cliente");
        clienteConectado=servidor.accept();
        
        InputStream entrada =null;
        entrada=clienteConectado.getInputStream();
        DataInputStream flujoEntrada=new DataInputStream(entrada);
        
        String contenido=flujoEntrada.readUTF();
        
      
      
        
        
        
        
        OutputStream salida=null;
        salida=clienteConectado.getOutputStream();
        DataOutputStream flujoSalida=new DataOutputStream(salida);
        
        //ENVIO SALUDO AL CLIENTE 
        flujoSalida.writeUTF(contenido.toUpperCase());
        
        entrada.close();
        flujoEntrada.close();
        salida.close();
        flujoSalida.close();
        clienteConectado.close();
        servidor.close();
    }
    
}
