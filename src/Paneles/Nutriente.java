/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paneles;

/**
 *
 * @author ASUS
 */
public class Nutriente extends javax.swing.JPanel {

    /**
     * Creates new form Nutriente
     */
    public Nutriente() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txttabla = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        btnListar = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();
        btnMostrar = new javax.swing.JButton();
        advID = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        lblNom = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        txtnombre = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        advNom = new javax.swing.JLabel();
        barra = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(245, 225, 200));

        jTable1.setBackground(new java.awt.Color(255, 248, 231));
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 122, 95), 2));
        jTable1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(75, 46, 46));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txttabla.setViewportView(jTable1);

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(75, 46, 46));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Nutrientes");

        lblID.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblID.setForeground(new java.awt.Color(75, 46, 46));
        lblID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID.setText("ID");

        btnListar.setBackground(new java.awt.Color(174, 97, 40));
        btnListar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnListar.setForeground(new java.awt.Color(255, 255, 255));
        btnListar.setText("LISTAR");
        btnListar.setBorder(null);

        txtid.setBackground(new java.awt.Color(255, 248, 231));
        txtid.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtid.setForeground(new java.awt.Color(75, 46, 46));
        txtid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 122, 95), 2));

        btnMostrar.setBackground(new java.awt.Color(174, 97, 40));
        btnMostrar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnMostrar.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrar.setText("MOSTRAR");
        btnMostrar.setBorder(null);

        advID.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        advID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnBuscar.setBackground(new java.awt.Color(174, 97, 40));
        btnBuscar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("BUSCAR");
        btnBuscar.setBorder(null);

        lblNom.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNom.setForeground(new java.awt.Color(75, 46, 46));
        lblNom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNom.setText("NOMBRE");

        btnEditar.setBackground(new java.awt.Color(174, 97, 40));
        btnEditar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("EDITAR");
        btnEditar.setBorder(null);

        txtnombre.setBackground(new java.awt.Color(255, 248, 231));
        txtnombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtnombre.setForeground(new java.awt.Color(75, 46, 46));
        txtnombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 122, 95), 2));

        btnEliminar.setBackground(new java.awt.Color(174, 97, 40));
        btnEliminar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorder(null);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        advNom.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        advNom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        barra.setBackground(new java.awt.Color(255, 248, 231));
        barra.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        barra.setForeground(new java.awt.Color(75, 46, 46));
        barra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 122, 95), 2));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(advID, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(advNom, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNom, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(barra)
                    .addComponent(txttabla))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(advID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(advNom, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(barra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttabla, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel advID;
    private javax.swing.JLabel advNom;
    private javax.swing.JTextField barra;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNom;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JScrollPane txttabla;
    // End of variables declaration//GEN-END:variables
}
