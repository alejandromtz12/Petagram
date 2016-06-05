package mx.alemtz.petagram;

import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snombre = nombre.getText().toString();
                semail = email.getText().toString();
                smensaje= mensaje.getText().toString();
            }
        });

    }

}
