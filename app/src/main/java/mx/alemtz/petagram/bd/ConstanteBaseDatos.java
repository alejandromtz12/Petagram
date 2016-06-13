package mx.alemtz.petagram.bd;

/**
 * Created by alejandro on 11/06/2016.
 */
public class ConstanteBaseDatos {

    public static final String DATABASE_NAME = "Mascotas";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_MASCOTA        = "mascota";
    public static final String TABLE_MASCOTA_ID     = "id";
    public static final String TABLE_MASCOTA_NOMBRE = "nombre";
    public static final String TABLE_MASCOTA_PIC    = "pic";

    public static final String TABLE_LIKES = "likes";
    public static final String TABLE_LIKES_ID = "id";
    public static final String TABLE_LIKES_LIKE = "like";
    public static final String TABLE_LIKES_MASCOTAID = "id_mascota";

}
