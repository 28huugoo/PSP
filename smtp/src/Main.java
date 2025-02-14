import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Main {

    // Replace FROM with your "From" address.
    // This address must be added to Approved Senders in the console.
    static final String FROM = "<hola@mariobros.damiansu.com>";
    static final String FROMNAME = "<hola>";

    // Replace TO with a recipient address.
    static final String TO = "<hola@mariobros.damiansu.com>";

    // Replace smtp_username with your Oracle Cloud Infrastructure SMTP username generated in console.

    // Replace smtp_password with your Oracle Cloud Infrastructure SMTP password generated in console.

    // Oracle Cloud Infrastructure Email Delivery hostname.

    // The port you will connect to on the SMTP endpoint. Port 25 or 587 is allowed.
    static final int PORT = 25;

    static final String SUBJECT = "<Hola soy Lamine>";
    static final String BODY = String.join(

            System.getProperty("line.separator"),
            "<h1>Estoy probando cosas</h1>",
            "<h4>1, 2, 3... avance</h4>"

    );

    public static void main(String[] args) throws Exception {

        // Create a Properties object to contain connection configuration information.

        Properties props = System.getProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.port", PORT);

        //props.put("mail.smtp.ssl.enable", "true"); //the default value is false if not set
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.auth.login.disable", "true");  //the default authorization order is "LOGIN PLAIN DIGEST-MD5 NTLM". 'LOGIN' must be disabled since Email Delivery authorizes as 'PLAIN'
        props.put("mail.smtp.starttls.enable", "true");   //TLSv1.2 is required
        props.put("mail.smtp.starttls.required", "true");  //Oracle Cloud Infrastructure required

        // Create a Session object to represent a mail session with the specified properties.
        Session session = Session.getDefaultInstance(props);

        // Create a message with the specified information.
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(FROM,FROMNAME));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
        msg.setSubject(SUBJECT);
        msg.setContent(BODY,"text/html");

        // Create a transport.
        Transport transport = session.getTransport();


        // Send the message.

        try
        {

            System.out.println("Enviando el emauil... espera...");


            // Connect to OCI Email Delivery using the SMTP credentials specified.
            transport.connect("mariobros.damiansu.com", "hola@damiansu.com", "1234");

            // Send email.
            transport.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Email enviado!");

        }

        catch (Exception ex) {

            System.out.println("email no enviado.");
            System.out.println("Error message: " + ex.getMessage());

        }

        finally

        {

            // Close & terminate the connection.
            transport.close();

        }

    }

}
