package mx.alemtz.petagram.pojo;

/**
 * Created by alejandro on 25/05/2016.
 */

public class Mascota {
    private int imagen, ivlikes;
    private String nombre;
    private int likes = 0;
    private int id;

    public Mascota (int imagen){
        setImagen(imagen);
    }

    public Mascota (int imagen, String nombre, int likes){
        setImagen(imagen);
        setNombre(nombre);
        setLikes(likes);
    }

    public Mascota() {

    }


    //setters and getters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getIvlikes() {
        return ivlikes;
    }

    public void setIvlikes(int ivlikes) {
        this.ivlikes = ivlikes;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
