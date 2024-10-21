/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadenaContenido;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author FP
 */
public class main {

    public static void main(String[] args) throws MalformedURLException, IOException {
        String cadena;
        URL url = new URL("http://damiansu.com");
        URLConnection conexion = url.openConnection();

        System.out.println("Dirección [getURL()]: " + conexion.getURL());
        Date fecha = new Date(conexion.getLastModified());
        System.out.println("Fecha de la última modificación [getLastModified()]" + fecha);
        System.out.println("Tipo de contenido [getContentType()]" + conexion.getContentType());
        System.out.println("Tipo de contenido [url.getFile()]" + url.getFile());
        BufferedReader pagina = new BufferedReader(new InputStreamReader(url.openStream()));
        while ((cadena = pagina.readLine()) != null) {
            System.out.println(cadena);
        }
        System.out.println("<=========================================3");

        System.out.println("CAMPOS 1 Y 4 DE CABECERA");
        System.out.println("getHeaderField(1) -- > " + conexion.getHeaderField(1));
        System.out.println("getHeaderField(4) -- > " + conexion.getHeaderField(4));
        System.out.println("<=========================================3");

        System.out.println("TODOS LOS CAMPOS DE LA CABECERA CON EL GETHEADERFIELD");

        Map camposcabecera = conexion.getHeaderFields();
        Iterator it = camposcabecera.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry map = (Map.Entry) it.next();
            System.out.println(map.getKey() + " : " + map.getValue());
        }
        System.out.println("<=========================================3");
        System.out.println("código de respuesta del servidor: " + conexion.getHeaderField(0));
        System.out.println("código de respuesta del servidor: " + conexion.getHeaderField(1));
        System.out.println("<=========================================3");

    }
}
