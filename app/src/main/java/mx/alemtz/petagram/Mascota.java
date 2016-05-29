package mx.alemtz.petagram;

/**
 * Created by alejandro on 25/05/2016.
 */

public class Mascota {
    private int imagen;
    private String nombre;

    public Mascota (int imagen){
        setImagen(imagen);
    }

    public Mascota (int imagen, String nombre){
        setImagen(imagen);
        setNombre(nombre);
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
}
