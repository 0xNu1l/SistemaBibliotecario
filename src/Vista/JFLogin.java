package Vista;

import ConexionBD.ConexionBD;
import Logica.Login;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class JFLogin extends javax.swing.JFrame {
    ConexionBD con = new ConexionBD();
    Login logi = new Login();
    JFCrearUsuario jfcrearusuario;
    
    public JFLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
        scaleImage();
        this.jfcrearusuario = new JFCrearUsuario();
    }
    //Escalar imagenes
    public void scaleImage() {
        //login
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/iconoLogin.png"));
        Image image = (icon).getImage().getScaledInstance(iconLogin.getWidth(), iconLogin.getHeight(), Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        iconLogin.setIcon(icon);
        //user
        ImageIcon iconUser = new ImageIcon(getClass().getResource("/Imagenes/user.png"));
        Image imageUser = (iconUser).getImage().getScaledInstance(iconoUser.getWidth(), iconoUser.getHeight(), Image.SCALE_SMOOTH);
        iconUser = new ImageIcon(imageUser);
        iconoUser.setIcon(iconUser);
        //pasword
        ImageIcon iconPass = new ImageIcon(getClass().getResource("/Imagenes/lock.png"));
        Image imagePass = (iconPass).getImage().getScaledInstance(iconoPass.getWidth(), iconoPass.getHeight(), Image.SCALE_SMOOTH);
        iconPass = new ImageIcon(imagePass);
        iconoPass.setIcon(iconPass);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        iconLogin = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        iconoUser = new javax.swing.JLabel();
        iconoPass = new javax.swing.JLabel();
        btnLogin = new javax.swing.JPanel();
        btnLogintxt = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblSignUp = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        iconLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconoLogin.png"))); // NOI18N

        txtUsername.setForeground(new java.awt.Color(204, 204, 204));
        txtUsername.setText("Ingrese su nombre de usuario");
        txtUsername.setBorder(null);
        txtUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtUsernameMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtUsernameMousePressed(evt);
            }
        });
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsernameKeyTyped(evt);
            }
        });

        txtPassword.setForeground(new java.awt.Color(204, 204, 204));
        txtPassword.setText("********");
        txtPassword.setBorder(null);
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtPasswordMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPasswordMousePressed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(95, 7, 232));

        jSeparator2.setForeground(new java.awt.Color(95, 7, 232));

        jLabel1.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel1.setText("USUARIO");

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel2.setText("CONTRASEÑA");

        btnLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 7, 232)));
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLoginMouseExited(evt);
            }
        });

        btnLogintxt.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        btnLogintxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnLogintxt.setText("INICIAR SESION");
        btnLogintxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogintxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogintxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogintxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogintxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnLoginLayout = new javax.swing.GroupLayout(btnLogin);
        btnLogin.setLayout(btnLoginLayout);
        btnLoginLayout.setHorizontalGroup(
            btnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnLogintxt, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
        );
        btnLoginLayout.setVerticalGroup(
            btnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnLogintxt, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Roboto Medium", 0, 10)); // NOI18N
        jLabel3.setText("Not Account?");

        lblSignUp.setFont(new java.awt.Font("Roboto Medium", 0, 10)); // NOI18N
        lblSignUp.setForeground(new java.awt.Color(0, 0, 255));
        lblSignUp.setText("Sign Up");
        lblSignUp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSignUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSignUpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSignUpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSignUpMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(iconoUser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iconoPass, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                .addComponent(txtPassword)
                                .addComponent(jSeparator1)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(iconLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSignUp)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(iconLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iconoUser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iconoPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblSignUp))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseEntered

    }//GEN-LAST:event_btnLoginMouseEntered

    private void btnLogintxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogintxtMouseExited
        this.btnLogintxt.setForeground(Color.black);
        this.btnLogin.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnLogintxtMouseExited

    private void btnLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseExited

    }//GEN-LAST:event_btnLoginMouseExited

    private void btnLogintxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogintxtMouseEntered
        this.btnLogintxt.setForeground(Color.white);
        this.btnLogin.setBackground(new Color(95, 102, 211));
    }//GEN-LAST:event_btnLogintxtMouseEntered

    private void txtUsernameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsernameMouseEntered


    }//GEN-LAST:event_txtUsernameMouseEntered

    private void txtPasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMouseEntered

    }//GEN-LAST:event_txtPasswordMouseEntered

    private void txtUsernameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsernameMousePressed
        if (this.txtUsername.getText().equals("Ingrese su nombre de usuario")) {
            this.txtUsername.setText("");
            this.txtUsername.setForeground(Color.black);
        }
        if (String.valueOf(this.txtPassword.getPassword()).isEmpty()) {
            this.txtPassword.setText("********");
            this.txtPassword.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtUsernameMousePressed

    private void txtPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMousePressed
        if (String.valueOf(this.txtPassword.getPassword()).equals("********")) {
            this.txtPassword.setText("");
            this.txtPassword.setForeground(Color.black);

        }
        if (this.txtUsername.getText().isEmpty()) {
            this.txtUsername.setText("Ingrese su nombre de usuario");
            this.txtUsername.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtPasswordMousePressed

    private void btnLogintxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogintxtMouseClicked
         String pass = String.valueOf(this.txtPassword.getPassword());
        //el metodo loginuser devuelve null
        boolean x = logi.loginUsers(this.txtUsername.getText(), pass);
        if(x == true ){
            System.out.println("Ingreso a la plataforma: "+x);
            JFBiblioteca jfs = new JFBiblioteca();
            jfs.setVisible(true);
            this.dispose();
            
        }else{
            System.out.println("Ingreso a la plataforma: "+x);
            JOptionPane.showMessageDialog(null, "Correo o contraseña invalida");
        } 
    }//GEN-LAST:event_btnLogintxtMouseClicked

    private void txtUsernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyTyped
        txtPassword.setText("");
        this.txtPassword.setForeground(Color.black);
    }//GEN-LAST:event_txtUsernameKeyTyped

    private void lblSignUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSignUpMouseClicked
       JFCrearUsuario jfcrear = new JFCrearUsuario();
       jfcrear.setVisible(true);
    }//GEN-LAST:event_lblSignUpMouseClicked

    private void lblSignUpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSignUpMouseEntered
       lblSignUp.setForeground(Color.red);
    }//GEN-LAST:event_lblSignUpMouseEntered

    private void lblSignUpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSignUpMouseExited
       lblSignUp.setForeground(Color.BLUE);
    }//GEN-LAST:event_lblSignUpMouseExited

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
            java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnLogin;
    private javax.swing.JLabel btnLogintxt;
    private javax.swing.JLabel iconLogin;
    private javax.swing.JLabel iconoPass;
    private javax.swing.JLabel iconoUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblSignUp;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
