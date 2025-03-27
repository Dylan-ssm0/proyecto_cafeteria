
package Metodos;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class metodo_validaciones {
    
    
    public void validar_numero(JTextField campo, JTextField siguiente, JLabel msj) {
    String texto = campo.getText().trim(); // Elimina espacios en blanco al inicio y final

    // Primero verificamos si el campo está vacío
    if (texto.isEmpty()) {
        msj.setForeground(Color.RED);
        msj.setText("¡El campo no puede estar vacío!");
        campo.requestFocus();
        return; // Salimos de la función para evitar más validaciones innecesarias
    }

    // Luego verificamos si es un número
    for (char c : texto.toCharArray()) {
        if (!Character.isDigit(c)) {
            msj.setForeground(Color.RED);
            msj.setText("¡El formato no es correcto!");
            campo.requestFocus();
            return;
        }
    }

    // Si todo está correcto, limpiar el mensaje y mover el foco
    msj.setText("");
    if (siguiente != null) {
        siguiente.requestFocus();
    }
}

    
    public void validar_ultimo_numero(JTextField campo, JLabel msj){
        String texto =campo.getText().trim();
        
        if (texto.isEmpty()) {
        msj.setForeground(Color.RED);
        msj.setText("¡El campo no puede estar vacío!");
        campo.requestFocus();
        return; // Salimos de la función para evitar más validaciones innecesarias
    }

    // Luego verificamos si es un número
    for (char c : texto.toCharArray()) {
        if (!Character.isDigit(c)) {
            msj.setForeground(Color.RED);
            msj.setText("¡El formato no es correcto!");
            campo.requestFocus();
            return;
        }
    }

    // Si todo está correcto, limpiar el mensaje y mover el foco
    msj.setText("");
    }
    
    public void validar_texto(JTextField campo, JTextField siguiente, JLabel msj){
        String texto = campo.getText().trim();
        
        if(texto.isEmpty()){
            msj.setForeground(Color.RED);
            msj.setText("¡El campo no puede estar vacío!");
            campo.requestFocus();
            return;
        }
        if(!texto.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$")){
            msj.setForeground(Color.RED);
            msj.setText("¡El formato no es correcto!");
            campo.requestFocus();
            return;
        }
        if(texto.length()<3){
            msj.setForeground(Color.RED);
            msj.setText("¡El campo debe tener al menos 3 caracteres!");
            campo.requestFocus();
            return;
        }
        
        msj.setText("");
        if(siguiente != null){
            siguiente.requestFocus();
        }
    }
    
    public void validar_texto_area(JTextField campo, JTextArea siguiente, JLabel msj){
        String texto = campo.getText().trim();
        
         if(texto.isEmpty()){
            msj.setForeground(Color.RED);
            msj.setText("¡El campo no puede estar vacío!");
            campo.requestFocus();
            return;
        }
        if(!texto.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$")){
            msj.setForeground(Color.RED);
            msj.setText("¡El formato no es correcto!");
            campo.requestFocus();
            return;
        }
        if(texto.length()<3){
            msj.setForeground(Color.RED);
            msj.setText("¡El campo debe tener al menos 3 caracteres!");
            campo.requestFocus();
            return;
        }
        
        msj.setText("");
        if(siguiente != null){
            siguiente.requestFocus();
        }
    }
    
    public void validar_ultimo_texto(JTextField campo, JLabel msj){
        String texto = campo.getText().trim();
        
        if(texto.isEmpty()){
            msj.setForeground(Color.RED);
            msj.setText("¡El campo no puede estar vacío!");
            campo.requestFocus();
            return;
        }
        if(!texto.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$")){
            msj.setForeground(Color.RED);
            msj.setText("¡El formato no es correcto!");
            campo.requestFocus();
            return;
        }
        if(texto.length()<3){
            msj.setForeground(Color.RED);
            msj.setText("¡El campo debe tener al menos 3 caracteres!");
            campo.requestFocus();
            return;
        }
        
        msj.setText("");
    }
    
    public void validar_campo(JTextField campo, JTextField siguiente, JLabel msj){
        String texto = campo.getText().trim();
        
        if(texto.isEmpty()){
            msj.setForeground(Color.RED);
            msj.setText("¡El campo no puede estar vacío!");
            campo.requestFocus();
            return;
        }
        if(texto.length()<3){
            msj.setForeground(Color.RED);
            msj.setText("¡El campo debe tener al menos 3 caracteres!");
            campo.requestFocus();
            return;
        }
        
        msj.setText("");
        if(siguiente != null){
            siguiente.requestFocus();
        }
    }
    
    public void validar_ultimo_campo(JTextField campo, JLabel msj){
        String texto = campo.getText().trim();
        
        if(texto.isEmpty()){
            msj.setForeground(Color.RED);
            msj.setText("¡El campo no puede estar vacío!");
            campo.requestFocus();
            return;
        }
        if(texto.length()<3){
            msj.setForeground(Color.RED);
            msj.setText("¡El campo debe tener al menos 3 caracteres!");
            campo.requestFocus();
            return;
        }
        
        msj.setText("");
    }
    

}

