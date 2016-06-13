package mx.alemtz.petagram.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.alemtz.petagram.pojo.Mascota;
import mx.alemtz.petagram.R;
import mx.alemtz.petagram.adapter.Adapter;
import mx.alemtz.petagram.presentador.IRecyclerViewFragmentPresenter;
import mx.alemtz.petagram.presentador.RecyclerViewFragmentPresenter;


public class Fragment_recyclerview extends Fragment implements IRecyclerViewFragment {
    private ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter presenter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_recyclerview, container, false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rv1);

        presenter = new RecyclerViewFragmentPresenter (this, getContext());

        return v;
    }



    @Override
    public void generarLinearLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

    }

    @Override
    public Adapter crearAdaptador(ArrayList<Mascota> mascotas) {
        Adapter adaptador= new Adapter(mascotas); //creamos objeto de la clase llamada adaptar y pasamos el Arraylist mascotas

        return adaptador;
    }

    @Override
    public void inicializarAdaptador(Adapter adaptador) {
        listaMascotas.setAdapter(adaptador); // del RecyclerView pasamos nuestro adaptador a la clase Adaptador
    }


}
