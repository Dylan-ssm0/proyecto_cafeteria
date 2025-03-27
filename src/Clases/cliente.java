
package Clases;

import java.util.Date;


public class cliente {
    private long cedula_cliente;
    private String nombre_cliente;
    private String apellido_cliente;
    private long telefono_cliente;
    private String email_cliente;
    private String direccion_cliente;
    private Date fecha_nacimiento_cliente;
    private String genero_cliente;

    public long getCedula_cliente() {
        return cedula_cliente;
    }

    public void setCedula_cliente(long cedula_cliente) {
        this.cedula_cliente = cedula_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getApellido_cliente() {
        return apellido_cliente;
    }

    public void setApellido_cliente(String apellido_cliente) {
        this.apellido_cliente = apellido_cliente;
    }

    public long getTelefono_cliente() {
        return telefono_cliente;
    }

    public void setTelefono_cliente(long telefono_cliente) {
        this.telefono_cliente = telefono_cliente;
    }

    public String getEmail_cliente() {
        return email_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    public String getDireccion_cliente() {
        return direccion_cliente;
    }

    public void setDireccion_cliente(String direccion_cliente) {
        this.direccion_cliente = direccion_cliente;
    }

    public Date getFecha_nacimiento_cliente() {
        return fecha_nacimiento_cliente;
    }

    public void setFecha_nacimiento_cliente(Date fecha_nacimiento_cliente) {
        this.fecha_nacimiento_cliente = fecha_nacimiento_cliente;
    }

    public String getGenero_cliente() {
        return genero_cliente;
    }

    public void setGenero_cliente(String genero_cliente) {
        this.genero_cliente = genero_cliente;
    }
    
    public cliente(long cedula_cliente, String nombre_cliente, String apellido_cliente, long telefono_cliente, String email_cliente, String direccion_cliente, Date fecha_nacimiento_cliente, String genero_cliente) {
        this.cedula_cliente = cedula_cliente;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
        this.telefono_cliente = telefono_cliente;
        this.email_cliente = email_cliente;
        this.direccion_cliente = direccion_cliente;
        this.fecha_nacimiento_cliente = fecha_nacimiento_cliente;
        this.genero_cliente = genero_cliente;
    }


}
