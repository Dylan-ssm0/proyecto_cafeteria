
package Metodos;

import GUI.menu_admin;
import GUI.menu_empleado;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class metodo_inicio {
    
    public void iniciar (JFrame login, JTextField camp1, JPasswordField camp2, JLabel msj){
        
        Connection conect = null;
        PreparedStatement pslogin = null;
        ResultSet rs = null;
        
        try{
            String C1 = camp1.getText().trim();
            String C2 = camp2.getText().trim();
            
            if(C1.isEmpty() || C2.isEmpty()){
                msj.setForeground(Color.RED);
                msj.setText("Error: Todos los campos de texto son obligatorios.");
           }
            
            Conexion con = new Conexion("postgres", "12345", "localhost", "5432", "proyecto_cafeteria");
            con.ConexionPostgres();
            conect = con.getConnection();
            
            String querylogin = ("SELECT rol_usuario FROM usuario WHERE nombre_usuario = ? AND contraseña_usuario = ?");
            pslogin = conect.prepareStatement(querylogin);

            pslogin.setString(1, C1);
            pslogin.setString(2, C2);
            
            rs = pslogin.executeQuery();
            
            if(rs.next()){
               String rol = rs.getString("rol_usuario");
               JOptionPane.showMessageDialog(null, "✅ Inicio de sesión exitoso como " + rol);
               
               //Redirige según el tipo de rol
               if(rol.equalsIgnoreCase("Administrador")){
                   new menu_admin().setVisible(true);
               }
               else if (rol.equalsIgnoreCase("Empleado")){
                   new menu_empleado().setVisible(true);
               }
               login.dispose();
            }else{
                msj.setForeground(Color.RED);
                msj.setText("Usuario o contraseña incorrectos");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "❌ Error de base de datos: "+e.getMessage());
            e.printStackTrace();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "❌ Error inesperado: "+e.getMessage());
            e.printStackTrace();
        } finally{
            try {
                if (rs != null) rs.close();
                if (pslogin != null) pslogin.close();
                if (conect != null) conect.close(); // Cerrar conexión
            } 
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
