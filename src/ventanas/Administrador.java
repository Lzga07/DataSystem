package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

/**
 * Clase que representa la interfaz gráfica de la ventana del Administrador.
 * Permite gestionar usuarios y acceder a diferentes secciones del sistema según
 * el rol del usuario.
 *
 * @author Lizarraga
 */
public class Administrador extends javax.swing.JFrame {

    // Variables para almacenar el nombre de usuario y el nombre completo del usuario.
    String user, nombre_usuario;
    // Variable estática para controlar la sesión del usuario.
    public static int sesion_usuario;

    /**
     * Constructor de la clase Administrador. Configura la ventana e inicializa
     * los componentes de la interfaz.
     */
    public Administrador() {

        initComponents(); // Inicializa los componentes de la interfaz.
        user = Login.user; // Obtiene el nombre de usuario de la clase Login.
        sesion_usuario = 1; // Establece el valor de la sesión del usuario.

        // Configuración de la ventana
        setSize(660, 435); // Establece el tamaño de la ventana.
        setResizable(false); // Impide que la ventana se pueda redimensionar.
        setTitle("Administrador - Sesión de " + user); // Establece el título de la ventana con el nombre de usuario.
        setLocationRelativeTo(null); // Centra la ventana en la pantalla.

        // Configuración para cerrar la ventana y terminar la aplicación al salir.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Configuración del fondo de pantalla de la ventana.
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));

        jLabel_Wallpaper.setIcon(icono); // Establece el icono como fondo de pantalla.
        this.repaint(); // Refresca la ventana para que los cambios se vean reflejados.

        // Conexión a la base de datos para obtener el nombre completo del usuario.
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select nombre_usuario from usuarios where username = '" + user + "'");

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                nombre_usuario = rs.getString("nombre_usuario"); // Obtiene el nombre completo del usuario.
                jLabel_NombreUsuario.setText(nombre_usuario); // Muestra el nombre del usuario en la interfaz.
            }
        } catch (Exception e) {
            System.err.println("Error en conexión desde la interfaz Administrador.");  // Muestra un mensaje de error en caso de que falle la conexión.
        }
    }

    /**
     * Método que retorna la imagen del icono de la ventana.
     *
     * @return Imagen del icono.
     */
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

    /**
     * Método que inicializa los componentes de la interfaz. Este código es
     * generado automáticamente por el Editor de Formularios.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_NombreUsuario = new javax.swing.JLabel();
        jButton_RegistrarUsuario = new javax.swing.JButton();
        jButton_GestionarUsuarios = new javax.swing.JButton();
        jButton_AcercaDe = new javax.swing.JButton();
        jButton_Capturista = new javax.swing.JButton();
        jButton_Tecnico = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_NombreUsuario.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel_NombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel_NombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jButton_RegistrarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addUser.png"))); // NOI18N
        jButton_RegistrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistrarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_RegistrarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 120, 100));

        jButton_GestionarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/informationuser.png"))); // NOI18N
        jButton_GestionarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GestionarUsuariosActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_GestionarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 120, 100));

        jButton_AcercaDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/creatividad.png"))); // NOI18N
        jButton_AcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AcercaDeActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_AcercaDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 155, 120, 100));

        jButton_Capturista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/capturista.png"))); // NOI18N
        jButton_Capturista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CapturistaActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Capturista, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 120, 100));

        jButton_Tecnico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tecnico.png"))); // NOI18N
        jButton_Tecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TecnicoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Tecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 240, 120, 100));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registrar Usuario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 170, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Gestionar Usuarios");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Acerca De");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 260, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Panel vista Capturista");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 340, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Panel vista Tecnico");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 340, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Acción al presionar el botón "Registrar Usuario".
    private void jButton_RegistrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarUsuarioActionPerformed

        RegistrarUsuarios registrarUsuarios = new RegistrarUsuarios(); // Crea una instancia de la ventana para registrar usuarios.
        registrarUsuarios.setVisible(true); // Muestra la ventana de registro de usuarios.

    }//GEN-LAST:event_jButton_RegistrarUsuarioActionPerformed

    // Acción al presionar el botón "Gestionar Usuarios".
    private void jButton_GestionarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GestionarUsuariosActionPerformed

        GestionarUsuarios gestionarUsuarios = new GestionarUsuarios(); // Crea una instancia de la ventana para gestionar usuarios.
        gestionarUsuarios.setVisible(true); // Muestra la ventana de gestión de usuarios.

    }//GEN-LAST:event_jButton_GestionarUsuariosActionPerformed

    // Acción al presionar el botón "Capturista".
    private void jButton_CapturistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CapturistaActionPerformed

        Capturista capturista = new Capturista(); // Crea una instancia de la ventana para la vista del Capturista.
        capturista.setVisible(true); // Muestra la ventana de la vista Capturista.

    }//GEN-LAST:event_jButton_CapturistaActionPerformed

    //Acción al presionar el botón "Tecnico".
    private void jButton_TecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TecnicoActionPerformed

        Tecnico tecnico = new Tecnico();
        tecnico.setVisible(true);

    }//GEN-LAST:event_jButton_TecnicoActionPerformed

    private void jButton_AcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AcercaDeActionPerformed
        
        AcercaDe acercaDe = new AcercaDe();
        acercaDe.setVisible(true);
        
    }//GEN-LAST:event_jButton_AcercaDeActionPerformed

    /**
     * Método principal que ejecuta la aplicación.
     *
     * @param args Argumentos de la línea de comandos.
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
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Crea y muestra la ventana del Administrador */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrador().setVisible(true); // Muestra la ventana de Administrador.
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_AcercaDe;
    private javax.swing.JButton jButton_Capturista;
    private javax.swing.JButton jButton_GestionarUsuarios;
    private javax.swing.JButton jButton_RegistrarUsuario;
    private javax.swing.JButton jButton_Tecnico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_NombreUsuario;
    private javax.swing.JLabel jLabel_Wallpaper;
    // End of variables declaration//GEN-END:variables
}
