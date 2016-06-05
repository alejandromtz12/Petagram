package mx.alemtz.petagram.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.alemtz.petagram.Mascota;
import mx.alemtz.petagram.R;
import mx.alemtz.petagram.adapter.Adapter;


public class Fragment_recyclerview extends Fragment {
    private ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
    private RecyclerView listaMascotas;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_recyclerview, container, false);

        //recyclerView
        listaMascotas = (RecyclerView) v.findViewById(R.id.rv1);
        LlenadoMascotas();
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        startAdapter();
        return v;
    }


    public void startAdapter (){
        Adapter adaptador= new Adapter(mascotas); //creamos objeto de la clase llamada adaptar y pasamos el Arraylist mascotas
        listaMascotas.setAdapter(adaptador); // del RecyclerView pasamos nuestro adaptador a la clase Adaptador
    }




    public void LlenadoMascotas (){

        Mascota mascota1 = new Mascota(R.drawable.mascota1,"Gatito Pelusa");
        Mascota mascota2 = new Mascota(R.drawable.mascota2,"Perrito Roco");
        Mascota mascota3 = new Mascota(R.drawable.mascota3, "Hamster Chocolate");
        Mascota mascota4 = new Mascota(R.drawable.mascota4, "PuercoEspin Mickey");
        Mascota mascota5 = new Mascota(R.drawable.mascota5, "Conejo Alicia");

        mascotas.add(mascota1);
        mascotas.add(mascota2);
        mascotas.add(mascota3);
        mascotas.add(mascota4);
        mascotas.add(mascota5);
    }

}
