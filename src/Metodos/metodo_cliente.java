
package Metodos;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class metodo_cliente {
    
    
    //Listar
    public void listar (JTextField camp1, JTextField camp2, JTextField camp3, JTextField camp4, JTextField camp5, JTextField camp6, JDateChooser camp7, JComboBox camp8, JLabel msj){
        PreparedStatement ps = null;
        
        try{
            long c1 =0;
            long c4 =0;
            
            try{
                c1 = Long.parseLong(camp1.getText().trim());
                c4 =  Long.parseLong(camp4.getText().trim());
            }
            catch(NumberFormatException e){
                msj.setForeground(Color.RED);
                msj.setText("⚠ Error: Debe rellenar todos los campos numericos.");
                return;
            }
            
            String c2 = camp2.getText().trim();
            String c3 = camp3.getText().trim();
            String c5 = camp5.getText().trim();
            String c6 = camp6.getText().trim();
            
            if(c2.isEmpty() || c3.isEmpty() || c5.isEmpty() || c6.isEmpty()){
                msj.setForeground(Color.RED);
                msj.setText("⚠ Error: Todos los campos de texto son obligatorios.");
                return;
            }
            
            Date c7 = camp7.getDate();
            Object obj8 = camp8.getSelectedItem();
            
            if(c7 == null || obj8 == null){
                msj.setForeground(Color.RED);
                msj.setText("⚠ Error: debe llenar los campos de selección.");
                return;
            }
            
            String c8 = obj8.toString();
            
            Conexion con = new Conexion("postgres", "12345", "localhost", "5432", "proyecto_cafeteria");
            con.ConexionPostgres();
            
            String querylistar = "INSERT INTO cliente VALUES ("+c1+", '"+c2+"', '"+c3+"' , "+c4+" , '"+c5+"' , '"+c6+"' , '"+c7+"' , '"+c8+"')";
            ps = con.getConnection().prepareStatement(querylistar);

            int rowsInserted = ps.executeUpdate();

            if (rowsInserted > 0) {
                msj.setForeground(Color.GREEN);
                msj.setText("Registro guardado con éxito.");
            } else {
                msj.setForeground(Color.RED);
                msj.setText("⚠ Error: No se pudo guardar el registro.");
            }
            
            ps.close();
            con.cerrar();
            
            camp1.setText("");
            camp2.setText("");
            camp3.setText("");
            camp4.setText("");
            camp5.setText("");
            camp6.setText("");
            camp7.setDate(null);
            camp8.setSelectedIndex(0);
        }
        catch(Exception ex){
            Logger.getLogger(metodo_cliente.class.getName()).log(Level.SEVERE, null, ex);
            msj.setForeground(Color.RED);
            msj.setText("⚠ Error inesperado: " + ex.getMessage());
        }
    }
    
    
    //Mostrar
    public void mostrar(DefaultTableModel tabla, JLabel msj){
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            Conexion con = new Conexion("postgres", "12345", "localhost", "5432", "proyecto_cafeteria");
            con.ConexionPostgres();
            conect = con.getConnection();
            tabla.setRowCount(0);
            
            String querymostrar = "SELECT * FROM cliente";
            ps = conect.prepareStatement(querymostrar);
            rs = ps.executeQuery();
            
            while(rs.next()){
                tabla.addRow(new Object[]{
                    rs.getLong("cedula_cliente"),
                    rs.getString("nombre_cliente"),
                    rs.getString("apellido_cliente"),
                    rs.getLong("telefono_cliente"),
                    rs.getString("email_cliente"),
                    rs.getString("direccion_cliente"),
                    rs.getDate("fecha_nacimiento_cliente"),
                    rs.getString("genero_cliente")
                });
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "❌ Error de base de datos: "+e.getMessage());
            e.printStackTrace();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,  "❌ Error inesperado: "+e.getMessage());
            e.printStackTrace();
        }
        finally{
            try{
                if (conect != null) conect.isClosed();
                if (ps != null) ps.isClosed();
                if (rs != null) rs.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    
    //Buscar 
    public void buscar(JTextField camp1, JTextField camp2, JTextField camp3, JTextField camp4, JTextField camp5, JTextField camp6, JDateChooser camp7, JComboBox camp8, JLabel msj){
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            Conexion con = new Conexion("postgres", "12345", "localhost", "5432", "proyecto_cafeteria");
            con.ConexionPostgres();
            conect = con.getConnection();
            
            String querybuscar = "SELECT * FROM cliente WHERE cedula_cliente = ?";
            ps = conect.prepareStatement(querybuscar);
            
            long buscar = Long.parseLong(JOptionPane.showInputDialog("Ingrese el registro del usuario que desee buscar: "));
            ps.setLong(1, buscar);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                
                camp1.setText(rs.getString("cedula_cliente"));
                camp2.setText(rs.getString("nombre_cliente"));
                camp3.setText(rs.getString("apellido_cliente"));
                camp4.setText(rs.getString("telefono_cliente"));
                camp5.setText(rs.getString("email_cliente"));
                camp6.setText(rs.getString("direccion_cliente"));
                
                Date fecha_nacimiento = rs.getDate("fecha_nacimiento_cliente");
                camp7.setDate(fecha_nacimiento !=null? fecha_nacimiento: new Date());
                camp8.setSelectedItem("genero_cliente");
                
                msj.setForeground(Color.GREEN);
                msj.setText("Registro encontrado.");
                return;
            }
            
            msj.setForeground(Color.RED);
            msj.setText("Registro no encontrado.");
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,  "❌ Error: Ingrese un número válido.");
        }
        catch(SQLException e){
            JOptionPane.showConfirmDialog(null, "❌ Error de base de datos: " + e.getMessage());
            e.printStackTrace();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "❌ Error inesperado: "+e.getMessage());
            e.printStackTrace();
        }
        finally{
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conect != null) conect.close(); 
            } 
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    //Editar 
    public void editar (JTextField camp1, JTextField camp2, JTextField camp3, JTextField camp4, JTextField camp5, JTextField camp6, JDateChooser camp7, JComboBox camp8, JTable tabla, JLabel msj){
        
        Connection conect = null;
        PreparedStatement ps = null;
        
        try{
            Conexion con = new Conexion("postgres", "12345", "localhost", "5432", "proyecto_cafeteria");
            con.ConexionPostgres();
            conect = con.getConnection();
            
            String queryeditar  = "UPDATE cliente SET nombre_cliente = ?,  "
                    + "apellido_cliente = ?,  telefono_cliente = ?,  email_cliente = ?,  "
                    + " direccion_cliente = ?,  fecha_nacimiento_cliente = ?,  "
                    + "genero_cliente = ? WHERE cedula_cliente = ? ";
                    
            ps = conect.prepareStatement(queryeditar);
            
            int fila_seleccionada = tabla.getSelectedRow();
            if(fila_seleccionada == -1){
                msj.setForeground(Color.RED);
                msj.setText("Debe seleccionar un registro para editar.");
                return;
            }
            
            long c1 = Long.parseLong(camp1.getText().trim());
            long c4 = Long.parseLong(camp4.getText().trim());
            
            String c2 = camp2.getText().trim();
            String c3 = camp3.getText().trim();
            String c5 = camp5.getText().trim();
            String c6 = camp6.getText().trim();
            
            java.sql.Date c7 = new java.sql.Date(camp7.getDate().getTime());
            
            Object obj8 = camp8.getSelectedItem();
            String c8 = obj8.toString();
            
            ps.setString(1, c2);
            ps.setString(2, c3);
            ps.setLong(3, c4);
            ps.setString(4, c5);
            ps.setString(5, c6);
            ps.setDate(6, c7);
            ps.setString(7, c8);
            ps.setLong(8, c1);
            
            int fila_afectada = ps.executeUpdate();
            if(fila_afectada>0){
                tabla.setValueAt(c1, fila_seleccionada, 0);
                tabla.setValueAt(c2, fila_seleccionada, 1);
                tabla.setValueAt(c3, fila_seleccionada, 2);
                tabla.setValueAt(c4, fila_seleccionada, 3);
                tabla.setValueAt(c5, fila_seleccionada, 4);
                tabla.setValueAt(c6, fila_seleccionada, 5);
                tabla.setValueAt(c7, fila_seleccionada, 6);
                tabla.setValueAt(c8, fila_seleccionada, 7);
                
                msj.setForeground(Color.GREEN);
                msj.setText("Registro editado con éxito");
                camp1.setText("");
                camp2.setText("");
                camp3.setText("");
                camp4.setText("");
                camp5.setText("");
                camp6.setText("");
                camp7.setDate(null);
                camp8.setSelectedIndex(0);
            }
            else{
                msj.setForeground(Color.RED);
                msj.setText("No se encontró un Empleado con esa Cédula.");
            }
        }
        catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "❌ Error: el contenido de los campos numéricos debe ser válido.");
         } 
        catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "❌ Error de base de datos: " + e.getMessage());
        e.printStackTrace();
        } 
        catch (Exception e) {
        JOptionPane.showMessageDialog(null, "❌ Ocurrió un error al editar el empleado: " + e.getMessage());
        e.printStackTrace();
        } 
        finally {
            try {
                if (ps != null) ps.close();
                if (conect != null) conect.close();
            } 
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    //Eliminar
    public void eliminar(DefaultTableModel tabla, JTable txttabla, JLabel msj){
        
        PreparedStatement ps = null;
        
        int fila_seleccionada = txttabla.getSelectedRow();
        
        if(fila_seleccionada == -1){
                msj.setForeground(Color.RED);
                msj.setText("Debe seleccionar un registro para eliminar.");
                return;
            }
        
        int confirmacion = JOptionPane.showConfirmDialog(null, 
        "¿Está seguro de eliminar la línea seleccionada?", 
        "Confirmación de Eliminación", 
        JOptionPane.YES_NO_OPTION, 
        JOptionPane.WARNING_MESSAGE);
        
            if(confirmacion == JOptionPane.YES_OPTION){
             try {
                 long cc = Long.parseLong(tabla.getValueAt(fila_seleccionada, 0).toString());
                 
                 Conexion  con= new Conexion("postgres", "12345", "localhost", "5432", "proyecto_cafeteria");
                 con.ConexionPostgres();
                 
                 String queryeliminar = "DELETE FROM cliente WHERE cedula_cliente = ? ";
                 ps = con.getConnection().prepareStatement(queryeliminar);
                 ps.setLong(1, cc);
                 
                 int FilasAfectadas = ps.executeUpdate();
             
                 if(FilasAfectadas > 0){
                     msj.setForeground(Color.GREEN);
                     msj.setText("Cliente eliminado con éxito.");
                     tabla.removeRow(fila_seleccionada);
                 }
                 else{
                    msj.setForeground(Color.RED);
                    msj.setText("No se ha encontrado el cliente");
                 }
                 
                 ps.close();
                 con.cerrar();
             }
             catch(Exception ex){
                 JOptionPane.showMessageDialog(null, "⚠ Error al eliminar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
             }
            }
    }
}
    
    
    

