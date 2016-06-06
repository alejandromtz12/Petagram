package mx.alemtz.petagram;

import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class Contacto extends AppCompatActivity {
    private TextInputEditText nombre,email, mensaje;
    private String snombre,semail,smensaje;
    private Button enviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        nombre = (TextInputEditText) findViewById(R.id.txinombre);
        email = (TextInputEditText) findViewById(R.id.txiemail);
        mensaje = (TextInputEditText) findViewById(R.id.tximensaje);
        enviar = (Button) findViewById(R.id.btenviar);

    }


    public void EnviarEmail (View v){

        Email emails = new Email();
        emails.execute(email.getText().toString(), mensaje.getText().toString());

        try {
            Object ob = emails.get();
            if (ob != null) {
                Toast.makeText(this,"mensaje enviado",Toast.LENGTH_SHORT);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
