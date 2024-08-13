package ventanas;

import clases.Conexion;
import java.sql.*;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileOutputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 * La clase Capturista representa la ventana principal para los capturistas.
 * Permite registrar clientes, gestionar clientes e imprimir una lista de
 * clientes. Además, establece la configuración inicial de la ventana y maneja
 * la conexión con la base de datos para obtener y mostrar el nombre del
 * usuario.
 *
 * @author Lizarraga
 */
public class AcercaDe extends javax.swing.JFrame {

    // Variables para almacenar el nombre de usuario y el estado de la sesión
    String user, nombre_usuario;
    int sesion_usuario;

    /**
     * Constructor de la clase Capturista. Configura los componentes iniciales y
     * establece la información del usuario.
     */
    public AcercaDe() {

        // Inicializa los componentes de la interfaz gráfica
        initComponents();

        // Obtiene el nombre de usuario desde la clase Login y el estado de la sesión desde la clase Administrador
        user = Login.user;
        sesion_usuario = Administrador.sesion_usuario;

        // Configura las propiedades de la ventana
        setSize(415, 300);
        setResizable(false);
        setTitle("Acerca De - Sesión de " + user);
        setLocationRelativeTo(null);

        // Configura el comportamiento del cierre de la ventana según el estado de la sesión
        if (sesion_usuario == 1) {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        } else {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }

        // Establece el fondo de pantalla de la ventana
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));

        jLabel_Wallpaper.setIcon(icono);
        this.repaint();

    }

    /**
     * Sobrescribe el método para obtener el icono de la ventana.
     *
     * @return El icono de la ventana.
     */
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

    /**
     * Este método es llamado dentro del constructor para inicializar los
     * componentes de la interfaz. ¡Advertencia! No modifiques este código. El
     * contenido de este método es siempre regenerado por el Editor de
     * Formularios.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_1 = new javax.swing.JLabel();
        jLabel_2 = new javax.swing.JLabel();
        jLabel_3 = new javax.swing.JLabel();
        jLabel_4 = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_1.setText("Sistema creado por Luis Lizarraga");
        getContentPane().add(jLabel_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));

        jLabel_2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_2.setText("Github: Lzga07");
        getContentPane().add(jLabel_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, -1, -1));

        jLabel_3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_3.setText("Linkedin: https://www.linkedin.com/in/luis-lizarraga07/");
        getContentPane().add(jLabel_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jLabel_4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_4.setText("em@il: luis.lizarraga11@outlook.com");
        getContentPane().add(jLabel_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método principal que inicia la aplicación.
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
            java.util.logging.Logger.getLogger(AcercaDe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AcercaDe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AcercaDe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AcercaDe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Crea y muestra la ventana principal */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AcercaDe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel_1;
    private javax.swing.JLabel jLabel_2;
    private javax.swing.JLabel jLabel_3;
    private javax.swing.JLabel jLabel_4;
    private javax.swing.JLabel jLabel_Wallpaper;
    // End of variables declaration//GEN-END:variables
}
