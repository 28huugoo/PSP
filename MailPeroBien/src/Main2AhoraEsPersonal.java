import java.util.*;
import java.io.*;
import jakarta.mail.*;
import jakarta.mail.internet.*;
//import jakarta.activation.*;
public class Main2AhoraEsPersonal {
    static String msgText1 = "<h1>Esto es un mensaje enviado con la API de jakarta y con las librerias actualizadas</h1>";
    //static String msgText2 = "Prueba2.";

    public static void main(String[] args) {
        /*if (args.length != 4) {
            System.out.println("usage: java msgmultisend <to> <from> <smtp> true|false");
            return;
        }*/

        String to = "alumno@mariobros.damiansu.com";
        String from = "hola@mariobros.damiansu.com";
        String host = "mariobros.damiansu.com";
        boolean debug = Boolean.valueOf(true).booleanValue();

        // create some properties and get the default Session
        Properties props = new Properties();
        //props.put("mail.smtp.host", host);
        //props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", host);

        Session session = Session.getInstance(props, null);
        session.setDebug(debug);

        try {
            // create a message
            MimeMessage msg = new MimeMessage(session);
            //set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress(from, "MiNombre"));

            msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

            msg.setSubject("Prueba", "UTF-8");

            msg.setContent(msgText1, "text/html; charset=utf-8");

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));

            System.out.println("Message is ready");

            Transport tr = session.getTransport("smtp");
            tr.connect(host, from, "1234");
            msg.saveChanges();
            tr.sendMessage(msg, msg.getAllRecipients());
            tr.close();


            //Transport.send(msg);
        } catch (MessagingException mex) {
            mex.printStackTrace();
            Exception ex = null;
            if ((ex = mex.getNextException()) != null) {
                ex.printStackTrace();
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
