package Explicacoin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class Principal {

    public static void main(String[] args) throws IOException {
        FTPClient ftp = new FTPClient();
        ftp.connect("vbo.damiansu.com", 21);
        boolean login = ftp.login("alumno", "fp.2023");
        if (!login) {
            System.out.println("Conexión incorrecta");
            System.out.println(ftp.getReplyString());
        } else {
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            System.out.println("Estamos dentro");
            FTPFile[] ficheros = ftp.listFiles();
            System.out.println("Nº de ficheros: " + ficheros.length);
            infoCarpeta(ficheros);
            //Subir un fichero
            File f = new File("C:\\Users\\FP\\Desktop\\orejona.webp");
            if (f.exists()) {
                System.out.println("Vamos a subir el fichero");
                FileInputStream fSubida
                        = new FileInputStream(f);
               
                ftp.storeFile("orejona-1234.webp", fSubida);
            }
            System.out.println("----------Como ha quedado-------------");
            infoCarpeta(ficheros);
            
            //bajar un fichero
            FileOutputStream fBajada = new FileOutputStream("sandamian.png");
            ftp.retrieveFile("sandamian.png", fBajada);
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
                System.out.println("Otra cosa: " + ficheros[i].getName());
            }
        }
    }
}
