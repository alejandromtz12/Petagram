package mx.alemtz.petagram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import javax.crypto.Mac;

import mx.alemtz.petagram.bd.ConstructorMascotas;
import mx.alemtz.petagram.pojo.Mascota;
import mx.alemtz.petagram.R;

/**
 * Created by alejandro on 24/05/2016.
 */


public class Adapter extends RecyclerView.Adapter <Adapter.MascotaViewHolder>{
    ArrayList<Mascota> mascotas;
    Activity activity;



    public Adapter (ArrayList <Mascota> mascotas, Activity activity){
        this.mascotas=mascotas;
        this.activity=activity;
    }


    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType){ //le da vida al reciclerview
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.animales,parent,false);
        return new MascotaViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final MascotaViewHolder MascotaViewHolder, int position) { //setar datos
        final Mascota mascota= mascotas.get(position);
        MascotaViewHolder.iv1.setImageResource(mascota.getImagen());
        MascotaViewHolder.nombreM.setText(mascota.getNombre());
        MascotaViewHolder.tvlikes.setText(String.valueOf(mascota.getLikes()) );




        MascotaViewHolder.ivlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLike(mascota);
                /*MascotaViewHolder.tvlikes.setText(constructorMascotas.obtenerLikes(mascota));*/

                Log.e("-------------------", "--------------------------Mensaje de like-------------------------");
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        ImageView iv1 ;
        ImageButton ivlike;
        TextView nombreM, tvlikes;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            tvlikes= (TextView) itemView.findViewById(R.id.tvlikes);
            nombreM = (TextView) itemView.findViewById(R.id.tvnombre);
            iv1= (ImageView) itemView.findViewById(R.id.iv1);
            ivlike = (ImageButton) itemView.findViewById(R.id.ivlike);

        }
    }
}
