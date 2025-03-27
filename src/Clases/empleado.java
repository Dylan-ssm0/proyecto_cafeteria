
package Clases;

import java.util.Date;


public class empleado {
    
    private long cedula_empleado;
    private String nombre_empleado;
    private String apellido_empleado;
    private long telefono_empleado;
    private String email_empleado;
    private String direccion_empleado;
    private Date fecha_nacimiento_empleado;
    private Date fecha_ingreso_empleado;
    private String genero_empleado;

    public long getCedula_empleado() {
        return cedula_empleado;
    }

    public void setCedula_empleado(long cedula_empleado) {
        this.cedula_empleado = cedula_empleado;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getApellido_empleado() {
        return apellido_empleado;
    }

    public void setApellido_empleado(String apellido_empleado) {
        this.apellido_empleado = apellido_empleado;
    }

    public long getTelefono_empleado() {
        return telefono_empleado;
    }

    public void setTelefono_empleado(long telefono_empleado) {
        this.telefono_empleado = telefono_empleado;
    }

    public String getEmail_empleado() {
        return email_empleado;
    }

    public void setEmail_empleado(String email_empleado) {
        this.email_empleado = email_empleado;
    }

    public String getDireccion_empleado() {
        return direccion_empleado;
    }

    public void setDireccion_empleado(String direccion_empleado) {
        this.direccion_empleado = direccion_empleado;
    }

    public Date getFecha_nacimiento_empleado() {
        return fecha_nacimiento_empleado;
    }

    public void setFecha_nacimiento_empleado(Date fecha_nacimiento_empleado) {
        this.fecha_nacimiento_empleado = fecha_nacimiento_empleado;
    }

    public Date getFecha_ingreso_empleado() {
        return fecha_ingreso_empleado;
    }

    public void setFecha_ingreso_empleado(Date fecha_ingreso_empleado) {
        this.fecha_ingreso_empleado = fecha_ingreso_empleado;
    }

    public String getGenero_empleado() {
        return genero_empleado;
    }

    public void setGenero_empleado(String genero_empleado) {
        this.genero_empleado = genero_empleado;
    }

    public empleado(long cedula_empleado, String nombre_empleado, String apellido_empleado, long telefono_empleado, String email_empleado, String direccion_empleado, Date fecha_nacimiento_empleado, Date fecha_ingreso_empleado, String genero_empleado) {
        this.cedula_empleado = cedula_empleado;
        this.nombre_empleado = nombre_empleado;
        this.apellido_empleado = apellido_empleado;
        this.telefono_empleado = telefono_empleado;
        this.email_empleado = email_empleado;
        this.direccion_empleado = direccion_empleado;
        this.fecha_nacimiento_empleado = fecha_nacimiento_empleado;
        this.fecha_ingreso_empleado = fecha_ingreso_empleado;
        this.genero_empleado = genero_empleado;
    }
}
