
package Metodos;

import java.awt.Color;
import javax.swing.JTable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class metodo_barra {
    
    private void cambiar_estilo(JTable tabla){
        tabla.setBackground(new Color(255,248,231));
        tabla.setForeground(new Color(75,46,46));
        tabla.setSelectionBackground(new Color(174, 97, 40));
        tabla.setSelectionForeground(new Color(255, 248, 231));
        tabla.setGridColor(new Color(159, 129, 98));
    }
    
    private void restaurar_estilo(JTable tabla){
        tabla.setBackground(new Color(255,248,231));
        tabla.setForeground(new Color(75,46,46));
        tabla.setSelectionBackground(new Color(174, 97, 40));
        tabla.setSelectionForeground(new Color(255, 248, 231));
        tabla.setGridColor(new Color(159, 129, 98));
    }
    
    Connection conect = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    
    //Cliente
    public void barra_cliente(JTextField barra, DefaultTableModel tabla, JTable txttabla, JLabel msj){
        
        if(barra.getText().trim().isEmpty()){
            tabla.setRowCount(0);
            restaurar_estilo(txttabla);
            msj.setText("");
        }
        else{
            try{
                Conexion con = new Conexion("postgres", "12345", "localhost", "5432", "proyecto_cafeteria");
                con.ConexionPostgres();
                conect = con.getConnection();

                String cad = barra.getText().trim();
                String querybarra = "SELECT * FROM cliente WHERE nombre_cliente LIKE ?";

                ps = conect.prepareStatement(querybarra);
                ps.setString(1, cad+"%");

                rs = ps.executeQuery();
                tabla.setRowCount(0);

                while(rs.next()){
                    tabla.addRow(new Object[]{
                        rs.getLong("cedula_cliente"),
                        rs.getString("nombre_cliente"),
                        rs.getString("apellido_cliente"),
                        rs.getLong("telefono_cliente"),
                        rs.getString("email.cliente"),
                        rs.getString("direccion_cliente"),
                        rs.getDate("fecha_nacimiento_cliente"),
                        rs.getString("genero_cliente")
                    });
                }
                txttabla.setModel(tabla);
                cambiar_estilo(txttabla);
            }
            catch(ClassNotFoundException | SQLException e){
                msj.setForeground(Color.RED);
                msj.setText("❌ Error: "+e.getMessage());
            }
            catch(Exception e){
                msj.setForeground(Color.RED);
                msj.setText("❌ Error inesperado: "+e.getMessage());
                e.printStackTrace();
            }
            finally{
                try{
                    if(rs != null)rs.close();
                    if(ps != null)ps.close();
                    if(conect != null)conect.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
    
    
    //Empleado
    public void barra_empleado(JTextField barra, DefaultTableModel tabla, JTable txttabla, JLabel msj){
        
        if(barra.getText().trim().isEmpty()){
            tabla.setRowCount(0);
            restaurar_estilo(txttabla);
            msj.setText("");
        }
        else{
            try{
                Conexion con = new Conexion("postgres", "12345", "localhost", "5432", "proyecto_cafeteria");
                con.ConexionPostgres();
                conect = con.getConnection();

                String cad = barra.getText().trim();
                String querybarra = "SELECT * FROM empleado WHERE nombre_empleado LIKE ?";

                ps = conect.prepareStatement(querybarra);
                ps.setString(1, cad+"%");

                rs = ps.executeQuery();
                tabla.setRowCount(0);

                while(rs.next()){
                    tabla.addRow(new Object[]{
                        rs.getLong("cedula_empleado"),
                        rs.getString("nombre_empleado"),
                        rs.getString("apellido_empleado"),
                        rs.getLong("telefono_empleado"),
                        rs.getString("email_empleado"),
                        rs.getString("direccion_empleado"),
                        rs.getDate("fecha_nacimiento_empleado"),
                        rs.getDate("fecha_ingreso_empleado"),
                        rs.getString("genero_empleado")
                    });
                }
                txttabla.setModel(tabla);
                cambiar_estilo(txttabla);
            }
            catch(ClassNotFoundException | SQLException e){
                msj.setForeground(Color.RED);
                msj.setText("❌ Error: "+e.getMessage());
            }
            catch(Exception e){
                msj.setForeground(Color.RED);
                msj.setText("❌ Error inesperado: "+e.getMessage());
                e.printStackTrace();
            }
            finally{
                try{
                    if(rs != null)rs.close();
                    if(ps != null)ps.close();
                    if(conect != null)conect.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
    
    
    //Categoria
    public void barra_categoria(JTextField barra, DefaultTableModel tabla, JTable txttabla, JLabel msj){
        
        if(barra.getText().trim().isEmpty()){
            tabla.setRowCount(0);
            restaurar_estilo(txttabla);
            msj.setText("");
        }
        else{
            try{
                Conexion con = new Conexion("postgres", "12345", "localhost", "5432", "proyecto_cafeteria");
                con.ConexionPostgres();
                conect = con.getConnection();

                String cad = barra.getText().trim();
                String querybarra = "SELECT * FROM categoria WHERE nombre_categoria LIKE ?";

                ps = conect.prepareStatement(querybarra);
                ps.setString(1, cad+"%");

                rs = ps.executeQuery();
                tabla.setRowCount(0);

                while(rs.next()){
                    tabla.addRow(new Object[]{
                        rs.getLong("id_categoria"),
                        rs.getString("nombre_categoria"),
                        rs.getString("descripcion_categoria")
                    });
                }
                txttabla.setModel(tabla);
                cambiar_estilo(txttabla);
            }
            catch(ClassNotFoundException | SQLException e){
                msj.setForeground(Color.RED);
                msj.setText("❌ Error: "+e.getMessage());
            }
            catch(Exception e){
                msj.setForeground(Color.RED);
                msj.setText("❌ Error inesperado: "+e.getMessage());
                e.printStackTrace();
            }
            finally{
                try{
                    if(rs != null)rs.close();
                    if(ps != null)ps.close();
                    if(conect != null)conect.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
    
    
    //Nutriente
    public void barra_nutriente(JTextField barra, DefaultTableModel tabla, JTable txttabla, JLabel msj){
        
        if(barra.getText().trim().isEmpty()){
            tabla.setRowCount(0);
            restaurar_estilo(txttabla);
            msj.setText("");
        }
        else{
            try{
                Conexion con = new Conexion("postgres", "12345", "localhost", "5432", "proyecto_cafeteria");
                con.ConexionPostgres();
                conect = con.getConnection();

                String cad = barra.getText().trim();
                String querybarra = "SELECT * FROM nutriente WHERE nombre_nutriente LIKE ?";

                ps = conect.prepareStatement(querybarra);
                ps.setString(1, cad+"%");

                rs = ps.executeQuery();
                tabla.setRowCount(0);

                while(rs.next()){
                    tabla.addRow(new Object[]{
                        rs.getLong("id_nutriente"),
                        rs.getString("nombre_nutriente"),
                    });
                }
                txttabla.setModel(tabla);
                cambiar_estilo(txttabla);
            }
            catch(ClassNotFoundException | SQLException e){
                msj.setForeground(Color.RED);
                msj.setText("❌ Error: "+e.getMessage());
            }
            catch(Exception e){
                msj.setForeground(Color.RED);
                msj.setText("❌ Error inesperado: "+e.getMessage());
                e.printStackTrace();
            }
            finally{
                try{
                    if(rs != null)rs.close();
                    if(ps != null)ps.close();
                    if(conect != null)conect.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
