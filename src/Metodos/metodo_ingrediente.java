/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metodos;

import Clases.nutriente;
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class metodo_ingrediente {
    
    public void añadir(JTable camp, List<Long> lista_nutriente, JLabel msj){
        
        int fila_seleccionada = camp.getSelectedRow();
    
        if (fila_seleccionada == -1) {  
        msj.setForeground(Color.RED);
        msj.setText("⚠ Error: Seleccione un producto antes de agregarlo.");
        return;
        }

        // Obtener valores de la fila seleccionada
        Object idNutriente = camp.getValueAt(fila_seleccionada, 0);

        if (idNutriente != null) {
            long id = Long.parseLong(idNutriente.toString());

            // Verificar que el nutriente no esté repetido en la lista
            if (!lista_nutriente.contains(id)) {
                lista_nutriente.add(id);
                msj.setForeground(Color.GREEN);
                msj.setText("✅ Producto agregado con éxito.");
            } else {
                msj.setForeground(Color.ORANGE);
                msj.setText("⚠ El producto ya ha sido agregado.");
            }
        } else {
            msj.setForeground(Color.RED);
            msj.setText("⚠ Error: No se pudo obtener el producto.");
        }
    }
    
    public void listar(JTextField camp1, JTextField camp2, JTextArea camp4, DefaultTableModel tabla, JLabel msj, List<Long> lista_nutriente) {
    PreparedStatement ps = null;
    Connection conn = null;

    try {
        // Validar que los campos obligatorios estén llenos
        long c1;
        try {
            c1 = Long.parseLong(camp1.getText().trim());
        } catch (NumberFormatException e) {
            msj.setForeground(Color.RED);
            msj.setText("⚠ Error: Debe rellenar todos los campos numéricos.");
            return;
        }

        String c2 = camp2.getText().trim();
        String c4 = camp4.getText().trim();

        if (c2.isEmpty() || c4.isEmpty()) {
            msj.setForeground(Color.RED);
            msj.setText("⚠ Error: Todos los campos de texto son obligatorios.");
            return;
        }

        // Validar que haya al menos un nutriente seleccionado
        if (lista_nutriente.isEmpty()) {
            msj.setForeground(Color.RED);
            msj.setText("⚠ Error: Debe agregar al menos un nutriente.");
            return;
        }

        // Establecer conexión a la base de datos
        Conexion con = new Conexion("postgres", "12345", "localhost", "5432", "proyecto_cafeteria");
        con.ConexionPostgres();  // Establecer la conexión
        conn = con.getConnection();  // Obtener la conexión

        if (conn == null) {
            msj.setForeground(Color.RED);
            msj.setText("⚠ Error: No se pudo conectar a la base de datos.");
            return;
        }

        // Convertir lista de nutrientes en un ARRAY de PostgreSQL
        Long[] arrayNutrientes = lista_nutriente.toArray(new Long[0]); 
        java.sql.Array sqlArray = conn.createArrayOf("bigint", arrayNutrientes); // Convertir en ARRAY de PostgreSQL

        // Consulta corregida
        String queryIngrediente = "INSERT INTO ingrediente (id_ingrediente, id_nutriente, nombre_ingrediente, descripcion_ingrediente) VALUES (?, ?, ?, ?)";
        ps = conn.prepareStatement(queryIngrediente);
        ps.setLong(1, c1);
        ps.setArray(2, sqlArray);  // Usar el ARRAY de PostgreSQL
        ps.setString(3, c2);
        ps.setString(4, c4);

        int filasInsertadas = ps.executeUpdate();

        if (filasInsertadas > 0) {
            msj.setForeground(Color.GREEN);
            msj.setText("✅ Ingrediente y nutrientes guardados con éxito.");
        } else {
            msj.setForeground(Color.RED);
            msj.setText("⚠ Error: No se pudo guardar el ingrediente.");
        }

        // Limpiar los campos y la lista
        camp1.setText("");
        camp2.setText("");
        camp4.setText("");
        lista_nutriente.clear();

    } catch (Exception e) {
        Logger.getLogger(metodo_cliente.class.getName()).log(Level.SEVERE, null, e);
        JOptionPane.showMessageDialog(null, "⚠ Error inesperado: " + e.getMessage());
    } finally {
        try {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
            
            String querymostrar = "SELECT * FROM ingrediente";
            ps = conect.prepareStatement(querymostrar);
            rs = ps.executeQuery();
            
            while(rs.next()){
                tabla.addRow(new Object[]{
                    rs.getLong("id_ingrediente"),
                    rs.getString("nombre_ingrediente"),
                    rs.getArray("id_nutriente"),
                    rs.getString("descripcion_ingrediente"),
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
            
            String querybuscar = "SELECT * FROM ingrediente WHERE id_ingrediente = ?";
            ps = conect.prepareStatement(querybuscar);
            
            long buscar = Long.parseLong(JOptionPane.showInputDialog("Ingrese el registro del usuario que desee buscar: "));
            ps.setLong(1, buscar);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                
                camp1.setText(rs.getString("id_ingrediente"));
                camp2.setText(rs.getString("nombre_ingrediente"));
                camp3.setText(rs.getString("descripcion_ingrediente"));
                
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
     public void editar (JTextField camp1, JTextField camp2, JTextArea camp3, List<Long> lista_nutriente, JTable tabla, JLabel msj){
        Connection conect = null;
        PreparedStatement ps = null;
        
        try{
            Conexion con = new Conexion("postgres", "12345", "localhost", "5432", "proyecto_cafeteria");
            con.ConexionPostgres();
            conect = con.getConnection();
            
            int fila_seleccionada = tabla.getSelectedRow();
            if(fila_seleccionada == -1){
                msj.setForeground(Color.RED);
                msj.setText("Debe seleccionar un registro para editar.");
                return;
            }
            
             long c1 = Long.parseLong(camp1.getText().trim());
            String c2 = camp2.getText().trim();
            String c3 = camp3.getText().trim();
            
            Long[] array_nutriente = lista_nutriente.toArray(new Long[0]);
            java.sql.Array sqlArray = conect.createArrayOf("bigint", array_nutriente);
            
            String queryEditar = "UPDATE ingrediente SET nombre_ingrediente = ?, id_nutriente = ?, descripcion_ingrediente = ? WHERE id_ingrediente = ?";
            ps = conect.prepareStatement(queryEditar);
            
            ps.setString(1, c2);
            ps.setArray(2, sqlArray); 
            ps.setString(3, c3);
            ps.setLong(4, c1);

            int fila_afectada = ps.executeUpdate();
            if(fila_afectada>0){
                tabla.setValueAt(c1, fila_seleccionada, 0);
                tabla.setValueAt(c2, fila_seleccionada, 1);
                tabla.setValueAt(lista_nutriente.toString(), fila_seleccionada, 2);
                tabla.setValueAt(c3, fila_seleccionada, 3);
                
                msj.setForeground(Color.GREEN);
                msj.setText("Registro editado con éxito");
                camp1.setText("");
                camp2.setText("");
                camp3.setText("");
                lista_nutriente.clear();
            }
            else{
                msj.setForeground(Color.RED);
                msj.setText("No se encontró un ingrediente con ese ID.");
            }
        }
        catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "❌ Error: el ID debe ser un número válido.");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "❌ Error de base de datos: " + e.getMessage());
        e.printStackTrace();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "❌ Error inesperado: " + e.getMessage());
        e.printStackTrace();
    } finally {
        try {
            if (ps != null) ps.close();
            if (conect != null) conect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
     }
     
     
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
                 
                 String queryeliminar = "DELETE FROM ingrediente WHERE id_ingrediente = ? ";
                 ps = con.getConnection().prepareStatement(queryeliminar);
                 ps.setLong(1, cc);
                 
                 int FilasAfectadas = ps.executeUpdate();
             
                 if(FilasAfectadas > 0){
                     msj.setForeground(Color.GREEN);
                     msj.setText("Ingrediente eliminado con éxito.");
                     tabla.removeRow(fila_seleccionada);
                 }
                 else{
                    msj.setForeground(Color.RED);
                    msj.setText("No se ha encontrado el ingrediente");
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
