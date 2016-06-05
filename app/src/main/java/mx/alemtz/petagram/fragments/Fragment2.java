package mx.alemtz.petagram.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.alemtz.petagram.Mascota;
import mx.alemtz.petagram.R;
import mx.alemtz.petagram.adapter.Adapter;


public class Fragment2 extends Fragment {
    private ArrayList<Mascota> mascota = new ArrayList<Mascota>();
    private RecyclerView rvfrac2;

    public Fragment2() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_fragment2, container, false);
        rvfrac2 = (RecyclerView) v.findViewById(R.id.rvfrag2);

        LlenadoMascota();
        GridLayoutManager glm = new GridLayoutManager(getActivity(),2);
        glm.setOrientation(GridLayoutManager.VERTICAL);
        rvfrac2.setLayoutManager(glm);
        startAdapter();

        return v;
    }

    public void LlenadoMascota (){
        Mascota mascota2= new Mascota(R.drawable.mimascota1);
        Mascota mascota3= new Mascota(R.drawable.mimascota2);
        Mascota mascota1 = new Mascota(R.drawable.mimascota3);

        mascota.add(mascota1);
        mascota.add(mascota2);
        mascota.add(mascota3);
    }

    public void startAdapter (){
        Adapter adaptador = new Adapter(mascota);
        rvfrac2.setAdapter(adaptador);
    }

}
