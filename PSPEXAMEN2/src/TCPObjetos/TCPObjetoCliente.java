/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class TCPObjetoCliente {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String host = "localhost";
        int puerto = 6000; //puertoRemoto
        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("PROGRAMA CLIENTE INICIADO...");
        Socket cliente = new Socket(host, puerto);
        //Flujo de entrada para objetos        
        ObjectInputStream perEnt = new ObjectInputStream(cliente.getInputStream());

        //Se recibe un objeto
        Persona dato = (Persona) perEnt.readObject();
        System.out.println("Recibido: " + dato.getNombre() + "*" + dato.getEdad());

        //Modifico el objeto
        dato.setNombre("Ricardo F.");
        dato.setEdad(51);

        //Flujo de salida para datos
        ObjectOutputStream perSal = new ObjectOutputStream(cliente.getOutputStream());
        //Se envía el objeto
        perSal.writeObject(dato); // enviando el objeto
        System.out.println("Envio: " + dato.getNombre() + "*" + dato.getEdad());

        //CERRAR STREAMS Y SOCKETS
        perEnt.close();
        perSal.close();
        cliente.close();
        servidor.close();
    }
}
