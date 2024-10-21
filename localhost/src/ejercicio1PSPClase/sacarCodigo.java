/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1PSPClase;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author FP
 */
public class sacarCodigo {
    public static void main(String[] args) throws MalformedURLException, IOException {
        URL url = new URL("http://damiansu.com");
        URLConnection conexion = url.openConnection();
        
        conexion.getHeaderField(name)
    }
}
