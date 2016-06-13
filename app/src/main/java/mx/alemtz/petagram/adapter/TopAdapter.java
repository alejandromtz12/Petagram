package mx.alemtz.petagram.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import mx.alemtz.petagram.pojo.Mascota;
import mx.alemtz.petagram.R;

public class TopAdapter extends RecyclerView.Adapter <TopAdapter.TopMascotaViewHolder> {

    ArrayList<Mascota> mascotas;

    public TopAdapter(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }


    @Override
    public TopMascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) { //le da vida al reciclerview
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_animales, parent, false);
        return new TopMascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TopMascotaViewHolder TopMascotaViewHolder, int position) { //setar datos
        Mascota mascota = mascotas.get(position);
        TopMascotaViewHolder.ivtop_animales.setImageResource(mascota.getImagen());

    }

    @Override
    public int getItemCount() { //cantidad elemtos que tiene la lista
        return mascotas.size();
    }


    public static class TopMascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivtop_animales;


        public TopMascotaViewHolder(View itemView) {
            super(itemView);
            ivtop_animales = (ImageView) itemView.findViewById(R.id.ivtop_animales);

        }
    }
}