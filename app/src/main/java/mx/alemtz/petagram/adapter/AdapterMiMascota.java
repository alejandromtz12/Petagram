package mx.alemtz.petagram.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import mx.alemtz.petagram.pojo.Mascota;
import mx.alemtz.petagram.R;


public class AdapterMiMascota extends RecyclerView.Adapter <AdapterMiMascota.MiMascotaViewHolder> {

    ArrayList<Mascota> mimascota;

    public AdapterMiMascota (ArrayList <Mascota> mimascota){
        this.mimascota = mimascota;
    }

    @Override
    public MiMascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mi_mascota,parent,false);
        return new MiMascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MiMascotaViewHolder MiMascotaViewHolder, int position) {
        Mascota mascota = mimascota.get(position);


    }

    @Override
    public int getItemCount() {
        return mimascota.size();
    }

    public static class MiMascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView immimascota;

        public MiMascotaViewHolder(View itemView) {
            super(itemView);
            immimascota = (ImageView) itemView.findViewById(R.id.immimascota);
        }
    }
}
