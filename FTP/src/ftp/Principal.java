package ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        FTPClient ftp = new FTPClient();
        ftp.connect("vbo.damiansu.com", 21);
        boolean login = ftp.login("alumno", "fp.2023");
        if (!login) {
            System.out.println("ConexiOn incorrecta");
            System.out.println(ftp.getReplyString());
        } else {
            System.out.println("Estamos dentro");
            System.out.println(ftp.getReplyString());
            FTPFile[] ficheros = ftp.listFiles();
            System.out.println("Nº de ficheros: " + ficheros.length);
            infoCarpeta(ficheros);
            File f = new File("‪C:\\Users\\FP\\Desktop\\usa.png");
            if (f.exists()) {
                System.out.println("Vamos a subir el fichero");
                FileInputStream fsubida = new FileInputStream(f);
                ftp.storeFile("campilloPutero.png", fsubida);
            }
            System.out.println("---------------Como ha quedado---------------");
            infoCarpeta(ficheros);
            
            //Bajar un fichero
            FileOutputStream fBajada = new FileOutputStream("messiPutero.jpg");
            ftp.retrieveFile("messiPutero.jpg", fBajada);
        }
        ftp.logout();
    }

    private static void infoCarpeta(FTPFile[] ficheros) {
        for (int i = 0; i < ficheros.length; i++) {
            if (ficheros[i].isFile()) {
                System.out.println("Fichero: " + ficheros[i].getName());
            } else if (ficheros[i].isDirectory()) {
                System.out.println("Directorio: " + ficheros[i].getName());
            } else {
                System.out.println("Algo raro primo: " + ficheros[i].getName());
            }
        }
    }

}
