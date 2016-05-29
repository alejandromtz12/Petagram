package mx.alemtz.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import java.util.ArrayList;

public class FavMascotas extends AppCompatActivity {

    ArrayList <Mascota> mascotas = new ArrayList<Mascota>();
    private Toolbar actionbar;
    private RecyclerView topmascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_mascotas);

        //define tu toolbar
        actionbar = (Toolbar) findViewById(R.id.actionbar2);
        setSupportActionBar (actionbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //define icono izquierdo de back
        actionbar.setNavigationIcon(R.mipmap.footprint);

        //pasar arraylist
        LlenadoMascotas();


        //recycleView
        topmascotas = (RecyclerView) findViewById(R.id.rv2);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        topmascotas.setLayoutManager(llm);
        startAdapter();

    }


    public void startAdapter (){
        TopAdapter adaptador= new TopAdapter(mascotas);
        topmascotas.setAdapter(adaptador);
    }

    public void LlenadoMascotas (){
        mascotas.add(new Mascota(R.drawable.mascota1));
        mascotas.add(new Mascota (R.drawable.mascota2));
        mascotas.add(new Mascota (R.drawable.mascota3));
        mascotas.add(new Mascota (R.drawable.mascota4));
        mascotas.add(new Mascota (R.drawable.mascota5));
    }



}
