package mx.alemtz.petagram.fragments;

import java.util.ArrayList;

import mx.alemtz.petagram.adapter.Adapter;
import mx.alemtz.petagram.pojo.Mascota;

/**
 * Created by alejandro on 11/06/2016.
 */
public interface IRecyclerViewFragment {


    public void generarLinearLayoutVertical ();

    public Adapter crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptador (Adapter adaptador);

}
