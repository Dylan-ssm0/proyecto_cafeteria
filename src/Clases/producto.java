
package Clases;


public class producto {
    
    private long id_producto;
    private long id_categoria;
    private String nombre_producto;
    private long id_ingrediente;
    private String descripcion_producto;
    private double precio_producto;

    public long getId_producto() {
        return id_producto;
    }

    public void setId_producto(long id_producto) {
        this.id_producto = id_producto;
    }

    public long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public long getId_ingrediente() {
        return id_ingrediente;
    }

    public void setId_ingrediente(long id_ingrediente) {
        this.id_ingrediente = id_ingrediente;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public double getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(double precio_producto) {
        this.precio_producto = precio_producto;
    }

    public producto(long id_producto, long id_categoria, String nombre_producto, long id_ingrediente, String descripcion_producto, double precio_producto) {
        this.id_producto = id_producto;
        this.id_categoria = id_categoria;
        this.nombre_producto = nombre_producto;
        this.id_ingrediente = id_ingrediente;
        this.descripcion_producto = descripcion_producto;
        this.precio_producto = precio_producto;
    }
    
}

