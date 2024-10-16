/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package url;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author FP
 */
public class main {

    private static void Visualizar(URL url) {
        System.out.println("\tURL completa: " + url.toString());
        System.out.println("\tgetProtocol: " + url.getProtocol());
        System.out.println("\tgetAuthority: " + url.getAuthority());
        System.out.println("\tgetPath: " + url.getPath());
        System.out.println("\tgetPort: " + url.getPort());
        System.out.println("\tgetHost: " + url.getHost());
        System.out.println("\tgetQuery: " + url.getQuery());
        System.out.println("\tgetUserInfo: " + url.getUserInfo());
        System.out.println("\tgetFile: " + url.getFile());
        System.out.println("\tgetDefaultPort: " + url.getDefaultPort());
        System.out.println("==========================");
    }

    public static void main(String[] args) {
        URL url;
        try {
            System.out.println("Constructor simple para una URL: ");
            url = new URL("http://docs.oracle.com/");
            Visualizar(url);

            System.out.println("Constructor simple para otra URL: ");
            url = new URL("https://m.locowin.com/");
            Visualizar(url);
            
            System.out.println("Constructor para protocolo, url, directorio ");
            url = new URL("http", "docs.oracle.com", "/javase/10");
            Visualizar(url);
            
            System.out.println("Constructor para protocolo, url, puerto, directorio ");
            url = new URL("http", "localhost", 8080, "/docs/appdev/instalation.html");
            Visualizar(url);
            
            System.out.println("Constructor para un objeto url en un contexto");
            url = new URL("http", "localhost", 8080, "/docs/appdev/instalation.html");
            Visualizar(url);
        } catch (MalformedURLException ex) {
            System.out.println("Error al formar la URL: " + ex);
        }
    }
}
