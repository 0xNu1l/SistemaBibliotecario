/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Logica.Estudiante;
import Logica.Libro;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

/**
 *
 * @author PC
 */
public class JFModificarLibro extends javax.swing.JFrame {
Libro libro;
JTable tabla;
    public JFModificarLibro(JTable tabla) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.tabla = tabla;
        this.libro = new Libro();
        libro.actualizarTabla(tabla);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel11 = new javax.swing.JPanel();
        jCNombreLibro = new javax.swing.JCheckBox();
        jCGeneroLibro = new javax.swing.JCheckBox();
        jTFCodigoLibroActualizar = new javax.swing.JTextField();
        jTFNombreLibroActualizar = new javax.swing.JTextField();
        jTFGeneroLibroActualizar = new javax.swing.JTextField();
        jTFCantidadActualizarLibros = new javax.swing.JTextField();
        jCCantidadLibro = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTLibrosBusqueda = new javax.swing.JTable();
        jCBusquedaLibro = new javax.swing.JComboBox<>();
        jTFBusquedaLibro = new javax.swing.JTextField();
        btnActualizarLib = new javax.swing.JButton();
        btnEliminarLib = new javax.swing.JButton();
        btnCancelarLib = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setTitle("Actualizar y eliminar Libros");

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Atributos a actualizar"));

        jCNombreLibro.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jCNombreLibro.setText("Nombre");
        jCNombreLibro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCNombreLibro.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCNombreLibroStateChanged(evt);
            }
        });

        jCGeneroLibro.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jCGeneroLibro.setText("G??nero");
        jCGeneroLibro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCGeneroLibro.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCGeneroLibroStateChanged(evt);
            }
        });

        jTFCodigoLibroActualizar.setEditable(false);

        jTFNombreLibroActualizar.setEditable(false);

        jTFGeneroLibroActualizar.setEditable(false);

        jTFCantidadActualizarLibros.setEditable(false);

        jCCantidadLibro.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jCCantidadLibro.setText("Cantidad");
        jCCantidadLibro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCCantidadLibro.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCCantidadLibroStateChanged(evt);
            }
        });
        jCCantidadLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCCantidadLibroActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel2.setText("C??digo:");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCNombreLibro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jCCantidadLibro)
                                        .addGap(0, 8, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jCGeneroLibro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(31, 31, 31)))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTFCantidadActualizarLibros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFCodigoLibroActualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFNombreLibroActualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFGeneroLibroActualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFCodigoLibroActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCCantidadLibro)
                    .addComponent(jTFCantidadActualizarLibros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCNombreLibro)
                    .addComponent(jTFNombreLibroActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCGeneroLibro)
                    .addComponent(jTFGeneroLibroActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("B??squeda"));

        jTLibrosBusqueda.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jTLibrosBusqueda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "C??digo", "Cantidad", "Nombre", "G??nero"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTLibrosBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTLibrosBusquedaMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTLibrosBusqueda);

        jCBusquedaLibro.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jCBusquedaLibro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "codigo_l", "nombre", "genero" }));

        jTFBusquedaLibro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFBusquedaLibroKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jCBusquedaLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTFBusquedaLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBusquedaLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFBusquedaLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        btnActualizarLib.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizarLib.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btnActualizarLib.setText("Actualizar");
        btnActualizarLib.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnActualizarLibMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnActualizarLibMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnActualizarLibMousePressed(evt);
            }
        });
        btnActualizarLib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarLibActionPerformed(evt);
            }
        });

        btnEliminarLib.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarLib.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btnEliminarLib.setText("Eliminar");
        btnEliminarLib.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarLibMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarLibMouseExited(evt);
            }
        });
        btnEliminarLib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarLibActionPerformed(evt);
            }
        });

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

        jLabel1.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabel1.setText("ACTUALIZAR Y ELIMINAR LIBROS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addComponent(btnActualizarLib, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnEliminarLib, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnCancelarLib, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizarLib, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarLib, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarLib, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCNombreLibroStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCNombreLibroStateChanged
        Checkboxcambio(jCNombreLibro, jTFNombreLibroActualizar);
    }//GEN-LAST:event_jCNombreLibroStateChanged

    private void jCGeneroLibroStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCGeneroLibroStateChanged
        Checkboxcambio(jCGeneroLibro, jTFGeneroLibroActualizar);
    }//GEN-LAST:event_jCGeneroLibroStateChanged

    private void jCCantidadLibroStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCCantidadLibroStateChanged
        Checkboxcambio(jCCantidadLibro, jTFCantidadActualizarLibros);
    }//GEN-LAST:event_jCCantidadLibroStateChanged

    private void jCCantidadLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCCantidadLibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCCantidadLibroActionPerformed

    private void jTLibrosBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTLibrosBusquedaMouseClicked
        int row =jTLibrosBusqueda.getSelectedRow();
        if (row !=-1 ){
            jTFCodigoLibroActualizar.setText(Integer.toString((int)jTLibrosBusqueda.getValueAt(row, 0)));
            jTFCantidadActualizarLibros.setText(Integer.toString((int)jTLibrosBusqueda.getValueAt(row, 1)));
            jTFNombreLibroActualizar.setText((String)jTLibrosBusqueda.getValueAt(row, 2));
            jTFGeneroLibroActualizar.setText((String)jTLibrosBusqueda.getValueAt(row, 3));
        }
    }//GEN-LAST:event_jTLibrosBusquedaMouseClicked

    private void btnActualizarLibActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarLibActionPerformed
        ArrayList<String> atributosActualizar = new ArrayList<String>();

        String consulta = "";
        atributosActualizar.add("codigo_l="+jTFCodigoLibroActualizar.getText());
        if (jCNombreLibro.isSelected()){atributosActualizar.add("nombre='"+jTFNombreLibroActualizar.getText()+"'");}
        if (jCGeneroLibro.isSelected()){atributosActualizar.add("genero='"+jTFGeneroLibroActualizar.getText()+"'");}
        if (jCCantidadLibro.isSelected()){atributosActualizar.add("cantidad='"+jTFCantidadActualizarLibros.getText()+"'");}

        Iterator<String> i = atributosActualizar.iterator();

        while (i.hasNext()){
            consulta += i.next() +",";
        }
        consulta = consulta.substring (0, consulta.length()-1);
        String condicion = "'" +jTFCodigoLibroActualizar.getText () + "'";
        String sql = "UPDATE Libro SET "+ consulta + " WHERE codigo_l " + " LIKE "+condicion;


        if(libro.actualizarLibro(sql))
            JOptionPane.showMessageDialog(null, "Datos Actualizados correctamente. ");
        else{
            JOptionPane.showMessageDialog (null, "Ocurrio un error al Actualizar los datos ");  
        }
        
        libro.actualizarTabla(tabla);
        libro.ActualizarTablaLibrosBusqueda(jTLibrosBusqueda, getConsulta());
    }//GEN-LAST:event_btnActualizarLibActionPerformed

    private void btnEliminarLibActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarLibActionPerformed

        if(0==JOptionPane.showConfirmDialog(null, "??Esta seguro de borrar "+jTFNombreLibroActualizar.getText()+" ?","Advertencia",JOptionPane.INFORMATION_MESSAGE)){
            libro.setCodigoLibro(Integer.parseInt(jTFCodigoLibroActualizar.getText()));
            if(libro.eliminarLibro()){
                JOptionPane.showMessageDialog(null, "Registro eliminado correctamente.");
            }else{
                JOptionPane.showMessageDialog (null, "Ocurrio un error al eliminar los datos ");
            }
            jTFCodigoLibroActualizar.setText("");
            jTFCantidadActualizarLibros.setText("");
            jTFNombreLibroActualizar.setText("");
            jTFGeneroLibroActualizar.setText("");
            libro.actualizarTabla(tabla);
        }
    }//GEN-LAST:event_btnEliminarLibActionPerformed

    private void jTFBusquedaLibroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBusquedaLibroKeyReleased
        libro.ActualizarTablaLibrosBusqueda(jTLibrosBusqueda, getConsulta());
    }//GEN-LAST:event_jTFBusquedaLibroKeyReleased

    private void btnCancelarLibActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarLibActionPerformed
       this.setVisible(false);
    }//GEN-LAST:event_btnCancelarLibActionPerformed

    private void btnActualizarLibMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarLibMouseEntered
        this.btnActualizarLib.setBorder(new LineBorder(Color.red));
        this.btnActualizarLib.setForeground(Color.red);
    }//GEN-LAST:event_btnActualizarLibMouseEntered

    private void btnActualizarLibMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarLibMousePressed

    }//GEN-LAST:event_btnActualizarLibMousePressed

    private void btnEliminarLibMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarLibMouseEntered
        this.btnEliminarLib.setBorder(new LineBorder(Color.red));
        this.btnEliminarLib.setForeground(Color.red);
    }//GEN-LAST:event_btnEliminarLibMouseEntered

    private void btnEliminarLibMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarLibMouseExited
        this.btnEliminarLib.setBorder(new LineBorder(new Color(90,130,191)));
        this.btnEliminarLib.setForeground(Color.black);
    }//GEN-LAST:event_btnEliminarLibMouseExited

    private void btnCancelarLibMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarLibMouseEntered
        this.btnCancelarLib.setBorder(new LineBorder(Color.red));
        this.btnCancelarLib.setForeground(Color.red);
    }//GEN-LAST:event_btnCancelarLibMouseEntered

    private void btnCancelarLibMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarLibMouseExited
        this.btnCancelarLib.setBorder(new LineBorder(new Color(90,130,191)));
        this.btnCancelarLib.setForeground(Color.black);
    }//GEN-LAST:event_btnCancelarLibMouseExited

    private void btnActualizarLibMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarLibMouseExited
        this.btnActualizarLib.setBorder(new LineBorder(new Color(90,130,191)));
        this.btnActualizarLib.setForeground(Color.black);
    }//GEN-LAST:event_btnActualizarLibMouseExited




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarLib;
    private javax.swing.JButton btnCancelarLib;
    private javax.swing.JButton btnEliminarLib;
    private javax.swing.JComboBox<String> jCBusquedaLibro;
    private javax.swing.JCheckBox jCCantidadLibro;
    private javax.swing.JCheckBox jCGeneroLibro;
    private javax.swing.JCheckBox jCNombreLibro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField jTFBusquedaLibro;
    private javax.swing.JTextField jTFCantidadActualizarLibros;
    private javax.swing.JTextField jTFCodigoLibroActualizar;
    private javax.swing.JTextField jTFGeneroLibroActualizar;
    private javax.swing.JTextField jTFNombreLibroActualizar;
    private javax.swing.JTable jTLibrosBusqueda;
    // End of variables declaration//GEN-END:variables

    public void Checkboxcambio(javax.swing.JCheckBox jCheckBox, javax.swing.JTextField jTField ){
        if(jCheckBox.isSelected()){
            jTField.setEditable(true);
        }else{
             jTField.setEditable(false);
        }
}
    public String getConsulta(){
     String consulta = "";
        switch(jCBusquedaLibro.getSelectedIndex()){
            case 0:
                consulta="codigo_l="+jTFBusquedaLibro.getText(); 
                break;
            case 1:
                consulta="nombre='"+jTFBusquedaLibro.getText()+"'"; 
                break;
            case 2: 
                consulta="genero='"+jTFBusquedaLibro.getText()+"'";
                break;
        
        }
        return consulta;
    }
}
