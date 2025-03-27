
package Metodos;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class metodo_categoria {
    
    //Listar
    public void listar (JTextField camp1, JTextField camp2, JTextArea camp3, JLabel msj){
        PreparedStatement ps;
        
        try{
            long c1 =0;
            
            try{
                c1 = Long.parseLong(camp1.getText().trim());
            }
            catch(NumberFormatException e){
                msj.setForeground(Color.RED);
                msj.setText("⚠ Error: Debe rellenar todos los campos numericos.");
                return;
            }
            
            String c2 = camp2.getText().trim();
            String c3 = camp3.getText().trim();
            
            if(c2.isEmpty() || c3.isEmpty()){
                msj.setForeground(Color.RED);
                msj.setText("⚠ Error: Todos los campos de texto son obligatorios.");
                return;
            }

            Conexion con = new Conexion("postgres", "12345", "localhost", "5432", "proyecto_cafeteria");
            con.ConexionPostgres();
            
            String querylistar = "INSERT INTO categoria VALUES ("+c1+", '"+c2+"', '"+c3+"')";
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
            
            String querymostrar = "SELECT * FROM categoria";
            ps = conect.prepareStatement(querymostrar);
            rs = ps.executeQuery();
            
            while(rs.next()){
                tabla.addRow(new Object[]{
                    rs.getLong("id_categoria"),
                    rs.getString("nombre_categoria"),
                    rs.getString("descripcion_categoria"),
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
    public void buscar(JTextField camp1, JTextField camp2, JTextArea camp3, JLabel msj){
        Connection conect = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            Conexion con = new Conexion("postgres", "12345", "localhost", "5432", "proyecto_cafeteria");
            con.ConexionPostgres();
            conect = con.getConnection();
            
            String querybuscar = "SELECT * FROM categoria WHERE id_categoria = ?";
            ps = conect.prepareStatement(querybuscar);
            
            long buscar = Long.parseLong(JOptionPane.showInputDialog("Ingrese el registro de la categoria que desee buscar: "));
            ps.setLong(1, buscar);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                
                camp1.setText(rs.getString("id_categoria"));
                camp2.setText(rs.getString("nombre_categoria"));
                camp3.setText(rs.getString("descripcion_categoria"));
                
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
    public void editar (JTextField camp1, JTextField camp2, JTextArea camp3, JTable tabla, JLabel msj){
        
        Connection conect = null;
        PreparedStatement ps = null;
        
        try{
            Conexion con = new Conexion("postgres", "12345", "localhost", "5432", "proyecto_cafeteria");
            con.ConexionPostgres();
            conect = con.getConnection();
            
            String queryeditar  = "UPDATE categoria SET nombre_categoria = ?,  "
                    + "descripcion_categoria = ? WHERE id_categoria = ? ";
                    
            ps = conect.prepareStatement(queryeditar);
            
            int fila_seleccionada = tabla.getSelectedRow();
            if(fila_seleccionada == -1){
                msj.setForeground(Color.RED);
                msj.setText("Debe seleccionar un registro para editar.");
                return;
            }
            
            long c1 = Long.parseLong(camp1.getText().trim());
            
            String c2 = camp2.getText().trim();
            String c3 = camp3.getText().trim();
            
            ps.setString(1, c2);
            ps.setString(2, c3);
            ps.setLong(3, c1);
            
            int fila_afectada = ps.executeUpdate();
            if(fila_afectada>0){
                tabla.setValueAt(c1, fila_seleccionada, 0);
                tabla.setValueAt(c2, fila_seleccionada, 1);
                tabla.setValueAt(c3, fila_seleccionada, 2);
                
                msj.setForeground(Color.GREEN);
                msj.setText("Registro editado con éxito");
                camp1.setText("");
                camp2.setText("");
                camp3.setText("");
            }
            else{
                msj.setForeground(Color.RED);
                msj.setText("No se encontró una Categoria con esa ID.");
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
        
        PreparedStatement ps;
        
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
                 
                 String queryeliminar = "DELETE FROM categoria WHERE id_categoria = ? ";
                 ps = con.getConnection().prepareStatement(queryeliminar);
                 ps.setLong(1, cc);
                 
                 int FilasAfectadas = ps.executeUpdate();
             
                 if(FilasAfectadas > 0){
                     msj.setForeground(Color.GREEN);
                     msj.setText("Categoria eliminada con éxito.");
                     tabla.removeRow(fila_seleccionada);
                 }
                 else{
                    msj.setForeground(Color.RED);
                    msj.setText("No se ha encontrado la categoria");
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
