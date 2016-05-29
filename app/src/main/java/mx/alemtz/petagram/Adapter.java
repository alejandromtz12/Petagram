package mx.alemtz.petagram;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alejandro on 24/05/2016.
 */


public class Adapter extends RecyclerView.Adapter <Adapter.MascotaViewHolder>{
    ArrayList<Mascota> mascotas;

    public Adapter (ArrayList <Mascota> mascotas){
        this.mascotas=mascotas;
    }







    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType){ //le da vida al reciclerview
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.animales,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder MascotaViewHolder, int position) { //setar datos
        Mascota mascota= mascotas.get(position);
        MascotaViewHolder.iv1.setImageResource(mascota.getImagen());
        MascotaViewHolder.nombreM.setText(mascota.getNombre());

    }

    @Override
    public int getItemCount() { //cantidad elemtos que tiene la lista
        return mascotas.size();
    }




    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv1;
        TextView nombreM;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            nombreM = (TextView) itemView.findViewById(R.id.tvnombre);
            iv1= (ImageView) itemView.findViewById(R.id.iv1);

        }
    }
}
