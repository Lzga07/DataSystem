package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 * Esta clase define una ventana para la restauración del password de un
 * usuario. Permite ingresar un nuevo password y confirmarlo. Valida la entrada
 * y actualiza el password del usuario en la base de datos.
 *
 * @author Lizarraga
 */
public class RestaurarPassword extends javax.swing.JFrame {

    String user = "", user_update = "";

    /**
     * Crea una nueva instancia de la ventana de restauración de password.
     * Inicializa los componentes y configura la interfaz gráfica.
     *
     * También establece el título de la ventana y ajusta su apariencia.
     */
    public RestaurarPassword() {
        initComponents();
        user = Login.user;
        user_update = GestionarUsuarios.user_update;

        setSize(360, 260);
        setResizable(false);
        setTitle("Cambio de Password para " + user_update);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));

        jLabel_Wallpaper.setIcon(icono);
        this.repaint();
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

    /**
     * Inicializa los componentes de la interfaz gráfica de usuario. Este método
     * es generado automáticamente por el editor de formularios.
     *
     * @see javax.swing.JFrame#initComponents()
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        txt_passwordConfirmacion = new javax.swing.JPasswordField();
        jButton_RestaurarPassword = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cambio de password");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nuevo Password:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Confirmar Password:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txt_password.setBackground(new java.awt.Color(153, 153, 255));
        txt_password.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_password.setForeground(new java.awt.Color(255, 255, 255));
        txt_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_password.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));

        txt_passwordConfirmacion.setBackground(new java.awt.Color(153, 153, 255));
        txt_passwordConfirmacion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_passwordConfirmacion.setForeground(new java.awt.Color(255, 255, 255));
        txt_passwordConfirmacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_passwordConfirmacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_passwordConfirmacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 210, -1));

        jButton_RestaurarPassword.setBackground(new java.awt.Color(153, 153, 255));
        jButton_RestaurarPassword.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_RestaurarPassword.setForeground(new java.awt.Color(255, 255, 255));
        jButton_RestaurarPassword.setText("Restaurar Password");
        jButton_RestaurarPassword.setBorder(null);
        jButton_RestaurarPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RestaurarPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_RestaurarPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 210, 35));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Maneja el evento de clic en el botón de restaurar password. Valida las
     * contraseñas ingresadas y, si coinciden, actualiza el password del usuario
     * en la base de datos. Muestra mensajes de error o éxito según corresponda.
     *
     * @param evt El evento de acción del botón de restaurar password.
     */
    private void jButton_RestaurarPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RestaurarPasswordActionPerformed

        String password, confirmacion_password;

        password = txt_password.getText().trim();
        confirmacion_password = txt_passwordConfirmacion.getText().trim();

        // Verifica que ambos campos no estén vacíos
        if (!password.equals("") && !confirmacion_password.equals("")) {

            // Verifica que las contraseñas coincidan
            if (password.equals(confirmacion_password)) {

                try {

                    // Conecta con la base de datos y actualiza el password del usuario
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement(
                            "update usuarios set password=? where username = '" + user_update + "'");
                    pst.setString(1, password);

                    pst.executeUpdate();
                    cn.close();

                    txt_password.setBackground(Color.green);
                    txt_passwordConfirmacion.setBackground(Color.green);

                    JOptionPane.showMessageDialog(null, "Restauración exitosa.");
                    this.dispose();

                } catch (SQLException e) {
                    System.out.println("Error en restaurar password " + e);
                }

            } else {
                // Muestra un mensaje de error si las contraseñas no coinciden
                txt_passwordConfirmacion.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.");
            }

        } else {
            // Muestra un mensaje de error si alguno de los campos está vacío
            txt_password.setBackground(Color.red);
            txt_passwordConfirmacion.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "No se admite contraseña vacias.");
        }

    }//GEN-LAST:event_jButton_RestaurarPasswordActionPerformed

    /**
     * Crea y muestra la ventana de restauración de password.
     *
     * @param args Los argumentos de la línea de comandos.
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
            java.util.logging.Logger.getLogger(RestaurarPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RestaurarPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RestaurarPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RestaurarPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RestaurarPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_RestaurarPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JPasswordField txt_passwordConfirmacion;
    // End of variables declaration//GEN-END:variables
}
