package mx.alemtz.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList <Mascota> mascotas = new ArrayList<Mascota>();
    private RecyclerView listaMascotas;
    Toolbar actionbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaMascotas = (RecyclerView) findViewById(R.id.rv1);

        //define  toolbar
        actionbar = (Toolbar) findViewById(R.id.actionbar1);
        setSupportActionBar (actionbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionbar.setNavigationIcon(R.mipmap.footprint);

        //recyclerView
        LlenadoMascotas();
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        startAdapter();


        actionbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }



    public void startAdapter (){
        Adapter adaptador= new Adapter(mascotas); //creamos objeto de la clase llamada adaptar y pasamos el Arraylist mascotas
        listaMascotas.setAdapter(adaptador); // del RecyclerView pasamos nuestro adaptador a la clase Adaptador
    }


    public void LlenadoMascotas (){
        mascotas.add(new Mascota(R.drawable.mascota1,"Gatito Pelusa"));
        mascotas.add(new Mascota (R.drawable.mascota2, "Perrito Roco"));
        mascotas.add(new Mascota (R.drawable.mascota3, "Hamster Chocolate"));
        mascotas.add(new Mascota (R.drawable.mascota4, "PuercoEspin Mickey"));
        mascotas.add(new Mascota (R.drawable.mascota5, "Conejo Alicia"));
    }


    //crea el menu de acciones
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
        case R.id.ic_next:
            Intent intent = new Intent(this,FavMascotas.class);
            startActivity (intent);
        default:
            return super.onOptionsItemSelected(item);
    }
    }
}


