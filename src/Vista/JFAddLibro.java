package Vista;

import Logica.Libro;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

public class JFAddLibro extends javax.swing.JFrame {
    JTable tabla;
    Libro libro;
    /**
     * Creates new form JFAddEstudiante
     */
    public JFAddLibro(JTable tabla) {
        initComponents();
//        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.tabla = tabla;
        libro = new Libro();
        libro.actualizarTabla(tabla);
    }

    private JFAddLibro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTFCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTFNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTFGenero = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTFCantidad = new javax.swing.JTextField();
        btnCancelarLib = new javax.swing.JButton();
        btnAceptarLib = new javax.swing.JButton();

        setTitle("Añadir Libro");

        jLabel5.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabel5.setText("AÑADIENDO LIBROS");

        jLabel1.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel1.setText("Código");

        jTFCodigo.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel3.setText("Género");

        jLabel4.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel4.setText("Cantidad");

        btnCancelarLib.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelarLib.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btnCancelarLib.setText("Cancelar");
        btnCancelarLib.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarLibMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarLibMouseExited(evt);
            }
        });
        btnCancelarLib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarLibActionPerformed(evt);
            }
        });

        btnAceptarLib.setBackground(new java.awt.Color(255, 255, 255));
        btnAceptarLib.setText("Aceptar");
        btnAceptarLib.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAceptarLibMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAceptarLibMouseExited(evt);
            }
        });
        btnAceptarLib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarLibActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(79, 79, 79)
                                .addComponent(jTFNombre))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(83, 83, 83)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFCantidad)
                                    .addComponent(jTFGenero)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(85, 85, 85)
                                .addComponent(jTFCodigo)))))
                .addGap(85, 85, 85))
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(btnAceptarLib, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(btnCancelarLib, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel5)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTFCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTFGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTFCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptarLib, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarLib, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarLibActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarLibActionPerformed
        libro = new Libro(this.jTFNombre.getText(), this.jTFGenero.getText(), Integer.parseInt(this.jTFCantidad.getText()));
        boolean flag = libro.añadirLibro();
        if(flag){
            JOptionPane.showMessageDialog(null, "Datos Guardados correctamente.");
            tabla = libro.actualizarTabla(tabla);
            comewth();
        }else{
            JOptionPane.showMessageDialog (null, "Ocurrio un error al ingresar los datos ");    
        }
    }//GEN-LAST:event_btnAceptarLibActionPerformed

    private void btnCancelarLibActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarLibActionPerformed
        this.dispose();
        comewth();
    }//GEN-LAST:event_btnCancelarLibActionPerformed

    private void btnAceptarLibMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarLibMouseEntered
        this.btnAceptarLib.setBorder(new LineBorder(Color.red));
        this.btnAceptarLib.setForeground(Color.red);
    }//GEN-LAST:event_btnAceptarLibMouseEntered

    private void btnAceptarLibMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarLibMouseExited
        this.btnAceptarLib.setBorder(new LineBorder(new Color(90,130,191)));
        this.btnAceptarLib.setForeground(Color.black);
    }//GEN-LAST:event_btnAceptarLibMouseExited

    private void btnCancelarLibMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarLibMouseEntered
        this.btnCancelarLib.setBorder(new LineBorder(Color.red));
        this.btnCancelarLib.setForeground(Color.red);
    }//GEN-LAST:event_btnCancelarLibMouseEntered

    private void btnCancelarLibMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarLibMouseExited
        this.btnCancelarLib.setBorder(new LineBorder(new Color(90,130,191)));
        this.btnCancelarLib.setForeground(Color.black);
    }//GEN-LAST:event_btnCancelarLibMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFAddLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFAddLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFAddLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFAddLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFAddLibro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarLib;
    private javax.swing.JButton btnCancelarLib;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTFCantidad;
    private javax.swing.JTextField jTFCodigo;
    private javax.swing.JTextField jTFGenero;
    private javax.swing.JTextField jTFNombre;
    // End of variables declaration//GEN-END:variables

    public void comewth(){
        this.jTFCodigo.setText("");
        this.jTFNombre.setText("");
        this.jTFCantidad.setText("");
        this.jTFGenero.setText("");
    }
}