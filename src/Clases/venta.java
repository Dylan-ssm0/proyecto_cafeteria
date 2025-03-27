
package Clases;

import java.util.Date;


public class venta {
    
    private long id_venta;
    private long cedula_cliente;
    private long cedula_empleado;
    private Date fecha_venta;

    public long getId_venta() {
        return id_venta;
    }

    public void setId_venta(long id_venta) {
        this.id_venta = id_venta;
    }

    public long getCedula_cliente() {
        return cedula_cliente;
    }

    public void setCedula_cliente(long cedula_cliente) {
        this.cedula_cliente = cedula_cliente;
    }

    public long getCedula_empleado() {
        return cedula_empleado;
    }

    public void setCedula_empleado(long cedula_empleado) {
        this.cedula_empleado = cedula_empleado;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public venta(long id_venta, long cedula_cliente, long cedula_empleado, Date fecha_venta) {
        this.id_venta = id_venta;
        this.cedula_cliente = cedula_cliente;
        this.cedula_empleado = cedula_empleado;
        this.fecha_venta = fecha_venta;
    }
}
