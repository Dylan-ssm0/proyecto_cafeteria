
package Clases;


public class nutriente {
    
    private long id_nutriente;
    private String nombre_nutriente;

    public long getId_nutriente() {
        return id_nutriente;
    }

    public void setId_nutriente(long id_nutriente) {
        this.id_nutriente = id_nutriente;
    }

    public String getNombre_nutriente() {
        return nombre_nutriente;
    }

    public void setNombre_nutriente(String nombre_nutriente) {
        this.nombre_nutriente = nombre_nutriente;
    }

    public nutriente(long id_nutriente, String nombre_nutriente) {
        this.id_nutriente = id_nutriente;
        this.nombre_nutriente = nombre_nutriente;
    }
}
