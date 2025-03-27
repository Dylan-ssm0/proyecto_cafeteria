
package Clases;


public class detalle_venta {
    
    private long id_detalle;
    private long id_venta;
    private long id_producto;
    private int cantidad;
    private double valor;

    public long getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(long id_detalle) {
        this.id_detalle = id_detalle;
    }

    public long getId_venta() {
        return id_venta;
    }

    public void setId_venta(long id_venta) {
        this.id_venta = id_venta;
    }

    public long getId_producto() {
        return id_producto;
    }

    public void setId_producto(long id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public detalle_venta(long id_detalle, long id_venta, long id_producto, int cantidad, double valor) {
        this.id_detalle = id_detalle;
        this.id_venta = id_venta;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.valor = valor;
    }
}
