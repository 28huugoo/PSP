import jakarta.mail.*;

import java.util.Properties;

public class MDA {
    public static void main(String[] args) throws MessagingException {
        String host = "mariobros.damiansu.com";
        String username = "hola@mariobros.damiansu.com";
        String carpeta = "1234";
        String password = "INBOX";
        boolean debug = Boolean.valueOf(true).booleanValue();

        Properties props = new Properties();
        props.put("mail.imap.protocol", "imap");
        props.put("mail.imap.host", host);
        props.put("mail.imap.auth", "true");
        props.put("mail.imap.port", "143");

        Session session = Session.getDefaultInstance(props, null);
        session.setDebug(debug);

        Store store = session.getStore("imap");
        store.connect(username, password);

        Folder folder = store.getFolder(carpeta);
        folder.open(Folder.READ_ONLY);
        Message[] messages = folder.getMessages();
        System.out.println("Mensaje recibidos: " + messages.length);

        for (int i = 0; i < messages.length; i++) {
            System.out.println("--------------------------------------------------");
            System.out.println("Mensaje recibido: " + messages[i].getSubject());
            System.out.println("Remitente: " + messages[i].getFrom()[0]);
            System.out.println("Fecha: " + messages[i].getSentDate());
        }

        folder.close(false);
        store.close();
    }
}
