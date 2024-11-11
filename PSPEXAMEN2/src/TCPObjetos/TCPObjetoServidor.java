/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TCPObjetos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author FP
 */
public class TCPObjetoServidor {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int numeroPuerto = 6000; //puertoRemoto
        ServerSocket servidor = new ServerSocket(numeroPuerto);
        System.out.println("SOY EL SERVIDOR");
        System.out.println("Esperando al cliente...");
        Socket cliente = servidor.accept();
        //Se prepara un flujo de salida para objetos
        ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());
        //Se prepara un objeto y se envía
        Persona per = new Persona("Paco Pil", 53);
        outObjeto.writeObject(per); // enviando el objeto
        System.out.println("Envio: " + per.getNombre() + "*" + per.getEdad());

        //Se obtiene un stream para leer objetos
        ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
        Persona dato = (Persona) inObjeto.readObject();

        System.out.println("Recibido: " + dato.getNombre() + "*" + dato.getEdad());
        //CERRAR STREAMS Y SOCKETS
        outObjeto.close();
        inObjeto.close();
        cliente.close();
        servidor.close();
    }
}
