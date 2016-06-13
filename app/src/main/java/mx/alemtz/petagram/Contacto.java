package mx.alemtz.petagram;

import android.database.Cursor;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

import mx.alemtz.petagram.Email;
import mx.alemtz.petagram.R;

public class Contacto extends AppCompatActivity {

    private EditText nombre,email, mensaje;
    private Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        nombre = (EditText) findViewById(R.id.txinombre);
        email = (EditText) findViewById(R.id.txiemail);
        mensaje = (EditText) findViewById(R.id.tximensaje);
        enviar = (Button) findViewById(R.id.btenviar);

    }


    public void EnviarEmail (View v){

        Email emails = new Email();
        emails.execute(email.getText().toString(), mensaje.getText().toString());

        try {
            Object ob = emails.get();
            if (ob != null) {
                Snackbar.make(v,ob.toString(),Snackbar.LENGTH_LONG).show();
            }else{
                Snackbar.make(v,"Mensaje no enviado",Snackbar.LENGTH_LONG).show();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }


}
