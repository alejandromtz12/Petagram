package mx.alemtz.petagram.bd;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.zip.CheckedOutputStream;

import mx.alemtz.petagram.Contacto;
import mx.alemtz.petagram.pojo.Mascota;

/**
 * Created by alejandro on 11/06/2016.
 */
public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstanteBaseDatos.DATABASE_NAME, null , ConstanteBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascotas = "CREATE TABLE " + ConstanteBaseDatos.TABLE_MASCOTA + "("+
                                         ConstanteBaseDatos.TABLE_MASCOTA_ID        + " INTEGER PRIMARY kEY AUTOINCREMENT, " +
                                         ConstanteBaseDatos.TABLE_MASCOTA_NOMBRE    + " TEXT, "   +
                                         ConstanteBaseDatos.TABLE_MASCOTA_PIC       + " INTEGER"    +
                                         ")";


        String queryCrearTablaLikes = "CREATE TABLE " + ConstanteBaseDatos.TABLE_LIKES + "(" +
                                        ConstanteBaseDatos.TABLE_LIKES_ID           + " INTEGER PRIMARY KEY AUTOINCREMENT, "  +
                                        ConstanteBaseDatos.TABLE_LIKES_LIKE         + " INTEGER, "                           +
                                        ConstanteBaseDatos.TABLE_LIKES_MASCOTAID    + " INTERGER, "                           +
                                        "FOREIGN KEY (" +   ConstanteBaseDatos.TABLE_LIKES_MASCOTAID  +  ") "                +
                "REFERENCES " + ConstanteBaseDatos.TABLE_MASCOTA  +  "("  +  ConstanteBaseDatos.TABLE_MASCOTA_ID + ")"       +
                                        ")";

        db.execSQL(queryCrearTablaMascotas);
        db.execSQL(queryCrearTablaLikes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXIST " + ConstanteBaseDatos.TABLE_MASCOTA);
        db.execSQL("DROP TABLE IF EXIST " + ConstanteBaseDatos.TABLE_LIKES);
        onCreate(db);
    }

    public ArrayList <Mascota> ObtenerMascotas ( ){
        ArrayList <Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstanteBaseDatos.TABLE_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros  = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setImagen(registros.getInt(2));

            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }

    public  void insertarMascota (ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstanteBaseDatos.TABLE_MASCOTA, null, contentValues);
        db.close();
    }

    public void insertarLike (ContentValues contentValues){
        Log.e("-------------------", "3333333333333333333333333Mensaje de like33333333333333333333333");
        SQLiteDatabase db = this.getWritableDatabase();
        Log.e("-------------------", "4444444444444444444444444444Mensaje de like4444444444444444444");
        db.insert(ConstanteBaseDatos.TABLE_LIKES, null, contentValues);
        db.close();
    }

    public int obtenerlikes (Mascota mascota){
        int likes=0;
        String  query = "SELECT COUNT(" + ConstanteBaseDatos.TABLE_LIKES_LIKE + ")" +  "FROM " + ConstanteBaseDatos.TABLE_LIKES +
                " WHERE " + ConstanteBaseDatos.TABLE_LIKES_MASCOTAID + "=" + mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registro = db.rawQuery(query, null);

        if (registro.moveToNext()) {
            likes= registro.getInt(0);
        }
        db.close();

        return  likes;
    }

}
