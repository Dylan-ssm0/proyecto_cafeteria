
package Clases;


public class ingrediente {
    
    private long id_ingrediente;
    private long id_nutriente;
    private String nombre_ingrediente;
    private String descripcion_ingrediente;

    public long getId_ingrediente() {
        return id_ingrediente;
    }

    public void setId_ingrediente(long id_ingrediente) {
        this.id_ingrediente = id_ingrediente;
    }

    public long getId_nutriente() {
        return id_nutriente;
    }

    public void setId_nutriente(long id_nutriente) {
        this.id_nutriente = id_nutriente;
    }

    public String getNombre_ingrediente() {
        return nombre_ingrediente;
    }

    public void setNombre_ingrediente(String nombre_ingrediente) {
        this.nombre_ingrediente = nombre_ingrediente;
    }

    public String getDescripcion_ingrediente() {
        return descripcion_ingrediente;
    }

    public void setDescripcion_ingrediente(String descripcion_ingrediente) {
        this.descripcion_ingrediente = descripcion_ingrediente;
    }

    public ingrediente(long id_ingrediente, long id_nutriente, String nombre_ingrediente, String descripcion_ingrediente) {
        this.id_ingrediente = id_ingrediente;
        this.id_nutriente = id_nutriente;
        this.nombre_ingrediente = nombre_ingrediente;
        this.descripcion_ingrediente = descripcion_ingrediente;
    }
    
}
