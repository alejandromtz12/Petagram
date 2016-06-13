package mx.alemtz.petagram.bd;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

import mx.alemtz.petagram.R;
import mx.alemtz.petagram.pojo.Mascota;

/**
 * Created by alejandro on 11/06/2016.
 */
public class ConstructorMascotas {

    private Context context;
    private static final int LIKE=1;
    public ConstructorMascotas (Context context){
        this.context = context;
    }

    public ArrayList <Mascota> obtenerDatos (){
        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

        /*Mascota mascota1 = new Mascota(R.drawable.mascota1,"Gatito Pelusa", 8);
        Mascota mascota2 = new Mascota(R.drawable.mascota2,"Perrito Roco", 8);
        Mascota mascota3 = new Mascota(R.drawable.mascota3, "Hamster Chocolate", 5);
        Mascota mascota4 = new Mascota(R.drawable.mascota4, "PuercoEspin Mickey", 3);
        Mascota mascota5 = new Mascota(R.drawable.mascota5, "Conejo Alicia",8);
        mascotas.add(mascota1);
        mascotas.add(mascota2);
        mascotas.add(mascota3);
        mascotas.add(mascota4);
        mascotas.add(mascota5);
        return mascotas;*/

        BaseDatos db = new BaseDatos(context);
        insertarCincoMascota(db);
        return  db.ObtenerMascotas();
    }

    public  void insertarCincoMascota (BaseDatos db) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_NOMBRE, "Gatito Pelusa");
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_PIC, R.drawable.mascota1);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_NOMBRE, "Perrito Roco");
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_PIC, R.drawable.mascota2);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_NOMBRE, "Hamster Chocolate");
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_PIC, R.drawable.mascota3);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_NOMBRE, "PuercoEspin Mickey");
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_PIC, R.drawable.mascota4);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_NOMBRE, "Conejo Alicia");
        contentValues.put(ConstanteBaseDatos.TABLE_MASCOTA_PIC, R.drawable.mascota5);
        db.insertarMascota(contentValues);

    }
        public void darLike (Mascota mascota){
            BaseDatos db = new BaseDatos(context);
            ContentValues contentValues = new ContentValues();
            contentValues.put(ConstanteBaseDatos.TABLE_LIKES_MASCOTAID, mascota.getId());
            contentValues.put(ConstanteBaseDatos.TABLE_LIKES_LIKE, LIKE);
            db.insertarLike(contentValues);
        }

    public int obtenerLikes (Mascota mascota) {
        BaseDatos db = new BaseDatos(context);
        return db.obtenerlikes(mascota);
    }
}
