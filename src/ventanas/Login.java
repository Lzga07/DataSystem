package ventanas;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.sql.*;
import clases.Conexion;
import javax.swing.JOptionPane;

/**
 *
 * @author Lizarraga
 */

/**
 * Clase Login que maneja la interfaz y lógica de autenticación para un sistema
 * de inicio de sesión.
 */
public class Login extends javax.swing.JFrame {
    
     // Variable pública estática para almacenar el nombre de usuario ingresado
    public static String user = "";
    // Variable privada para almacenar la contraseña ingresada
    String pass = "";

    /**
     * Constructor de la clase Login.
     * Inicializa los componentes, configura la ventana y carga imágenes.
     */
    public Login() {
        initComponents(); // Inicializa los componentes generados por el editor visual
        setSize(400,550) ;// Establece el tamaño de la ventana
        setResizable(false); // Evita que la ventana se pueda redimensionar
        setTitle("Acceso al sistma"); // Establece el título de la ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        
        // Carga y ajusta la imagen de fondo
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jlabel_Wallpaper.getWidth(),
                jlabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        
        jlabel_Wallpaper.setIcon(icono); // Establece el fondo en el JLabel correspondiente
        this.repaint(); // Redibuja la ventana para aplicar cambios
        
        // Carga y ajusta el logo
        ImageIcon wallpaper_logo = new ImageIcon("src/images/DS.png");
        Icon icono_logo = new ImageIcon(wallpaper_logo.getImage().getScaledInstance(jLabel_Logo.getWidth(),
                jLabel_Logo.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Logo.setIcon(icono_logo);  // Establece el logo en el JLabel correspondiente
        this.repaint(); // Redibuja la ventana para aplicar cambios
    }
    
    
    /**
     * Método sobrescrito para obtener el icono de la ventana.
     * @return El icono de la ventana.
     */
    @Override
    public Image getIconImage(){
        // Carga el icono desde los recursos y lo devuelve
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

    /**
     * Este método es llamado desde el constructor para inicializar los componentes.
     * ADVERTENCIA: No modificar este código, el contenido de este método es generado automáticamente por el Editor de Formulario.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_Logo = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        jButton_Acceder = new javax.swing.JButton();
        jLabel_Footer = new javax.swing.JLabel();
        jlabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel_Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 270, 270));

        txt_user.setBackground(new java.awt.Color(153, 153, 255));
        txt_user.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_user.setForeground(new java.awt.Color(255, 255, 255));
        txt_user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_user.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 330, 210, -1));

        txt_password.setBackground(new java.awt.Color(153, 153, 255));
        txt_password.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_password.setForeground(new java.awt.Color(255, 255, 255));
        txt_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_password.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 370, 210, -1));

        jButton_Acceder.setBackground(new java.awt.Color(153, 153, 255));
        jButton_Acceder.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_Acceder.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Acceder.setText("Acceder");
        jButton_Acceder.setBorder(null);
        jButton_Acceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AccederActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Acceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 420, 210, 35));

        jLabel_Footer.setText("Creado por Luis Lizarraga");
        getContentPane().add(jLabel_Footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 495, -1, -1));
        getContentPane().add(jlabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que se ejecuta cuando se presiona el botón "Acceder".
     * @param evt El evento que dispara la acción.
     */
    private void jButton_AccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AccederActionPerformed
        
         // Obtiene el nombre de usuario y contraseña de los campos de texto
        user = txt_user.getText().trim();
        pass = txt_password.getText().trim();
        
        // Verifica que ambos campos estén llenos
        if (!user.equals("") || !pass.equals("")) {
            
            try {
                // Conexión a la base de datos
                Connection cn = Conexion.conectar();
                // Consulta SQL para verificar las credenciales
                PreparedStatement pst = cn.prepareStatement(
                    "select tipo_nivel, estatus from usuarios where username = '" + user
                        + "' and password = '" + pass + "'");
                
                ResultSet rs = pst.executeQuery(); // Ejecuta la consulta
                
                // Si se encuentran coincidencias en la base de datos
                if(rs.next()){
                    
                    String tipo_nivel = rs.getString("tipo_nivel"); // Obtiene el nivel de usuario
                    String estatus = rs.getString("estatus"); // Obtiene el estatus del usuario

                     // Verifica el tipo de usuario y su estatus
                    if(tipo_nivel.equals("Administrador") && estatus.equalsIgnoreCase("Activo")){
                        dispose(); // Cierra la ventana de login
                        new Administrador().setVisible(true); // Abre la ventana de administrador
                    }else if(tipo_nivel.equals("Capturista") && estatus.equalsIgnoreCase("Activo")){
                        dispose(); // Cierra la ventana de login
                        new Capturista().setVisible(true); // Abre la ventana de capturista
                    } else if(tipo_nivel.equals("Tecnico") && estatus.equalsIgnoreCase("Activo")){
                        dispose(); // Cierra la ventana de login
                        new Tecnico().setVisible(true);  // Abre la ventana de técnico
                    }
                    
                }else{
                    // Muestra un mensaje si las credenciales son incorrectas
                    JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos.");
                    txt_user.setText(""); // Limpia el campo de usuario
                    txt_password.setText(""); // Limpia el campo de contraseña
                }
            } catch (SQLException e) {
                 // Manejo de errores en caso de problemas con la base de datos
                System.err.println("Erro en el botón Acceder." + e);
                JOptionPane.showMessageDialog(null, "¡¡Error al iniciar sesión!!, contacte al administrador.");
            }
            
        } else {
             // Muestra un mensaje si no se llenaron todos los campos
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.");
        }
        
    }//GEN-LAST:event_jButton_AccederActionPerformed

    /**
     * Método principal que lanza la aplicación.
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Crea y muestra la ventana del login */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Acceder;
    private javax.swing.JLabel jLabel_Footer;
    private javax.swing.JLabel jLabel_Logo;
    private javax.swing.JLabel jlabel_Wallpaper;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
