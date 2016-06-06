package mx.alemtz.petagram;

import android.os.AsyncTask;
import android.util.Log;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Email extends AsyncTask<Object, Object, Object> {

    private static final String TAG = Email.class.getName();

    @Override
    protected Object doInBackground(Object... params) {
        try {

            String correo = (String) params[0];
            String mensaje = (String) params[1];

            String host = "smtp.gmail.com";
            final String address = "and134mnalejandro.mtz@gmail.com";
            final String pass = "Saltimbanqui";
            final String from = "and134mnalejandro.mtz@gmail.com";
            String to = correo;
            Properties props = System.getProperties();
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.user", address);
            props.put("mail.smtp.password", pass);
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            // Get the default Session object.
            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(address, pass);
                        }
                    });


            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("PETAGRAM");

            // Now set the actual message
            message.setText(mensaje);

            // Send message
            Transport.send(message);
            Log.i(TAG, "Sent message successfully....");

            Object ob = "Mensaje enviado.";
            return ob;

        } catch (Exception e) {
            Log.e(TAG, "Mensaje no enviado", e);
            return null;
        }
    }
}
