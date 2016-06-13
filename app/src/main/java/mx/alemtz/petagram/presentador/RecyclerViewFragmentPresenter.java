package mx.alemtz.petagram.presentador;

import android.content.Context;

import java.util.ArrayList;

import mx.alemtz.petagram.bd.ConstructorMascotas;
import mx.alemtz.petagram.fragments.IRecyclerViewFragment;
import mx.alemtz.petagram.pojo.Mascota;

/**
 * Created by alejandro on 11/06/2016.
 */
public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{

    private IRecyclerViewFragment iRecyclerViewFragment;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    public ArrayList<Mascota> mascota;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragment iRecyclerViewFragment, Context context){
        this.iRecyclerViewFragment = iRecyclerViewFragment;
        this.context = context;
        obtenerContactosBD();
    }

    @Override
    public void obtenerContactosBD() {
        constructorMascotas = new ConstructorMascotas(context);
        mascota = constructorMascotas.obtenerDatos();
        mostrarContactosRV();

    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragment.inicializarAdaptador(iRecyclerViewFragment.crearAdaptador(mascota));
        iRecyclerViewFragment.generarLinearLayoutVertical();
    }
}
