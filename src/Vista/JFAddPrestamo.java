package Vista;

import Logica.Estudiante;
import Logica.Libro;
import Logica.Prestamo;
import java.awt.Color;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

public class JFAddPrestamo extends javax.swing.JFrame {
    JTable tabla;
    Prestamo prestamo;
    Libro libro = new Libro();
    Estudiante estudiante=new Estudiante();  ;
    /**
     * Creates new form JFAddEstudiante
     */
    public JFAddPrestamo(JTable tabla) {
        initComponents();
//        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.tabla = tabla;
        prestamo = new Prestamo();
        prestamo.ActualizarTablaPrestamos(tabla);
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
        jTFCodigoPrestamo = new javax.swing.JTextField();
        jLCodigo9 = new javax.swing.JLabel();
        jLCodigo7 = new javax.swing.JLabel();
        jTFCodigoEstudiantePrestamo = new javax.swing.JTextField();
        jTFCodigoLibroPrestamo = new javax.swing.JTextField();
        jLNombres5 = new javax.swing.JLabel();
        btnAñadirPrest = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        canvas1 = new java.awt.Canvas();
        jDFechaIngreso = new com.toedter.calendar.JDateChooser();
        btnCancelarPrest = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTLibrosBusqueda2 = new javax.swing.JTable();
        jCBusquedaLibro2 = new javax.swing.JComboBox<>();
        jTFBusquedaLibro2 = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTEstudiantesBusqueda1 = new javax.swing.JTable();
        jCBusquedaEstudiante1 = new javax.swing.JComboBox<>();
        jTFBusquedaEstudiante1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setTitle("Añadir Prestamo");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Atributos"));

        jTFCodigoPrestamo.setEditable(false);

        jLCodigo9.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLCodigo9.setText("Codigo préstamo:");

        jLCodigo7.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLCodigo7.setText("Codigo estudiante:");

        jLNombres5.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLNombres5.setText("Código Libro:");

        btnAñadirPrest.setBackground(new java.awt.Color(255, 255, 255));
        btnAñadirPrest.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btnAñadirPrest.setText("Añadir");
        btnAñadirPrest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAñadirPrestMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAñadirPrestMouseExited(evt);
            }
        });
        btnAñadirPrest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirPrestActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel5.setText("Fecha \"Hasta\"");

        btnCancelarPrest.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelarPrest.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btnCancelarPrest.setText("Cancelar");
        btnCancelarPrest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarPrestMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarPrestMouseExited(evt);
            }
        });
        btnCancelarPrest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPrestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLCodigo9)
                            .addComponent(jLCodigo7)
                            .addComponent(jLNombres5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTFCodigoEstudiantePrestamo)
                            .addComponent(jTFCodigoPrestamo)
                            .addComponent(jTFCodigoLibroPrestamo)
                            .addComponent(jDFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAñadirPrest, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelarPrest, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCodigo9)
                    .addComponent(jTFCodigoPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCodigo7)
                    .addComponent(jTFCodigoEstudiantePrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNombres5)
                    .addComponent(jTFCodigoLibroPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jDFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAñadirPrest, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarPrest, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Búsqueda Libro"));

        jTLibrosBusqueda2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Cantidad", "Nombre", "Género"
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
        jTLibrosBusqueda2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTLibrosBusqueda2MouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(jTLibrosBusqueda2);

        jCBusquedaLibro2.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jCBusquedaLibro2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "codigo_l", "nombre", "genero" }));

        jTFBusquedaLibro2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFBusquedaLibro2KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jCBusquedaLibro2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTFBusquedaLibro2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBusquedaLibro2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFBusquedaLibro2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Búsqueda Estudiante"));

        jTEstudiantesBusqueda1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Cantidad", "Nombre", "Género"
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
        jTEstudiantesBusqueda1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTEstudiantesBusqueda1MouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(jTEstudiantesBusqueda1);

        jCBusquedaEstudiante1.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jCBusquedaEstudiante1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "codigo_e", "nombre", "apellidos" }));

        jTFBusquedaEstudiante1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFBusquedaEstudiante1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jCBusquedaEstudiante1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTFBusquedaEstudiante1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBusquedaEstudiante1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFBusquedaEstudiante1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabel1.setText("AÑADIENDO PRÉSTAMO A ESTUDIANTE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(230, 230, 230))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAñadirPrestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirPrestActionPerformed
          
        libro.setCodigoLibro(Integer.parseInt(jTFCodigoLibroPrestamo.getText()));
        estudiante.setCodigoEstudiante(Integer.parseInt(jTFCodigoEstudiantePrestamo.getText()));     
        prestamo= new Prestamo(estudiante, libro);
        prestamo.fechaActual();
        if(libro.LibroestaDisponible()){
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String dateDevolucion=sdf.format(jDFechaIngreso.getDate());
            if(prestamo.añadirPrestamo(dateDevolucion))
                JOptionPane.showMessageDialog (null, "El préstamo se creó apropiadamente ");
            else{
                JOptionPane.showMessageDialog (null, "Ocurrio un error al ingresar los datos ");
            }
            prestamo.setMultas();    
            prestamo.ActualizarTablaPrestamos(tabla);
                
        }else{
                JOptionPane.showMessageDialog(null, "El libro no se encuentra disponible");
            }
        
    }//GEN-LAST:event_btnAñadirPrestActionPerformed

    private void jTLibrosBusqueda2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTLibrosBusqueda2MouseClicked
        int row =jTLibrosBusqueda2.getSelectedRow();
        if (row !=-1){
            jTFCodigoLibroPrestamo.setText(Integer.toString((int)jTLibrosBusqueda2.getValueAt(row, 0)));
        }
    }//GEN-LAST:event_jTLibrosBusqueda2MouseClicked

    private void jTEstudiantesBusqueda1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTEstudiantesBusqueda1MouseClicked
        int row =jTEstudiantesBusqueda1.getSelectedRow();
        if (row !=-1 ){
            jTFCodigoEstudiantePrestamo.setText(Integer.toString((int)jTEstudiantesBusqueda1.getValueAt(row, 0)));
        }
    }//GEN-LAST:event_jTEstudiantesBusqueda1MouseClicked

    private void jTFBusquedaEstudiante1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBusquedaEstudiante1KeyReleased
        estudiante.actualizarTablaBusqueda(jTEstudiantesBusqueda1, getConsultaEstudiantes());
    }//GEN-LAST:event_jTFBusquedaEstudiante1KeyReleased

    private void jTFBusquedaLibro2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFBusquedaLibro2KeyReleased
        libro.ActualizarTablaLibrosBusqueda(jTLibrosBusqueda2, getConsultaLibros());
    }//GEN-LAST:event_jTFBusquedaLibro2KeyReleased

    private void btnCancelarPrestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPrestActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarPrestActionPerformed

    private void btnAñadirPrestMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAñadirPrestMouseEntered
        this.btnAñadirPrest.setBorder(new LineBorder(Color.red));
        this.btnAñadirPrest.setForeground(Color.red);
    }//GEN-LAST:event_btnAñadirPrestMouseEntered

    private void btnAñadirPrestMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAñadirPrestMouseExited
        this.btnAñadirPrest.setBorder(new LineBorder(new Color(90,130,191)));
        this.btnAñadirPrest.setForeground(Color.black);
    }//GEN-LAST:event_btnAñadirPrestMouseExited

    private void btnCancelarPrestMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarPrestMouseEntered
        this.btnCancelarPrest.setBorder(new LineBorder(Color.red));
        this.btnCancelarPrest.setForeground(Color.red);
    }//GEN-LAST:event_btnCancelarPrestMouseEntered

    private void btnCancelarPrestMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarPrestMouseExited
        this.btnCancelarPrest.setBorder(new LineBorder(new Color(90,130,191)));
        this.btnCancelarPrest.setForeground(Color.black);
    }//GEN-LAST:event_btnCancelarPrestMouseExited



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAñadirPrest;
    private javax.swing.JButton btnCancelarPrest;
    private java.awt.Canvas canvas1;
    private javax.swing.JComboBox<String> jCBusquedaEstudiante1;
    private javax.swing.JComboBox<String> jCBusquedaLibro2;
    private com.toedter.calendar.JDateChooser jDFechaIngreso;
    private javax.swing.JLabel jLCodigo7;
    private javax.swing.JLabel jLCodigo9;
    private javax.swing.JLabel jLNombres5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JTable jTEstudiantesBusqueda1;
    private javax.swing.JTextField jTFBusquedaEstudiante1;
    private javax.swing.JTextField jTFBusquedaLibro2;
    private javax.swing.JTextField jTFCodigoEstudiantePrestamo;
    private javax.swing.JTextField jTFCodigoLibroPrestamo;
    private javax.swing.JTextField jTFCodigoPrestamo;
    private javax.swing.JTable jTLibrosBusqueda2;
    // End of variables declaration//GEN-END:variables

public String getConsultaLibros(){
 String consulta = "";
        switch(jCBusquedaLibro2.getSelectedIndex()){
            case 0:
                consulta="codigo_l="+jTFBusquedaLibro2.getText(); 
                break;
            case 1:
                consulta="nombre='"+jTFBusquedaLibro2.getText()+"'"; 
                break;
            case 2: 
                consulta="genero='"+jTFBusquedaLibro2.getText()+"'";
                break;
    }
    return consulta;
}

public String getConsultaEstudiantes(){
        String consulta = "";
        switch(jCBusquedaEstudiante1.getSelectedIndex()){
            case 0:
                consulta="codigo_e="+jTFBusquedaEstudiante1.getText(); 
                break;
            case 1:
                consulta="nombres_e='"+jTFBusquedaEstudiante1.getText()+"'"; 
                break;
            case 2: 
                consulta="apellidos_e='"+jTFBusquedaEstudiante1.getText()+"'";
                break;
        
        }
    return consulta;
    }
}